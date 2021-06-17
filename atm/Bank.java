/**
 * This is an abstract class to show case the bank operations. 
 * Extend this class to integrate it with a real bank system in the future.
 * @author jonathanxpark
 * @version 1.0
 * @since 2021-06-21
 */

package atm;

abstract class BankBase {    
    abstract boolean Authenticate(String cardNumber, int pin);
    abstract Account GetAccount(String cardNumber, AccountType accountType);
}

/**
 * Simple example Bank class to provide values to test the code. 
 * @author jonathanxpark
 * @version 1.0
 * @since 2021-06-21
 */
public class Bank extends BankBase {
	/**
	 * the account 
	 */
	private Account account;
	
	/**
	 * Constructor for Bank class
	 */
	public Bank() {
		this.account = new Account(AccountType.CHECKING, "546-1235", 1000);
	}
	
	/**
	 * Constructor for unit test.
	 * @param accountType type of user account
	 * @param balance amount of balance in the account
	 */
	public Bank(AccountType accountType, long balance) {
		this.account = new Account(accountType, "546-1235", balance);
	}
	
    public boolean Authenticate(String cardNumber, int pin) {
        return true;
    }
    
    public Account GetAccount(String cardNumber, AccountType accountType) {
        return this.account;
    }
}
