import java.util.*;
public class BankAccount{
    private int accountNumber;
    private String accountName;
    private double balance=0;

    public BankAccount(){
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String name){
        this.accountName = name;
    }

    public void deposit(double value){
        this.balance += value;
        System.out.printf("You have deposited PHP %.2f to your account.", value);
    }

    public void withdraw(double value){
        if (balance - value < 0){
            System.out.println("Unfortunately, you don't have enough balance to withdraw this amount.");
            System.out.printf("Your remaining balance is : PHP %.2f", balance);
        }
        else{
            this.balance -= value;
            System.out.printf("You have withdrawn PHP %.2f from your account.", value);
        }
    }

    public void displayBalance(){
        System.out.println("\n======ACCOUNT=====");
        System.out.println("Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Balance: PHP %.2f", balance);
    }
}

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        BankAccount n = new BankAccount();
        boolean error = false;

        do{
            try{
                System.out.print("Enter your account number: ");
                int accountNumber = scan.nextInt();
                n.setAccountNumber(accountNumber);
            }
            catch(Exception e){
                System.out.println("Invalid Input");
                scan.nextLine();
                error = true;
                continue;
            }
            error = false;
            
        }
        while(error != false);
        
        
        
        scan.nextLine();

        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        n.setAccountName(name);
        int choice =0;
        do{
            try{
                System.out.println("\n======MENU======");
                System.out.println("[1] Deposit");
                System.out.println("[2] Withdraw");
                System.out.println("[3] Display balance");
                System.out.println("[4] Exit");
                System.out.print("------>");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the amount you want to deposit: ");
                        n.deposit(scan.nextDouble());
                        break;
                    case 2:
                        System.out.print("Enter the amount you want to withdraw: ");
                        n.withdraw(scan.nextDouble());
                        break;
                    case 3:
                        n.displayBalance();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Please select from the given choices");
                        break;
                }    
            }
            catch(Exception e){
                System.out.println("Invalid input!");
                scan.nextLine();//To avoid infinite loop
            }
            
        }
        while(choice != 4);
        scan.close();  
    }
}