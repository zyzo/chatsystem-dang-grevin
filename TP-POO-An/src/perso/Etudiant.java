package perso;

public class Etudiant extends Personne {
	private float score;

	public Etudiant(String nom, int age, float score) {
		super(nom, age);
		this.score = score;
	}

	float getScore() {
		return score;
	}

	void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Etudiant ["+ super.generalInfoToString() + ", score=" + score + "]";
	}
	
	
}
