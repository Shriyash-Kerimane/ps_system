package com.demo.entity;

public class GenericsApp<T> {
	
	T x,y;
	
	public void setData(T x, T y) {
		this.x = x;
		this.y = y;
	}
	
	public String getData() {
		return x.toString()+y.toString();
	}

}
