package atm;

public class ATM {
    private long amountOfCash = 10000;
    private CardReader cardReader;
    private CashBin cashBin;
    private Screen screen;
    private Bank bank;

    public ATM() {
        this.cardReader = new CardReader();
        this.cashBin = new CashBin(amountOfCash);
        this.screen = new Screen();
        this.bank = new Bank();
    }

    public String InsertCard() {
        String cardNumber = cardReader.Read();
        return cardNumber;
    }

    public boolean CheckPin(String cardNumber) {
        int pin = this.screen.GetPin();
        return this.bank.Authenticate(cardNumber, pin);
    }

    public AccountType SelectAccount() {
        return this.screen.SelectAccount();
    }

    public TransactionType GetTransactionType() {
        return this.screen.GetTransactionType();
    }

    public Account GetAccount(String cardNumber, AccountType accountType) {
        return this.bank.GetAccount(cardNumber, accountType);
    }

    public void CheckBalance(Account account) {
        long amount = account.GetBalance();
        this.screen.DisplayBalance(amount);
    }

    public boolean Deposit(Account account) {
        int amount = this.screen.GetDepositAmount();
        boolean success = account.Deposit(amount);
        if(success) {
            System.out.println("Deposited $" + amount);
        }
        return success;
    }

    public boolean Withdraw(Account account) {
        int amount = this.screen.GetWithdrawalAmount();
        boolean success = account.Withdraw(amount);
        if(success) {
            System.out.println("Withdrew $" + amount);
        }
        return success;
    }
}