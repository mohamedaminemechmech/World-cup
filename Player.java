import java.util.Scanner;
public class Player extends Person  implements java.io.Serializable
{
         
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		int number;
		String position;
		int score;
		int goals;
		int y_cards;
		int r_cards;
		public enum pos 
		{ 
			GB,DC,AD,AG,MDF,MC,MO,MD,MG,ALG,ALD,AV

		} ;
		public  boolean contains(String test) {

		    for (pos c : pos.values()) {
		        if (c.name().equals(test)) {
		            return true;
		        }
		    }

		    return false;
		}
		public Player(){
			super();
			boolean a=false;
			boolean b;
			this.score=0;
			Scanner sc = new Scanner(System.in);
			do {
				b=true;
				try {	
			System.out.println("Number :");
			String test = sc.nextLine();
			number=Integer.parseInt(test);
			}
			catch(NumberFormatException e) {
				System.out.println("donner un entier");
				b=false;
			}
				}
			while(b == false);
			while(a==false) {
				Scanner sc1=new Scanner(System.in);
				System.out.println("Position :");
				System.out.println("GB,DC,AD,AG,MDF,MC,MO,MD,MG,ALG,ALD,AV");
				position = sc1.nextLine();
				a=this.contains(position);
			
			}
			goals = 0;
			y_cards = 0;
			r_cards = 0;
		}
		public void change_number(int num ) {
		number = num;
		}
		public void change_position(String pos ) {
		position = pos;
		}
		public void change_goals(int ng) {
		goals += ng;
		}
		public void change_y_cards(int nyc ) {
		y_cards += nyc;
		}
		public void change_r_cards(int nrc) {
		r_cards += nrc;
		}
		public void affichage() {
		//super.affichage();
		System.out.println ("Name : " + name + " // Family name : " + family + " // Nationality : " + nationality + " // Number : " + number + " // Position : " + position + " // Goals : " + goals + " // Yellow Cards : " + y_cards + " // Red Cards : " + r_cards);
		}
		public  Player (Player p) {
			name = p.name;
			family = p.family;
			nationality = p.nationality;
			number = p.number;
			position = p.position;
			goals = p.goals;
			y_cards = p.y_cards;
			r_cards = p.r_cards;
			score = p.score;
		}

}
