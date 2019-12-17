/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Acer User
 */
public class DataManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       final int LENGTH = 10;
       double marks []= new double[LENGTH];
             
       readFile(marks);
     
       getAverageMark(marks); 
       
       sortMarks(marks);
       writeFile(marks);
      
    }
    
    public static void sortMarks(double [] marks)
    {
         double tempMark;
        for(int i = 0; i < marks.length; i++)
       {
           for(int j = 0; j < 9; j++)
           {
               if(marks[j] > marks[j+1])
               {
                   tempMark = marks[j];
                   marks[j] = marks[j+1];
                   marks[j+1] = tempMark;
               }
           
           }
       }
  
       System.out.println("--After Sorting--");
       
       for(int i = 0; i < marks.length; i++)
       {
           System.out.print(marks[i] + " ");
        
       }
    }
    
    
     public static void writeFile(double [] marks)
    {
      
       try
       {
           FileWriter file = new FileWriter("outMarks.txt");
           BufferedWriter buffer = new BufferedWriter(file);
           for(int i = 0; i < marks.length; i++)
           {
              buffer.write(String.valueOf(marks[i]) +"\n");
           }
           buffer.close();
       
       }
       
       catch(IOException e)
       {
           System.out.println("Sorry, the file was not correctly written");
           return;
       }
       
    }
    
    
    public static void readFile(double [] marks)
    {
      
       try
       {
           FileReader file = new FileReader("markData.txt");
           BufferedReader buffer = new BufferedReader(file);
           for(int i = 0; i < marks.length; i++)
           {
               marks[i] = Double.parseDouble(buffer.readLine());
           }
           
          buffer.close();
       }
       
       catch(IOException e)
       {
           System.out.println("Sorry, the file was not found");
           return;
       }
       
    }

    private static void getAverageMark(double[] marks) {
       double avgMark;
      
       double totalMark = 0;
        
        for(int i = 0; i < marks.length; i++)
       {
           totalMark = marks[i] + totalMark;
       }
       
       avgMark = totalMark / marks.length;
       avgMark = avgMark * 100;
       avgMark = Math.round(avgMark);
       avgMark = avgMark / 100;
       
       System.out.println("the average mark is " + avgMark);  
    }
    
  
    
}
