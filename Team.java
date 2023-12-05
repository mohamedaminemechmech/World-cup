import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Vector;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

class Team  implements java.io.Serializable
{
	
	String name;	
	int points;
    Hashtable<String, Player> players = new Hashtable<String, Player>();
	Person coach;	
	int goals_for;
	int goals_ag;
	Hashtable<String, Game> games = new Hashtable<String, Game>();
	Vector<Doctor> medical_staff=new Vector<Doctor>() ;
	Vector<Integer> Lnum=new Vector<Integer>();
	int games_won;
	int games_lost;
	int games_draw;
	public Team(String nu) {
		String info;
		Lnum = new Vector<Integer>();
		Scanner sc = new Scanner(System.in);
		name=nu;
		int i = 0;
		boolean a;
		String n;
		while ((i<11)||(i>23))
		{
		do {
			a=true;
			try {	
		System.out.println("Donner le nombre des joueurs");
		n=sc.nextLine();
		i=Integer.parseInt(n);
		}
		catch(NumberFormatException e) {
			a=false;
		}
			}
		while(a == false);
		if((i<11)||(i>23))
		{
			System.out.println("Le nombre des joueurs doit etre entre 11 et 23");
		}	
		}
		Player p=null;
		for( int j=0; j<i ; j++)
		{
		System.out.println("Donner les informations du joueurs n° "+(j+1));
		String s="";
		do
		{
			p=new Player();
			s=p.name+"_"+p.family;
			if (players.contains(s))
			{
				System.out.println("Ce joueur existe deja");
			}
		}
		while(players.contains(s));	
		while (Lnum.contains(p.number))
			{System.out.println("Cette numero est occupé,Donner un autre numero");	
			p.number=sc.nextInt();
			}
		Lnum.add(p.number);
		String cle;
		cle=p.name+"_"+p.family;
		players.put(cle,p);
		}
		System.out.println("Donner les informations du coach ");
		Person p1=new Person();
		coach=p1;
		System.out.println("Donner les informations du docteur 1 ");
		Doctor d=new Doctor();
		medical_staff.add(d);
		System.out.println("Donner les informations du docteur 2 ");
		d=new Doctor();
		medical_staff.add(d);
		System.out.println("Donner les informations du docteur  3 ");
		d=new Doctor();
		medical_staff.add(d);
		} 
		public void add_points(int n) {
		points+=n;
	}
	public void add_Player() {
		Player p=new Player();
		while((p.name=="")||(p.family==""));
		String cle=p.name+"_"+p.family;
		if(players.containsKey(cle)) {
			System.out.println("le joueur deja existe");
			return;
		}
		players.put(cle,p);
	}

	public void remove_Player() {
		Scanner sc=new Scanner(System.in);
		String info,info1;
		String name;
		System.out.println("le nom du joueur");
		info=sc.nextLine();
		System.out.println("le nom de famille du joueur");
		info1=sc.nextLine();
		name=info+"_"+info1;
 		try
 		{
 			players.remove(name);
 		}
		catch(NullPointerException e)
 		{
			System.out.println("Ce joueur n'existe pas");
 		}
	}

	public void changecoach() {
		Person p =new Person();
		coach=p;
	}

	public Player bestplayer() {
		Player p;
		Player b;
		String cle;
		List<String> t =new ArrayList(players.keySet());
		b=players.get(t.get(0));
		int j=b.score;
		for(int i=1;i<t.size();i++)
		{
			cle=t.get(i);
			p=players.get(cle);
			if ((p.score)>j)
			{
				j=p.score;
				b=p;
			}
		}
		return b;
	}

	public void affichage() {
		System.out.println("			L'Equipe "+name+":");
		System.out.println("Le nombre de point est :"+points);
		System.out.println("Le nombre de but marqué est:"+goals_for);
		System.out.println("Le nombre de but concédés est:"+goals_ag);
		System.out.println("Les joueurs de l'equipe :");
		String cle;
		Player p;
		Set<String> keys = players.keySet();
	        int i=0;
		Iterator<String> t = keys.iterator();
		String key="";
		int ti = 1;
		while(t.hasNext())
		{
			cle=t.next();
			System.out.println("Joueur "+ti+":");
			p=players.get(cle);
			p.affichage();
			ti+=1;
		}
		
		}

}