import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class q3 {
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumid = null;
        for(CSVRecord current : parser){
            if(lowestHumid == null){
                lowestHumid = current;
            }
            else{
                String check = current.get("Humidity");
                if(check != "N/A"){
                    double currentHumid = Double.parseDouble((current.get("Humidity")));
                    double lowestHumidity = Double.parseDouble((lowestHumid.get("Humidity")));
                    if(lowestHumidity > currentHumid){
                        lowestHumid = current;
                    }
                }
            }
        }
        return lowestHumid;
    }

    public void testLowestHumidity(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord record = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + record.get("Humidity") + " at " + record.get("DateUTC"));
    }

}
