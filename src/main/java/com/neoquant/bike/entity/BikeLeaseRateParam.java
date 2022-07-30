package com.neoquant.bike.entity;

import lombok.ToString;

@ToString
public class BikeLeaseRateParam {
	private long mileage;
	private int duration;
	private float interestRate;
	private double nettPrice;
	private long bikeId;
	public BikeLeaseRateParam(long mileage, int duration, float interestRate, double nettPrice, long bikeId) {
		super();
		this.mileage = mileage;
		this.duration = duration;
		this.interestRate = interestRate;
		this.nettPrice = nettPrice;
		this.bikeId = bikeId;
	}
	public long getMileage() {
		return mileage;
	}
	public void setMileage(long mileage) {
		this.mileage = mileage;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public double getNettPrice() {
		return nettPrice;
	}
	public void setNettPrice(double nettPrice) {
		this.nettPrice = nettPrice;
	}
	public long getBikeId() {
		return bikeId;
	}
	public void setBikeId(long bikeId) {
		this.bikeId = bikeId;
	}
	
}
