package atm;

public class ATMController {
    public void Process() {
        ATM atm = new ATM();
        String cardNumber = atm.InsertCard();
        if(cardNumber.isEmpty()) {
            return;
        }
        boolean authenticated = atm.CheckPin(cardNumber);
        if(!authenticated) {
            return;
        }
        AccountType accountType = atm.SelectAccount();
        TransactionType transactionType = atm.GetTransactionType();

        Account account = atm.GetAccount(cardNumber, accountType);
        switch (transactionType) {
            case BALANCE: 
                atm.CheckBalance(account);
                break;
            case DEPOSIT:
                atm.Deposit(account); 
                break;
            case WITHDRAW:
                atm.Withdraw(account);
                break;
        }
    }
}
