/**
 * The ATMController class implements an ATM test.
 * 
 * @author jonathanxpark
 * @version 1.0
 * @since 2021-06-21
 */

package atm;

public class ATMController {
	private ATM atm;
	
	/**
	 * Constructor for ATM Controller.
	 */
	public ATMController() {
		this.atm = new ATM();
	}
	
	/**
	 * Constructor for the unit test.
	 */
	protected ATMController(ATM atm) {
		this.atm = atm;
	}
	
	/**
	 * ATM Controller containing all the functions of the ATM.
	 */
    public void Process() {
        // Ask user to insert their card 
        String cardNumber = this.atm.InsertCard();
        
        // Check if the card was properly read
        if(cardNumber.isEmpty()) {
            return;
        }
        
        // Ask the pin number and authenticate user
        boolean authenticated = this.atm.CheckPin(cardNumber);
        if(!authenticated) {
            return;
        }
        
        // Ask user to select which type of account they want to use
        AccountType accountType = this.atm.SelectAccount();
        
        // Ask user for specific transaction type
        TransactionType transactionType = this.atm.GetTransactionType();

        // Retrieve account information
        Account account = atm.GetAccount(cardNumber, accountType);
        
        // Perform the transaction
        switch (transactionType) {
            case BALANCE: 
                this.atm.CheckBalance(account);
                break;
            case DEPOSIT:
                this.atm.Deposit(account); 
                break;
            case WITHDRAW:
                this.atm.Withdraw(account);
                break;
        }
    }
    
}
