import java.util.Comparator;

public class Sortbypoints implements Comparator<Team>,java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int compare(Team a, Team b) {
		return a.points - b.points; 
	}

}