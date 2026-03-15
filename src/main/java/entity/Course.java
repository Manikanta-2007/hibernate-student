package entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}