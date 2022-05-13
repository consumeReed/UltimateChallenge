package ultimate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class removeNum {
	
	public static void main(String[] args)
	{
		BufferedReader br = null;
		try {
			File f = new File("C:\\Users\\rmitc\\Desktop\\items.txt");
			br = new BufferedReader(new FileReader(f));
			String line = null;
			while((line = br.readLine()) != null)
			{
				String[] parts = line.split(":");
				System.out.println(parts[1].trim());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
