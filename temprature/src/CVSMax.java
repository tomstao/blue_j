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




    public static CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord theColdestHour = null;
        for (CSVRecord currentRow : parser) {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            if(currentTemp < -999) continue;
            if (theColdestHour == null) {
                theColdestHour = currentRow;
            }
            double coldestTemp = Double.parseDouble(theColdestHour.get("TemperatureF"));
            if (coldestTemp > currentTemp) {
                theColdestHour = currentRow;
            }
        }
        return theColdestHour;
    }

    public static void testColdestHourInFile()
    {
        FileResource fr = new FileResource();
        CSVParser coldest = fr.getCSVParser();
        CSVRecord coldestSoFar = coldestHourInFile(coldest);
        //coldestHourInFile(coldest);

        System.out.println("Coldest Hour:" + coldestSoFar.get("TemperatureF") );
        System.out.println("The date:" + coldestSoFar.get("DateUTC"));
    }

    public static String fileWithColdestTemperature()
    {



        return "";
    }
}

