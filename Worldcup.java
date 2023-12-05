import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.FileReader;
	public class Worldcup implements java.io.Serializable {
		 public  Hashtable<String, Team> teamlist=new Hashtable<String, Team>(); 
		 public Hashtable<String, Referee> reflist=new Hashtable<String, Referee>(); ;
		 public ArrayList<Team> teamss = new ArrayList<Team>();
		 public  Hashtable<String, Integer> round=new Hashtable<String, Integer>();
		 public int nbeq;
		 public int neqa=0;
		 public void addTeam() {
			 if (neqa<nbeq)
			 {
				 String teamname;
				 Scanner sc=new Scanner(System.in);
				 do {
				 System.out.println("Donner le nom de l'équipe");
				 teamname=sc.nextLine();
				 }
				 while(teamname.length()==0);
				 if(teamlist.containsKey(teamname)) {
					 String rep;
					 System.out.println("cette equipe existe deja");
					System.out.println("vous voulez l ecraser? oui/non");
					rep=sc.nextLine();
					if(rep.equals("non"))
						return;
				}
				Team team=new Team(teamname);
				 teamlist.put(team.name, team);
				 neqa++;
			 }
			 else
			 {
				 System.out.println("vous ne pouver pas ajouter d'autre equipe");
			 }
			 
		}
		public Worldcup(){
			ArrayList<Team> teamss = new ArrayList<Team>();
			Hashtable<String, Team> teamlist = new Hashtable<String, Team>(); 
			 Hashtable<String, Referee> reflist = new Hashtable<String, Referee>(); 
		}
		public void modifyteam() throws IOException, ClassNotFoundException {
			Scanner sc=new Scanner(System.in);
		    String teamname="";
		    while (teamlist.containsKey(teamname)==false) {
		    System.out.println("nom d equipe?");
		    teamname=sc.nextLine();
		    }
		    Team team1=null;
			Game game=null;
			boolean changee=true;
		      String str;
		      char c;
		      int i ;
		      while(changee) {
		    	  System.out.println("qu'est ce que tu veux changer?");
		    	  System.out.println("nom: 1");
		    	  System.out.println("ajouter un joueur 2");
		    	  System.out.println("supprimer un joueur 3");
		    	  System.out.println("coach 4");
		    	  System.out.println("exit: *");
		    	  str = sc.nextLine();
		    	  c=str.charAt(0);
		    	  switch(c) {
		    	  case'*':{
		    		  return;
		    	  }
		    	  case'1':{
		    		  Team t;
		    		  team1=teamlist.get(teamname);
		    		  do {
			    		  System.out.println("nouveau nom?");
			    		  str = sc.nextLine();
			    		  }
			    	  while(str.length()==0);
		    		  team1.name=str;
		    		  teamlist.remove(teamname);
		    		  teamlist.put(str,team1);
		    		  System.out.println("tu veux changer une autre chose? oui/non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  changee=false;
		    		  break;
		    	  }
		    	  case'2':{
		    		  team1=teamlist.get(teamname);
		    		  team1.add_Player();
		    		  teamlist.put(teamname,team1);
		    		  System.out.println("tu veux changer une autre chose? oui/non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  changee=false;
		    		  break;
		    	  }
		    	  case'3':{
		    		  Team t;
		    		  team1=teamlist.get(teamname);
		    		  team1.remove_Player();
		    		  teamlist.put(teamname,team1);
		    		  System.out.println("tu veux changer une autre chose? oui/non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  changee=false;
		    		  break;
		    	  }
		    	  case'4':{
		    		  System.out.println("nom du coach");
		    		  team1=teamlist.get(teamname);
		    		  team1.changecoach();
		    		  teamlist.put(teamname,team1);
		    		  System.out.println("tu veux changer une autre chose? oui/non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  changee=false;
		    		  break;
		    	  }
		    	  default:
		    	        System.out.println("faux!!");
		    	  }
		      }
		    	  }		
		public void remove() throws IOException {
		    Scanner sc=new Scanner(System.in);
		    Team t;
		    String teamname;
		    System.out.println("le nom d equipe?");
		    teamname=sc.nextLine();
		    try {
			t=teamlist.remove(teamname);
			neqa--;
		    }
		    catch( NullPointerException e  ){
		    	System.out.print("faux nom\n");
		    }
		}
		public void bestplayer() {
			Team t;
			Player p=null;
		    Set keys = teamlist.keySet();
		    int i=0;
		    Iterator itr = keys.iterator();
		    String key="";
		    while (itr.hasNext()) { 
		        key = (String) itr.next();
		        t=teamlist.get(key);
				p=t.bestplayer();
			if(p.score>i)
			{
				t=teamlist.get(key);
				p=t.bestplayer();
				i=p.score;
			}
		}
		System.out.println("le meilleur joueur est");
		Iterator itr1 = keys.iterator();
		String keyy="";
		while (itr1.hasNext()) { 
	        keyy = (String) itr1.next();
	        t=teamlist.get(keyy);
			p=t.bestplayer();
			if(p.score==i) {
				System.out.println(teamlist.get(keyy).bestplayer().name+" "+teamlist.get(keyy).bestplayer().family);
			}
		}
		}
		public void bestteam() {
			int i=0;
			 Set keys = teamlist.keySet();
			 Iterator itr = keys.iterator();
			    String key="";
			    while (itr.hasNext()) { 
			        key = (String) itr.next();
				if(teamlist.get(key).points>i)
					i=teamlist.get(key).points;
			}
			System.out.println("la meilleur equipe est");
			Iterator itr1 = keys.iterator();
			String keyy="";
			while (itr1.hasNext()) { 
		        keyy = (String) itr1.next();
				if(teamlist.get(keyy).points==i)
					teamlist.get(keyy).affichage();
			}
		}
		public void seelist() {
			int i=0;
			teamss.clear();
			Set<String> keys = teamlist.keySet();
			 Iterator itr = keys.iterator();
			    String key="";
			    while (itr.hasNext()) { 
			        key = (String) itr.next();
			        teamss.add(teamlist.get(key));
			    }
			    Collections.sort(teamss, new Sortbypoints());
			    System.out.printf("\n%-20s %4s %4s %4s %4s %4s %4s %4s %4s \n", "les equipes","J","G","N","P","BP","BC","+/-","pts");
			    for ( i=teamss.size()-1; i>=0; i--) 
			    {
			    	System.out.printf("\n%-20s %4s %4s %4s %4s %4s %4s %4s %4s \n", teamss.get(i).name, teamss.get(i).games.size(),teamss.get(i).games_won,teamss.get(i).games_draw,teamss.get(i).games_lost,teamss.get(i).goals_for,teamss.get(i).goals_ag,teamss.get(i).goals_for-teamss.get(i).goals_ag,teamss.get(i).points);
			    }
		            
			    
		}
		public void seeplayer(){
			Scanner sc=new Scanner(System.in);
			Player plaayer=null;
		    String plname,plfamily;
		    String teamname;
		    System.out.println("le prenom du joueur");
		    plname=sc.nextLine();
		    System.out.println("le nom du joueur");
		    plfamily=sc.nextLine();
		    System.out.println("son equipe");
		    teamname=sc.nextLine();
		    Team team=null;
		    team=teamlist.get(teamname);
		                String a=plname+"_"+plfamily;
		                Hashtable<String, Player> joueur = new Hashtable<String, Player>();
		                try {
			                joueur=team.players;
			    			plaayer=joueur.get(a);
			    			plaayer.affichage();
						}
			                catch(NullPointerException e) {
			                	System.out.println("faux nom");
			                }
		    }
		public void seeteam(){
			Scanner sc=new Scanner(System.in);
		    String teamname;
		    System.out.println("nom d equipe?");
		    teamname=sc.nextLine();
		    Team team=null;
		    team=teamlist.get(teamname);
		    try {
		    team.affichage();
		    }
		    catch(NullPointerException e){
		    	System.out.println("faux nom");
		    }
		    }
		public void affichage() throws IOException, ClassNotFoundException { 
			
			String str;
		      char c;
		      int i ;
		      Scanner sc=new Scanner(System.in);
			System.out.println("bienvenue au Football league manger ");
			boolean change=true;
			while(change== true) {
				System.out.println("qu est ce que vous voulez faire?");
				System.out.println("ajouter une equipe: 1");
				System.out.println("modifier une equipe: 2");
				System.out.println("supprimer une equipe: 3");
				System.out.println("voir best player: 4");
				System.out.println("voir best team: 5");
				System.out.println("voir un joueur: 6");
				System.out.println("voir une equipe: 7");
				System.out.println("voir la liste ordonne : 8");
				System.out.println("ajouter un match: 9");
				System.out.println("ajouter un arbitre: r");
				System.out.println("etablir le tirage de sort: g");
				System.out.println("modifier un joueur: p");
				System.out.println("voir un match: m");
				System.out.println("exit :*");
				str = sc.nextLine();
		    	  c=str.charAt(0);
		    	  switch(c) {
		    	  case'm':{
		    		  if(teamlist.isEmpty()) {
		    			  System.out.println("******");
		    			  System.out.println("tableau vide");
		    			  break;
		    		  }
		    		  this.seegame();
		    			  System.out.println("voulez vous faire une autre chose? oui ou non");
			    		  str = sc.nextLine();
			    		  if (str.equals("non"))
			    			  change=false;
			    		  break;
		    		  
		    	  }
		    	  case'1':{
		    		  this.addTeam();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case '2':{
		    		  if(teamlist.isEmpty()) {
		    			  System.out.println("******");
		    			  System.out.println("tableau vide");
		    			  break;
		    		  }
		    		  this.modifyteam();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case'3' :{
		    		  if(teamlist.isEmpty()) {
		    			  System.out.println("******");
		    			  System.out.println("tableau vide");
		    			  break;
		    		  }
		    		  this.remove();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  
		    		  if (str.equals("non"))
		    			  change= false;
		    		  break;
		    	  }
		    	  case'4':{
		    		  if(teamlist.isEmpty()) {
		    			  System.out.println("******");
		    			  System.out.println("tableau vide");
		    			  break;
		    		  }
		    		  try {
			    		  this.bestplayer();
			    		  }
			    		  catch(IndexOutOfBoundsException e) {
			    			  System.out.println("il n ya pas de joueurs");
			    		  }
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case'5':{
		    		  if(teamlist.isEmpty()) {
		    			  System.out.println("******");
		    			  System.out.println("tableau vide");
		    			  break;
		    		  }
		    		  this.bestteam();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case'6':{
		    		  if(teamlist.isEmpty()) {
		    			  System.out.println("******");
		    			  System.out.println("tableau vide");
		    			  break;
		    		  }
		    		  this.seeplayer();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case'7':{
		    		  if(teamlist.isEmpty()) {
		    			  System.out.println("******");
		    			  System.out.println("tableau vide");
		    			  break;
		    		  }
		    		  this.seeteam();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case'8':{
		    		  if(teamlist.isEmpty()) {
		    		  System.out.println("******");
	    			  System.out.println("tableau vide");
	    			  break;
	    		  }
		    		  this.seelist();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case'9':{
		    		  this.addgame();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case 'r' :{
		    		  this.addref();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case 'p' :{
		    		  if(teamlist.isEmpty()) {
		    			  System.out.println("******");
		    			  System.out.println("tableau vide");
		    			  break;
		    		  }
		    		  this.changeplayer();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case'g':{
		    		  if(round.size()!=0)
		    		  {
		    			  System.out.println("le tirage de sort est deja etablie");
		    		  }
		    		  this.affichageround();
		    		  System.out.println("voulez vous faire une autre chose? oui ou non");
		    		  str = sc.nextLine();
		    		  if (str.equals("non"))
		    			  change=false;
		    		  break;
		    	  }
		    	  case'*':{
		    		  return;
		    	  }
		    	  default :{
		    		  System.out.println("faux");
		    	  }
		    	  }
			}
		}
		public void addgame() {
			Scanner sc=new Scanner(System.in);
			String str;
			if(round.size()==0)
			{
				System.out.println("s'il vous plait etablie le tirage de sort");
				return;
			}
			List<String> keys = new ArrayList<String>(round.keySet());
			for(int i=1;i<(round.size()/2)+1;i++)
			{
				System.out.printf("\n\n%32s %4s ","","journeé"+i);
				for(String match:keys)
				{
					if(round.get(match)==i)
					{
						System.out.printf("\n\n%32s %4s ","",match);
					}
				}
			}
			Team t1=null,t2=null;
			Game newgame=null;
			try {
			System.out.println("\nnom d equipe1");
			str = sc.nextLine() ;
			if (teamlist.containsKey(str)==false) {
				System.out.println("faux nom");
				return;
			}
			t1=teamlist.get(str);
			System.out.println("nom d equipe2");
			str = sc.nextLine();
			if (teamlist.containsKey(str)==false) {
				System.out.println("faux nom");
				return;
			}
			t2=teamlist.get(str);
			if(t1.name.equals(t2.name)) {
				System.out.println("meme equipe !!");
				return;
			}
			if(t1.games.containsKey(t1.name+"_"+t2.name)==true) {
				System.out.println("match deja existe");
				return;
			}
			if(round.containsKey(t1.name+"_"+t2.name)==false)
			{
				System.out.println("cette partie n'est pas programmable");
				return;
			}
			newgame=new Game(t1,t2);
			}
			catch( NullPointerException e  ){
		    	System.out.print("faux nom\n");
		    }
			t1.games.put(t1.name+"_"+t2.name,newgame);
			t2.games.put(t1.name+"_"+t2.name,newgame);
		}
		public void addref() {
			Referee ref=new Referee();
			reflist.put(ref.name,ref);
		}
		public void affichageround() {
			if(neqa<nbeq)
			{
				System.out.println("s'il vous plait ajouter les autres equipes restant");
				return;
			}
			List<String> myNumbers = new ArrayList<String>(teamlist.keySet());
		    int l=myNumbers.size();
		    int m = l/2;
		    for (int i = 1 ; i<l ;i++ ) {
		    	System.out.println("journeé"+i);
		    	myNumbers.add(myNumbers.remove(1));
		    	List<String> fh = myNumbers.subList(0,m);
			    List<String> sh = myNumbers.subList(m,l);
		    	for(int j = 0 ; j<m; j++ ) {
				  System.out.println( fh.get(j) + " vs " + sh.get(m-1-j) );
		    	  round.put(fh.get(j)+"_"+sh.get(m-1-j),i);
		    	  round.put (sh.get(m-1-j)+"_"+fh.get(j),(i+(l-1)));
		    	}
		    }
		    for (int i = 1 ; i<l ;i++ ) {
			    System.out.println( "journeé" + (i+(l-1)));
			    myNumbers.add(myNumbers.remove(1));
			    List<String> sh = myNumbers.subList(0,m);
				List<String> fh = myNumbers.subList(m,l);
			    for(int j = 0 ; j<m; j++ ) {
			    System.out.println( fh.get(j) + " vs " + sh.get(m-1-j) );
			    }
			}
		    	
		    	
		    	
		    }
		    
		
		public void changeplayer() {
			Scanner sc=new Scanner(System.in);
			System.out.println("nom d equipe");
			String str;
			str = sc.nextLine();
			Player p=null;
			try {
			Team t=teamlist.get(str);
			System.out.println("nom d joueur");
			str = sc.nextLine();
			System.out.println("family d joueur");
			String st = sc.nextLine();
			p=t.players.get(str+"_"+st);
			}
			catch( NullPointerException e  ){
		    	System.out.print("faux nom\n");
		    }
			System.out.println("***************");
			System.out.println("changer num :1");
			System.out.println("changer position: 2");
			char c;
			int i;
			str = sc.nextLine();
	    	c=str.charAt(0);
	    	switch(c) {
	    	case'1':{
	    		int h=sc.nextInt();
	    		sc.nextLine();
	    		p.change_number(h);
	    		break;
	    	}
	    	case'2':{
	    		str = sc.nextLine();
	    		p.change_position(str);
	    		break;
	    	}
	    	default:{
	    		System.out.println("faux");
	    	}
	    	
		}
	}
		public void seegame() {
			Scanner sc=new Scanner(System.in);
			String str;
			Team t1=null,t2=null;
			System.out.println("nom d equipe1");
			str = sc.nextLine() ;
			if((str.length()==0) || (teamlist.containsKey(str)==false)) {
				System.out.println("faux!");
				return;
			}
			t1=teamlist.get(str);
			System.out.println("les partie joué par "+str);
			
			Enumeration e1 = t1.games.keys();
			 
			while(e1.hasMoreElements()) {
			System.out.println(e1.nextElement());
			}
			
			System.out.println("nom d equipe2");
			str = sc.nextLine();
			if((str.length()==0) || (teamlist.containsKey(str)==false)) {
				System.out.println("faux!");
				return;
			}
			Game g;
			t2=teamlist.get(str);
			try {
			g=t1.games.get(t1.name+"_"+t2.name);
			g.affichage();
				}
			catch(java.lang.NullPointerException e) {
				System.out.println("faux entree");
				return;
			}
		}
		
		
	}
