package pfe;
import java.util.ArrayList;
public class GestionAffectations {
	public void affecterProjet(Etudiant etudiant, Projet projet, Encadrant encadrant) throws pfeException {
	    if (!projet.estDisponible()) {
	        throw new pfeException("Le projet n'est pas disponible.");
	    }
	    if (!encadrant.EncadrantestDisponible()) {
	        throw new pfeException("L'encadrant n'est pas disponible.");
	    }

	    projet.setEtudiant(etudiant);

	    encadrant.ajouterProjetSupervise(projet);
	    System.out.println("=========================================");
	    System.out.println("Affectation réussie :");
	    System.out.println("Étudiant: "+ etudiant.getNom()+ " "+ etudiant.getPrenom());
	    System.out.println("Projet: "+ projet.getTitre());
	    System.out.println("Encadrant: "+ encadrant.getNom()+ " "+ encadrant.getPrenom());
	    System.out.println("=========================================");
	}
	 public void affectationAutomatique(Etudiant etudiant,ArrayList<Projet> projets,ArrayList<Encadrant> encadrants) throws pfeException {
	        for (Projet projet:projets) {
	            if (projet.estDisponible()) {
	                for (Encadrant encadrant:encadrants) {
	                    if (encadrant.EncadrantestDisponible()) {
	                        affecterProjet(etudiant,projet,encadrant);
	                        return;
	                    }
	                }
	            }
	        }
	        throw new pfeException("Aucun projet ou encadrant disponible pour cet étudiant.");
	    }
	 


}
