package Experiment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PocketMoneyTest {

	private PocketMoney money = null;
	private int num;
	private int result;
	
	public PocketMoneyTest(int num,int result){
		this.num = num;
		this.result = result;
	}
	
	@Before
	public void setup() {
		money = new PocketMoney();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
			
		return Arrays.asList(new Object[][]{
			{3,1},
			{24,0},
			{25,1},
			{29,0},
			{34,0},
			{48,0},
			{94,0}
			});
	}

	@Test
	public void test() {
		
		assertEquals(result,money.calc(num));
	}
}
