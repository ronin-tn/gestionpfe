package pfe;

public class Rapport {
	private String identifiant;
    private String titre;
    private String dateDepot;
    private String statut;
    private double note;
    private boolean valide;
    private Stage stage;
    private Projet projet;
    public Rapport(String identifiant,String titre) {
        this.identifiant=identifiant;
        this.titre=titre;
        this.valide=false;
        this.statut="Soumis";
    }

    public String getIdentifiant() 
    {return identifiant;}
    public String getTitre() 
    {return titre;}
    public String getDateDepot() 
    {return dateDepot;}
    public double getNote() 
    {return note;}
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut =statut;
    }
    public boolean estValide() 
    {return valide;}
    public Stage getStage() 
    {return stage;}
    public Projet getProjet() 
    {return projet;}

    public void setStage(Stage stage) {
        this.stage=stage;
        stage.setRapport(this);
    }
    public void setProjet(Projet projet) {
        this.projet=projet;
        projet.setRapport(this);
    }
    public void genererRapportSuivi(Etudiant etudiant) {
    	System.out.println("=========================================");
        System.out.println("Rapport de suivi pour l'étudiant " + etudiant.getNom());
        System.out.println("=========================================");
    }
    public void validerRapport(double note) throws pfeException {
        if (note < 0 || note > 20) {
            throw new pfeException("La note doit être comprise entre 0 et 20.");
        }
        statut="Validé";
        this.note = note;
        this.valide = true;
    }
}