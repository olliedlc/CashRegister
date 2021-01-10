package test.com.rocketmiles.register.cash;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rocketmiles.register.cash.main.CashRegister;

public class CashRegisterTest {

	
	@Test
	public void test() {
		CashRegister cashRegister = new CashRegister();
		/*
		 * Put test
		 * 
		 * $20 * 10 = 200
		 * $10 * 10 = 100
		 * $5 * 10 = 50
		 * $2 * 10 = 20
		 * $1 * 10 = 10
		 * Total = $380
		 */
		cashRegister.putBills(10, 10, 10, 10, 10);
		
		assertEquals(cashRegister.showTotal()[0], 380);
		assertEquals(cashRegister.showTotal()[1], 10);
		assertEquals(cashRegister.showTotal()[2], 10);
		assertEquals(cashRegister.showTotal()[3], 10);
		assertEquals(cashRegister.showTotal()[4], 10);
		assertEquals(cashRegister.showTotal()[5], 10);
		
		/*
		 * Take test
		 * 
		 * $20(10) - 5 = 100(5)
		 * $10(10) - 5 = 50(5)
		 * $5(10) - 5 = 25(5)
		 * $2(10) - 5 = 10(5)
		 * $1(10) - 5 = 5(5)
		 * Total = $190
		 */
		cashRegister.takeBills(5, 5, 5, 5, 5);
		assertEquals(cashRegister.showTotal()[0], 190);
		assertEquals(cashRegister.showTotal()[1], 5);
		assertEquals(cashRegister.showTotal()[2], 5);
		assertEquals(cashRegister.showTotal()[3], 5);
		assertEquals(cashRegister.showTotal()[4], 5);
		assertEquals(cashRegister.showTotal()[5], 5);
		
		/*
		 * Change test
		 * 
		 * Change 59
		 * 
		 * $20(5) - 2 = 40
		 * $10(5) - 1 = 10
		 * $5(5) - 1 = 5
		 * $2(5) - 2 = 4
		 * $1(5) - 0 = 0
		 * Total of Remaining Bills= $141
		 * Total Remaining 20s = 3
		 * Total Remaining 10s = 4
		 * Total Remaining 5s = 4
		 * Total Remaining 2s = 3
		 * Total Remaining 1s = 5
		 */
		cashRegister.changeBills(59);
		assertEquals(cashRegister.showTotal()[0], 131);
		assertEquals(cashRegister.showTotal()[1], 3);
		assertEquals(cashRegister.showTotal()[2], 4);
		assertEquals(cashRegister.showTotal()[3], 4);
		assertEquals(cashRegister.showTotal()[4], 3);
		assertEquals(cashRegister.showTotal()[5], 5);
	}

}
