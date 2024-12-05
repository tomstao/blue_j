import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;

public class Main extends Export{
    public static void main(String[] args) {
       // tester();
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //listExportersTwoProducts(parser, "cotton", "flowers");
        //System.out.println("Number of Exporters:" + numberOfExporters(parser, "cocoa"));
        bigExporters(parser, "$299,018,000,999");


    }


}