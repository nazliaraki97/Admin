package sample.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Employee;

import java.sql.*;

class mySQLconn{
    public static void doInsert(String finame,String laname,String usname,String password,String jobtitle){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            int rs=stmt.executeUpdate("insert into employees values (null,\""+ finame +"\",\""+laname+"\",\""+usname+"\",\""+password+"\",\""+jobtitle+"\") ;");
            /*
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

             */


            con.close();

        }catch(Exception e){ System.out.println(e);}
    }

    public static ObservableList<Employee> doSelect(){
        ObservableList<Employee> data =

                FXCollections.observableArrayList(
                //        new Employee("1", "Smith", "jacob","smith@example.com","admin"),
               //         new Employee("2","Isabella", "Johnson", "isabella.johnson@example.com","emp","111")
                );

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery("SELECT id,firstname,lastname,username,jobtitle,password from employees ;");





            while(rs.next()){
                data.add(new Employee(rs.getString("id") , rs.getString("firstname") , rs.getString("lastname") , rs.getString("username") , rs.getString("jobtitle") , rs.getString("password")) ) ;
            }
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));




            con.close();

        }catch(Exception e){ System.out.println(e);}
        return data ;

    }


    public static void doDelete(String id) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            System.out.println("DELETE FROM employees WHERE id=" + id + " ;");
            int rs=stmt.executeUpdate("DELETE FROM employees WHERE id=" + id + " ;")  ;
            /*
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

             */


            con.close();

        }catch(Exception e){ System.out.println(e);}
    }

    public static void doUpdate(String fn , String ln , String un , String ps , String jt ,String id) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            System.out.println("UPDATE employees SET firstname = "+ fn + " , lastname = " + ln + " , password = " + ps + " ,username =  " + un + " , jobtitle = " + jt + " WHERE id = " +  id + "; ");
            int rs=stmt.executeUpdate("UPDATE employees SET firstname = \""+ fn + "\" , lastname = \"" + ln + "\" , password = \"" + ps + "\" ,username =  \"" + un + "\" , jobtitle = \"" + jt + "\" WHERE id = " +  id + "; ")  ;
            /*
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

             */


            con.close();

        }catch(Exception e){ System.out.println(e);}
    }
}
