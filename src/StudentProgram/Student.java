package StudentProgram;

import java.util.Scanner;

public class Student
{
    private static Scanner scanner = new Scanner(System.in);
    private static dataHolder dataHolder = new dataHolder();

//    method to input data of student to be saved
    public static void saveStudent()
    {
        int studentID;
        String studentName;
        int studentAge;
        String studentEmail;
        String studentCourse;
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("***************************************");

        System.out.print("Enter the student ID: ");
        studentID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the student name: ");
        studentName = scanner.nextLine();

//        Loop for age entering I got from a friend
        while (true)
        {
            System.out.print("Enter the student age (>16y/o): ");
            studentAge = scanner.nextInt();
            scanner.nextLine();
            if (studentAge > 15)
            {
                break;
            }
            else
            {
                System.out.println("You have entered an incorrect student age!!!");
            }
        }


        System.out.print("Enter the student's email: ");
        studentEmail = scanner.nextLine();

        System.out.print("Enter the student's course: ");
        studentCourse = scanner.nextLine();

//        where data is written to the arrray
        dataHolder.saveStudent(studentName, studentEmail, studentID, studentAge, studentCourse);
        System.out.println("Student was added to the system!");
        System.out.println("***************************************");

        System.out.println("Enter (1) to launch the menu or any other key to exit");
        int afterSaveMenuSelection = scanner.nextInt();
        System.out.println("---------------------------------------");
        switch (afterSaveMenuSelection)
        {
            case 1:
                runApp.mainMenu();
                break;
            default:
                exitStudentApplication();
        }
    }

//    method to search a student by their ID
    public static void searchStudent()
    {
        System.out.println("Enter the student id to search: ");
        System.out.println("---------------------------------------");
        int ID = scanner.nextInt();
        scanner.nextLine();
        int[] studentIDs = dataHolder.getStudentID();
        int count = dataHolder.getStudentCount();

//        look for and display details
        boolean found = false;
        for (int i = 0; i < count; i++)
        {
            if (studentIDs[i] == ID)
            {
                System.out.println("STUDENT ID: " + dataHolder.getStudentID()[i]
                        + "\nSTUDENT NAME" + dataHolder.getStudentNames()[i]
                        + "\nSTUDENT AGE" + dataHolder.getStudentAge()[i]
                        + "\nSTUDENT EMAIL" + dataHolder.getStudentEmail()[i]
                        + "\nSTUDENT COURSE" + dataHolder.getStudentCourse()[i]);
                found = true;
                break;
            }
        }
        if (!found)
        {
            System.out.println("Student with Student Id:" + ID + "was not found!");
        }

        System.out.println("---------------------------------------");
        System.out.println("Enter (1) to launch the menu or any other key to exit");
        int afterSearchMenuSelection = scanner.nextInt();
        System.out.println("---------------------------------------");

        switch (afterSearchMenuSelection)
        {
            case 1:
                runApp.mainMenu();
                break;
            default:
                exitStudentApplication();
        }
    }

//    method to delete a students details from the system
    public static void deleteStudent()
    {
        System.out.println("Enter the student's ID to delete: ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        int[] studentIDs = dataHolder.getStudentID();
        int count = dataHolder.getStudentCount();
        System.out.println("---------------------------------------");

//        gotta make sure the student they're looking for does exist
        for (int i = 0; i < count; i++)
        {
            if (studentIDs[i] == ID)
            {
                System.out.println("Are you suer you want to student " + ID + "from the system? Yes (y) to delete.");
                String deleteChoice = scanner.nextLine();
                System.out.println("---------------------------------------");

                switch (deleteChoice)
                {
                    case "y":
                        dataHolder.deleteStudent(ID);
                        System.out.println("---------------------------------------");
                        System.out.println("Student with Student Id: " + ID + " WAS deleted!");
                        break;
                    default:
                        System.out.println("---------------------------------------");
                        System.out.println("Deletion canceled!");
                        break;
                }
            } else
            {
                System.out.println("Student not found.");
            }
        }

        System.out.println("---------------------------------------");
        System.out.println("Enter (1) to launch the menu or any other key to exit");
        int afterDeleteMenuSelection = scanner.nextInt();
        System.out.println("---------------------------------------");

        switch (afterDeleteMenuSelection)
        {
            case 1:
                runApp.mainMenu();
                break;
            default:
                exitStudentApplication();
        }
    }

//    method to display all the details at once
    public static void studentReport()
    {
        String[] names = dataHolder.getStudentNames();
        String[] emails = dataHolder.getStudentEmail();
        int[] ids = dataHolder.getStudentID();
        int[] ages = dataHolder.getStudentAge();
        String[] courses = dataHolder.getStudentCourse();
        int count = dataHolder.getStudentCount();

        for (int i = 0; i < count; i++)
        {
            System.out.println("STUDENT " + (i + 1)
                    + "\n---------------------------------------"
                    + "\nSTUDENT ID: " + ids[i]
                    + "\nSTUDENT NAME: " + names[i]
                    + "\nSTUDENT AGE: " + ages[i]
                    + "\nSTUDENT EMAIL: " + emails[i]
                    + "\nSTUDENT COURSE: " + courses[i]
                    + "\n---------------------------------------");
        }
//        displays if there's no students in the holder
        if (names == null)
        {
            System.out.println("No students to display");
        }

        System.out.println("Enter (1) to launch the menu or any other key to exit");
        int afterReportMenuSelection = scanner.nextInt();
        System.out.println("---------------------------------------");

        switch (afterReportMenuSelection)
        {
            case 1:
                runApp.mainMenu();
                break;
            default:
                exitStudentApplication();
        }
    }

//    method to exit the program
    public static void exitStudentApplication()
    {
        System.out.println("Exiting the application.");
        System.exit(0);
    }
}
