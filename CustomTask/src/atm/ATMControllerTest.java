package atm;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMControllerTest {
	
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	private final PrintStream output = System.out;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outputStream));
	}

	@After
	public void restoreStreams() {
	    System.setOut(output);
	}
	
	@Test
	public void testWithdraw() {
		// Test for withdraw
		Screen screen = new Screen(1234, AccountType.SAVINGS, 
				TransactionType.WITHDRAW, 0, 100 /* withdrawal amount*/);
		Bank bank = new Bank(AccountType.SAVINGS, 500 /* balance */);
		
		ATM atm = new ATM(screen, bank);
		ATMController controller = new ATMController(atm);
		
		controller.Process();
		assertEquals("Withdrew $100", outputStream.toString().trim());
	}
	
	@Test
	public void testCheckBalance() {
		// Test for checking balance
		Screen screen = new Screen(1234, AccountType.SAVINGS, 
				TransactionType.BALANCE, 0, 0);
		
		Bank bank = new Bank(AccountType.SAVINGS, 500 /* balance */);
		
		ATM atm = new ATM(screen, bank);
		ATMController controller = new ATMController(atm);
		
		controller.Process();
		assertEquals("Your balance is $500", outputStream.toString().trim());
	}
	
	@Test
	public void testDeposit() {
		// Test for deposit
		Screen screen = new Screen(1234, AccountType.SAVINGS, 
				TransactionType.DEPOSIT, 200 /* deposited amount*/, 0);
		
		Bank bank = new Bank(AccountType.SAVINGS, 500 /* balance */);
		
		ATM atm = new ATM(screen, bank);
		ATMController controller = new ATMController(atm);
		
		controller.Process();
		assertEquals("Deposited $200", outputStream.toString().trim());
	}
}
