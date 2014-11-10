package perso;

import base.Publication;

public class EnseignantChercheur extends Enseignant implements IChercheur {

	private static final int MAX_PUBLICATIONS = 10;
	private Publication[] listPublications;
	private int nbPublications;
	
	public EnseignantChercheur(String nom, int age, int heures) {
		super(nom, age, heures);
		listPublications = new Publication[MAX_PUBLICATIONS];
		nbPublications = 0;
	}

	@Override
	public void ajouterPublication(Publication p) {
		if (nbPublications == MAX_PUBLICATIONS) 
			throw new RuntimeException("Storage limits of publications reached! No more publication can be added");
		listPublications[nbPublications] = p;
		nbPublications++;
	}

	@Override
	public String listerPublications() {
		String res = "Publications of " + this.getNom() + " [";
		String prefix = "";
		for (int i = 0; i < nbPublications; i++) {
			res += prefix + listPublications[i];
			prefix = ",";
		}
		res += "]";
		return res;
	}

}
