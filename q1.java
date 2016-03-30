import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;


public class q1 {
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        for(CSVRecord current : parser){
            if(smallestSoFar == null){
                smallestSoFar = current;
            }
            else{
                double currentTemp = Double.parseDouble((current.get("TemperatureF")));
                double smallestTemp = Double.parseDouble((smallestSoFar.get("TemperatureF")));
                if(currentTemp >= 0){
                    if(currentTemp < smallestTemp){
                        smallestSoFar = current;
                    }
                }
            }
        }
        return smallestSoFar;
    }
    
    public void testColdestHourInAFile(){
        FileResource f = new FileResource();
        CSVParser parser = f.getCSVParser();
        CSVRecord smallest = coldestHourInFile(parser);
        System.out.println("Coldest Temperature is "+ smallest.get("TemperatureF")+ " at time " + smallest.get("TimeEST"));
    }

}
