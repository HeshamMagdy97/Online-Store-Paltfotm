package com.SWII.Entity;

import org.springframework.stereotype.Component;

@Component
public abstract class StatisticsDecorator implements Istatistics{

	private Istatistics stat;

	
	public StatisticsDecorator(Istatistics stat) {
		super();
		this.stat = stat;
	}

	public Istatistics getStat() {
		return stat;
	}

	public void setStat(Istatistics stat) {
		this.stat = stat;
	}

	@Override
	public int min() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int max() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int avg() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
