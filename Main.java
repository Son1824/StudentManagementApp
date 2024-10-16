package StudentManagementApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Peek at the top student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Search Student by Name");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter mark: ");
                    double mark = sc.nextDouble();
                    sc.nextLine();

                    studentManagement.addStudent(new Student(id, name, mark));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter the ID of the student to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new mark: ");
                    double newMark = sc.nextDouble();
                    sc.nextLine();

                    studentManagement.updateStudent(updateId, newName, newMark);
                    break;

                case 3:
                    System.out.print("Enter the ID of the student to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    studentManagement.deleteStudentByID(deleteId);
                    break;

                case 4:
                    studentManagement.peekStudent();
                    break;

                case 5:
                    studentManagement.sortByMark();
                    break;

                case 6:
                    System.out.print("Enter the name of the student to search: ");
                    String searchName = sc.nextLine();
                    studentManagement.searchStudentByName(searchName);
                    break;

                case 7:
                    studentManagement.displayStudents();
                    break;

                case 8:
                    System.out.println("Exiting program.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
