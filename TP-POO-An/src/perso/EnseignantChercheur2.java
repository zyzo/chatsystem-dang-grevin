package perso;

import java.util.TreeSet;

import base.Publication;


/**
 * Implementation of EnseignantChercheur using TreeSet
 * Requirements : object stored in TreeSet must implements java.lang.Comparable
 * @author AN
 *
 */
public class EnseignantChercheur2 extends Enseignant implements IChercheur {

	TreeSet<Publication> listPublications;
	
	public EnseignantChercheur2(String nom, int age, int heures) {
		super(nom, age, heures);
		listPublications = new TreeSet<Publication>();
	}

	@Override
	public void ajouterPublication(Publication p) {
		listPublications.add(p);

	}

	@Override
	public String listerPublications() {
		String res = "Publications of " + this.getNom() + " [";
		String prefix = "";
		for (Publication p : listPublications) {
			res += prefix + p;
			prefix = ",";
		}
		res += "]";
		return res;
	}

}
