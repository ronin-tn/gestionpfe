package pfe;
import java.util.ArrayList;
import java.util.Objects;
public class Etudiant {
	private String numeroInscription;
    private String nom;
    private String prenom;
    private String parcours;
    private String specialite;
    private ArrayList<Stage> stages;
    private ArrayList<Projet> projets;

    public Etudiant(String id,String nom,String prenom,String parcours,String specialite) {
        this.numeroInscription =id;
        this.nom =nom;
        this.prenom =prenom;
        this.parcours =parcours;
        this.specialite =specialite;
        this.stages =new ArrayList<>();
        this.projets =new ArrayList<>();

    }
    
    public String getNumeroInscription() 
    { 
    	return numeroInscription; 
    }
    public void setNumeroInscription(String id) 
    { 
    	this.numeroInscription = id; 
    }
    public String getNom()
    {
    	return nom; 
    }
    public void setNom(String nom) { 
    	this.nom = nom; 
    	}
    public String getPrenom() 
    { 
    	return prenom; 
    }
    public void setPrenom(String prenom) {
    	this.prenom =prenom; 
    	}
    public String getParcours() 
    { 
    	return parcours; 
    }
    public void setParcours(String parcours)
    { 
    	this.parcours =parcours; 
   }
    public String getSpecialite() 
    { 
    	return specialite;
    }
    public void setSpecialite(String specialite)
    { 
    	this.specialite =specialite;
    }

    public void ajouterStage(Stage stage) {
        if (!stages.contains(stage)) {
            stages.add(stage);
        }
    }

    public void ajouterProjet(Projet projet) {
        if (!projets.contains(projet)) {
            projets.add(projet);
        }
    }
    public void postulerStage(Stage stage) {
        if (this.specialite.equals(stage.getSpecialite())) {
        	System.out.println("=========================================");
            System.out.println(nom + " postule au stage : " + stage.getIdentifiant());
            System.out.println("=========================================");
        }
    }
    public void soumettreRapport(Rapport rapport, Stage stage) {
        stage.setRapport(rapport);
        System.out.println("=========================================");
        System.out.println(nom + " a soumis le rapport pour le stage : " + stage.getIdentifiant());
        System.out.println("=========================================");
        stage.getEncadrant().notifierRapport(rapport);
    }

    public void affiche_etudiant(){
    	System.out.println("=========================================");
        System.out.println("Détails de l'Étudiant :");
        System.out.println("- Numéro d'inscription: " + numeroInscription);
        System.out.println("- Nom: " + nom + " " + prenom);
        System.out.println("- Parcours: " + parcours);
        System.out.println("- Spécialité: " + specialite);
        System.out.println("- Nombre de stages: " + stages.size());
        System.out.println("- Nombre de projets: " + projets.size());
        System.out.println("=========================================");
    }
}

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(numeroInscription, etudiant.numeroInscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroInscription);
    }
}*/