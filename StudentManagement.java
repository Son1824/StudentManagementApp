package StudentManagementApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManagement {
    List<Student> studentList = new ArrayList<>();
    public void addStudent(Student student){
        for (Student s : studentList) {
            if (s.getId() == student.getId()) {
                System.out.println("ID already exists.");
                return;
            }
        }
        studentList.add(student);
        System.out.println("Student added successfully!");
     }
     public List<Student> getStudents() {
        return studentList;
    }

    public void editStudent(int id, String name, double marks) {
        boolean found = false;
        for (Student student : studentList) {
            if (student.getId() == id) {
                found = true;
                student.setName(name);
                student.setMarks(marks);
                System.out.println("ID has been updated.");
                return;
            }
        }
        if (!found) {
            System.out.println("ID not found.");
        }
    }

    public void deleteStudent(int id){
        boolean removed = studentList.removeIf(student -> student.getId() == id);
        if (removed) {
            System.out.println("ID has been deleted.");
        } else {
            System.out.println("ID not found.");
        }
    }
    public List<Student> sortStudents() {
        studentList.sort(Comparator.comparingDouble(Student::getMarks));
        return studentList;
    }

    public Student searchStudent(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

}
