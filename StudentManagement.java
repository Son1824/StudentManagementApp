package StudentManagementApp;

import java.util.Stack;

public class StudentManagement {
    private StudentStack studentStack;
    public StudentManagement(){
        studentStack = new StudentStack();
    }
    public void addStudent(Student student){
        studentStack.push(student);
    }
    public void updateStudent(int id, String newName, double newMark){
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()){
            Student student = studentStack.pop();
            if(student.getId() == id){
                student.setName(newName);
                student.setMark(newMark);
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()){
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Not found student with id: " + id);
        }
    }
    public void peekStudent() {
        Student topStudent = studentStack.peek();
        if (topStudent != null) {
            System.out.println("Top student: " + topStudent);
        }
    }

    public void deleteStudentByID(int id){
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()){
            Student student = studentStack.pop();
            if(student.getId() == id){
                found = true;
                System.out.println("Deleted student: " + student);
            }else {
                tempStack.push(student);
            }
        }
        while (!tempStack.isEmpty()){
            studentStack.push(tempStack.pop());
        }
        if(!found){
            System.out.println("Not found student with id: " + id);
        }
    }

    public void sortByMark() {
        if (studentStack.isEmpty()) {
            System.out.println("Stack is empty. No students to sort.");
            return;
        }

        StudentStack sortedStack = new StudentStack();
        while (!studentStack.isEmpty()) {
            Student temp = studentStack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek().getMark() > temp.getMark()) {
                studentStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        while (!sortedStack.isEmpty()) {
            studentStack.push(sortedStack.pop());
        }
        System.out.println("Students sorted by marks.");
    }

    public void searchStudentByName(String name) {
        Node current = studentStack.top;
        boolean found = false;

        while (current != null) {
            if (current.student.getName().equalsIgnoreCase(name)) {
                System.out.println("Found student: " + current.student);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }
    public void displayStudents() {
        if (studentStack.isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }
        studentStack.displayStudents();
    }
}