import java.util.Scanner;
class Student{
   String first_name;
   String middle_name;
   String last_name;
   String suffix;
   
   public Student(){
      
   }
   
   public String getfirstName(){
      return first_name;
   }
   
   public String getmiddleName(){
      return middle_name;
   }
   
   public String getlastName(){
      return last_name;
   }
   
   public String getsuffix(){
      return suffix;
   }
   
   public String getfullName(){
      return first_name +" "+middle_name+" "+last_name+" "+suffix;
   }
   public void setfirstName(String firstName){
      this.first_name = firstName;
   }
   
   public void setmiddleName(String middleName){
      this.middle_name = middleName;
   }
   
   public void setlastName(String lastName){
      this.last_name = lastName;
   }
   
   public void setsuffix(String suffix){
      this.suffix = suffix;
   }
}

class Interface{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      Student s = new Student();
      
      System.out.print("Enter First Name : ");
      s.setfirstName(scan.nextLine());
      System.out.print("Enter Middle Name : ");
      s.setmiddleName(scan.nextLine());
      System.out.print("Enter Last Name : ");
      s.setlastName(scan.nextLine());
      System.out.print("Enter Suffix : ");
      s.setsuffix(scan.nextLine());
      
      System.out.println("\nOUTPUT");
      System.out.println("First name:" + s.getfirstName());
      System.out.println("Middle name:" + s.getmiddleName());
      System.out.println("Last name:" + s.getlastName());
      System.out.println("Suffix:" + s.getsuffix());
      System.out.println("Full name: " + s.getfullName());
   }
}