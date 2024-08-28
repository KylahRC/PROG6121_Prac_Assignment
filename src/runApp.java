import java.util.Scanner;

public class runApp
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("***************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        int firstMenuSelection = scanner.nextInt();

        switch (firstMenuSelection)
        {
            case 1:
                mainMenu();
                break;

            default:
                System.out.println("Exiting the application.");
                System.exit(0);
        }
    }

    public static void mainMenu()
    {
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application");

        int mainMenuSelection = scanner.nextInt();
        scanner.nextLine();

        switch (mainMenuSelection)
        {
            case 1:
                Student.saveStudent();
                break;
            case 2:
                Student.searchStudent();
                break;
            case 3:
                Student.deleteStudent();
                break;
            case 4:
                Student.studentReport();
                break;
            case 5:
                Student.exitStudentApplication();
                break;
            default:
                System.out.println("Invalid selection. The program will now close.");
                System.exit(0);
        }
    }
}
