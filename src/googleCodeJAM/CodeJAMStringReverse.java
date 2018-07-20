package googleCodeJAM;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CodeJAMStringReverse 
{
	public static void main(String... args) throws IOException
	{
		File file = new File("F:\\PROJECTS\\GOOGLE-CODE-JAM\\StringReverse\\B-small-practice.in");
		File outFile = new File("F:\\PROJECTS\\GOOGLE-CODE-JAM\\StringReverse\\B-small-practice.out");
		//File file = new File("F:\\PROJECTS\\GOOGLE-CODE-JAM\\StringReverse\\B-large-practice.in");
		//File outFile = new File("F:\\PROJECTS\\GOOGLE-CODE-JAM\\StringReverse\\B-large-practice.out");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		printReversedStrings(br, bw);
		br.close();
		bw.close();
	}

	private static void printReversedStrings(BufferedReader br,	BufferedWriter bw) throws IOException 
	{
		int numberOfTestCases=Integer.parseInt(br.readLine());
		int count=1;
		while (count<=numberOfTestCases) 
		{
			String inputString = br.readLine();
			String outputString = getOutputString(inputString);
			bw.write("Case #" + count +": "+ outputString+"\n");
			System.out.println("Case #" + count +": Solved !\n");
			count++;
		}
	}

	private static String getOutputString(String inputString) 
	{
		String reversedInput = reverse(inputString);
		String outputString  = reverseStringTokens(reversedInput);
		return outputString;
	}

	private static String reverse(String inputString) 
	{
		String reversedInut = "";
		for(int index=inputString.toCharArray().length-1;index>=0;index--)
		{
			reversedInut += inputString.toCharArray()[index];
		}
		return reversedInut;
	}
	
	private static String reverseStringTokens(String reversedInput) 
	{
		String tokenReversedString="";
		for (String token : reversedInput.split(" "))
		{
			tokenReversedString += reverse(token)+" ";
		}
		return tokenReversedString;
	}

	
}
