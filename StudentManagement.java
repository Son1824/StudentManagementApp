package StudentManagementApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManagement {
     List<Student> studentList = new ArrayList<>();
     public void addStudent(Student student){
         studentList.add(student);
     }

    public List<Student> getStudents() {
        return studentList;
    }

    public void editStudent(int id, String name, double marks) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                student.setName(name);
                student.setMarks(marks);
                return;
            }
        }
        System.out.println("StudentManagementApp.Student with ID " + id + " not found.");
    }
    public void deleteStudent(int id){
         studentList.removeIf(student -> student.getId() == id);
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
