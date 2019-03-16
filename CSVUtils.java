package package_Pragma;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUtils {
	
	public List<Object> read_csv(String dir_path, String file_name)
	{
		List<Object> records = new ArrayList<>();
		try(Scanner sc  = new Scanner(new File(dir_path+"/"+file_name+".csv") ))
		{
			String line = sc.nextLine();
			
			String data[];
			// Creating different arraylist to store diff columns
			if(file_name.equals("deliveries"))
			{
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					data = line.split(",");
					records.add(new Deliveries_attrib(toInt(data[0]),toInt(data[1]),data[2], data[3],toInt(data[4]),
							toInt(data[5]),data[6],data[7],toInt(data[8]),toInt(data[9]),toInt(data[10]),
							toInt(data[11]),toInt(data[12]),toInt(data[13]),toInt(data[14]),toInt(data[15])));
				}
			}
			
			else if(file_name.equals("matches"))
			{
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					data = line.split(",");
					//System.out.println(data.length);
					if(data.length == 10)
						records.add(new Matches_attrib(toInt(data[0]),toInt(data[1]),data[2], data[3],data[4],
								data[5],data[6],data[7],data[8],data[9]));
					else
						records.add(new Matches_attrib(toInt(data[0]),toInt(data[1]),data[2], data[3],data[4],
								data[5],data[6],data[7],data[8],"NULL"));
			
				}
			}
			
			else
				
				System.out.println("Bad File");
						
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return records;	
	}
	
	
	public void printRecord(List<Object> records)
	{
		for(Object obj : records) 
			System.out.println((Matches_attrib)obj);
		
	}
	
	public static int toInt(String number)
	{
		return Integer.parseInt(number);
	}
	
}


