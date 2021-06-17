/**
 * This is an abstract class to show case the CashBin. 
 * Extend this class to integrate it with a real Cash Bin in the future.
 * @author jonathanxpark
 * @version 1.0
 * @since 2021-06-21
 */

package atm;

abstract class CashBinBase {
    abstract boolean DepositCash();
    abstract boolean WithdrawCash(long amount);
}

/**
 * Simple example CashBin class to provide values to test the code. 
 * @author jonxpan
 * @version 1.0
 * @since 2021-06-21
 */
public class CashBin extends CashBinBase{
	/**
	 * Amount of paper money in the Cash Bin.
	 */
    private long balance;

    /**
     * Constructor for CashBin class.
     * @param balance amount of paper money in the Cash Bin.
     */
    public CashBin(long balance) {
        this.balance = balance;
    }

    /**
     * User inputs/deposits cash into the machine.
     * @return boolean of if deposit was successful.
     */
    public boolean DepositCash() {
        long amount = ReceiveCash();
        this.balance += amount;
        return true;
    } 

    /**
     * Helper function for DepositCash to 
     * measure how much money was added.
     * @return amount of money deposited.
     */
    private long ReceiveCash() {
        return 75;
    }
    
    /**
     * User withdraws cash from the machine
     * @return boolean of if withdrawal was successful.
     */
    public boolean WithdrawCash(long amount) {
        if(this.balance >= amount) {
            this.balance -= amount;
            boolean success = GiveCash(amount);
            return success;
        }
        return false;
    }

    /**
     * Helper function for WithdrawCash to 
     * measure how much money was withdrawn.
     * @param amount of money withdrawn.
     * @return boolean of if money was given to user
     */
    private boolean GiveCash(long amount) {
        return true;
    }
}
