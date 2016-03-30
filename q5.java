import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class q5 {
    public double averageTemperatureInFile(CSVParser parser){
        int count = 0;
        double sum = 0.0;
        double temp = 0.0;
        double average = 0.0;
        for(CSVRecord record : parser){
            temp = Double.parseDouble(record.get("TemperatureF"));
            sum = sum + temp;
            count++;
        }
        
        average = sum /count;
        return average;
    }
    
    public void test(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        System.out.println("Average Temperature in file is " + average);
    }
}
