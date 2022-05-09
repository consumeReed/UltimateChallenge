package ultimate;
import java.util.*;

public class Runes {
	
	static final ArrayList<String>runes = new ArrayList<String>(Arrays.asList("Sorcery","Precision","Domination","Resolve","Inspiration"));
	
	String primary;
	String secondary;
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
			lr += random.nextInt(3);
		}
		return lr;
	}
	
	public static void main(String[] args)
	{
		Runes r = new Runes();
		System.out.println(r.primary + " " + r.secondary);
		System.out.println(r.lr());
	}
}
