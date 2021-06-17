package atm;
import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private AccountType accountType;
    private long balance;

    public Account(AccountType accountType, String accountNumber, long balance) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long GetBalance() {
        return this.balance;
    }

    public boolean Deposit(long amount) {
        if(amount < 0) {
            return false;
        }

        this.balance += amount;
        return true;
    }

    public boolean Withdraw(long amount) {
        if(amount > 500) {
            return false;
        }
        if(amount < 0) {
            return false;
        }

        if (this.balance < amount) {
            return false;
        }

        this.balance -= amount;
        return true;
    }
}
