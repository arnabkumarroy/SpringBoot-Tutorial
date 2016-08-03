package com.boot.roy_boot.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.roy_boot.model.Shipwreck;

@RestController
@RequestMapping("api/v1/")
public class FindShipReckContainer {
	
	@RequestMapping(value="shipwrecks", method= RequestMethod.GET)
	public List<Shipwreck> shipreckList(){
		
		return ShipwreckStub.list();
	}
	
	
	@RequestMapping(value="shipwrecks", method= RequestMethod.POST)
	public Shipwreck shipreckCreate(@RequestBody Shipwreck wreck){
		
		return ShipwreckStub.create(wreck);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method= RequestMethod.GET)
	public Shipwreck shipreck(@PathVariable Long id){
		
		return ShipwreckStub.get(id);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method= RequestMethod.DELETE)
	public Shipwreck shipreckDelete(@PathVariable Long id){
		
		return ShipwreckStub.delete(id);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method= RequestMethod.PUT)
	public Shipwreck shipreckUpdate(@PathVariable Long id,@RequestBody Shipwreck wreck){
		
		return ShipwreckStub.update(id, wreck);
	}

}
