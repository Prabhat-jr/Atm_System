import java.util.*;
class ATM
{
private double balance;
private int pin;
public ATM(double initialBalance, int pin)
{
    this.balance=initialBalance;
    this.pin=pin;
}
public boolean authenticate(int enterdPin)
{
    return this.pin == enterdPin;
}
public double checkBalance()
{
return balance;
}
public void deposit(double amount)
{
    if(amount > 0)
    {
        balance += amount;
        System.out.println("Successfully deposited: $" +amount);
    }
    else{
        System.out.println("invalid deposit amount");
    }
}
public void withdraw(double amount)
{
    if(amount > 0 && amount <=balance)
    {
        balance -= amount;
        System.out.println("Sucessfully withdraw $" +amount);
    }
    else{
        System.out.println("insufficient balance or invaild amount!");
    }
}
}
public class ATMSystem
{
    public static void main(String[] args) {
    Scanner  sc= new Scanner(System.in);
    ATM atm=new ATM(500, 1234);
    System.out.println("enter 4-digit PIN");
    
    int enterdPin =sc.nextInt();
    if(!atm.authenticate(enterdPin))
    {
        System.out.println("Incorrect Pin! Exiting...");
         return;
    }
    while (true) {
         System.out.println("\n======ATM Menu ======");
         System.out.println("1. Check Blance");
         System.out.println("2. Deposit Money");
         System.out.println("3. Withdraw Money");
         System.out.println("4. Exit");
         int choice =sc.nextInt();
         switch (choice) {
            case 1:
                System.out.println("Your Balance: $" +atm.checkBalance());
                break;
            case 2:
                 System.out.println("Enter Deposit Money: $");
                 double depositAmount= sc.nextDouble();
                 atm.deposit(depositAmount);  
                 break;
            case 3:
                 System.out.println("Enter Withdrawal amount: $");
                 double withdrawAmount = sc.nextDouble();
                 atm.withdraw(withdrawAmount);
                 break;
            case 4:
                System.out.println("Thank you for using this ATM Goodbye");
                return;
            default:
                System.out.println("Invaild Choice Please Try Again");
                sc.close();
         }
    }
    }
}
