import java.io.*;
import java.util.Scanner;

public class GradeBook implements Serializable{
    private int[][] grades;

    public GradeBook(){
        this.grades = new int[12][5];
    }

    public void getGrades(){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < this.grades.length; i++){
            sc.reset();

            int grade = 0;

            System.out.print("Enter grade for student " + (i + 1) + ": \n");

            for(int j = 0; j < this.grades[i].length; j++){
                System.out.print("Test " + (j + 1) + ": ");
                grade = sc.nextInt();
                this.grades[i][j] = grade;
                System.out.println();
            }
        }
    }

    public void showGrades(File file){
    	GradeBook gb;
    	FileInputStream fileInput;
    	ObjectInputStream objectInput;
    	
    	try {
    		fileInput = new FileInputStream(file);
    		objectInput = new ObjectInputStream(fileInput);
    		
    		gb = (GradeBook) objectInput.readObject();
        	
            for(int i = 0; i < gb.grades.length; i++){
                String displayGrades = "";

                System.out.println("STUDENT " + (i + 1) + ": ");
                System.out.print("Grades: ");

                for(int j = 0; j < gb.grades[i].length; j++){
                    displayGrades += gb.grades[i][j] + ", ";
                }

                displayGrades = displayGrades.substring(0, displayGrades.length() - 2);
                System.out.println(displayGrades + "\n");
            }
            
            fileInput.close();
    		objectInput.close();
    	}catch(FileNotFoundException e) {
    		System.out.println("File not found. " + e.getMessage());
    	}catch(IOException e) {
    		System.out.println("Problem with input/output." + e.getMessage());
    	} catch (ClassNotFoundException e) {
			System.out.println("Class cannot be used to cast object. " + e.getMessage());
		}
    }
    

    public void studentAvg(int studentNumber, File file){
    	GradeBook gb;
    	FileInputStream fileInput;
    	ObjectInputStream objectInput;
        double total = 0;
        double studentAvg = 0;
        
        try {
    		fileInput = new FileInputStream(file);
    		objectInput = new ObjectInputStream(fileInput);
    		
    		gb = (GradeBook) objectInput.readObject();

            for(int i = 0; i < gb.grades[studentNumber - 1].length; i++){
                total += gb.grades[studentNumber - 1][i];
            }
            
            fileInput.close();
    		objectInput.close();
    	}catch(FileNotFoundException e) {
    		System.out.println("File not found. " + e.getMessage());
    	}catch(IOException e) {
    		System.out.println("Problem with input/output." + e.getMessage());
    	} catch (ClassNotFoundException e) {
			System.out.println("Class cannot be used to cast object. " + e.getMessage());
		}

        studentAvg = total / 5;

        System.out.printf("Average grade for student %d: %.2f\n", studentNumber, studentAvg);
    }

    public void testAvg(int testNumber, File file){
    	GradeBook gb;
    	FileInputStream fileInput;
    	ObjectInputStream objectInput;
        double total = 0;
        double testAvg = 0;
        
        try {
    		fileInput = new FileInputStream(file);
    		objectInput = new ObjectInputStream(fileInput);
    		
    		gb = (GradeBook) objectInput.readObject();

            for(int i = 0; i < gb.grades.length; i++){
                total += gb.grades[i][testNumber - 1];
            }
            
            fileInput.close();
    		objectInput.close();
    	}catch(FileNotFoundException e) {
    		System.out.println("File not found. " + e.getMessage());
    	}catch(IOException e) {
    		System.out.println("Problem with input/output." + e.getMessage());
    	} catch (ClassNotFoundException e) {
			System.out.println("Class cannot be used to cast object. " + e.getMessage());
		}

        testAvg = total / 12;

        System.out.printf("Average grade for Test ID - %d: %.2f\n", testNumber, testAvg);
    }
}