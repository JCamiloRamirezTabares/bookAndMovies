package model;

public interface Rentable{
	
	public boolean isSafeRent();
	public double getRentPrice(int x);
	public void rentProduct(int x);
	
}