package OCP_voilate;

public class Payment {
   String method;

   public Payment(String var1) {
      this.method = var1;
   }

   public void pay() {
      if (this.method == "Creditcard") {
         System.out.println("payment through Creditcard");
      } else {
         System.out.println("payment through UPI");
      }

   }
}