import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class q4 {
    
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestHumid = null;
        DirectoryResource dr = new DirectoryResource();
       for(File f : dr.selectedFiles()){
           FileResource fr = new FileResource(f);
           CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
           if(lowestHumid == null){
                lowestHumid = current;
           }
           else{
              double currentHumidity = Double.parseDouble((current.get("Humidity")));
              double lowestHumidity = Double.parseDouble((lowestHumid.get("Humidity")));
              if(lowestHumidity > currentHumidity){
                    lowestHumid = current;
              }
           }
       }
       return lowestHumid;
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumid = null;
        for(CSVRecord current : parser){
            if(lowestHumid == null){
                lowestHumid = current;
            }
            else{
                String check = current.get("Humidity");
                if(check.equals("N/A") == false){
                
                    int currentHumid = Integer.parseInt(check);
                    int lowestHumidity = Integer.parseInt((lowestHumid.get("Humidity")));
                    if(lowestHumidity > currentHumid){
                        lowestHumid = current;
                    }
                }
                
            }
            
        }
        
        return lowestHumid;
    }

    public void testLowestHumidityInManyFiles(){
        CSVRecord record = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + record.get("Humidity") + " at " + record.get("DateUTC"));
    }

}
