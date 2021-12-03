import java.util.Vector;

public class Department {
    private final String name; // the name of school Dept of Computing and Info Science
    private final String id; // short name for courses SOFE, ELEE, STAT, etc
    private final Vector<Course> courseList; // all courses offered by the department
    private final Vector<Student> registerList; // all students taking courses in the department.

    public Department(String name, String id) {
        //Initialize name and id
        this.name = name;
        this.id = id;

        //Initiliaze courseList & registerList
        courseList = new Vector<Course>();
        registerList = new Vector<Student>();

    }

    //Getter for Name
    public String getName() {
        return name;
    }

    //Getter for ID
    public String getId() {
        return id;
    }

    //Add course to vector courselist
    public void offerCourse(Course course) {
        courseList.add(course);
    }

    //Prints courses offered by this dept
    public void printCoursesOffered() {
        //Go through courses and use toString method
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println(courseList.elementAt(i).toString());
        }
    }

    //Prints Students registered in this dept
    public void printStudentsByName() {
        for (int i = 0; i < registerList.size(); i++) {
            System.out.println(registerList.elementAt(i).toString());
        }
    }

    //Check if course is in department course list
    public boolean isRegisteredInCourse(Course course) {
        return (registerList.contains(course));
    }

    public Vector<Student> studentsRegisteredInCourse(int code) {
        Vector<Student> studentsInCourse = new Vector<Student>();

        //iterate courselist
        for (int i = 0; i < courseList.size(); i++) {
            //match code to course
            if (courseList.elementAt(i).getCourseNumber() == code) {
                studentsInCourse = courseList.elementAt(i).getClassList();
            }
        }
        return studentsInCourse;
    }

    //Registed Student in
    public void registerStudentCourseInDepartment(Student studentToBeResgiteredinDep, Course CourseToBeRegisteredIn) {
        if (isStudentRegistered(studentToBeResgiteredinDep)) {
            registerList.add(studentToBeResgiteredinDep);
            studentToBeResgiteredinDep.registerFor(CourseToBeRegisteredIn);
        }
    }

    //Check if a sudent is in the registeded list of department
    public boolean isStudentRegistered(Student StudentChecked) {
        return (registerList.contains(StudentChecked));
    }

    //Iterates all students and prints them
    public void printStudentsRegisteredInCourse(int course) {
        Vector<Student> allStudentsInCourse = studentsRegisteredInCourse(course);
        for (int i = 0; i < allStudentsInCourse.size(); i++) {
            System.out.println(allStudentsInCourse.elementAt(i).toString());
        }

    }

    //Iterates courses to find largest student count and returns course as string
    public String largestCourse() {
        Vector<Student> StudentCount = new Vector<Student>();
        int count = 0;
        String course = null;
        for (int i = 0; i < courseList.size(); i++) {
            StudentCount = courseList.elementAt(i).getClassList();
            if (StudentCount.size() > count) {
                count = StudentCount.size();
                course = courseList.elementAt(i).toString();
            }
        }
        return course;
    }

    public String toString() {
        // returns a string representation of department name, number
        // of courses offered and number of students registered in the
        // department. Use the format:
        // ECSE: 53 courses, 460 students
        String courses = name + ":" + courseList.size() + " courses," + registerList.size() + " students";
        return courses;
    }
}
