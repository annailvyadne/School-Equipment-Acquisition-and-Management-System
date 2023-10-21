package MyLibs;

//Abstract class defining the User structure and behavior
abstract class User {
 private int userID;
 private String username;
 private String password;
 private String userFname;
 private String userLname;
 private String userRole;

 // Constructor
 public User(int userID, String username, String password, String userFname, String userLname, String userRole) {
     this.userID = userID;
     this.username = username;
     this.password = password;
     this.userFname = userFname;
     this.userLname = userLname;
     this.userRole = userRole;
 }

 // Abstract method for user-specific actions
 public abstract void performUserAction();

 // Getters and setters
 public int getUserID() {
     return userID;
 }

 public String getUsername() {
     return username;
 }

 public String getPassword() {
     return password;
 }

 public String getUserFname() {
     return userFname;
 }

 public String getUserLname() {
     return userLname;
 }

 public String getUserRole() {
     return userRole;
 }
}

//Concrete subclass representing a Student
class Student extends User {
 public Student(int userID, String username, String password, String userFname, String userLname) {
     super(userID, username, password, userFname, userLname, "Student");
 }

 @Override
 public void performUserAction() {
     // Implement student-specific actions
     System.out.println("Performing student-specific action...");
 }
}

//Concrete subclass representing a Faculty
class Faculty extends User {
 public Faculty(int userID, String username, String password, String userFname, String userLname) {
     super(userID, username, password, userFname, userLname, "Faculty");
 }

 @Override
 public void performUserAction() {
     // Implement faculty-specific actions
     System.out.println("Performing faculty-specific action...");
 }
}

//Concrete subclass representing a Non-Teaching Staff
class NonTeachingStaff extends User {
 public NonTeachingStaff(int userID, String username, String password, String userFname, String userLname) {
     super(userID, username, password, userFname, userLname, "Non-Teaching Staff");
 }

 @Override
 public void performUserAction() {
     // Implement non-teaching staff-specific actions
     System.out.println("Performing non-teaching staff-specific action...");
 }
}

public class UserAbstractionExample {
 public static void main(String[] args) {
     // Create instances of different users
     User student = new Student(1, "student123", "pass123", "John", "Doe");
     User faculty = new Faculty(2, "faculty456", "pass456", "Alice", "Smith");
     User staff = new NonTeachingStaff(3, "staff789", "pass789", "Bob", "Johnson");

     // Demonstrate user-specific actions
     student.performUserAction();
     faculty.performUserAction();
     staff.performUserAction();
 }
}