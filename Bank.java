class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public String toString() {
        return "Account " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance;
    }
}

class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank() {
        accounts = new BankAccount[5]; // Max 5 accounts
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count++] = account;
        } else {
            System.out.println("Cannot add more accounts. Limit reached.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void displayAccounts() {
        for (int i = 0; i < count; i++) {
            System.out.println(accounts[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Add accounts
        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        // Attempt invalid withdrawal
        bank.withdraw(1001, 6000.0);

        // Valid withdrawal
        bank.withdraw(1002, 1000.0);

        // Display all accounts
        bank.displayAccounts();
    }
}
