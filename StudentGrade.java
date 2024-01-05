import java.util.Arrays;
import java.util.Scanner;

public class StudentGrade{

	private int numbersOfStudent;
	private int numbersOfSubject;
	private int[][] storage;
	private int[] total;
	private int[] position;
	private double[] average;
	Scanner scanner = new Scanner(System.in);
	private int score;
	private int sum;
	

 
	public static void main(String[] args){

		StudentGrade studentGrade = new StudentGrade();
		studentGrade.collectInput();
		studentGrade.collectingInput();
		studentGrade.calculatingTotal();
		studentGrade.calculatingAverage();
		studentGrade.sortedArray();
		studentGrade.printOutput();
		studentGrade.printOutput1();
		studentGrade.printOutput2();

	}

	public void collectInput(){
		System.out.println("How many students do you have?");
		numbersOfStudent = scanner.nextInt();

		System.out.println("How many subject do they offer?");
		numbersOfSubject = scanner.nextInt();

		System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Saved successfully");
		System.out.println();

		
	} 
		

	public void collectingInput(){
		storage = new int[numbersOfStudent][numbersOfSubject];
		for(int index = 1; index <= numbersOfStudent; index++){
			for(int input = 1; input <= numbersOfSubject; input++){
				System.out.println("Entering score for student "+ index);
				System.out.println("Entering score for subject "+ input);
				score = scanner.nextInt();
				if(score >= 0 && score <= 100){
					storage[index - 1][input - 1] = score;
				}
				else {
					input--;
				}
				System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Saved successfully");
				System.out.println();
		
			} 
			System.out.println();
		
		}

	
	}

	public void calculatingTotal(){
		total = new int[numbersOfStudent];
		for(int index = 0; index < numbersOfStudent; index++){
			sum = 0;
			for(int input = 0; input < numbersOfSubject; input++){
				sum += storage[index][input];
				
			}
			total[index] = sum;
		}
			
	}
	
	public void calculatingAverage(){
		average = new double[numbersOfStudent];
		for(int index = 0; index < total.length; index++){
			average[index] = (double)total[index] / numbersOfStudent;
		}
	}

	public int[] sortArray(int[] array) {
        	for (int index = 0; index < array.length; index++) {
            		for (int idx = index+1; idx < array.length; idx++) {
               			if (array[index] < array[idx]){
                    			int temp = array[index];
                    			array[index] = array[idx];
                   			array[idx] = temp;
                		}
            		}
        	}
        	return array;
        }

	public void sortedArray(){
		position = new int[total.length];
        	int[] sortedTotal = Arrays.copyOf(total, total.length);
        	sortedTotal = sortArray(sortedTotal);	
       		for (int index = 0; index < total.length; index++) {
            		for (int input = 0; input < sortedTotal.length; input++) {
                		if (total[index] == sortedTotal[input]) {
                        		position[index] = input + 1;
                		}
            		}
        	}
    

	
	}

	public void printOutput(){
		System.out.println("=================================".repeat(numbersOfSubject));
		System.out.print("STUDENT\t");
	for(int index = 1; index <= numbersOfSubject; index++){
			System.out.print("SUB" + index + "\t");
		}
		System.out.print("TOT\tAVG\tPOS\n");
		System.out.println("=================================".repeat(numbersOfSubject));
		for(int index = 0; index < numbersOfStudent; index++){
			System.out.print("Student" + (index + 1) + " ");
			for(int input = 0; input < numbersOfSubject; input++){
				System.out.print(storage[index][input] + "\t");
			
			}
			System.out.print(total[index] + "\t");
			System.out.print(average[index] + "\t");
			System.out.println(position[index]);



		}
		System.out.println("""
				==================================================================
				==================================================================
				""");

	}

	public void printOutput1() {
		System.out.println("SUBJECT SUMMARY");

		for (int subject = 0; subject < numbersOfSubject; subject++) {
        		int highestTotal = storage[0][subject];
        		int lowestTotal = storage[0][subject];
        		int highestIndex = 0;
        		int lowestIndex = 0;
        		int totalScores = 0;
        		int numPasses = 0;
        		int numFails = 0;
			System.out.println("Subject" + (subject + 1));

        		for (int student = 0; student < numbersOfStudent; student++) {
            			int score = storage[student][subject];
            			totalScores += score;

            			if (score > highestTotal) {
                			highestTotal = score;
                			highestIndex = student;
            			} else 
				if (score < lowestTotal) {
                			lowestTotal = score;
                			lowestIndex = student;
            			}

            			if (score >= 50) {
                			numPasses++;
            			} else {
                			numFails++;
            			}
        		}

        
        	double averageScore = (double) totalScores / numbersOfStudent;

        	System.out.println("Highest Scoring Student: Student" + (highestIndex + 1) + " scoring: " + highestTotal);
        	System.out.println("Lowest Scoring Student: Student" + (lowestIndex + 1) + " scoring: " + lowestTotal);
        	System.out.println("Total Scores: " + totalScores);
        	System.out.println("Average Score: " + averageScore);
        	System.out.println("Number of Passes: " + numPasses);
        	System.out.println("Number of Fails: " + numFails);
        	System.out.println();
    		}
	}


