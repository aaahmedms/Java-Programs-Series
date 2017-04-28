package application2;

public class Invoice 
{
   private String numPart; 
   private double perItemPrice;
   private int quantity;
   private String descriptPart;

   //invoice object constructor
   public Invoice( String part, String description, int count, double price )
   {
      numPart = part;
      descriptPart = description;
      
      //check if the quantity of the item is positive, if so then assign quantity to object
      if ( count > 0 ) quantity = count; 
      
      // check if price is a positive value, if so then assign price per item to object
      if ( price > 0.0 ) perItemPrice = price; 
      
   } // end four-argument Invoice constructor
   
   public String toString() {
	    return "Item: " + getPartNum() + " " + getPartDesc() 
	    + " " + getQuant() + " " + getPricePerItem();
	}// end constructor invoice

   
   // setter method to set the part number
   public void setPartNum( String part )
   {
      numPart = part;  
   } // end method setPartNum

   // getter method to get the part number
   public String getPartNum()
   {
      return numPart;
   } // end method getPartNum

   // setter method to set the part description
   public void setPartDesc( String description )
   {
      descriptPart = description;
   } // end method setPartDesc

   // getter method to get the part description
   public String getPartDesc()
   {
      return descriptPart;
   } // end method getPartDesc

   // setter method to set the quantity of item
   public void setQuant( int count )
   {
      //if less then or equal to 0, set to 0 else set to count
      quantity = (count <= 0.0) ? 0 : count;
   } // end method setQuant

   // getter method to get the quantity of item
   public int getQuant()
   {
      return quantity;
   } // end method getQuant

   // setter method to set the price per item
   public void setPricePerItem( double price )
   {
	   //if less then or equal to 0, set to 0 else set to price
	   perItemPrice = (price <= 0.0) ? 0.0 : price;
   } // end method setPricePerItem

   // setter method to get the price per item
   public double getPricePerItem()
   {
      return perItemPrice;
   } // end method getPricePerItem

   //return total cost
   public double getTotalCost() 
   {
      return getQuant() * getPricePerItem(); 
   } // end method getTotalCost

}// end class Invoice
