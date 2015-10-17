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
        	for(String number : numbers){
			total += toInt(number);
		}
		return total;
    }
	
}
