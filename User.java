public class User {   //Class User

    private String firstName, lastName;
    private int age;
    private String email, status, timeStamp;

    public User(String firstName, String lastName, int age, String email, String status, String timeStamp) {  //Contructor with all parameters
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.status = status;
        this.timeStamp = timeStamp;


    }
    // Getters, setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimes(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {  //custom toString method
        return "\nUsers{" +
                "First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Age: " + age +
                ", Email: '" + email + '\'' +
                ", Status: '" + status + '\'' +
                ", User was registered in the system: '" + timeStamp + '\'' +
                '}';
    }
}
