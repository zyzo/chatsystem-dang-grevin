package perso;

public class Personne {

	private String nom;
	private int age;
	
	
	public Personne(String nom, int age) {
		this.nom = nom;
		this.age = age;
	}
	
	String getNom() {
		return nom;
	}
	void setNom(String nom) {
		this.nom = nom;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age + "]";
	}

	protected final String generalInfoToString() {      
		return "nom=" + nom + ", age=" + age;
	}
}
