public class Student {

    public static void main(String[] argv) {

        Student e = new Student();
        Student f = new Student();
        e.setName("Tiffany");
        f.setName("Thomas");

        System.out.println("Student name : " + e.getName());
        System.out.println("Student name : " + f.getName());
        System.out.println("Count : " + e.getCount());
        System.out.println("Count : " + f.getCount());
    }

    private String name;
    int id;
    // Attribut de classe : Partagé par toutes les instances de l'objet 
    static private int count;

    public void setName(String str) {
        name = str;
    }

    public String getName() {
        return name;
    }

    static public int getCount() {
        return count;
    }

    public Student() {
        count++;
    }


}