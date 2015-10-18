package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	@Test
	public void testNumbersWithNewline(){
	assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testNumberWithOnlyNewline(){
	assertEquals(7, Calculator.add("1\n3\n3"));
	}
	@Test
	public void testDifferentDelimiter(){
	assertEquals(3, Calculator.add("//;\n1;2"));
	}
	@Test
	public void testDIfferentDelimeterMultipleNumbers(){
	assertEquals(8, Calculator.add("//a\n2a2a4"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testOneNegativeNumber(){
	try{
		Calculator.add("-1,2");
	}
	catch (IllegalArgumentException ex)
	{
	assertEquals("Negatives not allowed:-1", ex.getMessage() );
		throw ex;
	}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMultipleNegativeNumber(){
	try{
		Calculator.add("2,-4,3,-5");
	}
	catch (IllegalArgumentException ex)
	{
		assertEquals("Negatives not allowed:-4-5", ex.getMessage());
		throw ex;
	}
	}
	@Test
	public void testBiggerThan1000(){
		assertEquals(2, Calculator.add("1001,2")); 
	}
	@Test
	public void testMultipleBiggerThan1000(){
		assertEquals(4, Calculator.add("1\n1005,3,2800"));
	}
	@Test
	public void testMultipleBiggerThan1000Delimeter(){
		assertEquals(8, Calculator.add("//b\n4b2b1002b2b2800"));
	}
	@Test
	public void testDelimeterOfAnyLenghtMetaChar(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	@Test
	public void testDelimeterOfAnyLenght(){
		assertEquals(7, Calculator.add("//[aaaa]\n2aaaa2aaaa3"));
	}
	@Test
	public void testDelimeterMetaChar(){
		assertEquals(8, Calculator.add("//*\n4*4"));
	}
	@Test
	public void testMultipleMetaDelimeters(){
		assertEquals(6, Calculator.add("//[*][?]\n1*2?3"));
	}
	@Test 
	public void testMultipleDelimeters(){
		assertEquals(7, Calculator.add("//[a][b]\n2a2b3"));
	}	
	@Test
	public void testThreeDelimeters(){
		assertEquals(4, Calculator.add("//[*][b][%]\n1*1b1%1"));
	}
	@Test
	public void testMultipleDelimetersOfAnyLenght(){
		assertEquals(6, Calculator.add("//[***][%%%]\n1***2%%%3"));
	}
	@Test
	public void testThreeDelimetersOfAnyLenght(){
		assertEquals(8, Calculator.add("//[**][;;;][%]\n2**2;;;2%2"));
	}
}

