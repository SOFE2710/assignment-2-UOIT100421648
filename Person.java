public class Person {
    private String name;

    public Person(String initialName) {
        this.name = initialName;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String fullName) {
        this.name = fullName;
    }

    public String toString() {
        return name;
    }
}
