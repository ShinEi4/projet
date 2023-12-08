package connection;

import java.sql.*;

public class MySql {
    public static Connection connect() throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/employe?user=postgres&password=postgres1234");
        con.setAutoCommit(false);
        return con;
    }

    public static void main(String[] args) throws Exception {
        Connection con = MySql.connect();
        System.out.println(con);
        con.close();
    }
}