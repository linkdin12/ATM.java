import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; 
        }
        return false; 
    }
}
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    public void performTransaction() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble(); 
                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount. Please enter a positive value.");
                        break;
                    }
                    boolean withdrawalSuccess = bankAccount.withdraw(withdrawAmount);
                    if (withdrawalSuccess) {
                        System.out.println("Withdrawal successful. Please take your cash.");
                    } else {
                        System.out.println("Insufficient balance. Unable to process withdrawal.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount. Please enter a positive value.");
                        break;
                    }
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. Thank you for using our services.");
                    break;
                case 3:
                    double balance = bankAccount.getBalance();
                    System.out.println("Your account balance is: " + balance);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}
public class ATM{
	public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(500.0); 
        ATM atm = new ATM(bankAccount);
        atm.performTransaction();
    }

}