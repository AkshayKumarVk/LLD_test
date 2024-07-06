package vehicle;

public class Student {

   String name;
   Course course;

   Student(String name, Course course) {
	  this.name = name;
	  this.course = course;
   }

   // Deep copy constructor
   Student(Student student) {
	  this.name = student.name;
	  this.course = new Course(student.course); // A new Course object is created
   }

   void display() {
	  System.out.println("Name: " + name + ", Course: " + course.courseName);
   }

   static class Course {
	  String courseName;

	  Course(String courseName) {
		 this.courseName = courseName;
	  }

	  // Copy constructor for Course
	  Course(Course course) {
		 this.courseName = course.courseName;
	  }
   }
   public static void main(String[] args) {
	  Course course1 = new Course("Mathematics");
	  Student student1 = new Student("Alice", course1);
	  Student student2 =new Student (student1); // Using deep copy constructor

	  student1.display(); // Output: Name: Alice, Course: Mathematics
	  student2.display(); // Output: Name: Alice, Course: Mathematics

	  student2.course.courseName = "Physics";
	  student1.display(); // Output: Name: Alice, Course: Mathematics
	  student2.display(); // Output: Name: Alice, Course: Physics
   }


}
