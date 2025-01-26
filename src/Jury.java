package pfe;
import java.util.ArrayList;
public class Jury {
	private String identifiant;
    private ArrayList<Encadrant> membres;
    private ArrayList<Projet> projets;
    private Rapport rapport;
    private String dateSoutenance;
    private double noteFinale;
    private Salle salle;

    public Jury(String identifiant, String dateSoutenance) {
        this.identifiant =identifiant;
        this.membres =new ArrayList<>();
        this.dateSoutenance =dateSoutenance;
    }
    
    public String getIdentifiant()
    {return identifiant;}
    public ArrayList<Encadrant> getMembres() 
    {return membres;}
    public Rapport getRapport()
    {
    	return rapport;
    }
    public ArrayList<Projet> getProjets()
    {
    	return projets;
    }
    public void ajouter_membre(Encadrant E)
    {
    	membres.add(E);
    	System.out.println("Encadrant "+E.getNom()+" "+E.getPrenom()+"à été ajouté");
    }
    public void addProjet(Projet projet) { 
        projets.add(projet);
        projet.setJury(this);
    }
    public void notifierRapport(Rapport rapport) {
    	System.out.println("=========================================");
        System.out.println("Le jury a ete notifié du rapport soumis : " + rapport.getTitre());
        System.out.println("=========================================");
    }
    public String getDateSoutenance() 
    {return dateSoutenance; }
    public double getNoteFinale() 
    {return noteFinale; }

    public void ajouterMembre(Encadrant membre) {
        if (!membres.contains(membre)) {
            membres.add(membre);
        }
    }
    
    public void attribuerNoteFinale(double note) {
        this.noteFinale = note;
    }
    public boolean verifierDisponibilite(){
    	for(Encadrant E:membres)
    	{
    		if(!E.EncadrantestDisponible())
    			return false;
    	}
        if (salle!=null) {
            return salle.verifierDisponibilite(dateSoutenance);
        } else {
            System.out.println("Aucune salle attribuée au jury.");
            return false;
        }
    }
    public void evaluerSoutenance(Etudiant etudiant, double note) {
    	System.out.println("=========================================");
        System.out.println("Le jury a attribué une note de " + note + " à " + etudiant.getNom() + " pour la soutenance.");
        System.out.println("=========================================");
    }
    public Salle getSalle() {
        return salle;
    }
    public void setSalle(Salle S)
    {
    	this.salle=S;
    }
    public void afficherDetailsJury() {
    	System.out.println("=========================================");
        System.out.println("Détails du Jury :");
        System.out.println("Identifiant : "+identifiant);
        System.out.println("Date de soutenance : "+dateSoutenance);
        System.out.println("Salle: "+salle.getNom());
        System.out.println("Membres du jury :");
        if (membres.isEmpty()) {
            System.out.println("Aucun membre ajouté.");
        } else {
            for (Encadrant m:membres) {
                System.out.println(m.getNom() + " " + m.getPrenom() + " (Spécialité : " + m.getSpecialite() + ")");
            }
        }
        System.out.println("=========================================");
    }

    
}