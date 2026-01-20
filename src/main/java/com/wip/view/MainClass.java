package com.wip.view;

import java.util.Scanner;
import com.wip.controller.EmployeeController;
import com.wip.controller.EmployeeInterface;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Welcome to WIPRO");

        EmployeeInterface ec = new EmployeeController();
        Scanner scanner = new Scanner(System.in);
        String ch = null;

        do {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Add Employee to Array");
            System.out.println("4. Sort by Employee ID use Comparable");
            System.out.println("5. Sort by Employee Name use Comparator");
            System.out.println("6. Sort by Employee ID use Comparator");
            System.out.println("7. Serialize Employee");
            System.out.println("8. De-Serialize Employee");
            System.out.println("9. Update Employee");
            System.out.println("10. Delete Employee");
            System.out.println("11. Insert Employee via Procedure");
            System.out.println("12. Get MetaData Info");

            System.out.println("Enter your choice");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number:");
                scanner.next();
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: ec.addEmployee(); break;
                case 2: ec.viewEmployee(); break;
                case 3: ec.addEmployeeToArray(); break;
                case 4: ec.sortByEmpId(); break;
                case 5: ec.sortByEname(); break;
                case 6: ec.sortByEidUsingComparator(); break;
                case 7: ec.serializeEmp(); break;
                case 8: ec.deserializeEmp(); break;
                case 9: ec.updateEmployee(); break;
                case 10: ec.deleteEmployee(); break;
                case 11: ec.insertEmployeeViaProc(); break;
                case 12: ec.getDBinfo(); break;
                default: System.out.println("Invalid Choice");
            }

            System.out.println("Do you want to continue? (Y/N)");
            ch = scanner.next();

        } while (ch.equalsIgnoreCase("Y"));

        System.out.println("Thank you for using WIPRO Application");
        scanner.close();
        System.exit(0);
    }
}