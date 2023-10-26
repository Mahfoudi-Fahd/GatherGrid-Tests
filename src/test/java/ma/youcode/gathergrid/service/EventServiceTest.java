package ma.youcode.gathergrid.service;
import static org.mockito.Mockito.*;

import ma.youcode.gathergrid.domain.Category;
import ma.youcode.gathergrid.domain.Event;
import ma.youcode.gathergrid.domain.Organization;
import ma.youcode.gathergrid.repositories.EventRepository;
import ma.youcode.gathergrid.utils.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventServiceTest {
    private EventService eventService;
    private EventRepository eventRepository;

    @Before
    public void setUp() {
        eventRepository = mock(EventRepository.class);
        eventService = new EventService(eventRepository);
    }

//    @Test
//    public void testCreateEvent() {
//        // Create a sample event
//        Event event = new Event();
//        event.setName("Sample Event");
//
//        doNothing().when(eventRepository).save(event);
//
//        Response createdEvent = eventService.createEvent(event);
//
//        assertEquals(3, createdEvent.getError().size());
//
//
//
//    }
    @Test
    public void validTestCreateEvent() {
        Event event = new Event();
        event.setName("Sample Event");
        event.setLocation("ff");
        event.setDescription("description");
        event.setNumberOfTicketsAvailable(11);
        event.setCategory(new Category("test","test"));
        event.setOrganization(new Organization("test"));
        doNothing().when(eventRepository).save(event);

        Response<Event> createdEvent = eventService.createEvent(event);

        assertEquals(0, createdEvent.getError().size());




    }

}