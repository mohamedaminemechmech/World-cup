import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Game  implements java.io.Serializable
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Team team1;
    Team team2;
    int scoreTeam1;
    int scoreTeam2;
    Hashtable<String, String> cards_team1 = new Hashtable<String, String>();
    Hashtable<String, String> cards_team2 = new Hashtable<String, String>();
    List<String> goals_team1 = new ArrayList<String>();
    List<String> goals_team2 = new ArrayList<String>();
    Referee Referee ;
    public  Game(Team t1 ,Team t2 ) 
    {
    	team1=t1;
    	team2=t2;
    	boolean a;
    	int but1=0;
    	int but2=0;
    	//les buts de l'equipe 1
    	Scanner sci = new Scanner (System.in);
        Scanner scs = new Scanner (System.in);
        Scanner sc1 = new Scanner (System.in);
    	do
    	{
    	    a =true;
    		try {
    			System.out.println("Quelle est le nombre du but marqué par  " + team1.name);
                String n = scs.nextLine();
                int i = Integer.parseInt(n);
                but1 =i;
    		}
    	
    	catch(NumberFormatException e) {
			a=false;
			System.out.println("s'il vous plait donner un nombre ");
			
			}
    	}
		while(a == false);
        if (but1 == 0)
        {
            scoreTeam1 = but1;
        }
        else
        {
            scoreTeam1 = but1;
            for(int i = 0;i <= but1-1;i++)
            {
            	boolean test = false;
            	while(test == false){
            		System.out.println("donnez le prénom de joueur qui a marqué le but " + (i+1));
            		String prénom = scs.nextLine();
            		System.out.println("et son nom");
            		String nom = scs.nextLine();
            		String cle = prénom+"_"+nom;
            	    if((team1.players).containsKey(cle)) {
            	    	goals_team1.add(cle);
            	    	((team1.players).get(cle)).change_goals(1);
            			test=true;	
            	    }            			
            		
            		else {
            			System.out.println("Ce joueur n'existe pas dans cette equipe s'il vous plait donner un autre joueur ");
            		}
            	}
                 
            }
        }
        
//les buts de l'équipe 2   
        do
    	{
    	    a =true;
    		try {
    			System.out.println("Quelle est le nombre du but marqué par  " + team2.name);
                String n = scs.nextLine();
                int i = Integer.parseInt(n);
                but2 =i;
    		}
    	
    	catch(NumberFormatException e) {
			a=false;
			System.out.println("s'il vous plait donner un nombre ");
			
			}
    	}
		while(a == false);
        if (but2==0)
        {
            scoreTeam2 = but2;
        }
        else
        {   
        	scoreTeam2 = but2;
        	for(int i = 0;i <= but2-1;i++)
            {
            	boolean test = false;
            	while(test == false){
            		System.out.println("donnez le prénom de joueur qui a marqué le but " + (i+1));
            		String prénom = sc1.nextLine();
            		System.out.println("et son nom");
            		String nom = sc1.nextLine();
            		String clé = prénom+"_"+nom;
            	    if(team2.players.containsKey(clé)) {
            	    	goals_team2.add(clé);
            	    	((team2.players).get(clé)).change_goals(1);
            			test=true;	
            	    }            			
            		
            		else {
            			System.out.println("Ce joueur n'existe pas dans cette equipe s'il vous plait donner un autre joueur ");
            		}
            	}
                 
            }
        }
        team1.goals_ag=+scoreTeam2;
        team1.goals_for=+scoreTeam1;
        team2.goals_ag=+scoreTeam1;
        team2.goals_for=+scoreTeam2;

        	
 //les cartons de l'equipe 1
        int j1=0;
        do
    	{
    	    a =true;
    		try {
    			System.out.println("Quelle est le nombre du jouer de " +team1.name+" qui ont obtenu des cartons ");
                String n = scs.nextLine();
                int i = Integer.parseInt(n);
                j1 =i;
    		}
    	
    	catch(NumberFormatException e) {
			a=false;
			System.out.println("s'il vous plait donner un nombre ");
			
			}
    	}
		while(a == false);
        if (j1 != 0)
        {
        	for(int i = 0;i <= j1-1; i++)
            {
        		String clé="";
        		boolean existe=false;
                while(existe==false)
                {
                	System.out.println("donnez le prénom de joueur qui a obtenu des cartons :  ");                
                    String prénom = scs.nextLine();
                    System.out.println("et son nom");
                    String nom = scs.nextLine();
                    String clé_test = prénom+"_"+nom;
                    if(team1.players.containsKey(clé_test)) {
                    	existe=true;
                    	clé=clé_test;
                    }
                    else {
                    	System.out.println("Ce joueur n'existe pas dans cette equipe s'il vous plait donner un autre joueur ");
                    }
                }
                
                boolean test = false;
                int val=0;
                do
            	{
            	    a =true;
            		try {
            			System.out.println("combien de carton jaune a t'il obtenu : ");
                        String n = scs.nextLine();
                        int i1 = Integer.parseInt(n);
                        val = i1;
            		}
            	
            	catch(NumberFormatException e) {
        			a=false;
        			System.out.println("s'il vous plait donner un nombre ");
        			
        			}
            	}
        		while(a == false);
                while(test == false)
                {
                	if(val==0) {
                		test=true;
                		
                		System.out.println("a t-il obtenu une carton rouge ? o/n : ");
            			String rg1 =scs.nextLine();
            			if (rg1 == "o")
                		{
                			((team2.players).get(clé)).change_r_cards(1);                    		
                			cards_team2.put(clé+":1","r");                   			
                		}
                	}
                	if (val==1)                
                	{
                		test=true;                	
                		((team1.players).get(clé)).change_y_cards(1);
                		cards_team1.put(clé+":1","j");
                		System.out.println(" a t-il obtenu une carton rouge ? o/n");
                		String rg1 = scs.nextLine();
                		if (rg1 == "o")
                		{
                			((team1.players).get(clé)).change_r_cards(1);
                			cards_team1.put(clé+":1","r");
                		}
                	}

                	else if (val==2) 
                	{
                		test=true;
                		((team1.players).get(clé)).change_y_cards(2);
                		((team1.players).get(clé)).change_r_cards(1);
                        cards_team1.put(clé+":1","j");
                        cards_team1.put(clé+":2","j");
                        cards_team1.put(clé+":1","r");
                	}
                			
                		                		                	                	
                	else if(val>2)
                	{
                		System.out.println("le nombre de carton jaune possible par match soit 1 soit 2");
                		System.out.println("donner un nombre de carton valide");
                		int x = sci.nextInt();
                		val=x;
                	}
                }               
            }            
        }
        int j2=0;
        do
    	{
    	    a =true;
    		try {
    			System.out.println("Quelle est le nombre du jouer de " +team2.name+" qui ont obtenu des cartons ");
                String n = scs.nextLine();
                int i = Integer.parseInt(n);
                j2 =i;
    		}
    	
    	catch(NumberFormatException e) {
			a=false;
			System.out.println("s'il vous plait donner un nombre ");
			
			}
    	}
		while(a == false);
        if (j2 != 0)
        {
            for(int i = 0;i <= j2-1;i++)
            {
            	String clé="";
            	boolean existe=false;
                while(existe==false)
                {
                	System.out.println("donnez le prénom de joueur qui a obtenu des cartons :  ");                
                    String prénom = scs.nextLine();
                    System.out.println("et son nom");
                    String nom = scs.nextLine();
                    String clé_test = prénom+"_"+nom;
                    if(team2.players.containsKey(clé_test)) {
                    	existe=true;
                    	clé=clé_test;
                    }
                    else {
                    	System.out.println("Ce joueur n'existe pas dans cette equipe s'il vous plait donner un autre joueur ");
                    }
                }
                
                boolean test = false;
                int val=0;
                do
            	{
            	    a =true;
            		try {
            			System.out.println("combien de carton jaune a t'il obtenu : ");
                        String n = scs.nextLine();
                        int i1 = Integer.parseInt(n);
                        val = i1;
            		}
            	
            	catch(NumberFormatException e) {
        			a=false;
        			System.out.println("s'il vous plait donner un nombre ");
        			
        			}
            	}
        		while(a == false);
                while(test == false)
                {
                	if(val==0) {
                		test=true;
                		
                		System.out.println("a t-il obtenu une carton rouge ? o/n : ");
            			String rg1 =scs.nextLine();
            			if (rg1 == "o")
                		{
                			((team2.players).get(clé)).change_r_cards(1);                    		
                			cards_team2.put(clé+":1","r");                   			
                		}
        	
               
                	}
                
                    else if (val==1)                
                	{
                		test=true;                
                		((team2.players).get(clé)).change_y_cards(1);
                		cards_team2.put(clé+":1","j");
                		System.out.println(" a t-il obtenu une carton rouge ? o/n");
                		String rg1 = scs.nextLine();
                		if (rg1 == "o")
                		{
                			((team2.players).get(clé)).change_r_cards(1);                    		
                			cards_team2.put(clé+":1","r");                   			
                		}
                	}

                	else if (val==2) 
                	{
                		test=true;
                		((team2.players).get(clé)).change_y_cards(2);
                		((team2.players).get(clé)).change_r_cards(1);
                		cards_team2.put(clé+":1","j");
                        cards_team2.put(clé+":2","j");
                        cards_team2.put(clé+":1","r");
;
                	}
                			
                		                		                	                	
                	else if(val>2)
                	{
                		System.out.println("le nombre de carton jaune possible par match soit 1 soit 2");
                		System.out.println("donner un nombre de carton valide");
                		int x = sci.nextInt();
                		val=x;
                	}
                }               
        
            }
        }
        
    if(scoreTeam1>scoreTeam2)
    {
    	team1.add_points(3);
    	team1.games_won=+1;
    	team2.games_lost=+1;
    }
    else if(scoreTeam2>scoreTeam1)
    {
    	team2.add_points(3);
    	team2.games_won=+1;
    	team1.games_lost=+1;
    }
    else if (scoreTeam1==scoreTeam2)
    {
    	team1.add_points(1);
    	team2.add_points(1);
    	team1.games_draw=+1;
    	team2.games_draw=+1;
    }
    System.out.println("les notes de"+team1.name);
    ArrayList <String> players= new ArrayList<String>(team1.players.keySet());
    try {
    for(String str : players)
    {
    	do
    	{
    		int note;
    		
    			System.out.println("note de "+ str);
                String n= scs.nextLine();
                int i = Integer.parseInt(n);
                note =i;
    		
    		if(note<=10)
        	{
        		((team1.players).get(str)).score=+note;
        		a=true;
        	}
    	
    	
			
    	}
		while(a == false);
    	
    }
    }
    catch(NumberFormatException e) {
		a=false;
		System.out.println("s'il vous plait donner un nombre ");
    }
    System.out.println("les notes de"+team2.name);
    ArrayList <String> players2= new ArrayList<String>(team2.players.keySet());
    try {
        for(String str : players2)
        {
        	do
        	{
        		int note;
        		
        			System.out.println("note de "+ str);
                    String n= scs.nextLine();
                    int i = Integer.parseInt(n);
                    note =i;
        		
        		if(note<=10)
            	{
            		((team2.players).get(str)).score=+note;
            		a=true;
            	}
        	
        	
    			
        	}
    		while(a == false);
        	
        }
        }
        catch(NumberFormatException e) {
    		a=false;
    		System.out.println("s'il vous plait donner un nombre ");
        }
    }
  
    public void affichage() {
    	System.out.printf("%30s %-2d %1s %2d %-30s ",team1.name,scoreTeam1,"-",scoreTeam2,team2.name);
    	if(scoreTeam1 + scoreTeam2!=0)
    	{
    		System.out.printf("\n\n%32s %4s ","","buts");
    		if (scoreTeam1 == scoreTeam2)
    		{
    			for(int i=0;i <= scoreTeam1-1; i++)
    			{
    				System.out.printf("\n%-30s %5s %30s",goals_team1.get(i),"",goals_team2.get(i));	
    			}  			
    		}
    		else if (scoreTeam1>scoreTeam2)
    		{
    			for(int i=0;i<=scoreTeam2-1;i++)
    			{
    				System.out.printf("\n%-30s %5s %30s",goals_team1.get(i),"",goals_team2.get(i));
    			}
    			for(int i=scoreTeam2;i<=scoreTeam1-1;i++)
    			{
    				System.out.printf("\n%-30s %5s %30s",goals_team1.get(i),"","");
    			}
    		}
    		else if (scoreTeam2>scoreTeam1)
    		{
    			for(int i=0;i<=scoreTeam1-1;i++)
    			{
    				System.out.printf("\n%-30s %5s %30s",goals_team1.get(i),"",goals_team2.get(i));
    			}
    			for(int i=scoreTeam1;i<=scoreTeam2-1;i++)
    			{
    				System.out.printf("\n%-30s %5s %30s","","",goals_team2.get(i));
    			}
    		}
    	}
    	if(cards_team1.size() + cards_team2.size()!=0)
    	{
    		List<String> list1 = new ArrayList<String>(cards_team1.keySet());
    	    List<String> list2 = new ArrayList<String>(cards_team2.keySet());
    		System.out.printf("\n\n%31s %7s ","","cartons");;
    		if (list1.size() == list2.size())
    		{
    			for(int i=0;i <= list1.size()-1; i++)
    			{
    				System.out.printf("\n%-30s %5s %30s",list1.get(i)+"("+cards_team1.get(list1.get(i))+")","",list2.get(i)+"("+cards_team2.get(list2.get(i))+")");	
    			}  			
    		}
    		else if (list1.size()>list2.size())
    		{
    			for(int i=0;i<=list2.size()-1;i++)
    			{
    				System.out.printf("\n%-30s %5s %30s",list1.get(i)+"("+cards_team1.get(list1.get(i))+")","",list2.get(i)+"("+cards_team2.get(list2.get(i))+")");
    			}
    			for(int i=list2.size();i<=list1.size()-1;i++)
    			{
    				System.out.printf("\n%-30s %5s %30s",list1.get(i)+"("+cards_team1.get(list1.get(i))+")","","");
    			}
    		}
    		else if (list2.size()>list1.size())
    		{
    			for(int i=0;i<=list1.size()-1;i++)
    			{
    				System.out.printf("\n%-30s %5s %30s",list1.get(i)+"("+cards_team1.get(list1.get(i))+")","",list2.get(i)+"("+cards_team2.get(list2.get(i))+")");
    			}
    			for(int i=list1.size();i<=list2.size()-1;i++)
    			{
    				System.out.printf("\n%-30s %5s %30s","","",list2.get(i)+"("+cards_team2.get(list2.get(i))+")");
    			}
    		}
    	}
    	System.out.println("\n");
    }
}
    			
    	


    
