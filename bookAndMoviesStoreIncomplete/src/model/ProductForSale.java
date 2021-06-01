package model;

public class ProductForSale extends Product implements Saleable{
	
	//Attributes
	private double discount;
	
	//Constructor
	public ProductForSale(String code, String name, int units, double price, ProductType type){
		super(code, name, units, price, type);
		discount = 0;
	}
	
	
	//Methods
	//@Override from Saleable
	public double calculateTax(double totalPrice, double percenteage){
		return totalPrice + (totalPrice * percenteage);
	}
	
	//@Override from Saleable
	public double getSalePrice(int units){
		return (units*price) - discount;
	}
	
	//@Override from Product
	public String getInformation(){
		return "===================\n"+
			   "=== Information ===\n"+
			   "===================\n\n"+
			   "Product Type: " + getType() + "\n"+
			   "Code: " + getCode() + "\n"+
			   "Product name: " + getName() + "\n"+
			   "Available units: " + getUnits() + "\n"; 
	}
	
	public void setDiscount(double newDiscount){
		discount = newDiscount;
	}
	
	//@Override from Saleable
	public boolean isSafeSale(int units){
		int isSafeorNot = getUnits() - units;
		
		if(isSafeorNot >= 0){
			return true;
		} else{return false;}
	}
	
	//@Override from Saleable
	public double applyExtraDiscount(double subtotal, double percenteageDiscount){
		return subtotal - (subtotal * percenteageDiscount);
	}
	
}