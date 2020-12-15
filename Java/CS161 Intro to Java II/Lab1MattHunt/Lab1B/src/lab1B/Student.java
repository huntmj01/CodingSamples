package lab1B;

import java.io.PrintWriter;

public class Student {
	
	private String name;
	private char grade;
	private double average;
	private int[] scores;
	
	// getters and setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	// Determine the average of the five test scores for each student
	public void calculateAverage(){
		average = (scores[0] + scores[1] + scores[2] + scores[3] + scores[4] + 0.0)/scores.length;
	}
	
	// Determine each student’s letter grade based on 
	// 90-100 A, 80-89 B, 70-79 C, 60-69 D,	0-59 F
	public void calculateGrade(){
		
		if (average > 89){
			grade = 'A';
		}else if (average > 79){
			grade = 'B';
		}else if (average > 69){
			grade = 'C';
		}else if (average > 59){
			grade = 'D';
		}else{
			grade = 'F';
		}
	}
	
	// Print out name, test scores, average, and letter grade to the output file
	public void generateOutput(PrintWriter outFile){
		outFile.println(name + "\t" + scores[0] + "\t" + scores[1] + "\t" + scores[2] + "\t" + scores[3] + "\t" + scores[4] + "\t" + average + "\t" + grade);
	}
}
