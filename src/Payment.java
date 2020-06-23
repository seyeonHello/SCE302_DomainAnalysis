public class Payment
{
   private Float amount;

   public Payment( Float cashTendered ){
	   System.out.println("½ÂÀÎ ¿Ï·á.");
	   amount = cashTendered; 
	   }
   public Float getAmount() { return amount; }
}
