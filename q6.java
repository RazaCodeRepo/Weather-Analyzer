
import java.io.*;
import org.apache.commons.csv.*;
import edu.duke.*;

public class q6 {
    
    
        public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        int humidity = 0;
        double sum = 0.0;
        int count = 0;
        double average = 0.0;
        double temp = 0.0;
        for(CSVRecord record : parser){
            humidity = Integer.parseInt(record.get("Humidity"));
            if(humidity >= value){
                temp = Double.parseDouble(record.get("TemperatureF"));
                sum = sum + temp;
                count++;
            }
        }
        
        average = sum/count;
        
        return average;
    }
    
    public void test(){
        FileResource f = new FileResource();
        CSVParser parser = f.getCSVParser();
        double average = averageTemperatureWithHighHumidityInFile(parser,80);
        if (Double.isNaN(average)){
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average temperature when high humidity is " + average);
        }
        
    }
}
