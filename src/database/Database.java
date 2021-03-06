/*
copyright Paweł Czarnik 2016
 */
package database;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 *
 * @author Paweł Czarnik
 */
public class Database {
    //static Logger log = Logger.getLogger(Database.class.getName());
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/biblioteka";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";
            
    
    private Connection conn;

    public Database() {
        //PropertyConfigurator.configure("log4j.properties");
        //log.setLevel(Level.ALL); // ustawienie levelu logowania  ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF.
        conn = makeConnection();
        //createDB(); //utworzenie bazy
    }

    public Connection getConnection() {
        return conn;
    }

    public Connection makeConnection() {
        try {
            Class.forName(DRIVER); //odpowiedzialna za załadowanie sterownika
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD); //tworzymy połączenie z bazą danych
            //log.info("Nawiazano polaczenie z plikiem bazy danych");
            System.out.println("Nawiazano polaczenie z plikiem bazy danych");
            //PreparedStatement prepStmt = conn.prepareStatement("PRAGMA foreign_keys=ON");
            //prepStmt.execute();
            return conn;
        } catch (ClassNotFoundException cnfe) {
            //log.fatal("Blad ladowania sterownika: " + cnfe.getMessage());
            System.out.println("bład " + cnfe.getMessage());
            return null;
        } catch (SQLException sqle) {
            //log.fatal("Blad przy nawiazywaniu polaczenia: " + sqle.getMessage());
            System.out.println("bład " + sqle.getMessage());
            return null;
        }
    }
    
    public void close() {
        try {
            conn.close();
        } catch (SQLException sqle) {
            //log.error("Blad przy zamykaniu polaczenia: " + sqle.getMessage());
            System.out.println("Blad przy zamykaniu polaczenia: " + sqle.getMessage());
        }
    }
    
    public boolean createDB()  {
        //Zalozenie bazy danych
        String createDB = "CREATE TABLE user ( nick character varying(30) NOT NULL, password character varying(30) NOT NULL, join_date timestamp NOT NULL, admin boolean NOT NULL DEFAULT 'false', ban boolean DEFAULT 'false', CONSTRAINT Key1 PRIMARY KEY (nick) );  CREATE TABLE message ( date timestamp NOT NULL, content TEXT NOT NULL, nick character varying(30) NOT NULL, CONSTRAINT Key2 PRIMARY KEY (date,nick), CONSTRAINT R1 FOREIGN KEY (nick) REFERENCES user (nick) ON DELETE CASCADE ON UPDATE CASCADE );";
        try {
            PreparedStatement prepStmt = conn.prepareStatement(createDB);
            prepStmt.execute();
            
        } catch (SQLException e) {
            //log.fatal("Blad przy tworzeniu DB " + e.getMessage());
            //e.printStackTrace();
            return false;
        }
        return true;
    }
    public Egzemplarz selectEgzemplarz(String sz_kod_ean) {
        Egzemplarz egz= new Egzemplarz();
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "SELECT pr_wyszukaj_egzemplarz {'','?','','','','','','','' ;");
            prepStmt.setString(1, sz_kod_ean);
            prepStmt.execute();
            ResultSet result = prepStmt.getResultSet();
            String id_dziela,kod_ean,tytul,autor,typ,gatunek,tagi,jezyk,isbn;
            while(result.next()) {
                id_dziela = result.getString("id_dziela");
                kod_ean = result.getString("kod_ean");
                tytul = result.getString("tytul");
                autor = result.getString("autor");
                typ = result.getString("typ");
                gatunek= result.getString("gatunek");
                tagi= result.getString("tagi");
                jezyk= result.getString("jezyk");
                isbn= result.getString("isbn");
                
                egz= (new Egzemplarz(id_dziela,kod_ean,tytul,autor,typ,gatunek,tagi,jezyk,isbn));
            }
            //log.debug("Select egz list");
        } catch (SQLException e) {
            //log.error("Blad przy select wszystkich egz " + e.getMessage());
            //e.printStackTrace();
            System.out.println(e.toString());
            return null;
        }
        return egz;
    }
    
    public List<Egzemplarz> selectEgzemplarzList(
            String sz_id_dziela,
            String sz_kod_ean,
            String sz_tytul,
            String sz_autor,
            String sz_typ,
            String sz_gatunek,
            String sz_tagi,
            String sz_jezyk,
            String sz_isbn) {
        List<Egzemplarz> EgzemplarzList = new LinkedList<Egzemplarz>();
        System.out.println("Dziala select all egzemparz ");
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "SELECT pr_wyszukaj_egzemplarz {'?','?','?','?','?','?','?','?','?' ;");
            prepStmt.setString(1, sz_id_dziela);
            prepStmt.setString(2, sz_kod_ean);
            prepStmt.setString(3, sz_tytul);
            prepStmt.setString(4, sz_autor);
            prepStmt.setString(5, sz_typ);
            prepStmt.setString(6, sz_gatunek);
            prepStmt.setString(7, sz_tagi);
            prepStmt.setString(8, sz_jezyk);
            prepStmt.setString(9, sz_isbn);

            prepStmt.execute();
            ResultSet result = prepStmt.getResultSet();
            String id_dziela,kod_ean,tytul,autor,typ,gatunek,tagi,jezyk,isbn;
            
            System.out.println("Dziala select all egzemparz 3");
            while(result.next()) {
                id_dziela = result.getString("id_dziela");
                kod_ean = result.getString("kod_ean");
                tytul = result.getString("tytul");
                autor = result.getString("autor");
                typ = result.getString("typ");
                gatunek= result.getString("gatunek");
                tagi= result.getString("tagi");
                jezyk= result.getString("jezyk");
                isbn= result.getString("isbn");
                System.out.println("Egzemplarz{" + "id_dziela=" + id_dziela + ", kod_ean=" + kod_ean + ", tytul=" + tytul + ", autor=" + autor + ", typ=" + typ + ", gatunek=" + gatunek + ", tagi=" + tagi + ", jezyk=" + jezyk + ", isbn=" + isbn );
                EgzemplarzList.add(new Egzemplarz(id_dziela,kod_ean,tytul,autor,typ,gatunek,tagi,jezyk,isbn));
                System.out.println("Dziala select all egzemparz 3");
            }
            //log.debug("Select egz list");
        } catch (SQLException e) {
            //log.error("Blad przy select wszystkich egz " + e.getMessage());
            //e.printStackTrace();
            System.out.println(e.toString() );
            return null;
        }
        System.out.println("Dziala select all egzemparz 4");

        return EgzemplarzList;
    }
    //insert

}

