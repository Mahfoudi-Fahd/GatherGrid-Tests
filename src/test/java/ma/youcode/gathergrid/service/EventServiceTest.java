package ma.youcode.gathergrid.service;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.google.protobuf.Message;
import ma.youcode.gathergrid.domain.Event;
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
    @Test
    public void testCreateEvent() {
        // Create a sample event
        Event event = new Event();
        event.setName("Sample Event");

        doNothing().when(eventRepository).save(event);

        Response createdEvent = eventService.createEvent(event);

        assertEquals(3, createdEvent.getError().size());



    }


}