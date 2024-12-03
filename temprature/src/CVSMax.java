import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class CVSMax extends Main{
    public static CSVRecord hottestHoutInFile(CSVParser csvParser) {
        CSVRecord largestSoFar = null;


        for (CSVRecord currentRow : csvParser) {
            if(largestSoFar == null) {
                largestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if(currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            }
        }


        return largestSoFar;
    }

}
