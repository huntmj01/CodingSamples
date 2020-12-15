package lab2A;

import java.io.*;

public class ProgressReportDriver {
	public static void main(String[] args) throws IOException {
		Student tmpStudent;

		ProgressReport progressReport = new ProgressReport();

		progressReport.readInputFile();
		progressReport.generateReport();
		System.out.println("\nAFTER SORTING THE 2D ARRAY\n");
		progressReport.sortByName();
		progressReport.generateReport();

		System.out.println("\nSEARCH TEST");
		tmpStudent = null;
		tmpStudent = progressReport.binarySearch(0, "Cooper_");
		if (tmpStudent != null)
			System.out.println("Found " + tmpStudent.getName() + "\tAverage = " + tmpStudent.getAverage() + "\tGrade = "
					+ tmpStudent.getGrade());
		else
			System.out.println("Fail to find the student");

		tmpStudent = null;
		tmpStudent = progressReport.binarySearch(0, "Bronson");
		if (tmpStudent != null)
			System.out.println("Found " + tmpStudent.getName() + "\tAverage = " + tmpStudent.getAverage() + "\tGrade = "
					+ tmpStudent.getGrade());
		else
			System.out.println("Fail to find the student");

		tmpStudent = null;
		tmpStudent = progressReport.binarySearch(1, "Diana__");
		if (tmpStudent != null)
			System.out.println("Found " + tmpStudent.getName() + "\tAverage = " + tmpStudent.getAverage() + "\tGrade = "
					+ tmpStudent.getGrade());
		else
			System.out.println("Fail to find the student");

	}
}
