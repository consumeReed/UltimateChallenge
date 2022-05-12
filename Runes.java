package ultimate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Runes {
	
	static final ArrayList<String>runes = new ArrayList<String>(Arrays.asList("Sorcery","Precision","Domination","Resolve","Inspiration"));
	
	static String primary = "";
	static String secondary = "";
	ArrayList<String> left;
	ArrayList<String> right;
	

	public Runes()
	{
		ArrayList<String> rand = new ArrayList<String>();
		while(rand.size()<2) 
		{
			Random random = new Random();
			int randomInt = random.nextInt(runes.size());
			String t = runes.get(randomInt);
			if(!rand.contains(t))
			{
				rand.add(t);
			}
		}
		
		primary = rand.get(0);
		secondary = rand.get(1);
		
	}
	
	public String lr()
	{
		String lr = "";
		for(int i = 0; i<9;i++)
		{
			Random random = new Random();
			if(i==0&&primary.equals("Precision")||i==0&&primary.equals("Domination")||i==3&&primary.equals("Domination"))
				lr += random.nextInt(4);
			else
				lr += random.nextInt(3);
		}
		return lr;
	}
	
	public static ArrayList<String> conv(String lr)
	{
		ArrayList<String> ls = new ArrayList<String>();
		ArrayList<Integer> o = rand3();
		for(int i=0; i<lr.length();i++)
		{
			if(i<4)
				ls.add(primary+i+lr.substring(i, i+1));
			if(i==4)
				ls.add(secondary+o.get(0)+lr.substring(i, i+1));
			if(i==5)
				ls.add(secondary+o.get(1)+lr.substring(i, i+1));
			if(i>=6)
				ls.add(i+lr.substring(i, i+1));
		}
		Map<String, String> rune = readF();
		
		for(int i = 0; i < ls.size();i++)
		{
			String s=rune.get(ls.get(i));
			ls.set(i, s);
		}
		
		return ls;
	}
	
	public static ArrayList<Integer> rand3()
	{ 
		ArrayList<Integer> o = new ArrayList<Integer>();
		while(o.size()<2) 
		{
			Random random = new Random();
			int randomInt = random.nextInt(2)+1;
			if(!o.contains(randomInt))
			{
				o.add(randomInt);
			}
		}
		return o;
	}
	
	public static Map<String, String> readF()
	{
		Map<String, String> rune = new HashMap<String, String>();
		BufferedReader br = null;
		try {
			File f = new File("lib\\runes.txt");
			br = new BufferedReader(new FileReader(f));
			String line = null;
			while((line = br.readLine()) != null)
			{
				String[] parts = line.split(";");
				
				String id = parts[0].trim();
				String name = parts[1].trim();
				rune.put(id, name);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rune;
	}
	
	public static void main(String[] args)
	{
		Runes r = new Runes();
		System.out.println(r.primary + " " + r.secondary);
		//System.out.println(r.lr());
		System.out.println(conv(r.lr()));
	}
}
