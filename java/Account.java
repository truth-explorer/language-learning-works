public class Account {
   private int id;
   private String holder;
   private boolean checking;
   private double balance;

	
	
   public Account(int id, String holder, boolean checking, double balance) {
      super();
      this.id = id;
      this.holder = holder;
      this.checking = checking;
      this.balance = balance;
   }
	
	
   public Account(int id, String holder, boolean checking) {
      this(id, holder, checking, 0.0);
   }

   public Account(int id, String holder) {
      this(id, holder, true, 0.0);
   }

   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getHolder() {
      return holder;
   }
   public void setHolder(String holder) {
      this.holder = holder;
   }
   public boolean isChecking() {
      return checking;
   }
   public void setChecking(boolean checking) {
      this.checking = checking;
   }
   public double getBalance() {
      return balance;
   }
   public void setBalance(double balance) {
      this.balance = balance;
   }
	
   public double deposit(double amount) {
      this.balance += amount;
      return amount;
   }
	
   public double withdraw(double amount) {
      if (this.balance < amount)
         return -1;
      this.balance -= amount;
      return amount;
   }
	
   public double transferTo(Account other, double amount) {
      if (this.balance < amount)
         return -1;
      this.balance -= amount;
      other.balance += amount;
      return amount;
   }
			
}
