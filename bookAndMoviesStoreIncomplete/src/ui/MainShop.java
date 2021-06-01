package ui;

import java.util.Scanner;

import model.Shop;
import model.ProductType;

/**
 * 
 * @author angievig
 * 
 */
public class MainShop {
	private Shop shop;
	private static Scanner sc = new Scanner(System.in);
	
	public MainShop() {
		shop= new Shop("AP1's book store");
	}

	public static void main(String[] args) {
		
		MainShop mainObject= new MainShop();
		int option = 0;
		do {
			option=mainObject.showMenuAndReadInput();
			mainObject.dispatchOption(option);
		}while(option!=0);
		
	}

	public void dispatchOption(int option) {
		switch(option) {
		case -1: 
			createScenario();
			break;
		case 0: 
			System.out.println("\n*** Leaving the app, bye bye ***");
			break;
		case 1:
			addProductCatalog();
			break;
		case 2:
			System.out.println(shop.showCatalog() + "\n=====================================\n");
			break;
		case 3:
			processProduct();
			break;
				
		}
		
		
	}

	public void rentProduct(String code) {
		System.out.println("\n*** Welcome to the rent's screen***\n");
		
		System.out.println("How many days you wanna rent the product?");
		int days= sc.nextInt();
		sc.nextLine();
		
		String answer = shop.rentProduct(code, days);
		System.out.println(answer);
		
		
		
	}
	
	public void saleProduct(String code) {
		System.out.println("\n*** Welcome to the sale's screen***\n");
		
		System.out.println("Digit the amount of units you wanna buy");
		int units2Buy= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digit the percenteage of discount(if applies)\n"
				+ "the discount is a number between 0 and 1");
		double discount= sc.nextDouble();
		sc.nextLine();
		
		String answer = shop.saleProduct(code, units2Buy, discount);
		
		System.out.println(answer);
		
		
	}

	public void processProduct() {
		System.out.println("\n*** Digit the code of the product you wanna process ***\n");
		String code = sc.nextLine();
		
		int operation= shop.getOperation(code);
		
		switch(operation) {
		case Shop.SALE:
			System.out.println("You picked a saleable product!!");
			saleProduct(code);
			break;
		case Shop.RENT:
			System.out.println("You picked a rentable product!!");
			rentProduct(code);
			break;
			default :
				System.out.println("Sorry, there's no product with that code");
				
		}
		

	}

	public  void createScenario() {
		TestScenario scenario = new TestScenario();
		scenario.createScenario1(shop);
		
	}

	public int showMenuAndReadInput() {
		System.out.println("*** Welcome to the "+ shop.getName() +  " ***\n");
		System.out.println("Please, select one option:\n"+
							"(-1) For running the scenario \n"+
							"(1) For adding a product to the catalog \n"+
							"(2) For displaying the catalog's contents \n"+
							"(3) For rent/sale a product  \n"+
							"(0) For leaving the app");
		
		int number= sc.nextInt();
		sc.nextLine();
		
		return number;
		
		
	}
	
	public void addProductCatalog(){
		ProductType type = null;
		
		System.out.println("Porfavor ingrese los siguientes datos del producto: \n");
		System.out.println("Porfavor escoja el tipo de producto que deseas agregar:");
		System.out.println("( 1 ): Libro");
		System.out.println("( 2 ): Magacine");
		System.out.println("( 3 ): Pelicula en DVD");
		System.out.println("( 4 ): Pelicula Descargada");
		
		int option = 0;
		do{
			System.out.print("Opcion: ");
			option = sc.nextInt();
			sc.nextLine();
			
			switch(option){
				case 1:
				type = ProductType.BOOK;
				break;
				case 2:
				type = ProductType.MAGAZINE;
				break;
				case 3:
				type = ProductType.DVD_MOVIE;
				break;
				case 4:
				type = ProductType.DOWNLOAD_MOVIE;
				break;
				default:
				option = 0;
				break;
			}
			
		}while(option == 0);
		
		System.out.print("Codigo del producto: ");
		String code = sc.nextLine();
		
		System.out.print("Nombre del producto: ");
		String name = sc.nextLine();
		
		System.out.print("Precio del producto: $");
		double price = sc.nextDouble();
		
		System.out.println("¿El producto sera puesto a la venta?");
		System.out.println("( 1 ) SI\n( 2 ) NO");
		
		int option2 = 0;
		do{
			System.out.print("Opcion: ");
			option2 = sc.nextInt();
			sc.nextLine();
			
			switch(option2){
				case 1:
				System.out.println("Porfavor ingrese las unidades que dispondra a la venta: ");
				System.out.print("Unidades: ");
				int units = sc.nextInt();
				sc.nextLine();
				
				System.out.println(shop.addProduct(code, name, units, price, type));
				break;
				case 2:
				System.out.println(shop.addProduct(code, name, price, type));
				break;
				default:
				option = 0;
				break;
			}
			
		}while(option2 == 0);
		
	}
	
	

}
