import java.util.Vector;

public class Course {
    private Department dept;
    private String title; // title of the course (e.g. Intro to programming);
    private String code; // course code, e.g. SOFE, ELEE, MANE, etc.
    private int number; // course number, e.g. 1200, 2710, 2800, etc.
    private Vector<Student> classList; // contains all students registered in this course

    public Course(String code, int number, Department dept, String title) {
        // also initialize the classList;
        this.code = code;
        this.number = number;
        this.dept = dept;
        this.title = title;
        //initialize classlist
        classList = new Vector<Student>();
        dept.offerCourse(this);
    }

    public Course() {
        // TODO Auto-generated constructor stub
    }

    public String toString() {
        // return a string representation of the course with the course code,
        // name, and number of people registered in the course in the following
        // format:
        // SOFE 2710 Object Oriented Programming and Design, Enrollment = 260
        String course = code + " " + number + " " + title + ", Enrollement = " + classList.size();
        return course;
    }

    //Get Course number as Int
    public int getCourseNumber() {
        return number;
    }

    //Adds Studetns to classListVector
    public void addStudentToCourse(Student studentToBeAdded) {
        classList.add(studentToBeAdded);
    }

    //Returns the class list for course
    public Vector<Student> getClassList() {
        return classList;
    }
}
