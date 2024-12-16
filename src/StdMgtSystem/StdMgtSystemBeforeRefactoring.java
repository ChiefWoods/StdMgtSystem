package StdMgtSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StdMgtSystemBeforeRefactoring {
    public static void main(String[] args) {

        // This code is to add subjects to the student management system and sort them:
        ArrayList<String> subjectList = new ArrayList<String>(); // an array list of subjects
        String newSubjectName; // A variable to add a new subject name
        String subjectToSearch = null;
        String studentToSearch = null;
        Boolean isSubjectFound;
        Boolean isStudentFound;
        System.out.println("Create the subject name list by entering the subject names one by one");
        System.out.println("Enter a subject name to be added to the student management system");
        Scanner input = new Scanner(System.in);
        newSubjectName = input.next();
        while (!(newSubjectName.equals("end"))) {
            subjectList.add(newSubjectName);
            System.out.print("Enter a subject name to be added to the student management system");
            newSubjectName = input.next();
        }
        System.out.println("The subject names in the student management system before sorting are: ");
        for (String counter : subjectList) {
            System.out.println(counter);
        }
        // bubble sort--------------------------------------------------
        boolean isSubjectSorted = false;
        while (!isSubjectSorted) {
            isSubjectSorted = true;
            String temp = null;
            for (int i = 0; i < subjectList.size() - 1; i++) {
                if ((subjectList.get(i)).compareToIgnoreCase(subjectList.get(i + 1)) > 0) {
                    temp = subjectList.get(i);
                    subjectList.set(i, subjectList.get(i + 1));
                    subjectList.set(i + 1, temp);
                    isSubjectSorted = false;
                }
            }
        }
        // -------------------------------------------------------
        System.out.println("The subject names in the student management system after sorting are: ");
        for (String counter : subjectList) {
            System.out.println(counter);
        }
        // This code is to add student names to the student management system and sort
        // them
        ArrayList<String> studentList = new ArrayList<String>();// an array list of student names
        String newStudentName;// A variable to add a new student name
        System.out.println("Create the student name list by entering the student names one by one");
        System.out.println("Enter a student name to be added to the student management system");
        input = new Scanner(System.in);
        newStudentName = input.next();
        while (!(newStudentName.equals("end"))) {
            studentList.add(newStudentName);
            System.out.print("Enter a student name to be added to the student management system");
            newStudentName = input.next();
        }
        System.out.println("The student names in the student management system before sorting are: ");
        for (String counter : studentList) {
            System.out.println(counter);
        }
        // bubble sort--------------------------------------------------
        boolean isStudentSorted = false;
        while (!isStudentSorted) {
            isStudentSorted = true;
            String temp = null;
            for (int i = 0; i < studentList.size() - 1; i++) {
                if ((studentList.get(i)).compareToIgnoreCase(studentList.get(i + 1)) > 0) {
                    temp = studentList.get(i);
                    studentList.set(i, studentList.get(i + 1));
                    studentList.set(i + 1, temp);
                    isStudentSorted = false;
                }
            }
        }
        // -------------------------------------------------------
        System.out.println("The student names in the student management system after sorting are: ");
        for (String counter : studentList) {
            System.out.println(counter);
        }

        // This code is to search for a specific subject name
        System.out.println("Enter a subject name to search for:");
        subjectToSearch = input.next();
        isSubjectFound = false;

        // Linear Search----------------------------------------------
        for (int index = 0; index < subjectList.size(); index++) {
            if (subjectList.get(index).equals(subjectToSearch))
                isSubjectFound = true;
        }
        // ------------------------------------------------------------
        if (isSubjectFound == true)
            System.out.println("The subject name is found");
        else if (isSubjectFound == false)
            System.out.println("The subject name is not found");
        // --------------------------------------------------------------

        // This code is to search for a specific student name
        System.out.println("Enter a student name to search for:");
        studentToSearch = input.next();
        isStudentFound = false;

        // Linear Search----------------------------------------------
        for (int index = 0; index < studentList.size(); index++) {
            if (studentList.get(index).equals(studentToSearch))
                isStudentFound = true;
        }
        // ------------------------------------------------------------
        if (isStudentFound == true)
            System.out.println("The student name is found");
        else if (isStudentFound == false)
            System.out.println("The student name is not found");
        // --------------------------------------------------------------
    }
}