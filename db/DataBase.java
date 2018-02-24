package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import org.xml.sax.SAXException;


public class DataBase {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "1111";

    //Create connection method
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn != null)
                System.out.println("Connecting successful!!!");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return conn;
        /*
          // nothing we can do
          
           try{
             if(conn!=null)
                conn.close();
          }catch(SQLException se){
             se.printStackTrace();
          }//end finally try
        }//end try*/
    }//end getConnection

    //Close connection method
    public static void closeConnection(Connection con) {
        Connection conn = con;
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connecting successfully closed!!!");
            } else
                System.out.println("Connecting is NULL and cannot be close!");
        } catch (SQLException se) {
            se.printStackTrace();
        } //end try
    }

    //Add data to database
    public static void executeSQl() throws SQLException {
        Connection c = getConnection();
        Statement stmt = null;
        stmt = c.createStatement();
        String sql = "INSERT INTO genre (name) VALUES ('Экономика');";
        String sql1 = "INSERT INTO article (name, date_b, link, art_text, likes, dislike, ad_name, ad_contact, id_genre) VALUES ('Цель в том, чтобы продать всё это', '2017-05-06', 'https://vc.ru/p/valley-tobe-ornot', ' ', '12', '3', 'Павел Кузнецов', 'none', '2');";
        String sql2 = "INSERT INTO author (name) VALUES ('Экономика');";
        String sql3 = "INSERT INTO authorship (name) VALUES ('Экономика');";
        String sql5 = "INSERT INTO subscriber (name) VALUES ('Экономика');";
        stmt.executeUpdate(sql);
        stmt.close();
        closeConnection(c);
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
        }
        c.close();

    }

    public static String executeCommant(String command) throws SQLException {
        Connection c = getConnection();
        Statement stmt = null;
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(command);
        int columns = rs.getMetaData().getColumnCount();

        String td = "<td>";
        String ctd = "</td>";
        String tr = "<tr>";
        String ctr = "</tr>";
        String out = "";
        // Перебор строк с данными
        while (rs.next()) {
            out += tr;
            for (int i = 1; i <= columns; i++) {
                out += td + rs.getString(i) + ctd;
            }
            out += ctr;
        }
        //out += ctr;
        closeConnection(c);
        // try {
        //     rs = stmt.executeQuery(command);
        // } catch (SQLException se2) {
        //     se2.getStackTrace();
        // }
        stmt.close();
        c.close();
        return out;

    }

    //Main
    public static void main(String[] argv) {

        //Connection conn = getConnection();
        //closeConnection(conn);
        Connection c = getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sql = "SELECT * FROM genre;";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        closeConnection(c);
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
        }
        //  c.close();
    }
}