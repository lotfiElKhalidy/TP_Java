import java.util.*;

// Exemple de classes : les chaines de caractères (String)
public class String_type
{
    public static void main(String[] argv)
    {
        // String != char[]
        // String est un objet

        String s1 = "Hello";
        String s2 = "world !";
        String s4 = s1 + " " + s2;

        System.out.println("String : " + s4);
        
        StringBuffer sb = new StringBuffer(s1);
        
        sb.append(" ").append(s2);
        System.out.println("Stringbuffer : " + sb);

        
        StringBuffer s = new StringBuffer("Bonjour");

        // Avec StringBuffer, on est capable de faire un append (avec String c'est pas possible)
        // Si s = null, on ne peut pas faire un append
        s.append(" les ZZ");
        s.append(2);

        System.out.println(s);

        String chaine = new String("hello");       // Instanciation
        String s3 = null;

        // Manipulation de chaines
        StringBuffer s6 = new StringBuffer("Loic");
        s6.setCharAt(0, 'l');
        System.out.println(s6);

        String[] result = "Ca découpe la chaine".split("\\s");

        for (int i=0; i<result.length; i++)
            System.out.println(result[i]);
    }
}