package com.bridgelabz;

import java.sql.*;

public class EmployeeDB {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payrolldb?useSSL=false";
        String userName = "root";
        String password = "Madhu@28100";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded ");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        try {
            System.out.println("Connecting to DataBase:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successfully" + con);
            Statement statement = con.createStatement();
//            statement.executeUpdate("insert into employee(name,salary,age,department,joining_date) values ('Ritesh',40000,22,'IT Engineer','2021-04-18')");
//            statement.executeUpdate("update employee set Age=61 where Emp_Id in (2)");
//            statement.executeUpdate("alter table employee modify column salary double");
//            statement.executeQuery("desc employee");
//            statement.execute("insert into employee(name,salary,age,department,joining_date) values ('Amit',50000,24,'IT Engineer','2022-02-15'), ('Rohan',40000,26,'Software Engineer','2018-03-14'), ('Suraj',45000,28,'IT Engineer','2019-05-10'), ('Payal',55000,27,'Software Engineer','2020-08-09'), ('Mohak',25000,30,'IT Engineer','2016-06-26');");
//
//            PreparedStatement preparedStatement=con.prepareStatement("alter table employee add column " +
//                    "gender varchar(20)");
//            ResultSet resultSet = statement.executeQuery("select Gender,sum(salary) as sum," +
//                    "avg(salary) as average,max(salary) as maximum,min(salary) as minimum" +
//                    " from employee group by Gender");

            statement.execute("alter table employee add column phone varchar(30)");
            statement.execute("alter table employee add column address varchar(90)");
            statement.execute("update employee set department = not null");
            statement.execute("update employee set name='Terissa', department='sales and marketing' where id=2");
            ResultSet resultSet =statement.executeQuery("select * from employee");

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("Emp_Id"));
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Age: " + resultSet.getInt("Age"));
                System.out.println("Salary: " + resultSet.getInt("Salary"));
                System.out.println("Department: " + resultSet.getString("Department"));
                System.out.println("Joining_Date: " + resultSet.getDate("Join_Date"));

            }
        } catch (Exception e) {
           // e.printStackTrace();
        }
    }
}

