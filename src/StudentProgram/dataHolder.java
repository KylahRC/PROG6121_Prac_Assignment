package StudentProgram;

import javax.swing.*;

public class dataHolder
{
    static final int numberOfStudents = 10;

//    these are all parallel arrays to store the student details
    String[] studentNames = new String[numberOfStudents];
    String[] studentEmail = new String[numberOfStudents];
    int[] studentID = new int[numberOfStudents];
    int[] studentAge = new int[numberOfStudents];
    String[] studentCourse = new String[numberOfStudents];
    int studentCount = 0;

//    method to save a students details
    public void saveStudent(String name, String email, int ID, int age, String course)
    {
        if (studentCount < numberOfStudents)
        {
            studentNames[studentCount] = name;
            studentEmail[studentCount] = email;
            studentID[studentCount] = ID;
            studentAge[studentCount] = age;
            studentCourse[studentCount] = course;
            studentCount++;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Maximum number of students reached.");
        }
    }

//    method to delete a student
    public boolean deleteStudent(int ID)
    {
        for (int i = 0; i < studentCount; i++)
        {
            if (this.studentID[i] == ID)
            {
                for (int j = i; j < studentCount - 1; j++)
                {
                    studentNames[j] = studentNames[j + 1];
                    studentEmail[j] = studentEmail[j + 1];
                    studentID[j] = studentID[j + 1];
                    studentAge[j] = studentAge[j + 1];
                    studentCourse[j] = studentCourse[j + 1];
                }
                studentCount--;
                studentNames[studentCount] = null;
                studentEmail[studentCount] = null;
                studentID[studentCount] = 0;
                studentAge[studentCount] = 0;
                studentCourse[studentCount] = null;
                return true;
            }
        }
        return false;
    }

    public String[] getStudentNames()
    {
        return studentNames;
    }

    public String[] getStudentEmail()
    {
        return studentEmail;
    }

    public int[] getStudentID()
    {
        return studentID;
    }

    public int[] getStudentAge()
    {
        return studentAge;
    }

    public String[] getStudentCourse()
    {
        return studentCourse;
    }

    public int getStudentCount()
    {
        return studentCount;
    }
}

