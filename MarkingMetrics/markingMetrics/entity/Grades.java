package markingMetrics.entity;

public
class Grades {

    private String firstName;

    private String lastName;

    private String student_id;

    private double a1;

    private double a2;

    private double a3;

    public
    Grades ( ) {
    }

    public
    Grades ( String firstName , String lastName , String student_id , double a1 , double a2 , double a3 ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.student_id = student_id;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public
    String getFirstName ( ) {
        return firstName;
    }

    public
    void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public
    String getLastName ( ) {
        return lastName;
    }

    public
    void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    public
    String getStudent_id ( ) {
        return student_id;
    }

    public
    void setStudent_id ( String student_id ) {
        this.student_id = student_id;
    }

    public
    double getA1 ( ) {
        return a1;
    }

    public
    void setA1 ( double a1 ) {
        this.a1 = a1;
    }

    public
    double getA2 ( ) {
        return a2;
    }

    public
    void setA2 ( double a2 ) {
        this.a2 = a2;
    }

    public
    double getA3 ( ) {
        return a3;
    }

    public
    void setA3 ( double a3 ) {
        this.a3 = a3;
    }
}
