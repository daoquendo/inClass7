/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talent;

/**
 * Daniela Miles
 */
import com.opencsv.CSVReader;
import java.util.*;
import java.io.File;
import java.util.List;
import java.io.*;  
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Talent 
{   
    static String comma;
    static String fileName;
    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        try
        {
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Enter the name of the file you want to send to:");
            fileName = scan.next();
            System.out.println("What character you want to replace commas with?:");
            comma = scan.next();
            
            CSVReader reader;
            File file = new File(fileName);
            
            if(!file.createNewFile())
            {
                System.out.println("Error creating file");
            }
            
            FileWriter writer = new FileWriter(file);
            
            reader = new CSVReader(new FileReader("talent.csv"));
            
            try
            {
                List myEntries = reader.readAll();   
                
                for(int i = 0; i < myEntries.size(); i++)
                {
                    String[] replace = (String[]) myEntries.get(i);
                    
                    for(int y = 0; y < replace.length; y++)
                    {
                        if(y == (replace.length -1))
                        {
                            replace[y] += "\n";
                            writer.write(replace[y]);
                        }
                        else
                        {
                            replace[y] += comma;
                            writer.write(replace[y]);
                        }
                    }
                }
                
                writer.flush();
                writer.close();
                
            }catch (IOException er)
            {
                System.out.println(er);
            }
            
        }catch (FileNotFoundException ex)
        {
            System.out.println(ex);
        }
        
    }
    
    
    
}
    

