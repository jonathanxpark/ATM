package atm;

abstract class CashBinBase {
    abstract boolean DepositCash();
    abstract boolean WithdrawCash(long amount);
}

public class CashBin extends CashBinBase{
    private long balance;

    public CashBin(long balance) {
        this.balance = balance;
    }

    public boolean DepositCash() {
        long amount = ReceiveCash();
        this.balance += amount;
        return true;
    } 

    // TODO: update amount of cash in the CashBin
    private long ReceiveCash() {
        return 75;
    }

    // TODO: update amount of cash in the CashBin
    private boolean GiveCash(long amount) {
        return true;
    }

    public boolean WithdrawCash(long amount) {
        if(this.balance >= amount) {
            this.balance -= amount;
            boolean success = GiveCash(amount);
            return success;
        }
        return false;
    }

}
