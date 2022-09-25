package markingMetrics.dto;

public
class StudentGradeDTO {

    private String firstName;

    private String lastName;

    private String student_id;

    private double total_marks;

    public
    StudentGradeDTO ( ) {
    }

    public
    StudentGradeDTO ( String firstName , String lastName , String student_id , double total_marks ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.student_id = student_id;
        this.total_marks = total_marks;
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
    double getTotal_marks ( ) {
        return total_marks;
    }

    public
    void setTotal_marks ( double total_marks ) {
        this.total_marks = total_marks;
    }
}
