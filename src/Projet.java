package pfe;

public class Projet {
	private String identifiant;
    private String titre;
    private boolean estDisponible;
    private Etudiant etudiant;
    private Encadrant encadrant;
    private String dateDebut;
    private String dateFin;
    private Rapport rapport;
    private Jury jury;

    public Projet(String id,String titre,String dateDebut,String dateFin) {
        this.identifiant =id;
        this.titre =titre;
        this.dateDebut =dateDebut;
        this.dateFin =dateFin;
    }
    public String getIdentifiant(){
    	return identifiant; }
    public String getTitre(){
    	return titre;}
    public void setTitre(String titre){
    	this.titre =titre; }
    public boolean estDisponible() {
        return this.etudiant == null;
    }
    public Etudiant getEtudiant(){ 
    	return etudiant; }
    public void setEtudiant(Etudiant etudiant) throws pfeException{
        if (this.etudiant != null) {
            throw new pfeException("Ce projet est déjà attribué à un étudiant.");
        }
        this.etudiant =etudiant;
        etudiant.ajouterProjet(this);
    }
    public Encadrant getEncadrant() {
    	return encadrant; }
    public void setEncadrant(Encadrant encadrant){
    	this.encadrant = encadrant; }
    public String getDateDebut() {
    	return dateDebut;}
    public String getDateFin() {
    	return dateFin;}
    public Rapport getRapport() {
    	return rapport;}
    public void setRapport(Rapport rapport) {
    	this.rapport=rapport; }
    public Jury getJury() {
    	return jury;}
    public void setJury(Jury jury) {
    	this.jury = jury;}
    public void genererConventionProjet() {
    	System.out.println("=========================================");
        System.out.println("Génération de la convention de projet pour l'étudiant "+etudiant.getNom());
        System.out.println("=========================================");
    }
   

    public void genererProcesVerbal() {
    	System.out.println("=========================================");
        System.out.println("Genération du procès-verbal de soutenance pour l'étudiant "+etudiant.getNom());
        System.out.println("=========================================");
    }

    public void genererAttestationProjet() {
    	System.out.println("=========================================");
        System.out.println("Géneration de l'attestation de projet pour l'étudiant "+etudiant.getNom());
        System.out.println("=========================================");
    }
}