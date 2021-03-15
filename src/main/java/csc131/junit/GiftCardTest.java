package csc131.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import java.time.Month;

public class GiftCardTest
{
	@Test
    public void getIssuingStore()
    {
        double       balance;
        GiftCard     card;
        int          issuingStore;
        issuingStore = 1337;
        balance      = 100.00;
        card = new GiftCard(issuingStore, balance);
        assertEquals("getIssuingStore()",
                     issuingStore, card.getIssuingStore());
    
    } 
	@Test
	public void getBalance()
	{
		double       balance;
        GiftCard     card;
        int          issuingStore;
        issuingStore = 1335;
        balance      = 100.00;
        card = new GiftCard(issuingStore, balance);
        assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	@Test
	public void deduct_RemainingBalance() {
		double       balance;
        GiftCard     card;
        int          issuingStore;
        String str = "Remaining Balance: " + String.format("%6.2f",50.00);
        issuingStore = 1337;
        balance      = 100.00;
        card = new GiftCard(issuingStore, balance);
        assertEquals("deduct(50.00)", str, card.deduct(50.00));
	}
	@Test
	public void invalidTransaction() {
		double       balance;
	    GiftCard     card;
	    int          issuingStore;
	    String str = "Invalid Transaction";
		issuingStore = 1337;
		balance      = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("Invalid Transaction", str, card.deduct(-50.00));
	}
	@Test
	public void overdraft() {
		double       balance;
	    GiftCard     card;
	    int          issuingStore;
	    String str = "Amount Due: " + String.format("%6.2f",25.0);
	    issuingStore = 1337;
	    balance      = 25.00;
	    card = new GiftCard(issuingStore, balance);
	    assertEquals("overdraft", str, card.deduct(50.00));
	}
	@Test
	public void balanceTooLow() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	@Test
	public void constructor_IncorrectID_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,-100.00);});
	}
	@Test
	public void constructor_IncorrectID_High() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(100000,-100.00);});
	}

	 @Test
	 public void valueOfTest()
	 {
	 assertSame("valueOf(DECEMBER)",
	 Month.DECEMBER, Month.valueOf("DECEMBER"));
	 }
}
