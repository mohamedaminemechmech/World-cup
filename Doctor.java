class Doctor extends Person  implements java.io.Serializable
{
	public Doctor(){
		super();
	}
	
	public void affichage() {
		System.out.println("Le médecin"+ name + family +"du pays" + nationality);
	}

}