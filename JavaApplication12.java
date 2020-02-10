/*
 * Kindly run it in netbeans 
 */
package javaapplication12;
import java.util.Scanner;  // Import the Scanner class
import java.util.*; 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

class Faisal_Hospital{
  //  List<String> listStrings = new ArrayList<String>();
    List<patients> pl=new ArrayList<>();
staff s;
wards w;
String name;
String birthdate;

    public Faisal_Hospital(staff s, wards w, String name, String birthdate) {
        this.s = s;
        this.w = w;
        this.name = name;
        this.birthdate = birthdate;
    }


   

    void addpatients()
    {
    
    
    }
   
    
}

class staff
{
 String joinig_date;
 String education;

    public staff(String joinig_date, String education) {
        this.joinig_date = joinig_date;
        this.education = education;
    }
 
   
 
}

class wards
{
staff s;

    public wards(staff s) {
        this.s = s;
    }


}
class children_ward extends wards{

    public children_ward(staff s) {
        super(s);
    }

    
}
class orthopedic_ward extends wards
{

    public orthopedic_ward(staff s) {
        super(s);
    }

}
class surgical_ward extends wards{

    public surgical_ward(staff s) {
        super(s);
    }

}
class patients
{
public String name;
int patient_id;
String gender;
String date_of_checkup;

    public patients(String name, int patient_id, String gender, String date_of_checkup) {
        this.name = name;
        this.patient_id = patient_id;
        this.gender = gender;
        this.date_of_checkup = date_of_checkup;
    }
    
void getid(){
System.out.print("patient id: "+this.patient_id+" ");
    
}

void getname(){
System.out.println("Name: "+ this.name);
}
  

    public patients() {
        name = new String();
    }

    void visit(){
    
    }



}

class medical extends staff{

    public medical(String joinig_date, String education) {
        super(joinig_date, education);
    }

    

}

class doctors extends medical
{
int docid;
String name;
String gender;

    public doctors(int docid, String name, String gender, String joinig_date, String education) {
        super(joinig_date, education);
        this.docid = docid;
        this.name = name;
        this.gender = gender;
    }
  

  
}
class nurses extends medical
{

    public nurses(String joinig_date, String education) {
        super(joinig_date, education);
    }

    

}
class technical extends staff
{

    public technical(String joinig_date, String education) {
        super(joinig_date, education);
    }

    

}
class scrubs extends technical
{

    public scrubs(String joinig_date, String education) {
        super(joinig_date, education);
    }

}
class technicians extends technical
{

    public technicians(String joinig_date, String education) {
        super(joinig_date, education);
    }

    
}
/**
 *
 * @author Talha Jaleel
 */

public class JavaApplication12 {   //Faisal hospital main class

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
         List<doctors> doctor;
       doctor = new ArrayList<>();
        doctors d1=new doctors(1,"Hamza","male","12-01-1992","MBBS");
         doctors d2=new doctors(2,"Tayyab","female","12-01-1992","Physiotherapy");
          doctors d3=new doctors(3,"Ali","male","12-01-1993","MBBS");
           doctors d4=new doctors(4,"Amir","male","12-01-1993","MBBS");
       
           doctor.add(d1);
           doctor.add(d2);
           doctor.add(d3);
           doctor.add(d4);
          
           List<patients> patient;
        patient = new ArrayList<>();
           boolean quit=false;
           
           int pid = 0;
           patients temp = new patients();
           for(int i=0;quit!=true;i++){
               System.out.println("Enter 1 for adding a patient");
               System.out.println("Enter 2 for info of all Patients");
               System.out.println("Enter 3 for visiting a doctor");
               System.out.println("Enter 4 to quit");
               String check = myObj.nextLine();  // Read user input
               
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  //for date
               
               if(null == check){
                   quit=true;
               }
              else switch (check) {
                case "1":
                    System.out.println("Enter the name of patient");
                    String name = myObj.nextLine();  // Read user input
                    System.out.println("Enter gender of patient");
                    String gender = myObj.nextLine();  // Read user input
               //temp.date_of_checkup=date;
                     temp=new patients();
                    temp.name = name;
                    temp.gender=gender;
                    temp.patient_id = pid;
                    temp.date_of_checkup=null;
                    System.out.println("Your patient ID is " + pid + "\n");
                    pid++;
                    patient.add(temp);
                    
                    break;
                case "2":
                     for(patients p : patient)
                   {  
                       p.getid();
                       p.getname();
                   }
                   
                    
                    break;
                case "3":
                   if(patient.isEmpty()==true){
                   System.out.println("You have to enter a patient first!!!");
                   }
                   else
                   {
                       System.out.print("Enter patient id: ");
                       String p_id = myObj.nextLine();  // Read user input
                   System.out.println("Enter Doctor id to visit:");
                   String doc_id = myObj.nextLine();  // Read user input
                   boolean flag=false;
                   for(patients p : patient)
                   {                       
                       if((Integer.parseInt(p_id)) == p.patient_id){
                          flag=false;
                           if(p.date_of_checkup!=null){
                         //  Date today =new Date(); // Create a date object of today
                           LocalDateTime today = LocalDateTime.now();  
                           
                           if(p.date_of_checkup.equals(dtf.format(today))){
                           System.out.println(p.name+" with patient id "+p.patient_id+"has already visited");
                          
                           }
                           }
                           else{
                                 System.out.println("Patient"+ p_id+ "visited" + "doctor"+doc_id);
                             LocalDateTime now = LocalDateTime.now();  
                          // Date cd =new Date(); // Create a date object
                           p.date_of_checkup=dtf.format(now);
                           }
                       
                       }
                       else
                       {
                        flag=true;
                       }
                   }
                 if(flag==true)
                 {
                   System.out.println("The required patient is not present!!!");
                 }
                   }
                    break;
                default:
                    quit=true;
                    break;
            }
           }
    }
    }
