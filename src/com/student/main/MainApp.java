package com.student.main;

import com.student.dao.*;
import com.student.util.InputValidator;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        StudentDAO studentDAO = new StudentDAO();

        System.out.println("1. Register\n2. Login");
        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer

        // REGISTER
        if (choice == 1) {
            System.out.print("Username: ");
            String u = sc.nextLine();

            System.out.print("Password: ");
            String p = sc.nextLine();

            userDAO.register(u, p);
            System.out.println("Registration Successful");
        }

        // LOGIN
        else if (choice == 2) {

            System.out.print("Username: ");
            String u = sc.nextLine();

            System.out.print("Password: ");
            String p = sc.nextLine();

            if (userDAO.login(u, p)) {

                while (true) {
                    System.out.println("\n1.Add\n2.View\n3.Update\n4.Delete\n5.Exit");
                    int ch = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    // ADD
                    if (ch == 1) {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        while (!InputValidator.isValidName(name)) {
                            System.out.println("Name must have at least 3 characters");
                            System.out.print("Enter Name: ");
                            name = sc.nextLine();
                        }

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        while (!InputValidator.isValidEmail(email)) {
                            System.out.println("Invalid email format. Enter properly:");
                            System.out.print("Enter Email: ");
                            email = sc.nextLine();
                        }

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        studentDAO.addStudent(name, email, course);
                        System.out.println("Student added successfully");
                    }

                    // VIEW
                    else if (ch == 2) {
                        studentDAO.viewStudents();
                    }

                    // UPDATE
                    else if (ch == 3) {

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // clear buffer

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        while (!InputValidator.isValidName(name)) {
                            System.out.println("Name must have at least 3 characters");
                            System.out.print("Enter Name: ");
                            name = sc.nextLine();
                        }

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        while (!InputValidator.isValidEmail(email)) {
                            System.out.println("Invalid email format. Enter properly:");
                            System.out.print("Enter Email: ");
                            email = sc.nextLine();
                        }

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        studentDAO.updateStudent(id, name, email, course);
                        System.out.println("Student updated successfully");
                    }

                    // DELETE
                    else if (ch == 4) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // clear buffer

                        studentDAO.deleteStudent(id);
                        System.out.println("Student deleted successfully");
                    }

                    // EXIT
                    else if (ch == 5) {
                        break;
                    }

                    else {
                        System.out.println("Invalid choice");
                    }
                }

            } else {
                System.out.println("Invalid Login");
            }
        }

        sc.close();
    }
}









