package StudentManagementApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();

        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Add student");
            System.out.println("2. Edit student");
            System.out.println("3. Delete student");
            System.out.println("4. Sort students by marks");
            System.out.println("5. Search student by id");
            System.out.println("6. Display all students");
            System.out.println("7. Close");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number of students: ");
                    int num = sc.nextInt();
                    for (int i = 0; i < num; i++) {
                        System.out.println("Enter id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter marks: ");
                        double marks = sc.nextDouble();
                        studentManagement.addStudent(new Student(id, name, marks));
                        System.out.println("Add successfully!");
                    }
                    break;

                case 2:
                    System.out.println("Enter id to edit: ");
                    int editID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Edit name: ");
                    String editName = sc.nextLine();
                    System.out.println("Edit marks: ");
                    double editMarks = sc.nextDouble();
                    studentManagement.editStudent(editID, editName, editMarks);
                    break;

                case 3:
                    System.out.print("Enter id to delete: ");
                    int deleteId = sc.nextInt();
                    studentManagement.deleteStudent(deleteId);
                    break;

                case 4:
                    System.out.println("Sorted by marks: ");
                    studentManagement.sortStudents();
                    break;

                case 5:
                    System.out.println("Enter id to search: ");
                    int searchID = sc.nextInt();
                    Student student = studentManagement.searchStudent(searchID);
                    if (student != null) {
                        System.out.println("Found in list: " + student);
                    } else {
                        System.out.println("Not found in list");
                    }
                    break;

                case 6:
                    System.out.println("Students in list: ");
                    for (Student getStudent : studentManagement.getStudents()) {
                        System.out.println(getStudent);
                    }
                    break;

                case 7:
                    System.out.println("Closed");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again!");

            }
        }
    }
}
