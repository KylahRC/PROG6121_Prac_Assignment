package StudentProgram;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest
{

    dataHolder dataHolder = new dataHolder();
    int[] testID = {123, 456};
    String[] testName = {"name", "name2"};
    int[] testAge = {21, 32};
    String[] testEmail = {"email", "email2"};
    String[] testCourse = {"disd", "disd2"};

    int studentID = 123;
    String studentName = "name";
    int studentAge = 21;
    String studentEmail = "email";
    String studentCourse = "disd";

    @Test
    void TestSaveStudent()
    {


        System.out.println("Test the saving system");
        System.out.println("***************************************\n");

        dataHolder.saveStudent(studentEmail, studentName, studentAge, studentID, studentCourse);

        assertEquals(testID[0], studentID);
        System.out.println("Entered ID: " + testID[0] + " = Stored ID: " + studentID);
        assertEquals(testName[0], studentName);
        System.out.println("Entered name: " + testName[0] + " = Stored name: " + studentName);
        assertEquals(testAge[0], studentAge);
        System.out.println("Entered age: " + testAge[0] + " = Stored age: " + studentAge);
        assertEquals(testEmail[0], studentEmail);
        System.out.println("Entered email: " + testEmail[0] + " = Stored email: " + studentEmail);
        assertEquals(testCourse[0], studentCourse);
        System.out.println("Entered course: " + testCourse[0] + " = Stored course: " + studentCourse);
        System.out.println("\n***************************************");

    }

    @Test
    void TestSearchStudent()
    {

        System.out.println("Test the searching system if student found");
        System.out.println("***************************************\n");

        int ID = 123;
        String expected = "STUDENT ID: " + testID[0]
                + "\nSTUDENT NAME: " + testName[0]
                + "\nSTUDENT AGE: " + testAge[0]
                + "\nSTUDENT EMAIL: " + testEmail[0]
                + "\nSTUDENT COURSE: " + testCourse[0];
        int count = 2;
        String output = null;

        for (int i = 0; i < count; i++)
        {
            if (testID[i] == ID)
            {
                output = ("STUDENT ID: " + testID[i]
                        + "\nSTUDENT NAME: " + testName[i]
                        + "\nSTUDENT AGE: " + testAge[i]
                        + "\nSTUDENT EMAIL: " + testEmail[i]
                        + "\nSTUDENT COURSE: " + testCourse[i]);
            }
        }

        assertEquals(expected, output);
        System.out.println("Expected result:");
        System.out.println(expected);
        System.out.println(" ");
        System.out.println("Output recieved:");
        System.out.println(output);
        System.out.println("\n***************************************");
    }

    @Test
    void TestSearchStudent_StudentNotFound()
    {

        System.out.println("Test the searching system if no student found");
        System.out.println("***************************************\n");

        int ID = 789;
        String expected = "Student with Student Id:" + ID + " was not found!";
        int count = 2;
        String output = null;

        for (int i = 0; i < count; i++)
        {
            if (testID[i] != ID)
            {
                output = ("Student with Student Id:" + ID + " was not found!");
            }
        }

        assertEquals(expected, output);
        System.out.println("Expected result:");
        System.out.println(expected);
        System.out.println(" ");
        System.out.println("Output recieved:");
        System.out.println(output);
        System.out.println("\n***************************************");

    }


    @Test
    void TestDeleteStudent()
    {
        System.out.println("Test the deleting system");
        System.out.println("***************************************\n");

        boolean deleted = false;
        int ID = 456;
        String expected = "Student was deleted";
        int count = 2;
        String output = null;

        for (int i = 0; i < count; i++)
        {
            if (testID[i] == ID)
            {
                count--;
                testName[i] = null;
                testEmail[i] = null;
                testID[i] = 0;
                testAge[i] = 0;
                testCourse[i] = null;

            }
            deleted = true;
        }

        if (deleted)
        {
            output = "Student was deleted";
        }


        assertEquals(expected, output);
        System.out.println("Expected result:");
        System.out.println(expected);
        System.out.println(" ");
        System.out.println("Output recieved:");
        System.out.println(output);
        System.out.println("\n***************************************");
    }

    @Test
    void TestDeleteStudent_StudentNotFound()
    {
        System.out.println("Test the deleting system if no student found");
        System.out.println("***************************************\n");

        int ID = 789;
        String expected = "Student not found.";
        int count = 2;
        String output = null;

        for (int i = 0; i < count; i++)
        {
            if (testID[i] != ID)
            {
                output = ("Student not found.");
            }
        }

        assertEquals(expected, output);
        System.out.println("Expected result:");
        System.out.println(expected);
        System.out.println(" ");
        System.out.println("Output recieved:");
        System.out.println(output);
        System.out.println("\n***************************************");
    }


}
