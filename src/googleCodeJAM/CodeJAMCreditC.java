/** Store Credit Problem - Google Code JAM Africa Qualification 2010
    Author - Santhosh Kaitheri
*/	

package googleCodeJAM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CodeJAMCreditC 
{
	public static void main(String... args) throws IOException
	{
		//File file = new File("input\\B-small-practice.in");
		//File outFile = new File("input\\B-small-practice.out");
		File file = new File("input\\A-large-practice.in");
		File outFile = new File("input\\A-large-practice.out");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		printFactorIndices(br, bw);
		br.close();
		bw.close();
	}

	private static void printFactorIndices(BufferedReader br, BufferedWriter bw) throws IOException 
	{
		int count=1;
		int credtAmount;
		int numberOfItems;
		int itemsArray[];
		String input="";
		System.out.println("numberOfTestCases :"+br.readLine());
		while ((input = br.readLine()) != null) 
		{
			credtAmount = Integer.parseInt(input);
			numberOfItems = Integer.parseInt(br.readLine());	
			itemsArray = getItemsArray(br.readLine(), numberOfItems);
			bw.write(getIndexes(count, itemsArray,credtAmount));
			System.out.println("\nCase #" + count +": Solved !\n");
			count++;
		}
	}
	private static int[] getItemsArray(String line, int numberOfItems) throws IOException 
	{
		int[] listOfItems;
		listOfItems = new int[numberOfItems];
		String[] strs = line.trim().split("\\s+");
		for (int k = 0; k < strs.length; k++) 
		{
			listOfItems[k] = Integer.parseInt(strs[k]);
		}
		return listOfItems;
	}

	private static String getIndexes(int count,int[] itemsArray, int credtAmount) 
	{
		int firstIndex=0;
		int secondIndex=0;
		String outputLine="";
		for(int i=0;i<itemsArray.length;i++)
		{
			for(int j=0;j<itemsArray.length;j++)
			{
				if(i==j)
				{
					continue;
				}
				else if(itemsArray[i]+itemsArray[j]==credtAmount)
				{
					firstIndex=i+1;
					secondIndex=j+1;
					return  "\nCase #" + count +": "+ firstIndex+" "+secondIndex+"\n";
				}
			}
		}
		return outputLine;
	}



}
