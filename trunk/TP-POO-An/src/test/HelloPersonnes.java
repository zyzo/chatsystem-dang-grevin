package test;
import perso.Enseignant;
import perso.Etudiant;
import perso.Personne;



public class HelloPersonnes {

	public static void main(String[] args) {
		Personne p = new Personne("Einstein", 20);
		Personne en = new Enseignant("Newton", 60, 35);
		Personne et = new Etudiant("Descartes", 15, 20f);
		System.out.println(p);
		System.out.println(en);
		System.out.println(et);
	}
}
