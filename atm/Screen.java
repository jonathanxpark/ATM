/**
 * This is an abstract class to show case the screen outputs. 
 * Extend this class to integrate it with a real ATM in the future.
 * @author jonathanxpark
 * @version 1.0
 * @since 2021-06-21
 */

package atm;

abstract class ScreenBase {
    abstract int GetPin();
    abstract AccountType SelectAccount();
    abstract TransactionType GetTransactionType();
    abstract int GetDepositAmount();
    abstract int GetWithdrawalAmount();
    abstract void DisplayBalance(long balance);
}

/**
 * Simple example Screen class to provide values to test the code. 
 * @author jonathanxpark
 * @version 1.0
 * @since 2021-06-21
 */

public class Screen extends ScreenBase {
	private int pin;
	private AccountType accountType;
	private TransactionType transactionType;
	private int depositAmount;
	private int withdrawalAmount;
	
	/**
	 * Constructor to assign random values, to be replaced
	 * with real values from input in the future.
	 */
	public Screen() {
		this.pin = 123;
		this.accountType = accountType.CHECKING;
		this.transactionType = transactionType.DEPOSIT;
		this.depositAmount = 100;
		this.withdrawalAmount = 200;
	}
	
	/**
	 * Constructor for unit test
	 * @param pin user pin number for card.
	 * @param accountType CHECKING or SAVINGS account.
	 * @param transactionType Deposit/Withdrawal/Balance.
	 * @param depositAmount Amount of funds to be deposited.
	 * @param withdrawalAmount Amount of funds to be withdrawn.
	 */
	protected Screen(int pin, AccountType accountType,
			TransactionType transactionType,
			int depositAmount, int withdrawalAmount) {
		this.pin = pin;
		this.accountType = accountType;
		this.transactionType = transactionType;
		this.depositAmount = depositAmount;
		this.withdrawalAmount = withdrawalAmount;
	}
	
    public int GetPin() {
        return this.pin;
    }

    public AccountType SelectAccount() {
        return this.accountType;
    }

    public TransactionType GetTransactionType() {
        return this.transactionType;
    }

    public int GetDepositAmount() {
        return this.depositAmount;
    }

    public int GetWithdrawalAmount() {
        return this.withdrawalAmount;
    }

    public void DisplayBalance(long balance) {
        // TODO: display the balance
        System.out.println("Your balance is $" + balance);
    }
}