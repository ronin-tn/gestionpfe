package pfe;
import java.util.ArrayList;
public class Entreprise {
	private String nom;
	private String specialite;
    private ArrayList<Stage> offresStage;

    public Entreprise(String nom,String sp) {
        this.nom=nom;
        this.specialite=sp;
        this.offresStage=new ArrayList<>();
    }
    public String getNom() {
    	return nom;
    	}
    public void setNom(String nom) {
    	this.nom = nom;
    	}
    public String getSpecialite() {
    	return specialite;
    }
    public ArrayList<Stage> getOffresStage()
    {
    	return offresStage; }

    public void ajouterOffreStage(Stage stage) {
        if (!offresStage.contains(stage)) {
            offresStage.add(stage);
        }
    }
    public void details_stage_parentp()
    {
    	System.out.println("Détails des stages proposés par l'entreprise :");
        for (Stage stage : this.getOffresStage()) {
            stage.affiche_stage();
        }
    }
}
