package model;
import java.time.LocalDate;

public class ProductForRent extends Product implements Rentable{
	
	//Attributes
	private LocalDate devolutionDate;
	
	//Relationships
	private State state;
	
	//Constructor
	public ProductForRent(String code, String name, double price, ProductType type){
		super(code, name, 1, price, type);
		devolutionDate = LocalDate.of(2021, 5, 28);
		state = State.AVAILABLE;
	}
	
	//@0verride from Rentable
	public void rentProduct(int amountDays){
		int aux, day = 28, month = 5, year = 2021;
		
		state = State.RENTED;
		aux = day + amountDays;
	
		for(int i = 0; i <= 12; i++){
			if(month == 1){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
					year++;
				}
			} else if(month == 2){
				if(aux > 28){
					day = aux - 28;
					month++;
					aux = day;
				}
			} else if(month == 3){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 4){
				if(aux > 30){
					day = aux - 30;
					month++;
					aux = day;
				}
			} else if(month == 5){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 6){
				if(aux > 30){
					day = aux - 30;
					month++;
					aux = day;
				}
			} else if(month == 7){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 8){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 9){
				if(aux > 30){
					day = aux - 30;
					month++;
					aux = day;
				}
			} else if(month == 10){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			} else if(month == 11){
				if(aux > 30){
					day = aux - 30;
					month++;
					aux = day;
				}
			} else if(month == 12){
				if(aux > 31){
					day = aux - 31;
					month++;
					aux = day;
				}
			}
		}
		
		devolutionDate = LocalDate.of(year, month, day);
		
	} 
	
	//@0verride from Rentable
	public double getRentPrice(int amountDays){
		return amountDays * price; 
	}
	
	//@0verride from Product
	public String getInformation(){
		return "===================\n"+
			   "=== Information ===\n"+
			   "===================\n\n"+
			   "Product Type: " + getType() + "\n"+
			   "Code: " + getCode() + "\n"+
			   "Product name: " + getName() + "\n"+
			   "State: " + state + "\n"+
			   "Return deadline: " + devolutionDate + "\n";
	}
	
	//@0verride from Rentable
	public boolean isSafeRent(){
		if(state == State.AVAILABLE){
			return true;
		} else {return false;}
	}
	
}