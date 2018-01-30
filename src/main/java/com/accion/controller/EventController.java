package com.accion.controller;

import java.util.Arrays;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.accion.entity.Event;
import com.accion.service.EventService;


@RestController
@RequestMapping(value = "/app1")
public class EventController {
	final static Logger logger = Logger.getLogger(EventController.class);
	@Autowired
	private EventService es;

	
	@PostMapping("/events") // FETCH ALL EVENTS
	public ResponseEntity<List<Event>> getAllEvents() {
		List<Event> events = es.findAll();
		if (events.isEmpty()) {
			logger.debug("Events does not exists");
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + events.size() + " events");
		logger.debug(events);
		logger.debug(Arrays.toString(events.toArray()));
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
	
	@PostMapping("/event") // FETCH EVENT BY ID
	public ResponseEntity<Event> getEventById(@RequestParam("eid") int eid) {
		Event eve = es.findByEid(eid);

		if (eve == null) {
			logger.debug("Event with id " + eid + " does not exists");
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		} else {
			logger.debug("Found event with id " + eid + " id");
			return new ResponseEntity<Event>(eve, HttpStatus.OK);
		}
	}
	
	
	
	

}
