package test;
import perso.Enseignant;
import perso.Etudiant;
import perso.Personne;


public class HelloPersonnes2 {
	
	public static void main(String[] args) {
		Personne[] listPersonnes = new Personne[3];
		listPersonnes[0] = new Personne("Einstein", 20);
		listPersonnes[1] = new Enseignant("Newton", 60, 35);
		listPersonnes[2] = new Etudiant("Descartes", 15, 20f);
		for (Personne p : listPersonnes) {
			System.out.println(p);
		}
	}
}
