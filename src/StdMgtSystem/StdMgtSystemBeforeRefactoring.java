package StdMgtSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StdMgtSystemBeforeRefactoring {
    public static <T> void sortList(ArrayList<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        mergeSort(list, 0, list.size() - 1);
    }
    
    private static <T> void mergeSort(ArrayList<T> list, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }
    
    private static <T> void merge(ArrayList<T> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        ArrayList<T> leftArr = new ArrayList<>(n1);
        ArrayList<T> rightArr = new ArrayList<>(n2);
        for (int i = 0; i < n1; ++i) {
            leftArr.add(list.get(left + i));
        }
        for (int j = 0; j < n2; ++j) {
            rightArr.add(list.get(mid + 1 + j));
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr.get(i).toString().compareToIgnoreCase(rightArr.get(j).toString()) <= 0) {
                list.set(k, leftArr.get(i));
                i++;
            } else {
                list.set(k, rightArr.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            list.set(k, leftArr.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            list.set(k, rightArr.get(j));
            j++;
            k++;
        }
    }

    public static <T> boolean searchElement(ArrayList<T> list, String name) {
        sortList(list);
        return binarySearch(list, name, 0, list.size() - 1);
    }
    
    private static <T> boolean binarySearch(ArrayList<T> list, String name, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = low + (high - low) / 2;
        String midEle = list.get(mid).toString();
        int comparison = midEle.compareToIgnoreCase(name);
        if (comparison == 0) {
            return true;
        }
        if (comparison > 0) {
            return binarySearch(list, name, low, mid - 1);
        } else {
            return binarySearch(list, name, mid + 1, high);
        }
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