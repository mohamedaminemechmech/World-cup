import java.util.Scanner;
public class Person  implements java.io.Serializable
{	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;	
	 String family;
	 String nationality;
	public Person() {
	   Scanner sc = new Scanner(System.in);
		 while (name == null)
		 {System.out.println("Name :");
		  name = sc.nextLine();
		 }
		 while (family == null)
		 {System.out.println("Family Name :");
		  family = sc.nextLine();
		 }
		 System.out.println("Nationality :");
		 nationality  = sc.nextLine();
		 while (nationality== null)
		 {System.out.println("Nationality :");
		  nationality = sc.nextLine();
		 }
	}
	public void affichage() {
	System.out.println ("Name : " + name + " // Family name : " + family + " // Nationality : " + nationality);
	}
}