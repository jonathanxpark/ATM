/**
 * The Account Class implements the various transactions in an account
 * @author jonathanxpark
 * @version 1.0
 * @since 2021-06-21
 */

package atm;

public class Account {
	/**
	 * The account number of the account 
	 */
    private String accountNumber;
    /**
     * The type of account that is being used (e.g. CHECKING/SAVINGS)
     */
    private AccountType accountType;
    /**
     * The amount of money in the account
     */
    private long balance;

    /**
     * Constructor for Account class
     * @param accountType The type of account that is being used (e.g. CHECKING/SAVINGS)
     * @param accountNumber The account number of the account 
     * @param balance The amount of money in the account
     */
    public Account(AccountType accountType, String accountNumber, long balance) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Function to return the balance in an account
     * @return amount of money in an account
     */
    public long GetBalance() {
        return this.balance;
    }

    /**
     * Function to deposit a certain amount of money into an account
     * @param amount the amount of money being deposited
     * @return success of if deposit went through
     */
    public boolean Deposit(long amount) {
        if(amount < 0) {
            return false;
        }

        this.balance += amount;
        return true;
    }

    /**
     * Function to withdraw a certain amount of money from an account
     * @param amount the amount of money being withdrawn
     * @return success of if withdrawal went through
     */
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
