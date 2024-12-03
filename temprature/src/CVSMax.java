import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;


public class CVSMax extends Main{
    public static CSVRecord hottestHoutInFile(CSVParser csvParser) {
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : csvParser) {
            largestSoFar = getThelargestOfTwo(largestSoFar, currentRow);
        }
        return largestSoFar;
    }

    public static CSVRecord hottestDays() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord largestSoFar = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHoutInFile(fr.getCSVParser());
            largestSoFar = getThelargestOfTwo(largestSoFar, currentRow);
        }
        return largestSoFar;
    }

    public static CSVRecord getThelargestOfTwo(CSVRecord largestSoFar,CSVRecord currentRow)
    {
        if( largestSoFar == null) largestSoFar = currentRow;

        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
        if(currentTemp > largestTemp) {
            largestSoFar = currentRow;
        }

        return largestSoFar;
    }


}
