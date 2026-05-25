package task2;

import java.sql.*;
import java.util.Scanner;

public class Student {

    static final String URL      = "jdbc:postgresql://localhost:5432/javalab";
    static final String USER     = "postgres";
    static final String PASSWORD = "postgres";

    private String studentId;
    private String direction;
    private String fullName;
    private String group;

    public String getStudentId()            { return studentId; }
    public void   setStudentId(String v)    { this.studentId = v; }
    public String getDirection()            { return direction; }
    public void   setDirection(String v)    { this.direction = v; }
    public String getFullName()             { return fullName; }
    public void   setFullName(String v)     { this.fullName = v; }
    public String getGroup()               { return group; }
    public void   setGroup(String v)        { this.group = v; }

    public void inputData(Scanner sc) {
        System.out.print("  ID студента:            "); studentId = sc.nextLine().trim();
        System.out.print("  Направление подготовки: "); direction = sc.nextLine().trim();
        System.out.print("  ФИО студента:           "); fullName  = sc.nextLine().trim();
        System.out.print("  Группа:                 "); group     = sc.nextLine().trim();
    }

    public void showInfo() {
        System.out.printf("%-10s %-30s %-40s %-10s%n",
                studentId, direction, fullName, group);
    }

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
