package ultimate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class ulti {
	
	//static final int MAX = 159;
	String champ;
	Character ability;
	ArrayList<String> summonerSpells;
	ArrayList<String> runes;
	ArrayList<String> items;
	
	public ulti()
	{
		ChampionId ch = new ChampionId();
		champ = ch.randomChamp();
		ability = randomAbility();
		summonerSpells = randomSummSpells();
		Runes r = new Runes();
		runes = r.conv(r.lr());
	}
	
	public Character randomAbility()
	{
		Random random = new Random();
		String set = "QWE";
		int randomInt = random.nextInt(set.length());
		return set.charAt(randomInt);
	}
	
	public ArrayList<String> randomSummSpells()
	{
		ArrayList<String> spells = new ArrayList<String>();
		BufferedReader br = null;
		try {
			File f = new File("lib\\spells.txt");
			br = new BufferedReader(new FileReader(f));
			String line = null;
			while((line = br.readLine()) != null)
			{
				spells.add(line);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		ArrayList<String> rand = new ArrayList<String>();
		while(rand.size()<2) 
		{
			Random random = new Random();
			int randomInt = random.nextInt(spells.size());
			String t = spells.get(randomInt);
			if(!rand.contains(t))
			{
				rand.add(t);
			}
		}
		
		return rand;
	}
	
	
	
	public static void main(String[] args)
	{
		ulti t = new ulti();
		System.out.println(t.champ);
		System.out.println(t.ability);
		System.out.println(t.summonerSpells);
		System.out.println(t.runes);
	}

}
