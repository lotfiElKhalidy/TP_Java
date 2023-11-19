package isima;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parser {
        public List<MetroStop> listMetroStop;
        public String path;

        public Parser() {
            listMetroStop=new ArrayList<MetroStop>();
        }

        public Parser(String filePath) {
            this.path = filePath;
            listMetroStop=new ArrayList<MetroStop>();
        }

        public List<MetroStop> parse(String path) {
            try {
                Reader reader = new FileReader(path);
                BufferedReader br = new BufferedReader(reader);
                String line;

                while ((line = br.readLine()) != null) {
                    MetroStop metroStop = new MetroStop();

                    String[] parts = line.split("#");

                    if (parts.length < 6)
                        throw new IOException("Invalid format");

                    metroStop.id = Integer.parseInt(parts[0]);
                    metroStop.longitude = Double.parseDouble(parts[1]);
                    metroStop.latitude = Double.parseDouble(parts[2]);
                    metroStop.nom = parts[3];
                    metroStop.arrondissement = parts[4];
                    metroStop.type = parts[5];

                    listMetroStop.add(metroStop);
                }
                br.close();

                return listMetroStop;
            }
            catch (FileNotFoundException e) {
                System.out.println("The given path doesn't exist : " + path);
            }
            catch (IOException e) {
                System.out.println("Error during the analysis of the CSV file :" + e.getMessage());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return null;
        }

        public List<MetroStop> sortMetroStopListByID(List<MetroStop> listMetroStop) {
            listMetroStop.sort(Comparator.comparing((MetroStop s) -> s.id));

            return listMetroStop;
        }

        public List<MetroStop> sortMetroStopListByID_DESC(List<MetroStop> listMetroStop) {
            listMetroStop.sort(Comparator.comparing((MetroStop s) -> s.id, Comparator.reverseOrder()));

            return listMetroStop;
        }

        public List<MetroStop> sortMetroStopListByArrondissementThenByStationName(List<MetroStop> listMetroStop) {
            listMetroStop.sort(Comparator.comparing((MetroStop s) -> s.arrondissement)
                    .thenComparing((MetroStop s) -> s.nom));

            return listMetroStop;
        }
}
