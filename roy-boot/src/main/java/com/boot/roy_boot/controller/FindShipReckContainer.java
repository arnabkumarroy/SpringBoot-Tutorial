package com.boot.roy_boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.roy_boot.model.Shipwreck;
import com.boot.roy_boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class FindShipReckContainer {
	
	@Autowired
	public ShipwreckRepository shipwreckRepository;
	
	@RequestMapping(value="shipwrecks", method= RequestMethod.GET)
	public List<Shipwreck> shipreckList(){
		
		//Adding the JPA wireup for getting the value from DB
		return shipwreckRepository.findAll();
		//return ShipwreckStub.list();
	}
	
	
	@RequestMapping(value="shipwrecks", method= RequestMethod.POST)
	public Shipwreck shipreckCreate(@RequestBody Shipwreck wreck){
		
		//Adding the JPA wireup for getting the value from DB
		return shipwreckRepository.saveAndFlush(wreck);
		//return ShipwreckStub.create(wreck);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method= RequestMethod.GET)
	public Shipwreck shipreck(@PathVariable Long id){
		
		//Adding the JPA wireup for getting the value from DB
		return shipwreckRepository.findOne(id);
		//return ShipwreckStub.get(id);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method= RequestMethod.DELETE)
	public Shipwreck shipreckDelete(@PathVariable Long id){
		
		//Adding the JPA wireup for getting the value from DB
		Shipwreck shipwreck=shipwreckRepository.findOne(id);
		shipwreckRepository.delete(shipwreck);
		return shipwreck;
		//return ShipwreckStub.delete(id);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method= RequestMethod.PUT)
	public Shipwreck shipreckUpdate(@PathVariable Long id,@RequestBody Shipwreck wreck){
		//Adding the JPA wireup for getting the value from DB
		Shipwreck targetShipwreck=shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(wreck, targetShipwreck);
		shipwreckRepository.saveAndFlush(targetShipwreck);
		return targetShipwreck;
				
		//return ShipwreckStub.update(id, wreck);
	}

}
