import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;
public class q2 {
    
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
    
    public String fileWithColdestTemperature(){
        CSVRecord smallestSoFar = null;
        String fileName = "";
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
            if(smallestSoFar == null){
                smallestSoFar = current;
            }
            else{
                double currentTemp = Double.parseDouble((current.get("TemperatureF")));
                double largestTemp = Double.parseDouble((smallestSoFar.get("TemperatureF")));
                if(currentTemp < largestTemp){
                    smallestSoFar = current;
                    fileName = f.toString();
                }
            }
        }
        return fileName;
    }
    
    public void testFileWithColdestTemperature(){
        String fileName = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + fileName);
        FileResource f = new FileResource(fileName);
        int index1 = fileName.indexOf("2",0);
        int index2 = fileName.indexOf(".",index1);
        String subFileName = fileName.substring(index1,index2);
        CSVParser parser = f.getCSVParser();
        CSVRecord smallest = coldestHourInFile(parser);
        System.out.println("Coldest Temperature on that day was " + smallest.get("TemperatureF"));
        parser = f.getCSVParser();
        System.out.println("All the temperature on coldest day were:");
        for(CSVRecord record : parser){
            System.out.println(record.get("DateUTC")+ " " + record.get("TemperatureF"));
        }
    }
}
