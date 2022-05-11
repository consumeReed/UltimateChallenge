package ultimate;
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
		for(int i = 0; i<10;i++)
		{
			Random random = new Random();
			if(i==0)
				lr += random.nextInt(4);
			else
				lr += random.nextInt(3);
		}
		return lr;
	}
	
	public static ArrayList<String> conv(String lr)
	{
		System.out.println(lr);
		ArrayList<String> ls = new ArrayList<String>();
		for(int i=0; i<lr.length();i++)
		{
			if(i<4)
				ls.add(primary+i+lr.substring(i, i+1));
			if(i>=4&&i<7)
				ls.add(secondary+(i-3)+lr.substring(i, i+1));
			if(i>=7)
				ls.add(i+lr.substring(i, i+1));
		}
		
		return ls;
	}
	
	public static void main(String[] args)
	{
		Runes r = new Runes();
		System.out.println(r.primary + " " + r.secondary);
		//System.out.println(r.lr());
		System.out.println(conv(r.lr()));
	}
}
