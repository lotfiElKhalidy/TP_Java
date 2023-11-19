public class Personne implements Affichable {

    private String nom;
    private int age;
    private String adresse;

    protected String numDeTelephone;

    public int sexe; // 0: M, 1: F, 2: None

    public Personne() {
        nom = "John Doe";
        age = 0;
        adresse = "Adresse inconnu";
        numDeTelephone = "00-00-00-00-00";
        sexe = 2;
    }

    public Personne(String nom, int age, String adresse, String numDeTelephone, int sexe) {
        this.nom = nom;
        this.age = age;
        this.adresse = adresse;
        this.numDeTelephone = numDeTelephone;
        this.sexe = sexe;
    }

    public String getNom() { 
        return nom; 
    }

    public void setNom(String nouveauNom) { 
        nom = nouveauNom; 
    }

    public int getAge() { 
        return age; 
    }

    public void setAge(int nouvelAge) { 
        age = nouvelAge; 
    }

    public String getAdresse() { 
        return adresse; 
    }

    public void setAdresse(String nouvelleAdresse) { 
        adresse = nouvelleAdresse; 
    }

    protected String getNumDeTelephone() {
        return numDeTelephone;
    }

    protected void setNumDeTelephone(String nouveauNumDeTel) {
        numDeTelephone = nouveauNumDeTel;
    }

    private int getSexe() {
        return sexe;
    }

    private void setSexe(int nouveauSexe) {
        sexe = nouveauSexe;
    }
    
    @Override 
    public void afficherDetails() {
        System.out.println("Nom : " + nom + ", Âge : " + age + ", Adresse : " + adresse + ", Tél : " + numDeTelephone + ", Sexe : " + sexe);
    }

    public static void main(String[] args) {
        Personne personne1 = new Personne("Alice", 25, "123 Rue de la Joie", "07-63-54-65-32", 1);

        ExplorerClass.inspecterClassePersonne();
        ManipulationClass.manipulerClassePersonne();
    }
}