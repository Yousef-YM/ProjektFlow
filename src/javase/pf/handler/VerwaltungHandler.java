/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.pf.handler;

import javase.pf.haupt.Benutzer;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javase.pf.db.DbConnection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.pf.haupt.Anfrage;
import javase.pf.haupt.Aufgaben;
import javase.pf.haupt.Projekt;

/**
 *
 * @author user
 */
public class VerwaltungHandler extends Benutzer {

    public VerwaltungHandler(String benutzerVollName, String benutzerName, 
            String passwort, String rolle, String mail, String telNummer) {
        super(benutzerVollName, benutzerName, passwort, rolle, 
                mail, telNummer);
    }
    
    public static void benutzerHinzufuegen(Benutzer benutzer) {
        try {
            Connection conn = DbConnection.openConnection();
            String sql = "INSERT INTO Benutzer "
                    + " (BenutzerVollName, Rolle, Mail, Telefonnummer, "
                    + "Benutzername, Passwort) "
                    + " VALUES "
                    + " ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt;

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, benutzer.getBenutzerVollName());
            pstmt.setString(2, benutzer.getRolle());
            pstmt.setString(3, benutzer.getMail());
            pstmt.setString(4, benutzer.getTelNummer());
            pstmt.setString(5, benutzer.getBenutzerName());
            pstmt.setString(6, benutzer.getPasswort());

            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }
    }
    
    public static void benutzerBearbeiten(Benutzer benutzer) {

        try {

            Connection conn = DbConnection.openConnection();

            String sql = "UPDATE Benutzer "
                    + " SET "
                    + " BenutzerVollName = ?,"
                    + " Rolle = ? ,"
                    + " Mail = ? , "
                    + " TelefonNummer = ? ,"
                    + " BenutzerName = ? ,"
                    + " Passwort = ? "
                    + " WHERE "
                    + " BenutzerID = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, benutzer.getBenutzerVollName());
            pstmt.setString(2, benutzer.getRolle());
            pstmt.setString(3, benutzer.getMail());
            pstmt.setString(4, benutzer.getTelNummer());
            pstmt.setString(5, benutzer.getBenutzerName());
            pstmt.setString(6, benutzer.getPasswort());
            pstmt.setInt(7, benutzer.getBenutzerId());

            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }
    }

    
    public static void benutzerLoeschen(int benutzerId) {

        try {
            Connection conn = DbConnection.openConnection();

            String sql = "DELETE FROM Benutzer "
                    + " WHERE "
                    + " BenutzerID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, benutzerId);
            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Benutzer> gettAllMitarbeiter() {
        ArrayList<Benutzer> benutzerList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT BENUTZERID, BENUTZERVOLLNAME, "
                    + " ROLLE, MAIL, TELEFONNUMMER, BENUTZERNAME, PASSWORT  "
                    + " FROM BENUTZER"
                    + " ORDER BY ROLLE";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int benutzerId = rs.getInt("BENUTZERID");
                String benutzerVollName= rs.getString("BENUTZERVOLLNAME");
                String benutzerRolle = rs.getString("ROLLE");
                String benutzerMail = rs.getString("MAIL");
                String benutzerTelefon = rs.getString("TELEFONNUMMER");
                String benutzerName = rs.getString("BENUTZERNAME");
                String passwort = rs.getString("PASSWORT");

                Benutzer benutzer = new Benutzer(benutzerId, benutzerVollName,
                        benutzerRolle, benutzerMail, 
                        benutzerTelefon, benutzerName, passwort);

                benutzerList.add(benutzer);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }

        return benutzerList;
    }

    
    public static ArrayList<Projekt> getAllProjekte() {

        ArrayList<Projekt> projektList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT PROJEKTID, PROJEKTNAME, PROJEKTLEITERID, "
                    + "ERSTELLUNGSDATUM, ENDZEITRAUMDATUM "
                    + " FROM Projekt";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int projektId = rs.getInt("PROJEKTID");
                String projektName = rs.getString("PROJEKTNAME");
                int projektleiterId = rs.getInt("PROJEKTLEITERID");
                Date erstellungDatum = rs.getDate("ERSTELLUNGSDATUM");
                Date endZeitraumDatum = rs.getDate("ENDZEITRAUMDATUM");

                Projekt projekt = new Projekt(projektId, projektName, 
              projektleiterId, erstellungDatum, endZeitraumDatum);

                projektList.add(projekt);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }

        return projektList;
    }

    
    public static ArrayList<Aufgaben> getAllAufgaben() {
        ArrayList<Aufgaben> aufgabenList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();

            String sql= "SELECT A.AUFGABENID, A.PROJEKTID, PROJEKT.PROJEKTNAME,"
                + "A.MITARBEITERID, P.BENUTZERVOLLNAME AS PROJEKTLEITER_NAME, "
                + "A.PROJEKTLEITERID, U.BENUTZERVOLLNAME AS MITARBEITER_NAME, "
              + "A.ZEITRAUM_TAGE, A.ERSTELLUNGSDATUM, A.STATUS, A.BESCHREIBUNG "
                + "FROM NEUE_AUFGABEN A "
                + "JOIN BENUTZER U ON A.MITARBEITERID = U.BENUTZERID "
                + "JOIN BENUTZER P ON A.PROJEKTLEITERID = P.BENUTZERID "
                + "JOIN PROJEKT ON A.PROJEKTID = PROJEKT.PROJEKTID "
                + "ORDER BY A.PROJEKTLEITERID";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int aufgabenId = rs.getInt("AUFGABENID");
                int projektId = rs.getInt("PROJEKTID");
                String projektname = rs.getString("PROJEKTNAME");
                int projektleiterId = rs.getInt("PROJEKTLEITERID");
          String projektleiterName = rs.getString("PROJEKTLEITER_NAME");
                int mitarbeiterId = rs.getInt("MITARBEITERID");
                String mitarbeiterName = rs.getString("MITARBEITER_NAME");
                Date erstellungsdatum = rs.getDate("ERSTELLUNGSDATUM");
                int zeitraumTage = rs.getInt("ZEITRAUM_TAGE");
                String status = rs.getString("STATUS");
                String beschreibung = rs.getString("BESCHREIBUNG");

                Aufgaben aufgaben = new Aufgaben(aufgabenId, projektId,
                      projektname, projektleiterId, projektleiterName,
                 mitarbeiterId, mitarbeiterName, erstellungsdatum,
                        zeitraumTage, status, beschreibung);

                aufgabenList.add(aufgaben);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }

        return aufgabenList;
    }

    public static String aufgabeBeschreibungBayAufgabeId(int aufgabeId) {

        String beschreibung = null;
        try {
            Connection conn = DbConnection.openConnection();

            String sql = "Select BESCHREIBUNG "
                    + " from Neue_Aufgaben "
                    + " where aufgabenID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, aufgabeId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                beschreibung = rs.getString("Beschreibung");
            }

        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }
        return beschreibung;
    }

    
    public static ArrayList<Anfrage> getAnfragenVonProjektleiter() {
        ArrayList<Anfrage> anfragenList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();

            String sql = "SELECT A.AnfrageId, A.ProjektleiterId, "
                    + "B.BenutzerVollName, Nachricht, ErstellDatum "
                    + " FROM Anfrage A "
                    + "JOIN Benutzer B ON A.ProjektleiterID = B.BenutzerID "
                    + "WHERE ABSENDERROLLE = 'P'";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int anfrageId = rs.getInt("AnfrageID");
                int projektleiterId = rs.getInt("ProjektleiterID");
            String projektleiterName = rs.getString("BenutzerVollName");
                String nachricht = rs.getString("Nachricht");
                Date erstellDatum = rs.getDate("ErstellDatum");

                Anfrage anfrage = new Anfrage(anfrageId, projektleiterId, 
                        projektleiterName, nachricht, erstellDatum);
                anfragenList.add(anfrage);
            }

        } catch (SQLException ex) {
   System.out.println("Fehler beim Abrufen der Anfragen: " + ex.getMessage());
        }

        return anfragenList;
    }
    
    public static String anfrageNachrichtByProjektleiterId(int aufgabeId) {

        String beschreibung = null;
        try {
            Connection conn = DbConnection.openConnection();

            String sql = "Select Nachricht "
                    + " from Anfrage "
                    + " where Anfrageid = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, aufgabeId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                beschreibung = rs.getString("Nachricht");
            }

        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }
        return beschreibung;
    }
    
    public static int checkLoginVerwalter(String benutzerName, String passwort){

        int benutzerId = -1;
        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT BenutzerID "
                    + " FROM Benutzer "
                    + " WHERE Benutzername = ? "
                    + " AND Passwort = ?"
                    + " AND ROLLE = 'V'";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, benutzerName);
            pstmt.setString(2, passwort);

            ResultSet rs = pstmt.executeQuery();

            // Wenn ein Datensatz gefunden wird, ist die Anmeldung erfolgreich
            if (rs.next()) {
                benutzerId = rs.getInt("BenutzerID");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }

        return benutzerId;
    }

    public static void main(String[] args) {
       
    }

}
