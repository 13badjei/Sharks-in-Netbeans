/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.pkg1;

/**
 *
 * @author cocopops2016
 */
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
         String fileLocation = System.getProperty("user.dir");  
         String dataPath = fileLocation + File.separator + "shark-data.txt"; 
         java.io.File fileSave = new java.io.File("results.txt");
         java.io.PrintWriter output = new java.io.PrintWriter(fileSave);
         Scanner fileScanner = null;    
            File inputFile = new File(dataPath);  
        try {
            fileScanner = new Scanner(inputFile);
            fileScanner.useDelimiter("\\n");   
        } catch (FileNotFoundException e) {
            System.out.print("Error: File Not Found");
            System.exit(0); 
        }
        //Create an arraylist to store sharks
        ArrayList<Shark> sharkList = new ArrayList<>();
        //Create a File instance
        java.io.File file = new java.io.File("shark-data.txt");
        
        //Create a Scanner for the file
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Task1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Read data from shark-data.txt
        while (input.hasNextLine()){
            String line = input.nextLine();
            String[] data = line.split(":");
            Shark dataFile = new Shark(data[0], data[1], Integer.parseInt(data[2]));
            sharkList.add(dataFile);
        }
        sharkList.sort(Comparator.comparing(Shark::getMaxLengthInCm));
  
        //Getting the 3 largest sharks
        System.out.println("--- Three largest sharks ---");
        output.println("--- Three largest sharks ---");
        for(int i = 22; i < sharkList.size(); i++){
            System.out.println(sharkList.get(i).getCommonName() + ", Length = " + sharkList.get(i).getMaxLengthInCm() + " centimetres");
            output.println(sharkList.get(i).getCommonName() + ", Length = " + sharkList.get(i).getMaxLengthInCm() + " centimetres");
        }
        System.out.println();
        output.println();
        //Getting the 3 smallest sharks
        System.out.println("--- Three smallest sharks ---");
        output.println("--- Three smallest sharks ---");
        System.out.println(sharkList.get(0).getCommonName() + ", Length = " + sharkList.get(0).getMaxLengthInCm() + " centimetres"); 
        output.println(sharkList.get(0).getCommonName() + ", Length = " + sharkList.get(0).getMaxLengthInCm() + " centimetres"); 
        System.out.println(sharkList.get(1).getCommonName() + ", Length = " + sharkList.get(1).getMaxLengthInCm() + " centimetres"); 
        output.println(sharkList.get(1).getCommonName() + ", Length = " + sharkList.get(1).getMaxLengthInCm() + " centimetres"); 
        System.out.println(sharkList.get(2).getCommonName() + ", Length = " + sharkList.get(2).getMaxLengthInCm() + " centimetres"); 
        output.println(sharkList.get(2).getCommonName() + ", Length = " + sharkList.get(2).getMaxLengthInCm() + " centimetres"); 
        System.out.println();
        output.println();
        System.out.println("----------------------------------");
        output.println("----------------------------------");
        // Getting the number of letters in the sharks' Latin names
        int total = 0;
        for (int i = 0; i < sharkList.size(); i++){
            total = total + sharkList.get(i).getLatinName().replace(" ", "").length();  
        }
        System.out.println("Total number of letters in all Latin names = " + total);
        output.println("Total number of letters in all Latin names = " + total);
        // remove duplicates of words
        HashSet<String> uniqueWords = new HashSet<String>();
        for(int a = 0; a < sharkList.size(); a++){
            for (String myString: sharkList.get(a).getLatinName().split(" ")) {
                uniqueWords.add(myString);
            }
        }
        int even = 0;
        int odd = 0;
        for (String word :uniqueWords){
            if (word.length() % 2 == 0) {
                even += 1;
            } 
            else {
                odd +=1;
            }
        } 
        // Get total number of unique even words in all Latin names
        System.out.println("Total number of unique even words in all Latin names = " + even);
        output.println("Total number of unique even words in all Latin names = " + even);

        // Get total number of unique odd words in all Latin names
        System.out.println("Total number of unique odd words in all Latin names = " + odd);
        output.println("Total number of unique odd words in all Latin names = " + odd);
        output.close();
    }
}