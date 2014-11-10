package test;
import base.Publication;
import perso.EnseignantChercheur3;
import perso.IChercheur;

public class HelloChercheur {

  public static void main(String[] args) {
  // Creation of the objects
  IChercheur chercheur = new EnseignantChercheur3("tom", 35,192);
  chercheur.ajouterPublication(new Publication("La conception objet",2003));
  chercheur.ajouterPublication(new Publication("La programmation objet",2004));

  // printing the object attributes
  System.out.println(chercheur);
  System.out.println(chercheur.listerPublications());
  }
}