	public void printOutput2() {
    		int overallHighestScore = 0;
		int overallLowestScore = Integer.MAX_VALUE;
		int hardestSubjectFails = Integer.MIN_VALUE;
		int easiestSubjectPasses = Integer.MIN_VALUE;
		int hardestSubjectIndex = 0;
		int easiestSubjectIndex = 0;
		int bestGraduatingStudent = 0;
		int worstGraduatingStudent = 0;
		int classTotalScore = 0;
		int highestTotal = Integer.MIN_VALUE;
        	int lowestTotal = Integer.MAX_VALUE;
        	int highestIndex = 0;
        	int lowestIndex = 0;
		


    		for (int subject = 0; subject < numbersOfSubject; subject++) {
    			int totalScores = 0;
    			int numPasses = 0;
    			int numFails = 0;

    			for (int student = 0; student < numbersOfStudent; student++) {
        			totalScores += storage[student][subject];

        			if (storage[student][subject] < 50) {
            				numFails++;
        			} else {
            				numPasses++;
        			}
    			}

    
    			if (numFails > hardestSubjectFails) {
        			hardestSubjectIndex = subject + 1;
        			hardestSubjectFails = numFails;
    			}

    
    			if (numPasses > easiestSubjectPasses) {
        			easiestSubjectIndex = subject + 1;
        			easiestSubjectPasses = numPasses;
    			}
		}



		for (int subject = 0; subject < numbersOfSubject; subject++) {
			int totalScores = 0;
			int numPasses = 0;
			int numFails = 0;

			for (int student = 0; student < numbersOfStudent; student++) {
			int score = storage[student][subject];
			totalScores += score;
			if (score > highestTotal) {
				highestTotal = score;
				highestIndex = student;
			} 
			if (score < lowestTotal) {
				lowestTotal = score;
				lowestIndex = student;
        		}

			if (score >= 50) {
				numPasses++;
        		} else {
            			numFails++;
        		}
    		}
	}

		
		for (int student = 0; student < numbersOfStudent; student++) {
    			int studentTotal = total[student];

        		if (studentTotal > overallHighestScore) {
            			overallHighestScore = studentTotal;
            			bestGraduatingStudent = student + 1;
        		}
        		if (studentTotal < overallLowestScore) {
            			overallLowestScore = studentTotal;
            			worstGraduatingStudent = student + 1;
        		}

   
    			classTotalScore += studentTotal;
    			
		}





    	double classAverage = (double) classTotalScore / numbersOfStudent;
	System.out.println("Hardest Subject is subject " + (hardestSubjectIndex) + " with " + hardestSubjectFails + " failures");
	System.out.println("Easiest Subject is subject " + (easiestSubjectIndex) + " with " + easiestSubjectPasses + " passes");
	System.out.println("Overall Highest Score is scored by student: " + (highestIndex + 1) + " scoring " + highestTotal);
	System.out.println("Overall Lowest Score is scored by student: " + (lowestIndex + 1) + " scoring " + lowestTotal);
	System.out.println("""
	==========================================================
	""");
	System.out.println("CLASS SUMMARY");
	System.out.println("""
	==========================================================
	""");
	System.out.printf("Best Graduating Student is Student %d scoring %d%n", bestGraduatingStudent, overallHighestScore);
	System.out.println("""
	==========================================================
	""");
	System.out.println("""
	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	""");
	System.out.printf("Worst Graduating Student is Student %d scoring %d%n", worstGraduatingStudent, overallLowestScore);
	System.out.println("""
	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	""");
	System.out.println("""
	==========================================================
	""");
	System.out.println("Class Total Score: " + classTotalScore);    	
	System.out.println("Class Average: " + classAverage);
	System.out.println("""
	==========================================================
	""");

	}

    		

}