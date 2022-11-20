public class Bank {
    public static void main(String[] argv) {
        BankingAccount client1 = new BankingAccount();

        client1.setBalance(4000);
        client1.displayBank();
        client1.withdrawal(400);
        client1.displayBank();
    }
}

class BankingAccount {
    private double balance;
    private double overdraft;        // Authorized overdraft

    public BankingAccount() {
        balance = 0.0;
        overdraft = -700.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balanceEntry) {
        balance = balanceEntry;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraftEntry) {
        overdraft = overdraftEntry;
    }

    public void withdrawal(double amount) {
        double newBalance = balance - amount;
        
        if (amount < 0.0)  
            System.out.println("Error : Please enter a positive amount.");
        else if (newBalance < overdraft)
            System.out.println("This operation is impossible. You'll be overdrawn.");
        else balance = newBalance;
    }

    public void displayBank() {
        System.out.println("---------- Client 1 ----------");
        System.out.println("Balance : " + getBalance());
        System.out.println("Overdraft : " + getOverdraft());
    }
}