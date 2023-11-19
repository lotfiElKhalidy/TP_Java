import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ExplorerClass {

    public static void inspecterClassePersonne() {
        Personne instancePersonne = new Personne();
        Class classePersonne = instancePersonne.getClass();

        afficherNomDeClasse(classePersonne);
        afficherAttributs(classePersonne);
        afficherMethodes(classePersonne);
    }

    private static void afficherNomDeClasse(Class in_class) {
        System.out.println("--- Nom de la classe : " + in_class.getName());
    }

    public static void afficherAttributs(Class in_class) {
        System.out.println("----- Attributs de la classe : ");
        Field[] attributs = in_class.getDeclaredFields();
        for (Field attribut : attributs) {
            System.out.println("---------- Nom : " + attribut.getName() + ", Type : " + attribut.getType().getSimpleName());
        }
    }

    public static void afficherMethodes(Class in_class) {
        System.out.println("----- Méthodes de la classe : ");
        Method[] methodes = in_class.getDeclaredMethods();
        for (Method methode : methodes) {
            System.out.println("---------- Nom : " + methode.getName() + ", Retour : " + methode.getReturnType().getSimpleName());
        }
    }
}