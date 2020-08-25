package practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Nike1
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\kruta\\Downloads\\testcsv1.csv"));
		String line;
		int count = 0;
		Double minPrice = Double.MAX_VALUE;
		Double maxPrice = Double.MIN_VALUE;
		Double mean = 0.0;
		Double sd = 0.0;
		Double sum = 0.0;
		ArrayList<Double> priceList = new ArrayList<Double>();
		
		while((line = br.readLine()) != null)
		{
			if(count++ > 0)
			{
				String[] split = line.split("\\,");
				Double price = Double.parseDouble(split[1]);
				minPrice = Math.min(minPrice, price);
				maxPrice = Math.max(maxPrice, price);
				sum += price;
				priceList.add(price);
			}
			//count++;
		}
		System.out.println(minPrice);
		System.out.println(maxPrice);
		
		DecimalFormat sumFormat = new DecimalFormat("0.000#");
		sum = Math.round(sum*100.0)/100.0;
		sumFormat.format(sum);
		
		mean = sum / priceList.size();
		//System.out.println(mean);
		System.out.format("%.3f", mean);
		System.out.println();
		
		sum = 0.0;
		for(Double price : priceList)
		{
			Double square = Math.pow(Math.abs(price - mean), 2);
			sum += square;
		}
		
		sd = Math.sqrt((sum  / priceList.size()));
		DecimalFormat sdFormat = new DecimalFormat("0.0000#");
	    double sdRoundOff = Math.round(sd*1000.0)/1000.0;
	    
	    System.out.println(sdFormat.format((sdRoundOff)));
		
	    //System.out.format("%.3f", sd);
	
	}
}
