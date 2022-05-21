package ultimate;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,ll;
	TextField t1,t2,t3,t4,t5;
	Button b1, b2;
	
	public UI() 
	{
		l1 = new JLabel("Items:");
		l2 = new JLabel("Runes:");
		l3 = new JLabel("Champion:");
		l4 = new JLabel("Ability:");
		l5 = new JLabel("Summoner Spells:");
		
		t1 = new TextField(20);
		t2 = new TextField(20);
		t3 = new TextField(20);
		t4 = new TextField(20);
		t5 = new TextField(20);
		
		b1 = new Button("Search");
		b2 = new Button("Exit");
		add(l1);
		add(t1);
		
		add(l2);
		add(t2);
		
		add(l3);
		add(t3);
		
		add(l4);
		add(t4);
		
		add(l5);
		add(t5);
		
		add(b1);
		add(b2);
		setSize(1350,400);
		setTitle("LOL Stats");
		setLayout(new FlowLayout());
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent action)
	{
		
		if(action.getSource()==b1)
		{
			ulti s = new ulti();
			t1.setText(s.items.toString());
			t2.setText(s.runes.toString());
			t3.setText(s.champ);
			t4.setText(s.ability.toString());
			t5.setText(s.summonerSpells.toString());
			ll = new JLabel("");
			Image img = new ImageIcon(this.getClass().getResource("lib\\Annie.png")).getImage();
			ll.setIcon(new ImageIcon(img));
			add(ll);
			
		}
		
		if(action.getSource()==b2)
		{
			CloseFrame();
		}
		
	}
	
	public void CloseFrame()
	{
		super.dispose();
	}
	
	public static void main(String[] args)
	{
		UI u = new UI();
		u.setSize(1350,400);
		u.setVisible(true);
		u.setLocation(200,300);
		u.add(new JLabel(new ImageIcon("Annie.png")));
	}

}
