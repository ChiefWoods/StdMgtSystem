package StdMgtSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StdMgtSystemBeforeRefactoring {
    public static void main(String[] args) {

        // This code is to add subjects to the student management system and sort them:
        ArrayList<Subject> subjectList = new ArrayList<Subject>(); // an array list of subjects
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
            subjectList.add(new Subject(newSubjectName));
            System.out.println("Enter a subject name to be added to the student management system (enter 'end' to stop)");
            newSubjectName = input.next();
        }
        System.out.println("The subject names in the student management system before sorting are: ");
        for (Subject subject : subjectList) {
            System.out.println(subject.getName());
        }
        // bubble sort--------------------------------------------------
        Utils.sortList(subjectList);
        // -------------------------------------------------------
        System.out.println("The subject names in the student management system after sorting are: ");
        for (Subject subject : subjectList) {
            System.out.println(subject.getName());
        }
        // This code is to add student names to the student management system and sort
        // them
        ArrayList<Student> studentList = new ArrayList<Student>();// an array list of student names
        String newStudentName;// A variable to add a new student name
        System.out.println("Create the student name list by entering the student names one by one");
        System.out.println("Enter a student name to be added to the student management system");
        input = new Scanner(System.in);
        newStudentName = input.next();
        while (!(newStudentName.equals("end"))) {
            studentList.add(new Student(newStudentName));
            System.out.println("Enter a student name to be added to the student management system (enter 'end' to stop)");
            newStudentName = input.next();
        }
        System.out.println("The student names in the student management system before sorting are: ");
        for (Student student : studentList) {
            System.out.println(student.getName());
        }
        // bubble sort--------------------------------------------------
        Utils.sortList(studentList);
        // -------------------------------------------------------
        System.out.println("The student names in the student management system after sorting are: ");
        for (Student student : studentList) {
            System.out.println(student.getName());
        }

        // This code is to search for a specific subject name
        System.out.println("Enter a subject name to search for:");
        subjectToSearch = input.next();

        // Linear Search----------------------------------------------
        isSubjectFound = Utils.searchElement(subjectList, subjectToSearch);
        // ------------------------------------------------------------
        if (isSubjectFound == true)
            System.out.println("The subject name is found");
        else if (isSubjectFound == false)
            System.out.println("The subject name is not found");
        // --------------------------------------------------------------

        // This code is to search for a specific student name
        System.out.println("Enter a student name to search for:");
        studentToSearch = input.next();

        // Linear Search----------------------------------------------
        isStudentFound = Utils.searchElement(studentList, studentToSearch);
        // ------------------------------------------------------------
        if (isStudentFound == true)
            System.out.println("The student name is found");
        else if (isStudentFound == false)
            System.out.println("The student name is not found");
        // --------------------------------------------------------------
    }
}