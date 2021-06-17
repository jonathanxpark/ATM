package atm;

abstract class BankBase {    
    abstract boolean Authenticate(String cardNumber, int pin);
    abstract Account GetAccount(String cardNumber, AccountType accountType);
}

public class Bank extends BankBase {
    public boolean Authenticate(String cardNumber, int pin) {
        return true;
    }
    
    public Account GetAccount(String cardNumber, AccountType accountType) {
        Account account = new Account(accountType, "546-1235", 1000);
        return account;
    }
}
