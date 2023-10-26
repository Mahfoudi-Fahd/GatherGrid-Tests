package ma.youcode.gathergrid.service;

import java.time.LocalDateTime;
import java.util.Date;

public class EventDTO {

    private String name;
    private LocalDateTime newDate;

    public EventDTO(String name, LocalDateTime newDate) {
        this.name = name;
        this.newDate = newDate;
    }
}
