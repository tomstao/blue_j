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
            /*
            if (theColdestHour == null) {
                theColdestHour = currentRow;
            }
            double coldestTemp = Double.parseDouble(theColdestHour.get("TemperatureF"));
            if (coldestTemp > currentTemp) {
                theColdestHour = currentRow;
            } */
            theColdestHour = getCodest(theColdestHour, currentRow);
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

    public static CSVRecord getCodest (CSVRecord theColdestHour, CSVRecord currentRow) {

        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        //if(currentTemp < -999) continue;
        if (theColdestHour == null) {
            theColdestHour = currentRow;
        }
        double coldestTemp = Double.parseDouble(theColdestHour.get("TemperatureF"));
        if (coldestTemp > currentTemp) {
            theColdestHour = currentRow;
        }
        return theColdestHour;
    }

    public static String fileWithColdestTemperature()
    {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        File coldestF = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser currParser = fr.getCSVParser();
            if(coldestSoFar == null)
            {   coldestSoFar = coldestHourInFile(currParser);
                coldestF = f;
                continue;
            }
            double currColdest = Double.parseDouble(coldestHourInFile(currParser).get("TemperatureF"));
            double coldestTempSofar = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            fr = new FileResource(f);
            currParser = fr.getCSVParser();
            if(currColdest < coldestTempSofar) {
                coldestSoFar = coldestHourInFile(currParser);
                coldestF = f;
            }
        }
        FileResource fr = new FileResource(coldestF);
        CSVParser coldest = fr.getCSVParser();
        coldestSoFar = coldestHourInFile(coldest);
        String theColdestData = "Coldest day was in file:" + coldestF.getName() + "\n"
                                + "Coldest temperature on that day was:" + coldestSoFar.get("TemperatureF") + "\n"
                                +  "All the Temperature on the coldest day were:" + "\n" ;
        fr = new FileResource(coldestF);
        coldest = fr.getCSVParser();
        for (CSVRecord currentRow : coldest) {
            theColdestData = theColdestData.concat(currentRow.get("DateUTC"))
                            + ": " + currentRow.get("TemperatureF") + "\n";
        }

        return theColdestData;
    }

    public static void testFileWithColdestTemperature()
    {
        System.out.println(fileWithColdestTemperature());
    }

    public static CSVRecord lowestHumidityInFile (CSVParser parser)
    {
        CSVRecord lowestHumiditynow = null;
        for (CSVRecord currentRow : parser) {
            if (currentRow.get("Humidity").equals("N/A")) { continue; }
            if (lowestHumiditynow == null) {
                lowestHumiditynow = currentRow;
            }
            double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
            double lowestHumidity = Double.parseDouble(lowestHumiditynow.get("Humidity"));
            if(currentHumidity < lowestHumidity) {
                lowestHumiditynow = currentRow;
            }
        }
        return lowestHumiditynow;
    }
    public static void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord humidity = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity:" + humidity.get("Humidity")
                            + " At:" + humidity.get("DateUTC"));
    }

    public static CSVRecord  lowestHumidityInManyFiles()
    {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidity = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser currParser = fr.getCSVParser();
            if( lowestHumidity == null) lowestHumidity = lowestHumidityInFile(currParser);
            fr = new FileResource(f);
            currParser = fr.getCSVParser();
            CSVRecord  lowestHumidityNow = lowestHumidityInFile(currParser);
            double currLowest = Double.parseDouble(lowestHumidityNow.get("Humidity"));
            double lowestHumidity_D = Double.parseDouble(lowestHumidity.get("Humidity"));
            if(currLowest < lowestHumidity_D) {
                lowestHumidity = lowestHumidityNow;
            }
        }

        return lowestHumidity;
    }



    public static void testLowestHumidityInManyFiles()
    {
        CSVRecord lowestHumidity = lowestHumidityInManyFiles();

        System.out.println("Lowest Humidity was:" + lowestHumidity.get("Humidity")
                            + " At: " + lowestHumidity.get("DateUTC"));

    }
}

