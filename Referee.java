
public class Referee extends Person implements java.io.Serializable
{

	int y_cards;
	int r_cards;
	public void add_y_cards(int x ) {
		y_cards=y_cards+x;
	}

	public void add_r_cards(int x) {
		r_cards=r_cards+x;
	}
	
	public void affichage() {
		super.affichage();
		System.out.println("Yellow Cards : " + y_cards + "\nRed Cards :" + r_cards);
	}
	public Referee() {
		super();
		r_cards=0;
		y_cards=0;
}
}
