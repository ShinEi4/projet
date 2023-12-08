package olona;

import java.time.*;
import java.util.Vector;
import java.sql.*;
import connection.*;

public class Emp {
    int id;
    String nom;
    LocalDate date;

    // public void insert(Connection co)
    // {
    // if (co==null) {

    // }
    // String requete="insert into emp values(default,?,?)";
    // PreparedStatement st=new PreparedStatement(requete);
    // st.setString(1, this.nom);
    // st.setDate(2, java.sql.Date.valueOf(this.date));
    // st.executeUpdate();
    // }
    public Emp(int id, String nom, LocalDate date) {
        this.id = id;
        this.nom = nom;
        this.date = date;
    }

    public static void main(String[] args) throws Exception {
        Connection co = MySql.connect();
        System.out.println(co);
        co.close();
    }

    public static Vector getAllEmploye(Connection co) throws Exception {
        Vector lsEmploye = new Vector();
        Connection con = co;
        boolean verif = false;
        if (con == null) {
            con = MySql.connect();
            verif = true;
        }
        String requete = "select * from olona";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(requete);
        try {
            while (rs.next()) {
                int id = rs.getInt("idOlona");
                String nom = rs.getString("nom");
                LocalDate date = rs.getDate("dateNaissance").toLocalDate();
                Emp e = new Emp(id, nom, date);
                lsEmploye.add(e);
            }

            return lsEmploye;
        } finally {
            rs.close();
            st.close();
            if (verif) {
                con.close();
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getDate() {
        return date;
    }
}