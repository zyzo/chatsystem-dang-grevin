package perso;

import java.util.TreeMap;

import base.Publication;


/**
 * Implementation of EnseignantChercheur using TreeMap
 * @author AN
 *
 */
public class EnseignantChercheur3 extends Enseignant implements IChercheur {

	TreeMap<String, Publication> listPublications;
	
	public EnseignantChercheur3(String nom, int age, int heures) {
		super(nom, age, heures);
		listPublications = new TreeMap<String, Publication>();
	}

	@Override
	public void ajouterPublication(Publication p) {
		listPublications.put(p.getTitre(), p);

	}

	@Override
	public String listerPublications() {
		String res = "Publications of " + this.getNom() + " [";
		String prefix = "";
		for (Publication p : listPublications.values()) {
			res += prefix + p;
			prefix = ",";
		}
		res += "]";
		return res;
	}

}