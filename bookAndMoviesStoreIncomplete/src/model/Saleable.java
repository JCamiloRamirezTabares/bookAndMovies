package model;

public interface Saleable{
	
	public double getSalePrice(int x);
	public boolean isSafeSale(int x);
	public double applyExtraDiscount(double x, double y);
	public double calculateTax(double x, double y);
	
}