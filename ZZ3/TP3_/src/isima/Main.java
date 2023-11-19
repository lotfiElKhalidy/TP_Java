package isima;

import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    interface PrintTest {
        public boolean test(MetroStop s);
    }

    private static void print(PrintStream out, ArrayList<MetroStop> l, PrintTest test) {
        for (MetroStop it: l) {
            if (test.test(it))
                out.println(it);
        }
    }

    private static void print(PrintStream out, ArrayList<MetroStop> l) {
        print(out, l, (s) -> true);
    }

    public static void main(String[] argv) {
        String path = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret.csv";
        Parser parser = new Parser(path);

        parser.listMetroStop = parser.parse(path);

        // Sort listMetroStop by ID
        parser.listMetroStop = parser.sortMetroStopListByID(parser.listMetroStop);

        // Sort listMetroStop by ID DESC
        parser.listMetroStop = parser.sortMetroStopListByID_DESC(parser.listMetroStop);

        // Sort listMetroStop by arrondissement then by station name
        parser.listMetroStop = parser.sortMetroStopListByArrondissementThenByStationName(parser.listMetroStop);


        for (MetroStop m : parser.listMetroStop) {
            System.out.println(m);
        }
    }
}
