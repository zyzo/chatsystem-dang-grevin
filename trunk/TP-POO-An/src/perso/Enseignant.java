package perso;

public class Enseignant extends Personne {
	private int heures;

	public Enseignant(String nom, int age, int heures) {
		super(nom, age);
		this.heures = heures;
	}

	public int getHeures() {
		return heures;
	}

	public void setHeures(int heures) {
		this.heures = heures;
	}

	@Override
	public String toString() {
		return "Enseignant [" + super.generalInfoToString() + ", heures=" + heures + "]";
	}
	
	
}
