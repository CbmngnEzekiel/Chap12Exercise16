import java.io.*;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        GradeBook gb = new GradeBook();
        File gradebookFile = new File("gradebook.txt");
        FileOutputStream fileOutput;
        ObjectOutputStream objectOutput;
        
        gb.getGrades();
        
        try {
        	fileOutput = new FileOutputStream(gradebookFile);
        	objectOutput = new ObjectOutputStream(fileOutput);
        	
        	objectOutput.writeObject(gb);
        	
        	objectOutput.close();
        	fileOutput.close();
        }catch(FileNotFoundException e) {
        	System.out.println("File not found. " + e.getMessage());
        }catch(IOException e) {
        	System.out.println("Problem with input/output. " + e.getMessage());
        }
        
        int menuChoice = 0;
        
        do{
            System.out.println("[1] Show grades");
            System.out.println("[2] Student Average");
            System.out.println("[3] Test Average");
            System.out.println("[0] Exit");
            menuChoice = sc.nextInt();

            switch(menuChoice){
                case 1 ->{
                    gb.showGrades(gradebookFile);
                }
                case 2 ->{
                	int studentId = 0;

                    System.out.print("Enter Student ID<1-12>: ");
                    studentId = sc.nextInt();
                    
                    gb.studentAvg(studentId, gradebookFile);
                }
                case 3 ->{
                	int testId = 0;

                    System.out.print("Enter Test ID<1-5>: ");
                    testId = sc.nextInt();
                    
                    gb.testAvg(testId, gradebookFile);
                }
                case 0 ->{

                }
                default ->{
                    System.out.println("Invalid input!");
                }
            }

        }while(menuChoice != 0);

    }
    
}
