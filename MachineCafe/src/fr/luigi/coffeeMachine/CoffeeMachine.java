/*
 Projet pour création d'une machine à café
 Auteur : Luigi CAPO-CHICHI
 Date : 26/12/2021
 */




package fr.luigi.coffeeMachine;

public class CoffeeMachine {
	private static String drink;
	private static int sugar;
	private StringBuilder sortie;
	private double paiement;
	private static final double priceCoffee = 0.6;
	private static final double priceTea = 0.4;
	private static final double priceChocolate = 0.5;
	private static final double priceOrange = 0.6;

	//itération 1
	public CoffeeMachine() {
		drink = "M";
		sugar = 0;
		sortie = new StringBuilder();
	}
	
	//itération 2
	public CoffeeMachine(double money) {
		drink = "M";
		sugar = 0;
		sortie = new StringBuilder();
		paiement = money;
	}
	
	
	public static String getDrink() {
		return drink;
	}

	public static void setDrink(String drink) {
		CoffeeMachine.drink = drink;
	}

	public static int getSugar() {
		return sugar;
	}

	public static void setSugar(int sugar) {
		CoffeeMachine.sugar = sugar;
	}

	public static double getPricechocolate() {
		return priceChocolate;
	}

	public static double getPricecoffee() {
		return priceCoffee;
	}

	public static double getPricetea() {
		return priceTea;
	}

	public static double getPriceorange() {
		return priceOrange;
	}

	//Methode permettant de définir les éléments de la boisson en fonction d'une chaine de caractères en entrée
	public void initDrink(String s) {
		String[] tab = s.split(":");
		drink = tab[0];
		try{sugar = Integer.parseInt(tab[1]);}
		catch(Exception e) {sugar = 0;}
	}
	
	//rajout du controle sur le prix pour l'itération 2
	public StringBuilder getSortie() {
		switch(drink) {
		case "T":
			if(paiement >= priceTea) {
				sortie.append("Drink maker makes 1 tea with ");
				if (sugar == 0) {sortie.append("no sugar - and therefore no stick");}
				else {sortie.append(String.valueOf(sugar));
				sortie.append(" sugar and a stick");}
			}
			else {
				sortie.append("missing "); 
				sortie.append(priceTea - paiement); 
			    sortie.append("euros to make the drink");
		   } 
			break;
		case "H":
			if(paiement >= priceChocolate) {
				sortie.append("Drink maker makes 1 chocolate with ");
				if (sugar == 0) {sortie.append("no sugar - and therefore no stick");}
				else {
					sortie.append(String.valueOf(sugar));
					sortie.append(" sugar and a stick");
				}
			}
			else {
				sortie.append("missing "); 
				sortie.append(priceChocolate - paiement); 
			    sortie.append("euros to make the drink");
		   } 
			break;
		case "C":
			if(paiement >= priceCoffee) {
				sortie.append("Drink maker makes 1 coffee with ");
				if (sugar == 0) {sortie.append("no sugar - and therefore no stick");}
				else {sortie.append(String.valueOf(sugar));
				sortie.append(" sugar and a stick");}
			}
			else {
				sortie.append("missing "); 
				sortie.append(priceCoffee - paiement); 
			    sortie.append("euros to make the drink");
			}
			break;
		case "Ch":
			if(paiement >= priceCoffee) {
				sortie.append("Drink maker makes an extra hot coffee with ");
				if (sugar == 0) {sortie.append("no sugar - and therefore no stick");}
				else {sortie.append(String.valueOf(sugar));
				sortie.append(" sugar and a stick");}
			}
			else {
				sortie.append("missing "); 
				sortie.append(priceCoffee - paiement); 
			    sortie.append("euros to make the drink");
			}
			break;
		case "Hh":
			if(paiement >= priceChocolate) {
				sortie.append("Drink maker makes an extra hot chocolate with ");
				if (sugar == 0) {sortie.append("no sugar - and therefore no stick");}
				else {sortie.append(String.valueOf(sugar));
				sortie.append(" sugar and a stick");}
			}
			else {
				sortie.append("missing "); 
				sortie.append(priceChocolate - paiement); 
			    sortie.append("euros to make the drink");
			}
			break;
		case "Th":
			if(paiement >= priceTea) {
				sortie.append("Drink maker makes an extra hot tea with ");
				if (sugar == 0) {sortie.append("no sugar - and therefore no stick");}
				else {sortie.append(String.valueOf(sugar));
				sortie.append(" sugar and a stick");}
			}
			else {
				sortie.append("missing "); 
				sortie.append(priceTea - paiement); 
			    sortie.append("euros to make the drink");
			}
			break;
		case "O":
			if(paiement >= priceOrange) {
				sortie.append("Drink maker makes 1 orange juice");
			}
			else {
				sortie.append("missing "); 
				sortie.append(priceOrange - paiement); 
			    sortie.append("euros to make the drink");
			}
			break;
		case "M":
			sortie.append("Drink maker forwards any message received onto the coffee machine interface for the customer to see");
			break;
		}
		return sortie;
	}
	
	public double getPaiement() {
		return paiement;
	}

	public void setPaiement(double paiement) {
		this.paiement = paiement;
	}

	public static void main(String args[]) {
		
		//Demande d'un café sans sucre avec 0.6 euros
		CoffeeMachine cm = new CoffeeMachine(0.6);
		String s = "C::";
		cm.initDrink(s);
		StringBuilder sb = cm.getSortie();
		System.out.println(sb.toString());
		
		//Demande d'un café sans sucre avec 0.3 euros
		cm = new CoffeeMachine(0.3);
		s = "C::";
		cm.initDrink(s);
		sb = cm.getSortie();
		System.out.println(sb.toString());
		
		//Demande d'un café avec 0.6 euros
		cm = new CoffeeMachine(0.6);
		s = "C:2:0";
		cm.initDrink(s);
		sb = cm.getSortie();
		System.out.println(sb.toString());
		
		//Demande d'un chocolat avec 0.7 euros
		cm = new CoffeeMachine(0.7);
		s = "H::";
		cm.initDrink(s);
		sb = cm.getSortie();
		System.out.println(sb.toString());
		
		//Demande d'un thé avec 0.7 euros
		cm = new CoffeeMachine(0.7);
		s = "T:2:0";
		cm.initDrink(s);
		sb = cm.getSortie();
		System.out.println(sb.toString());
		
		//Demande d'un cafe chaud avec 0.7 euros sans sucre
		cm = new CoffeeMachine(0.7);
		s = "Ch::";
		cm.initDrink(s);
		sb = cm.getSortie();
		System.out.println(sb.toString());
		
		//Demande d'un café chaud avec 0.7 euros
		cm = new CoffeeMachine(0.7);
		s = "Ch:3:0";
		cm.initDrink(s);
		sb = cm.getSortie();
		System.out.println(sb.toString());
		
		//Demande d'un chocolat chaud avec 0.7 euros
		cm = new CoffeeMachine(0.7);
		s = "Hh:2:0";
		cm.initDrink(s);
		sb = cm.getSortie();
		System.out.println(sb.toString());
		
		//Demande d'un jus d'orange
		cm = new CoffeeMachine(0.7);
		s = "O::";
		cm.initDrink(s);
		sb = cm.getSortie();
		System.out.println(sb.toString());
	}

}
