package com.neoquant.bike.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.neoquant.bike.entity.Bike;
import com.neoquant.bike.entity.BikeLeaseRateParam;

@Service
public class BikeService {

	public static List<Bike> bikeinfo= new ArrayList<Bike>();

	public BikeService() {
		bikeinfo.add(new Bike(1,"Yamaha-2021","mt 15","V1.0","15",80000.00,63000.00,""));
		bikeinfo.add(new Bike(2,"Yamaha-2022","mt 125","V1.2","12",110000.00,60000.00,""));
		bikeinfo.add(new Bike(3,"Honda-2021"," CBR 150","V3.4","10",190000.00,53000.00,""));
		bikeinfo.add(new Bike(4,"Yamaha-2021"," cb 125r ","V1.0","18",100000.00,79000.00,""));
		bikeinfo.add(new Bike(5,"Yamaha-2021"," r15s ","V3.0","20",150000.00,90000.00,""));
		bikeinfo.add(new Bike(6,"Yamaha-2021","r15s ","V5.0","12",180000.00,45000.00,""));

	}
	public List<Bike> getAllBikeInfo(){
		return bikeinfo;
	}

	public Bike bikeGetById(long id) {
		Bike bikeinfo=null;
		for (Bike bike : BikeService.bikeinfo) {
			if(bike.getId()==id) {
				bikeinfo=bike;
				break;

			}
		}
		return bikeinfo;
	}
	public boolean saveBike(Bike bike) {
		boolean result = bikeinfo.add(bike);
		return result;
	}

	public Bike deleteBikeById(long id) {
		Bike bikeInfo = null;
		for (Bike bike : bikeinfo) {
			if(bike.getId()==id) {
				bikeInfo = bike;
				break;
			}
		}
		return bikeInfo;
	}

	private String bikeLeaseRate(long mileage,int duration,float interestRate,double nettPrice) {
		String pattern = "###,###.##";
		double result=(((mileage/12)*duration)/nettPrice) + (((interestRate/100)*nettPrice)/12);
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		String format = decimalFormat.format(result);
		return format;	
	}
	public Bike bikeLeaseRate(BikeLeaseRateParam leaserate) {
		Bike bike=null;
		bike = bikeGetById(leaserate.getBikeId());
		System.out.println("BIKE BEFORE LEASE RATE CALCULATION");
		System.out.println(bike.toString());
		if(bike!=null) {
			String leaseRate = bikeLeaseRate(leaserate.getMileage(),leaserate.getDuration(),leaserate.getInterestRate(),bike.getNetPrice());
			bike.setLeaseRate(leaseRate);
		}
		System.out.println("BIKE AFTER LEASE RATE CALCULATION");
		System.out.println(bike.toString());
		return bike;
	}
	public Bike getBikeById(long id) {
		Bike bikeInfo = null;
		for (Bike bike : bikeinfo) {
			if(bike.getId()==id) {
				bikeInfo = bike;
				break;
			}
		}
		return bikeInfo;
	}
	public Bike updateBikeById(long id) {
		Bike bikeinfo=null;
		for (Bike bike : BikeService.bikeinfo) {
			if(bike.getId()==id) {
				bikeinfo=bike;
				break;
			}
		}
		return bikeinfo;
	}

}

