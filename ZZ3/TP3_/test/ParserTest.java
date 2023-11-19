import isima.MetroStop;
import isima.Parser;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ParserTest extends TestCase {

    public void testParserWithFileNotFound() {
        String nonExistingPath = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret_empty.png";
        Parser parser = new Parser(nonExistingPath);

        List<MetroStop> listMetroStop = parser.parse(nonExistingPath);
    }

    public void testParserWithEmptyFile() {
        String path = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret_empty.csv";
        Parser parser = new Parser(path);

        List<MetroStop> listMetroStop = parser.parse(path);
        assertTrue(listMetroStop.isEmpty());
    }

    public void testParserWithCorrectFile() {
        String path = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret_correctInfo.csv";
        Parser parser = new Parser(path);

        List<MetroStop> listMetroStop = parser.parse(path);
        assertFalse(listMetroStop.isEmpty());
    }

    public void testSortListMetroStopByID() {
        String path = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret_correctInfo.csv";
        Parser parser = new Parser(path);

        List<MetroStop> listMetroStop = parser.parse(path);
        listMetroStop = parser.sortMetroStopListByID(listMetroStop);

        assertTrue(listMetroStop.get(0).id <= listMetroStop.get(1).id);
    }

    public void testSortListMetroStopByID_DESC() {
        String path = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret_correctInfo.csv";
        Parser parser = new Parser(path);

        List<MetroStop> listMetroStop = parser.parse(path);
        listMetroStop = parser.sortMetroStopListByID_DESC(listMetroStop);

        assertTrue(listMetroStop.get(0).id >= listMetroStop.get(1).id);
    }

    public void testSortListMetroStopByArrondissementThenByStationName() {
        String path = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret.csv";
        Parser parser = new Parser(path);

        List<MetroStop> listMetroStop = parser.parse(path);
        listMetroStop = parser.sortMetroStopListByArrondissementThenByStationName(listMetroStop);

        for (int i=0; i<parser.listMetroStop.size()-1; i++) {
            String currentArrondissement = parser.listMetroStop.get(i).arrondissement;
            String nextArrondissement = parser.listMetroStop.get(i+1).arrondissement;

            if (currentArrondissement.compareTo(nextArrondissement) == 0) {
                assertTrue(parser.listMetroStop.get(i).nom.compareTo(parser.listMetroStop.get(i+1).nom) <= 0);
            } else {
                assertTrue(currentArrondissement.compareTo(nextArrondissement) <= 0);
            }
        }
    }

    public void testParserWithLargeFile() {
        String path = "/home/local.isima.fr/loelkhalid/shared/ZZ3/Java/isima-poa-2023-TP3-ELKHALIDY/ratp_arret_largeFile.csv";
        Parser parser = new Parser(path);

        List<MetroStop> listMetroStop = parser.parse(path);
        assertFalse(listMetroStop.isEmpty());
    }
}
