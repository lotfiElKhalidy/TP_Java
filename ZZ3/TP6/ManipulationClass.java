import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class ManipulationClass {

    public static void manipulerClassePersonne() {
        Personne personne = new Personne("Tom", 25, "2 rue de F. Rosevelt", "03-239-393-33-330", 0);

        try {
            Personne nouvelleInstancePersonne = (Personne) personne.getClass().newInstance();

            modifierAttributs(nouvelleInstancePersonne);
            
            System.out.println("\n*-*-*-*-*-*-*-* Réflexion *-*-*-*-*-*-*-*");
            System.out.println("Age après modification de l'attribut : " + nouvelleInstancePersonne.getAge());
            System.out.println("Adresse après modification de l'attribut : " + nouvelleInstancePersonne.getAdresse());

            System.out.println("\n*-*-*-*-*-*-*-* Invoke *-*-*-*-*-*-*-*");
            invokeMethods(nouvelleInstancePersonne);
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }  
    }

    private static void modifierAttributs(Personne personne) {
        try {
            Field ageField = personne.getClass().getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(personne, 25);
            
            Field adresseField = personne.getClass().getDeclaredField("adresse");
            adresseField.setAccessible(true);
            adresseField.set(personne, "15 rue de Jaude");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void invokeMethods(Personne personne) {
        try {
            Method getNomMethod = personne.getClass().getDeclaredMethod("getNom");
            getNomMethod.setAccessible(true);
            System.out.println("Résultat d'invoke de la méthode getName() : " + getNomMethod.invoke(personne));

            Method setNumDeTelephone = personne.getClass().getDeclaredMethod("setNumDeTelephone");
            setNumDeTelephone.setAccessible(true);
            setNumDeTelephone.invoke(personne);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void IntrospectionMethodeAfficherDetails() {
        Personne personne = new Personne();

        if (Affichable.class.isAssignableFrom(personne.getClass())) {
            try {
                Method afficherDetailsMethod = personne.getClass().getDeclaredMethod("afficherDetails");
                afficherDetailsMethod.invoke(personne);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("La classe n'implémente pas l'interface Affichable.");
        }
    }
}