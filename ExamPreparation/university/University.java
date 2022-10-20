package ExamPreparation.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        students = new ArrayList<>();
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStudents() {
        StringBuilder sb = new StringBuilder();
        students.forEach(student -> sb.append(student).append("\n"));
        return sb.toString().trim();
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {

        if (capacity < students.size()) {
            return "No seats in the ExamPreparation.university";
        }

        if (students.contains(student)) {
            return "Student is already in the ExamPreparation.university";
        }

        students.add(student);
        return "Added student " + student.getFirstName() + " " + student.getLastName();
    }

    public String dismissStudent(Student student) {

        if (!students.contains(student)) {
            return "Student not found";
        }

        students.remove(student);
        return "Removed student " + student.getFirstName() + " " + student.getLastName();
    }

    public Student getStudent(String firstName, String lastName) {

        for (Student student : students) {

            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        students.forEach(student -> sb.append("==Student: First Name = ")
                .append(student.getFirstName())
                .append(", Last Name = ")
                .append(student.getLastName())
                .append(", Best Subject = ")
                .append(student.getBestSubject())
                .append("\n"));
        return sb.toString().trim();
    }
}
