package com.neoquant.bike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoquant.bike.entity.Bike;
import com.neoquant.bike.entity.BikeLeaseRateParam;
import com.neoquant.bike.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {
	private static final Bike bike = null;

	@Autowired
	private BikeService bikeService;
	@GetMapping(value="/mgs")
	public String getMessage() {
		return "hello world";
	}

	@GetMapping(value="/allbike")
	public List<Bike> getAllBikeInfo(){
		return bikeService.getAllBikeInfo();
	}
	@GetMapping(value="/bikeinfo/{id}")
	public Bike bikeGetById(@PathVariable long id) {
		return bikeService.bikeGetById(id);
	}
	@PostMapping(value="/savebike")
	public List<Bike> saveBikeInfo(@RequestBody Bike bike){
		bikeService.saveBike(bike);
		return bikeService.getAllBikeInfo();
	}
	@DeleteMapping(value="/deletebikeinfo/{id}")
	public Bike deleteBikeById(@PathVariable long id) {
		return bike;
	}
	
	@PostMapping(value="leaseRate")
	public Bike bikeLeaseRate(@RequestBody BikeLeaseRateParam leaserateparameters) {
		return bikeService.bikeLeaseRate(leaserateparameters);
	}
	
	@PutMapping(value="updatebike/{id}")
	public Bike updateBikeById(@PathVariable long id) {
bikeService.saveBike(bike);
return  bikeService.getBikeById(id);
	}
}
