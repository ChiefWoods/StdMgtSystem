package StdMgtSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StdMgtSystemBeforeRefactoring {
    public static <T> void sortList(ArrayList<T> list) {
        boolean isListSorted = false;
        while (!isListSorted) {
            isListSorted = true;
            T temp = null;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).toString().compareToIgnoreCase(list.get(i + 1).toString()) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    isListSorted = false;
                }
            }
        }
    }

    public static <T> boolean searchElement(ArrayList<T> list, String name) {
        boolean isElementFound = false;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).toString().equals(name))
                isElementFound = true;
        }
        return isElementFound;
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
        sortList(subjectList);
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
        sortList(studentList);
        // -------------------------------------------------------
        System.out.println("The student names in the student management system after sorting are: ");
        for (Student student : studentList) {
            System.out.println(student.getName());
        }

        // This code is to search for a specific subject name
        System.out.println("Enter a subject name to search for:");
        subjectToSearch = input.next();

        // Linear Search----------------------------------------------
        isSubjectFound = searchElement(subjectList, subjectToSearch);
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
        isStudentFound = searchElement(studentList, studentToSearch);
        // ------------------------------------------------------------
        if (isStudentFound == true)
            System.out.println("The student name is found");
        else if (isStudentFound == false)
            System.out.println("The student name is not found");
        // --------------------------------------------------------------
    }
}