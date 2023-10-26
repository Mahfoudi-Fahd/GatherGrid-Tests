package ma.youcode.gathergrid.service;

import jakarta.inject.Inject;
import ma.youcode.gathergrid.domain.Event;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TEST {
    @Inject
    EventService eventService;

    public List<EventDTO> updateEvent(){
        List<Event> events = eventService.getAllEvents().getResult();

        return events.stream()
                .filter(event -> event.getTickets().size() < 20 && LocalDateTime.now().isAfter(event.getDateTime()))
                .map( event -> {
                    event.setDateTime(LocalDateTime.now().plusDays(event.getTickets().size()));
                    eventService.updateEvent(event);
                    return new EventDTO(event.getName(),event.getDateTime());
                }).collect(Collectors.toList());
    }

    public List<EventDTO> updateEvent1(){
        List<Event> events = eventService.getAllEvents().getResult();

        int[] size = new int[1];
        
        return events.stream()
                .filter(event -> {
                    size[0] =event.getTickets().size();
                    return size[0] < 20 && LocalDateTime.now().isAfter(event.getDateTime());
                })
                .map( event -> {
                    event.setDateTime(LocalDateTime.now().plusDays(size[0]));
                    eventService.updateEvent(event);
                    return new EventDTO(event.getName(),event.getDateTime());
                }).collect(Collectors.toList());
    }

}
