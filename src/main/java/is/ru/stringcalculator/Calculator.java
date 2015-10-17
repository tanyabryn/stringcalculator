package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		
		else if(text.contains(",")|| text.contains("\n")){

		if(text.substring(0, 2).equals("//"))
			{
				return sum(splitDelimeters(text));
			}
		else
		
			return sum(splitNumbers(text));
		}
	
		else
			return 1;
	}
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	
	private static String[] splitDelimeters(String numbers){
		int n = numbers.indexOf("\n");
		String delimeter = numbers.substring(2, n);
		String toSplit = numbers.substring(n+1);
		
		return toSplit.split(delimeter);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("[\n,]");
        }

   	private static int sum(String[] numbers){
 		int total = 0;
		String invalid = "";
        	for(String number : numbers){
			if(toInt(number) < 0)
			{	
				invalid += number;
			}
			if(toInt(number) <= 1000)
			{
				total += toInt(number);
			}
		}
		if(!invalid.equals(""))
		{
			throw new IllegalArgumentException("Negatives not allowed:" + invalid);
		}
		return total;
    }
	
}
