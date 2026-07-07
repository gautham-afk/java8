
import java.util.function.DoubleSupplier;

interface Add{
    
    double addition(double a, double b);
}

class Account{
 private String accountHolder;
 private double balance;

  Account(String accountHolder,double balance){
    this.accountHolder = accountHolder;
    this.balance = balance;
  }

  void deposit(double amount){
    Add add = (a, b) -> {
       System.out.println("Depositing money");
       return a + b;
    };
    double result = add.addition(amount, balance);
    System.out.println(result + " deposited");
  }

  void withdraw(double amount) {
    if (amount <= balance){
        balance = balance - amount;
        System.out.println(amount + " withdrawn");
    } else {
        System.out.println("Insufficient balance");
    }
}

    void displayBalance(){
        System.out.println("Balance: " + balance);
    }
}

public class BankAccount {
  public static void main(String[] args) {
    DoubleSupplier random = Math::random;
    Account a1 = new Account("gautham",0);
    a1.deposit(random.getAsDouble());
    a1.deposit(10000);
    a1.withdraw(1500);
    a1.displayBalance();
  }
}
