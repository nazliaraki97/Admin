//nazli araki 170503107

package sample.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Employee;
import sample.model.equipment;
import sample.model.firma;

import java.sql.*;

class mySQLconn{
    public static void doInsert(String finame,String laname,String usname,String password,String jobtitle){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            Statement stmt=con.createStatement();

            int rs=stmt.executeUpdate("insert into employees values (null,\""+ finame +"\",\""+laname+"\",\""+usname+"\",\""+password+"\",\""+jobtitle+"\") ;");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    public static void doInserte(String p,String ee,String c,String m,String l,String d){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            int rs=stmt.executeUpdate("insert into equipments values (\""+ p +"\",\""+ee+"\",\""+c+"\",\""+m+"\",\""+l+"\",\""+d+"\",null) ;");
            con.close();

        }catch(Exception e){ System.out.println(e);}
    }

    public static void doInsertee(String c,String p,String i,String j,String o){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            int rs=stmt.executeUpdate("insert into companies values (\""+ c +"\",\""+p+"\",\""+i+"\",\""+j+"\",\""+o+"\",null) ;");

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



    public static ObservableList<equipment> doSelecte(){
        ObservableList<equipment> data =
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

            ResultSet rs=stmt.executeQuery("SELECT Pole_Distance,Eq_name,Carrier_Medium,Mag_Tech,Light_Intensity,DistanceofLight,id from equipments ;");


            while(rs.next()){
                data.add(new equipment(rs.getString("Pole_Distance") , rs.getString("Eq_name") , rs.getString("Carrier_Medium") , rs.getString("Mag_Tech") , rs.getString("Light_Intensity") , rs.getString("DistanceofLight"),rs.getString("id")) ) ;
            }
            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
        return data ;
    }
    public static ObservableList<firma> doSelectee(){
        ObservableList<firma> data =
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

            ResultSet rs=stmt.executeQuery("SELECT Costumer,Project_name,il_ilce,job_order_no,offer_no,id from companies ;");


            while(rs.next()){
                data.add(new firma(rs.getString("Costumer") , rs.getString("Project_name") , rs.getString("il_ilce") , rs.getString("job_order_no") , rs.getString("offer_no") ,rs.getString("id")) ) ;
            }
            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
        return data ;
    }


    public static ObservableList<String> doSelectco(){
        ObservableList<String> data =

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

            ResultSet rs=stmt.executeQuery("SELECT costumer from companies ;");


            while(rs.next()){
                data.add(new String(rs.getString("costumer") ) ) ;
            }
            System.out.println(rs.getInt(2)+"  ");
            con.close();
        }catch(Exception e){ System.out.println(e);}
        return data ;

    }

    public static String doSer(String fi){
     String data="";

        String selectSQL = "SELECT  il_ilce FROM companies WHERE Costumer ='"+fi + "'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/checkingdb","root","");
        //here sonoo is database name, root is username and password
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(selectSQL);
           if(rs.next()) {
                data= rs.getString("il_ilce");
            }
            con.close();

        } catch(Exception e){ System.out.println(e);}
        return  data;
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
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public static void doDeletei(String id) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            System.out.println("DELETE FROM equipments WHERE id=" + id + " ;");
            int rs=stmt.executeUpdate("DELETE FROM equipments WHERE id=" + id + " ;")  ;
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    public static void doDeleteii(String id) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            System.out.println("DELETE FROM companies WHERE id=" + id + " ;");
            int rs=stmt.executeUpdate("DELETE FROM companies WHERE id=" + id + " ;")  ;
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

            con.close();

        }catch(Exception e){ System.out.println(e);}
    }
    public static void doUpdatei(String p , String ee , String c , String m , String l ,String d,String id) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            System.out.println("UPDATE equipments SET Pole_Distance = "+ p + " , Eq_name = " + ee + " , Carrier_Medium = " + c + " ,Mag_Tech =  " + m + " , Light_Intensity = " + l + ",DistanceofLight="+d+" WHERE id = " +  id + "; ");
            int rs=stmt.executeUpdate("UPDATE equipments SET Pole_Distance = \""+ p + "\" , Eq_name = \"" + ee + "\" , Carrier_Medium = \"" + c + "\" ,Mag_Tech =  \"" + m + "\" , Light_Intensity = \"" + l + "\",DistanceofLight=\""+d+"\" WHERE id = " +  id + "; ")  ;

            con.close();

        }catch(Exception e){ System.out.println(e);}
    }
    public static void doUpdateii(String c , String p , String i , String j , String o ,String id) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();

            System.out.println("UPDATE companies SET Costumer = "+ c + " , Project_name = " + p + " , il_ilce = " + i + " ,job_order_no =  " + j + " , offer_no = " + o + " WHERE id = " +  id + "; ");
            int rs=stmt.executeUpdate("UPDATE companies SET Costumer = \""+ c + "\" , Project_name = \"" + p + "\" , il_ilce = \"" + i + "\" ,job_order_no =  \"" + j + "\" , offer_no = \"" + o + "\" WHERE id = " +  id + "; ")  ;

            con.close();

        }catch(Exception e){ System.out.println(e);}
    }

    public ObservableList<equipment> doSert(String text) {
        ObservableList <equipment> data=FXCollections.observableArrayList();

        String selectSQL = "SELECT Pole_Distance,Eq_name,Carrier_Medium,Mag_Tech,Light_Intensity,DistanceofLight FROM equipments WHERE id ='"+text + "'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(selectSQL);
            if(rs.next()) {
                data.add(new equipment(rs.getString("Pole_Distance") , rs.getString("Eq_name") , rs.getString("Carrier_Medium") , rs.getString("Mag_Tech") , rs.getString("Light_Intensity") , rs.getString("DistanceofLight")));
            }
            con.close();

        } catch(Exception e){ System.out.println(e);}
        return  data;

    }

    public ObservableList<Employee> doSert1(String text) {
        ObservableList <Employee> data=FXCollections.observableArrayList();

        String selectSQL = "SELECT firstname,lastname,jobtitle FROM employees WHERE id ='"+text + "'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(selectSQL);
            if(rs.next()) {
                data.add(new Employee(rs.getString("firstname") , rs.getString("lastname"),rs.getString("jobtitle")  ));
            }
            con.close();

        } catch(Exception e){ System.out.println(e);}
        return  data;

    }
    public ObservableList<Employee> doSert2(String text) {
        ObservableList <Employee> data=FXCollections.observableArrayList();

        String selectSQL = "SELECT firstname,lastname,jobtitle FROM employees WHERE id ='"+text + "'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/checkingdb","root","");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(selectSQL);
            if(rs.next()) {
                data.add(new Employee(rs.getString("firstname") , rs.getString("lastname"),rs.getString("jobtitle")  ));
            }
            con.close();

        } catch(Exception e){ System.out.println(e);}
        return  data;

    }


}
