package StdMgtSystem;
import java.util.ArrayList;
import java.util.Scanner;
public class StdMgtSystemBeforeRefactoring {
	public static void main(String[] args) {
		
		//This code is to add subjects to the student management system and sort them:
		ArrayList<String> SMS = new ArrayList<String>(); // an array list of subjects
		String nsn; //A variable to add a new subject name
		String elementToSearch = null;
		Boolean Found;
		System.out.println("Create the subject name list by entering the subject names one by one");		
		System.out.println("Enter a subject name to be added to the student management system");
		Scanner input = new Scanner(System.in);		
		nsn = input.next();		
		while (!(nsn.equals("end"))) {		
			SMS.add(nsn);
			System.out.print("Enter a subject name to be added to the student management system");
			nsn = input.next();			
			}
		System.out.println("The subject names in the student management system before sorting are: ");
		   for(String counter: SMS){
				System.out.println(counter);
			}
		 //bubble sort--------------------------------------------------
		   boolean sorted = false;
		    String temp = null;
		    while(!sorted) {
		        sorted = true;
		        for (int i = 0; i < SMS.size() - 1; i++) {		           
		        	if((SMS.get(i)).compareToIgnoreCase(SMS.get(i+1))>0) {
		                temp = SMS.get(i);
		                SMS.set(i,SMS.get(i+1));
		                SMS.set(i+1,temp);
		                sorted = false;
		            }
		        }
		    }
		 //-------------------------------------------------------
		 System.out.println("The subject names in the student management system after sorting are: ");
		   for(String counter: SMS){
				System.out.println(counter);
			}  	   
		 //This code is to add student names to the student management system and sort them
			ArrayList<String> SMST = new ArrayList<String>();// an array list of student names
			String nstn;//A variable to add a new student name
			System.out.println("Create the student name list by entering the student names one by one");		
			System.out.println("Enter a student name to be added to the student management system");
			input = new Scanner(System.in);		
			nstn = input.next();		
			while (!(nstn.equals("end"))) {		
				SMST.add(nstn);
				System.out.print("Enter a student name to be added to the student management system");
				nstn = input.next();			
				}
			System.out.println("The student names in the student management system before sorting are: ");
			   for(String counter: SMST){
					System.out.println(counter);
				}
			 //bubble sort--------------------------------------------------
			   sorted = false;
			   temp = null;
			    while(!sorted) {
			        sorted = true;
			        for (int i = 0; i < SMST.size() - 1; i++) {		           
			        	if((SMST.get(i)).compareToIgnoreCase(SMST.get(i+1))>0) {
			                temp = SMST.get(i);
			                SMST.set(i,SMST.get(i+1));
			                SMST.set(i+1,temp);
			                sorted = false;
			            }
			        }
			    }
			 //-------------------------------------------------------
			 System.out.println("The student names in the student management system after sorting are: ");
			   for(String counter: SMST){
					System.out.println(counter);
				}		   
			  			   
			 //This code is to search for a specific subject name
		     System.out.println("Enter a subject name to search for:");
			   elementToSearch = input.next();	
			   Found = false;	
			   
		   //Linear Search----------------------------------------------
		   for (int index = 0; index < SMS.size(); index++) {
		        if (SMS.get(index).equals(elementToSearch)) 
		        	Found = true;     
		    }
		   //------------------------------------------------------------
		   if (Found == true)
		       System.out.println("The subject name is found");
		   else if (Found == false)
				   System.out.println("The subject name is not found");
		   //--------------------------------------------------------------
		   
		 //This code is to search for a specific student name
		     System.out.println("Enter a student name to search for:");
			   elementToSearch = input.next();	
			   Found = false;	
			   
		   //Linear Search----------------------------------------------
		   for (int index = 0; index < SMST.size(); index++) {
		        if (SMST.get(index).equals(elementToSearch)) 
		        	Found = true;     
		    }
		   //------------------------------------------------------------
		   if (Found == true)
		       System.out.println("The student name is found");
		   else if (Found == false)
				   System.out.println("The student name is not found");
		   //--------------------------------------------------------------
	}
}