import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		List<String> l=new ArrayList();
		File t= new File("listtournoi.ser");
		boolean exist=t.exists();
		if (exist==false)
		{
			FileOutputStream fileOut =new FileOutputStream("listtournoi.ser");
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(l);
	        out.close();
	        fileOut.close();
		}
		try {
			FileInputStream fileIn = new FileInputStream("listtournoi.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			l = (List)in.readObject();
			in.close();
	        fileIn.close();
		      } 
	      catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } 
	      catch (ClassNotFoundException c) {
	         c.printStackTrace();
	         return;
	      }
		boolean b=true;
		Scanner sc=new Scanner(System.in);
		String str;
		String nom;
		char c;
		while(b)
		{
			System.out.println("qu est ce que vous voulez faire?");
			System.out.println("nouveau tournoi : 1");
			System.out.println("charger un tournoi precedent : 2");
			System.out.println("exit: *");
			str=sc.nextLine();
			c=str.charAt(0);
			switch (c)
			{
			case'*':
			{b=false;
				break;}
			case'1':
			{
				do {
				System.out.println("donner le nom");
				nom=sc.nextLine();
				}
				while(nom.length()==0);
				l.add(nom);
				int neq=1;
				String ceq;
				boolean test;
				while((neq%2)!=0)
			    {
			    	do {
						test=true;
						try {
					System.out.println("Donner un nombre pair d'équipe :");
					ceq = sc.nextLine();
					neq=Integer.parseInt(ceq);
					}
					catch(NumberFormatException e) {
						System.out.println("Donner un nombre pair :");
						test=false;
					}
						}
					while(test == false);
			    }
				Worldcup worldcup=new Worldcup();
				worldcup.nbeq=neq;
				File tmp= new File(nom+".ser");
				boolean exists=tmp.exists();
				if (exists==false)
				{
					FileOutputStream fileOut =
					         new FileOutputStream(nom+".ser");
					         ObjectOutputStream out = new ObjectOutputStream(fileOut);
					         out.writeObject(worldcup);
					         out.close();
					         fileOut.close();
				}
				try {
					FileInputStream fileIn = new FileInputStream(nom+".ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					worldcup = (Worldcup)in.readObject();
					in.close();
			        fileIn.close();
				      } 
			      catch (IOException i) {
			         i.printStackTrace();
			         return;
			      } 
			      catch (ClassNotFoundException e) {
			         e.printStackTrace();
			         return;
			      }
				worldcup.affichage();	
				try {
			         FileOutputStream fileOut =
			         new FileOutputStream(nom+".ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(worldcup);
			         out.close();
			         fileOut.close();
			         System.out.println("programme ferme");
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
				System.out.println("voulez vous faire une autre chose selon les tournois? oui ou non");
	    		  str = sc.nextLine();
	    		  if (str.equals("non"))
	    			  b=false;
	    		  break;
			}
			case'2':
			{
				if (l.isEmpty())
				{
					System.out.println("Il n y a aucun tournoi");
					break;
				}
				System.out.println("Choisir le tournoi");
				for (int i=0;i<l.size();i++)
				{
					System.out.println(l.get(i));
				}
				nom=sc.nextLine();
				if (l.contains(nom))
				{
					Worldcup worldcup=new Worldcup();
					File tmp= new File(nom+".ser");
					boolean exists=tmp.exists();
					if (exists==false)
					{
						FileOutputStream fileOut =
						         new FileOutputStream(nom+".ser");
						         ObjectOutputStream out = new ObjectOutputStream(fileOut);
						         out.writeObject(worldcup);
						         out.close();
						         fileOut.close();
					}
					try {
						FileInputStream fileIn = new FileInputStream(nom+".ser");
						ObjectInputStream in = new ObjectInputStream(fileIn);
						worldcup = (Worldcup)in.readObject();
						in.close();
				        fileIn.close();
					      } 
				      catch (IOException i) {
				         i.printStackTrace();
				         return;
				      } 
				      catch (ClassNotFoundException e) {
				         e.printStackTrace();
				         return;
				      }
					worldcup.affichage();	
					try {
				         FileOutputStream fileOut =
				         new FileOutputStream(nom+".ser");
				         ObjectOutputStream out = new ObjectOutputStream(fileOut);
				         out.writeObject(worldcup);
				         out.close();
				         fileOut.close();
				         System.out.println("programme ferme");
				      } catch (IOException i) {
				         i.printStackTrace();
				      }
				}
				else
				{
					System.out.println("Ce tournoi n existe pas");	
				}
				System.out.println("voulez vous faire une autre chose selon les tournois? oui ou non");
	    		  str = sc.nextLine();
	    		  if (str.equals("non"))
	    			  b=false;
	    		  break;
			}
			}
			}
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("listtournoi.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(l);
	         out.close();
	         fileOut.close();
	         System.out.printf("programme ferme");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}

}