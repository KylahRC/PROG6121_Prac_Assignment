import java.util.Scanner;

public class Student
{
    private static Scanner scanner = new Scanner(System.in);
    private static dataHolder dataHolder = new dataHolder();

    public static void saveStudent()
    {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("***************************************");

        System.out.print("Enter the student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter the student age (>16y/o): ");
        int studentAge = scanner.nextInt();
        scanner.nextLine();

        if (studentAge < 16)
        {
            System.out.println("You have entered an incorrect student age!!!");
            return;
        }

        System.out.print("Enter the student's email: ");
        String studentEmail = scanner.nextLine();

        System.out.print("Enter the student's course: ");
        String studentCourse = scanner.nextLine();

        dataHolder.saveStudent(studentName, studentEmail, studentID, studentAge, studentCourse);
        System.out.println("Student was added to the system!");

        System.out.println("Enter (1) to launch the menu or any other key to exit");
        int afterSaveMenuSelection = scanner.nextInt();

        switch (afterSaveMenuSelection)
        {
            case 1:
                runApp.mainMenu();
                break;
            default:
                exitStudentApplication();
        }
    }

    public static void searchStudent()
    {
        System.out.print("Enter the student id to search: ");
        System.out.println("---------------------------------------");
        int ID = scanner.nextInt();
        scanner.nextLine();
        int[] studentIDs = dataHolder.getStudentID();
        int count = dataHolder.getStudentCount();

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

        switch (afterSearchMenuSelection)
        {
            case 1:
                runApp.mainMenu();
                break;
            default:
                exitStudentApplication();
        }
    }

    public static void deleteStudent()
    {
        System.out.print("Enter the student's ID to delete: ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        int[] studentIDs = dataHolder.getStudentID();
        int count = dataHolder.getStudentCount();
        System.out.println("---------------------------------------");

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
            }
            else
            {
                System.out.println("Student not found.");
            }
        }

        System.out.println("---------------------------------------");
        System.out.println("Enter (1) to launch the menu or any other key to exit");
        int afterDeleteMenuSelection = scanner.nextInt();

        switch (afterDeleteMenuSelection)
        {
            case 1:
                runApp.mainMenu();
                break;
            default:
                exitStudentApplication();
        }
    }

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

        switch (afterReportMenuSelection)
        {
            case 1:
                runApp.mainMenu();
                break;
            default:
                exitStudentApplication();
        }
    }

    public static void exitStudentApplication()
    {
        System.out.println("Exiting the application.");
        System.exit(0);
    }
}
