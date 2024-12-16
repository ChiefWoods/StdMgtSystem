package StdMgtSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StdMgtSystemBeforeRefactoring {
    public static void sortSubjectList(ArrayList<Subject> list) {
        boolean isListSorted = false;
        while (!isListSorted) {
            isListSorted = true;
            Subject temp = null;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getName().compareToIgnoreCase(list.get(i + 1).getName()) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    isListSorted = false;
                }
            }
        }
    }

    public static void sortStudentList(ArrayList<Student> list) {
        boolean isListSorted = false;
        while (!isListSorted) {
            isListSorted = true;
            Student temp = null;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getName().compareToIgnoreCase(list.get(i + 1).getName()) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    isListSorted = false;
                }
            }
        }
    }

    public static boolean searchSubject(ArrayList<Subject> list, String name) {
        boolean isSubjectFound = false;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getName().equals(name))
                isSubjectFound = true;
        }
        return isSubjectFound;
    }

    public static boolean searchStudent(ArrayList<Student> list, String name) {
        boolean isStudentFound = false;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getName().equals(name))
                isStudentFound = true;
        }
        return isStudentFound;
    }

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
            System.out.print("Enter a subject name to be added to the student management system");
            newSubjectName = input.next();
        }
        System.out.println("The subject names in the student management system before sorting are: ");
        for (Subject subject : subjectList) {
            System.out.println(subject.getName());
        }
        // bubble sort--------------------------------------------------
        sortSubjectList(subjectList);
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
            System.out.print("Enter a student name to be added to the student management system");
            newStudentName = input.next();
        }
        System.out.println("The student names in the student management system before sorting are: ");
        for (Student student : studentList) {
            System.out.println(student.getName());
        }
        // bubble sort--------------------------------------------------
        sortStudentList(studentList);
        // -------------------------------------------------------
        System.out.println("The student names in the student management system after sorting are: ");
        for (Student student : studentList) {
            System.out.println(student.getName());
        }

        // This code is to search for a specific subject name
        System.out.println("Enter a subject name to search for:");
        subjectToSearch = input.next();

        // Linear Search----------------------------------------------
        isSubjectFound = searchSubject(subjectList, subjectToSearch);
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
        isStudentFound = searchStudent(studentList, studentToSearch);
        // ------------------------------------------------------------
        if (isStudentFound == true)
            System.out.println("The student name is found");
        else if (isStudentFound == false)
            System.out.println("The student name is not found");
        // --------------------------------------------------------------
    }
}