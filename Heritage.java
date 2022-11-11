// Heritage & Polymorphism

public class Heritage {
    public static void main(String[] argv) {
        Daughter Tochter  = new Daughter("Eleni");
        Daughter Tochter2 = new Daughter();
        Tochter.display();
        Tochter2.display();
    }
}

class Mother {
    private String name;

    public Mother() { 
        System.out.println("Mother's constructor");
        setName("Lena (default)");
    }

    public Mother(String entryName) { 
        System.out.println("Mother's constructor 2");
        name = entryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String entryName) {
       name = entryName;
    }

    public void display() {
        System.out.println("Mother : " + getName());
    }
}

class Daughter extends Mother {
    public Daughter() {
        System.out.println("Daughter's constructor");
        setName("Lena (Default)");
    }

    public Daughter(String entryName) {
        System.out.println("Daughter's constructor 2");
        setName(entryName);
    }

    @Override
    public void display() {
        System.out.println("Daughter : " + getName());
    }
}