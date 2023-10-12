package ma.youcode.gathergrid.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import ma.youcode.gathergrid.domain.User;
import ma.youcode.gathergrid.repositories.UserRepository;
import ma.youcode.gathergrid.repositories.UserRepositoryImpl;

import javax.validation.Valid;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Transactional(Transactional.TxType.REQUIRED)
    public User registerUser(@Valid User user) {
        System.out.println("Registering user: " + user);
        userRepository.save(user);
        return user;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public User updateUserInfo(@Valid User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.update(user);
        return user;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteAccount(@Valid User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.delete(user);
    }

    public boolean isValidUser(@Valid User user) {
        System.out.println("Validating user: " + user);
        Optional<User> byUsername = userRepository.findByUsername(user.getUsername());
        return byUsername.isPresent()
                && user.getPassword().equals(byUsername.get().getPassword());
    }

    public boolean validLoginDetails(@Valid User user) {
        System.out.println("Validating user: " + user);
        return !userRepository.findByUsername(user.getUsername()).isPresent()
                && user.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }
}
