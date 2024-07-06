package Accessibility.passByValue;

public class Example {
   public static void main (String[] args) {
	  Person person=new Person ("Akshay");

	  System.out.println (person);


	  modifyObj (person);

	  System.out.println (person);


   }

   public  static void modifyObj(Person person){

	  person= new Person ("Akshay Kumar");
   }
}
