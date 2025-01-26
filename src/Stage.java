package pfe;
public class Stage {
	private String identifiant;
    private Entreprise entreprise;
    private Etudiant etudiant;
    private Encadrant encadrant;
    private Jury jury;
    private String dateDebut;
    private String dateFin;
    private Rapport rapport;

    public Stage(String identifiant,Entreprise entreprise,String dateDebut,String dateFin) {
        this.identifiant =identifiant;
        this.entreprise =entreprise;
        this.dateDebut =dateDebut;
        this.dateFin =dateFin;
    }
    public String getIdentifiant() { 
    	return identifiant; }
    public void setIdentifiant(String identifiant) { 
    	this.identifiant = identifiant; }
    public Entreprise getEntreprise() {
    	return entreprise;}
    public Etudiant getEtudiant() {
    	return etudiant;}
    public void setEtudiant(Etudiant etudiant) throws pfeException {
        if (this.etudiant != null) {
            throw new pfeException("Ce stage est déjà attribué à un étudiant.");
        }
        this.etudiant = etudiant;
        etudiant.ajouterStage(this);
        System.out.println("=========================================");
        System.out.println("Stage : "+identifiant+" est attribué au "+etudiant.getNom()+" "+etudiant.getPrenom());
        System.out.println("=========================================");
    }
    public Encadrant getEncadrant() {
    	return encadrant; }
    public Jury getJury() {
    	return jury; }
    public void setEncadrant(Encadrant encadrant){
    	this.encadrant= encadrant; }
    public String getDateDebut(){
    	return dateDebut; }
    public String getDateFin(){
    	return dateFin; }
    public String getSpecialite() {
        return entreprise.getSpecialite();
    }
    public Rapport getRapport() {
    	return rapport; }
    public void setRapport(Rapport rapport) {
    	this.rapport = rapport; }
    public void demanderRevision() {
        if (rapport != null) {
        	System.out.println("=========================================");
            rapport.setStatut("En révision");
            System.out.println("Révision demandée pour le rapport de stage : "+identifiant);
            System.out.println("=========================================");
        }
    }
    public void genererConventionStage() {
    	System.out.println("=========================================");
        System.out.println("Génération de la convention de stage pour l'étudiant "+etudiant.getNom() + " avec l'entreprise " + entreprise.getNom());
        System.out.println("=========================================");
    }

    public void genererProcesVerbal() {
    	System.out.println("=========================================");
        System.out.println("Genération du procès-verbal de soutenance pour l'étudiant "+etudiant.getNom());
        System.out.println("=========================================");
    }

    public void genererAttestationStage() {
    	System.out.println("=========================================");
        System.out.println("Generation de l'attestation de stage pour l'étudiant "+etudiant.getNom());
        System.out.println("=========================================");
    }
    public void suivreStageProjet(Etudiant etudiant) {
    	System.out.println("=========================================");
        System.out.println("Suivi du stage de l'étudiant " + etudiant.getNom());
        System.out.println("=========================================");
    }
    public void affiche_stage() {
    	System.out.println("=========================================");
        System.out.println("Détails du Stage:");
        System.out.println("-Identifiant: " + identifiant);
        System.out.println("-Entreprise: " + entreprise.getNom());
        System.out.println("-Étudiant: " + (etudiant != null ? etudiant.getNom() + " " + etudiant.getPrenom() : "Non assigné"));
        System.out.println("-Date de début: " + dateDebut);
        System.out.println("-Date de fin: " + dateFin);
        System.out.println("-Encadrant : " + (encadrant!= null ? encadrant.getNom()+" "+encadrant.getPrenom() : "Non assigné"));
        System.out.println("=========================================");
    }
}