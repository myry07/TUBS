/* 
 * Wir arbeiten hier mit ArrayList, in welche dynamisch Elemente hinzugefügt und gelöscht werden können.
 * ArrayList arbeitet mit Generics, d.h. wir müssen bei Deklaration angeben, welcher Typ benutzt wird.
 * Wir nehmen für diese Aufgabe an, dass wir eine Tabelle einlesen, 
 * welche in jeder Zeile einen Namen, eine ID, 5 Aufgabenpunkte, Summe und Note enthält.
 * Die erste Zeile enthält die Bezeichner der Spalten.
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Parser {
    static final double[] GRADE_VALS = {1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 5.0};
    static final int[] countGrades = {0,0,0,0,0,0,0,0,0,0,0}; //Zähle Anzahl der Noten 1.0, 1.3, 1.7, ...
    
    static int numAttendees;
    static final ArrayList<ArrayList<Integer>> pointsExercise; //Sammle hier zunächst alle Punkte pro Aufgabe
    
    //Bereite die Punktetabelle vor
    static{
         pointsExercise = new ArrayList<>(5);
         
         for (int i = 0; i < 5; ++i){
            pointsExercise.add(new ArrayList<>());
         }
    }
    
    public static int getGradeIndex(String grade){
        switch (grade){
            case "1.0":
                return 0;
            case "1.3":
                return 1;
            case "1.7":
                return 2;
            case "2.0":
                return 3;
            case "2.3":
                return 4;
            case "2.7":
                return 5;
            case "3.0":
                return 6;
            case "3.3":
                return 7;
            case "3.7":
                return 8;
            case "4.0":
                return 9;            
            default:
                assert grade.equals("5.0");
                return 10;
        }
    }

    public static void parse(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("ergebnisse.csv"));
            
            String line = reader.readLine();
            
            while((line = reader.readLine()) != null){
                ++numAttendees;
                
                String[] lineElements = line.split(",");
                int gradeIndex = getGradeIndex(lineElements[lineElements.length-1]);
                ++countGrades[gradeIndex];
                
                for (int i = 0; i < 5; ++i){
                    int point = Integer.parseInt(lineElements[i+2]);
                    pointsExercise.get(i).add(point);
                }
                
            }
        } catch (IOException e){
            System.out.println("Error occured. Could not read file. Aborting!");
            System.exit(-1);
        }
    }
    
    
    
    public static double averageGrade(){
        double result = 0.0;
        
        for (int i = 0; i < GRADE_VALS.length; ++i){
            result += GRADE_VALS[i] * countGrades[i];
        }
        return result / numAttendees;
    }
    
    
    public static double[] averagePoints(){
        double[] result = {0.0, 0.0, 0.0, 0.0, 0.0};
        for (int i = 0; i < 5; ++i){
            int exercisePoints = 0;
            for (Integer point : pointsExercise.get(i)){
                exercisePoints += point;
            }
            
            result[i] = (double) exercisePoints / numAttendees;
        }
        
        return result;
    }
    
    //Produziert gesamten String, der ausgegeben werden soll.
    public static String getPrintString(){
        String result = "";
        
        //Schreibe Durchschnittspunkte pro Aufgabe
        double[] avPoints = averagePoints();
        result += "AVERAGE POINTS IN EXERCISES\n";
        result += "___________________\n";
        for (int i = 0; i < 5; ++i){
            result += String.format("|Aufgabe %d | %05.2f |%n", i+1, avPoints[i]);
        }
        result += "-------------------\n";
        
        //Schreibe Anzahl der Noten
        String zeichen = ">";
        result += "GRADE DISTRIBUTION\n";
        result += "____________\n";
        for (int i = 0; i < GRADE_VALS.length; ++i){
            result += String.format("| %.1f | %02d | %s%n", GRADE_VALS[i], countGrades[i], zeichen.repeat(countGrades[i]));
        }
        result += "------------\n";
        
        //Bestehensquote
        double passRate = 100*(numAttendees - countGrades[10]) / (double) numAttendees;
        result += String.format("PASS RATE %.2f%%%n", passRate);
        
        //Durchschnittsnote
        result += String.format("%nAVERAGE GRADE: %.2f%n", averageGrade());
        
        return result;
    }
    
    public static void printStats(){
        System.out.println(getPrintString());
    }
    
    public static void writeStats(){
        try{
            //Falls Datei nicht existent, dann lege diese an.
            File file = new File("./ergebnisse.stats");
            if (!file.exists()){
                file.createNewFile();
            }
            
            //Überschreibt vorhandene Datei.
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            
            writer.write(getPrintString());
            writer.flush();
            writer.close();
        } catch (IOException e){
            System.out.println("Some error occured while writing the file. Aborting!");
            System.exit(-1);
        }
    }
    
    public static void main(String[] args){
        parse();
        printStats();
        writeStats();
    }
}