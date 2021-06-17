package atm;

abstract class ScreenBase {
    abstract int GetPin();
    abstract AccountType SelectAccount();
    abstract TransactionType GetTransactionType();
    abstract int GetDepositAmount();
    abstract int GetWithdrawalAmount();
    abstract void DisplayBalance(long balance);
}

public class Screen extends ScreenBase {
    public int GetPin() {
        return 123;
    }

    public AccountType SelectAccount() {
        return AccountType.CHECKING;
    }

    public TransactionType GetTransactionType() {
        return TransactionType.DEPOSIT;
    }

    public int GetDepositAmount() {
        return 100;
    }

    public int GetWithdrawalAmount() {
        return 100;
    }

    public void DisplayBalance(long balance) {
        // TODO: display the balance
        System.out.println("Your balance is $" + balance);
    }
}