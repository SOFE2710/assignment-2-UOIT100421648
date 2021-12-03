import java.util.Vector;

public class Student extends Person {
    private final String id;
    private final String name;
    private final Vector courses; // contains all courses the student is registered in

    public Student(String stdName, String stdId) {
        this.id = stdId;
        this.name = stdName;
        courses = new Vector();
    }

    //Getter for Name
    public String getName() {
        return name;
    }

    //Getter for id
    public String getId() {
        return id;
    }

    public void registerFor(Course course) {
        if (courses.contains(course)) {
            //Do nothing :)
        } else {
            course.addStudentToCourse(this);
            courses.add(course);
            //System.out.println("Registered!");
        }
    }

    public boolean isRegisteredInCourse(Course course) {
        //Returns if student is registered in course
        return (courses.contains(course));
    }

    public String toString() {
        // return a string representation of a student using the following format:
        // 100234546 John McDonald
        // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
        String student = id + " " + name + "\r\n" + "Registered courses: " + courses;
        return student;
    }
}
