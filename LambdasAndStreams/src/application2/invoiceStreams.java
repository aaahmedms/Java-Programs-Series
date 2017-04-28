package application2;

/* -------------------------------- Problem 2 -------------------------------- */

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class invoiceStreams {
public static void main(String[] args) {
		
		//Intialize array of invoice objects to be used for the stream
		Invoice[] invoiceTest =new Invoice[8]; 
		invoiceTest[0] = new Invoice("83", "Eletric sander", 7, 57.98);
		invoiceTest[1] = new Invoice("24", "Power saw     ", 18, 99.99);
		invoiceTest[2] = new Invoice(" 7", "Sledge hammer ", 11, 21.50);
		invoiceTest[3] = new Invoice("77", "Hammer        ", 76, 11.99);
		invoiceTest[4] = new Invoice("39", "Lawn mower    ", 3, 79.50);
		invoiceTest[5] = new Invoice("68", "Screwdriver   ", 106, 6.99);
		invoiceTest[6] = new Invoice("56", "Jig saw       ", 21, 11.00);
		invoiceTest[7] = new Invoice(" 3", "Wrench        ", 34, 7.50);
		
		
		/*Prints the entire invoice unsorted */
		System.out.println("Invoice Unsorted: ");
		System.out.println("-------------------------------------------------");
		Arrays.stream(invoiceTest).forEach(System.out::println);
        
		/*a) Sort invoice objects by parts description alphabetically*/
		System.out.println("\na) Sorted Invoice objects by parts description:");
		System.out.println("-------------------------------------------------");
        Arrays.stream(invoiceTest)
        		.sorted(Comparator.comparing(Invoice::getPartDesc))
        		.forEach(System.out::println);
        
        /*b) Sort invoice objects by price */
        System.out.println("\nb) Sorted Invoice objects by price:");
        System.out.println("-------------------------------------------------");
        Arrays.stream(invoiceTest)
        	.sorted(Comparator.comparing(Invoice::getPricePerItem))
        	.forEach(System.out::println);
        
        /*c) Map each Invoice to its PartDescription and Quantity, the sort the results by Quantity. */
        Function<Invoice, Integer> byQuantity = Invoice::getQuant;
        Comparator<Invoice> Quant = Comparator.comparing(byQuantity);

        System.out.printf("\nc)Invoices mapped to description and quantity:%n");
        System.out.println("-------------------------------------------------");
        Arrays.stream(invoiceTest)
        	.sorted(Quant)
        	.map(e -> e.getPartDesc() + " " + e.getQuant())
        	.forEach(System.out::println);
        
        /* d) map each Invoice to its PartDescription and the value
         * of the Invoice (i.e., Quantity * Price). Order the results by Invoice value. 
         */
        Function<Invoice, Double> byValue = Invoice::getTotalCost; //maps totalcast which contains quantity*price
        Comparator<Invoice> val = Comparator.comparing(byValue);

        System.out.printf("\nd)Invoices mapped to description and value:%n");
        System.out.println("-------------------------------------------------");
        Arrays.stream(invoiceTest)
        	.sorted(val)
        	.map(e -> e.getPartDesc() + " " + e.getTotalCost())
        	.forEach(System.out::println);
        
        /* e) Modify Part (d) to select the Invoice values in the range $200 to $500.
         */
        //A filter is created to get a certain range of values in the array stream
        Predicate<Invoice> twoTofiveHundred = e -> (e.getTotalCost() >= 200 && e.getTotalCost() <= 500);
        
        System.out.printf("\ne)Invoices mapped to description and value ranging from 200$ to 500$:%n");
        System.out.println("-------------------------------------------------");
        Arrays.stream(invoiceTest)
        	.filter(twoTofiveHundred)
        	.sorted(val)
        	.map(e -> e.getPartDesc() + " " + e.getTotalCost())
        	.forEach(System.out::println);
        
	}//end main method

}//end class invoiceStreams
