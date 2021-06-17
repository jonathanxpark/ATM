/**
 * The ATM class implements the various functions of an ATM machine.
 * 
 * @author jonathanxpark
 * @version 1.0
 * @since 2021-06-21
 */

package atm;

public class ATM {
	/**
	 *  The initial amount of cash available in the ATM machine
	 */
    private long amountOfCash = 10000;
    /**
	 *  The card reader to scan the card when the user inputs
	 */
    private CardReader cardReader;
    /**
	 *  The bin containing/holding the money in the ATM machine
	 */
    private CashBin cashBin;
    /**
	 *  Class to access the user interaction on screen
	 */
    private Screen screen;
    /**
	 *  Class to access a bank's information
	 */
    private Bank bank;

    /**
     * Constructor for ATM class
     */
    public ATM() {
        this.cardReader = new CardReader();
        this.cashBin = new CashBin(amountOfCash);
        this.screen = new Screen();
        this.bank = new Bank();
    }
    
    /**
     * Constructor for Unit Test.
     */
    protected ATM(Screen screen, Bank bank) {
        this.cardReader = new CardReader();
        this.cashBin = new CashBin(amountOfCash);
        this.screen = screen;
        this.bank = bank;
    }

    /**
     * User inserts the card and the machine reads it
     * @return associated card number on the card
     */
    public String InsertCard() {
        String cardNumber = cardReader.Read();
        return cardNumber;
    }

    /**
     * Checks the associated pin of a specific card
     * @param cardNumber the number on the card 
     * @return boolean of if the pin matches with the card.
     */
    public boolean CheckPin(String cardNumber) {
        int pin = this.screen.GetPin();
        return this.bank.Authenticate(cardNumber, pin);
    }

    /**
     * User selects what type of account they want to use
     * @return the account selected by the user
     */
    public AccountType SelectAccount() {
        return this.screen.SelectAccount();
    }

    /**
     * User selects the type of transaction they wish to make
     * @return the type of transaction selected by the user
     */
    public TransactionType GetTransactionType() {
        return this.screen.GetTransactionType();
    }

    /**
     * Gets the corresponding account based on card number and account type
     * @param cardNumber the number on the card
     * @param accountType the type of account selected by the user previously
     * @return the account associated with the card number and account type
     */
    public Account GetAccount(String cardNumber, AccountType accountType) {
        return this.bank.GetAccount(cardNumber, accountType);
    }

    /**
     * Checks the balance in a specific account and displays it
     * @param account the specific account of the user to be displayed
     */
    public void CheckBalance(Account account) {
        long amount = account.GetBalance();
        this.screen.DisplayBalance(amount);
    }

    /**
     * Deposits funds into a specific account and displays it
     * @param account the specific account of the user to receive funds
     * @return boolean of if deposit was successful
     */
    public boolean Deposit(Account account) {
        int amount = this.screen.GetDepositAmount();
        boolean success = account.Deposit(amount);
        if(success) {
            System.out.println("Deposited $" + amount);
        }
        return success;
    }

    /**
     * Withdraws funds from a specific account and displays it 
     * @param account the specific account of the user to withdraw funds
     * @return boolean of if withdrawal was successful
     */
    public boolean Withdraw(Account account) {
        int amount = this.screen.GetWithdrawalAmount();
        boolean success = account.Withdraw(amount);
        if(success) {
            System.out.println("Withdrew $" + amount);
        }
        return success;
    }
}