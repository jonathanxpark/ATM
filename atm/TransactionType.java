/**
 * Types of transaction options
 */

package atm;
public enum TransactionType {
	/**
	 * Check the balance of an account
	 */
    BALANCE,
    /**
     * Deposit funds into an account
     */
    DEPOSIT,
    /**
     * Withdraw funds from an account
     */
    WITHDRAW
};