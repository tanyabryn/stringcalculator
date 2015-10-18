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
			return toInt(text);
	}
	
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	
	private static String[] splitDelimeters(String numbers){
		int n = 0;
		String first = "";
		String delimeter = "";
		numbers = numbers.substring(2);
		if(numbers.substring(0,1).equals("["))
		{
			int amount = numbers.split("]").length -1;
			for(int i = 0; i < amount; i++)
			{
				first = numbers.substring(1,2);
				String deli = "";
				if(first.matches("[-+*/.?|$^]"))
				{	
					numbers = numbers.replaceAll("\\" + first, "a");
				}
				deli = numbers.substring(1,numbers.indexOf("]"));
				
				if(i < amount -1)
					delimeter += "(" + deli + ")" +  "|";
				else if(amount < 2)
					delimeter += deli;
				else
					delimeter += "(" + deli + ")";
				numbers = numbers.substring(numbers.indexOf("]") + 1); 
			}	
			n = numbers.indexOf("\n");
		}			
		else
		{
			first = numbers.substring(0,1);
			if(first.matches("[-+*/.?|$^]"))
				numbers = numbers.replaceAll("\\" + first, "a");
			n = numbers.indexOf("\n");
			delimeter = numbers.substring(0,n);
		}
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
