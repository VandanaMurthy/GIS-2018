package com.accion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accion.entity.Event;
import com.accion.repository.EventRepository;


@Service
public class EventService {
	@Autowired
	private EventRepository er;
	
	public List<Event> findAll(){
		return er.findAll();
	}
	
	public Event findByEid(int eid) {
		return er.findByEid(eid);
	}
  
}
