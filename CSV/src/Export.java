import edu.duke.*;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Export {
    public static void listExporters(CSVParser parser, String exportOfInterest) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportOfInterest)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public static void whoExportsCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }

    public static String countryInfo (CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            if (record.get("Country").equals(country)) {
                return (record.get("Country") + ": " + record.get("Exports")) + " :"
                        + record.get("Value (dollars)");
            }
        }

        return "NOT FOUND";
    }

    public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");

            if (export.contains(exportItem1) && export.contains(exportItem2)) {

                System.out.println(record.get("Country"));
            }
        }

    }

    public static int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem)) {
                count += 1;
            }
        }

        return count;
    }


    public static void bigExporters(CSVParser parser, String $amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > $amount.length()) {
                System.out.println(record.get("Country") + ": " + value);
            }
        }

    }

    public static void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Country information:");
        System.out.println(countryInfo(parser, "Nauru"));
        System.out.println("List Two products:");
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamond");
        System.out.println("Big Exporters:");
        parser = fr.getCSVParser();
        bigExporters(parser, "$299,018,000,999");
        parser = fr.getCSVParser();
        System.out.println("Number of Exporters:" + numberOfExporters(parser, "gold"));
    }


}
