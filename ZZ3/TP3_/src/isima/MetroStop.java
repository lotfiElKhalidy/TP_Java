package isima;

public class MetroStop {
    public int id;
    public double longitude;
    public double latitude;
    public String nom;
    public String arrondissement;
    public String type;

    public MetroStop() {}

    public MetroStop(int id, double longitude, double latitude, String nom, String arrondissement, String type) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nom = nom;
        this.arrondissement = arrondissement;
        this.type = type;
    }

    @Override
    public String toString() {
        return "MetroStop{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", nom='" + nom + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
