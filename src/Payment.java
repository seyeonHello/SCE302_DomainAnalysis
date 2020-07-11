public class Payment {
   private Float amount;

   public Payment(Float cashTendered) {
      // System.out.println("���� �Ϸ�.");
      amount = cashTendered;
   }

   public Float getAmount() {
      return amount;
   }
}
