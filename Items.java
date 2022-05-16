package ultimate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Items {
	
	ArrayList<String> items = new ArrayList<String>();
	
	public Items()
	{
		File it = new File("lib\\items.txt");
		while(items.size()<4)
		{
			Random r = new Random();
			int randomInt = r.nextInt(sizeItems("items"));
			try {
				String line = Files.readAllLines(Paths.get("lib\\items.txt")).get(randomInt);
				String[] parts = line.split(":");
				if(!items.contains(parts[1].trim()))
					items.add(parts[1].trim());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Random r = new Random();
		int randomInt = r.nextInt(sizeItems("boots"));
		try {
			String line = Files.readAllLines(Paths.get("lib\\boots.txt")).get(randomInt);
			String[] parts = line.split(":");
			items.add(parts[1].trim());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Random t = new Random();
		randomInt = r.nextInt(sizeItems("mythics"));
		try {
			String line = Files.readAllLines(Paths.get("lib\\mythics.txt")).get(randomInt);
			String[] parts = line.split(":");
			items.add(parts[1].trim());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public int sizeItems(String file)
	{
		int lines = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("lib\\"+file+".txt"));
			while(reader.readLine()!=null)
				lines++;
				reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public ArrayList<String> getItems()
	{
		return items;
	}
	
	public static void main(String[] args)
	{
		Items i = new Items();
	}

}
