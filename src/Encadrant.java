package pfe;
import java.util.ArrayList;
public class Encadrant {
	private String identifiant;
    private String nom;
    private String prenom;
    private String specialite;
    private int chargeMax=5;
    private ArrayList<Stage> stagesSupervises;
    private ArrayList<Projet> projetsSupervises;

    public Encadrant(String identifiant,String nom,String prenom,String specialite) {
        this.identifiant=identifiant;
        this.nom=nom;
        this.prenom=prenom;
        this.specialite=specialite;
        this.stagesSupervises=new ArrayList<>();
        this.projetsSupervises=new ArrayList<>();
    }

    public String getIdentifiant() 
    {
    	return identifiant; }
    public String getNom()
    { 
    return nom; }
    public String getPrenom(){
    	return prenom; }
    public String getSpecialite(){
    	return specialite; }
    public boolean EncadrantestDisponible(){
        return (projetsSupervises.size()<chargeMax);
    }
    
    public ArrayList<Stage> getStagesSupervises()
    {
    	return stagesSupervises; }
    public ArrayList<Projet> getProjetsSupervises() {
    	return projetsSupervises;}

    public void ajouterStageSupervise(Stage stage){
        if (!stagesSupervises.contains(stage)) {
            stagesSupervises.add(stage);
            stage.setEncadrant(this);
        }
    }

    public void ajouterProjetSupervise(Projet projet) {
        if (!projetsSupervises.contains(projet)) {
            projetsSupervises.add(projet);
            projet.setEncadrant(this);
        }
    }
    public void notifierRapport(Rapport rapport) {
    	System.out.println("=========================================");
        System.out.println("L'encadrant " + nom + " a ete notifié du rapport soumis : " + rapport.getTitre());
        System.out.println("=========================================");
    }
    public void evaluerRapport(Etudiant etudiant, double note) {
    	System.out.println("=========================================");
        System.out.println("L'encadrant a attribué une note de " + note + " au rapport de " + etudiant.getNom());
        System.out.println("=========================================");
    }

}