/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.pf.handler;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.pf.db.DbConnection;
import javase.pf.haupt.Anfrage;
import javase.pf.haupt.Aufgaben;
import javase.pf.haupt.Projekt;

/**
 *
 * @author user
 */
public class ProjektleiterHandler {

    public static ArrayList<Projekt> getProjektByProjektLeiterId(int projektleiterId) {

        ArrayList<Projekt> projektList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();

            String sql = "SELECT ProjektId, Projektname, Erstellungsdatum, Endzeitraumdatum "
                    + " FROM Projekt "
                    + " WHERE ProjektleiterID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, projektleiterId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int projektId = rs.getInt("PROJEKTID");
                String projektName = rs.getString("PROJEKTNAME");
                Date erstellungDatum = rs.getDate("ERSTELLUNGSDATUM");
                Date endZeitraumDatum = rs.getDate("ENDZEITRAUMDATUM");

                Projekt projekt = new Projekt(projektId, projektName, erstellungDatum, endZeitraumDatum);

                projektList.add(projekt);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return projektList;
    }

    
    public static void neueAufgabeErstellen(Aufgaben aufgabe) {
        try {
            Connection conn = DbConnection.openConnection();

            String sql = "INSERT INTO NEUE_Aufgaben "
                    + " (PROJEKTLEITERID, MITARBEITERID, PROJEKTID, ERSTELLUNGSDATUM, "
                    + " ZEITRAUM_TAGE, STATUS, BESCHREIBUNG) "
                    + " VALUES "
                    + "(?, ?, ?, CURRENT_DATE, ?, 'Offen', ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, aufgabe.getProjektleiterId());
            pstmt.setInt(2, aufgabe.getMitarbeiterId());
            pstmt.setInt(3, aufgabe.getProjektId());
            pstmt.setInt(4, aufgabe.getZeitraumTage());
            pstmt.setString(5, aufgabe.getBeschreibung());

            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public static ArrayList<Aufgaben> getAufgabenByProjektleiterID(int projektleiterId) {
        ArrayList<Aufgaben> aufgabeList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();

            String sql = "SELECT A.AUFGABENID, A.PROJEKTID, A.MITARBEITERID, U.BENUTZERVOLLNAME, "
                    + "A.ZEITRAUM_TAGE, A.STATUS, A.BESCHREIBUNG, A.ERSTELLUNGSDATUM "
                    + "FROM NEUE_AUFGABEN A "
                    + "JOIN BENUTZER U ON A.MITARBEITERID = U.BENUTZERID "
                    + "WHERE A.PROJEKTLEITERID = ? "
                    + "AND U.ROLLE = 'M'";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, projektleiterId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int anfrageId = rs.getInt("AUFGABENID");
                int projektId = rs.getInt("PROJEKTID");
                int mitarbeiterId = rs.getInt("MITARBEITERID");
                String mitarbeiterName = rs.getString("BENUTZERVOLLNAME");
                int zeitraumTage = rs.getInt("ZEITRAUM_TAGE");
                String status = rs.getString("STATUS");
                String beschreibung = rs.getString("BESCHREIBUNG");
                Date erstellungDatum = rs.getDate("ERSTELLUNGSDATUM");

                Aufgaben aufgabe = new Aufgaben(anfrageId, projektId, mitarbeiterId, mitarbeiterName, erstellungDatum, zeitraumTage, status, beschreibung);

                aufgabeList.add(aufgabe);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aufgabeList;
    }

    //Anfrage erstellen-----------------------------------------------------------
    public static void anfrageAnVerwaltungErstellen(Anfrage anfrage) {
        try {
            Connection conn = DbConnection.openConnection();

            String sql = " INSERT INTO Anfrage (ProjektleiterID, Nachricht, ErstellDatum, AbsenderRolle) "
                    + " VALUES "
                    + " (?, ?, CURRENT_DATE, 'P')";

            PreparedStatement pstmt;

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, anfrage.getProjektleiterId());
            pstmt.setString(2, anfrage.getNachricht());

            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public static ArrayList<Anfrage> getErstellteAnfragenAnVerwaltung(int projektleiterId) {
        ArrayList<Anfrage> anfragenList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();

            String sql = "SELECT A.AnfrageId, ErstellDatum, Nachricht "
                    + " FROM Anfrage A "
                    + "JOIN Benutzer B ON A.ProjektleiterID = B.BenutzerID "
                    + "WHERE PROJEKTLEITERID = ?"
                    + "AND ABSENDERROLLE = 'P'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, projektleiterId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int anfrageId = rs.getInt("AnfrageID");
                Date erstellDatum = rs.getDate("ErstellDatum");
                String nachricht = rs.getString("Nachricht");

                Anfrage anfrage = new Anfrage(anfrageId, nachricht, erstellDatum);

                anfragenList.add(anfrage);
            }

        } catch (SQLException ex) {
            System.out.println("Fehler beim Abrufen der Anfragen: " + ex.getMessage());
        }

        return anfragenList;
    }

    
    public static ArrayList<Anfrage> getAnfragenVonMitarbeiter(int projektleiterId) {
        ArrayList<Anfrage> anfragenList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();

            String sql = "SELECT A.AnfrageId, A.MitarbeiterId, B.BenutzerVollName, Nachricht, ErstellDatum "
                    + " FROM Anfrage A "
                    + "JOIN Benutzer B ON A.MitarbeiterID = B.BenutzerID "
                    + "WHERE ABSENDERROLLE = 'M'"
                    + "AND ProjektleiterId = ? ";
            PreparedStatement pstmt;

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, projektleiterId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int anfrageId = rs.getInt("AnfrageID");
                int mitarbeiterId = rs.getInt("MitarbeiterId");
                String projektleiterName = rs.getString("BenutzerVollName");
                String nachricht = rs.getString("Nachricht");
                Date erstellDatum = rs.getDate("ErstellDatum");

                Anfrage anfrage = new Anfrage(anfrageId, mitarbeiterId, projektleiterName, nachricht, erstellDatum);
                // Weitere Eigenschaften zur Anfrage hinzufügen, falls notwendig

                anfragenList.add(anfrage);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return anfragenList;
    }

    
    public static int checkProjektleiter(String benutzerName, String passwort) {

        int benutzerId = -1;
        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT BenutzerID "
                    + " FROM Benutzer "
                    + " WHERE Benutzername = ? "
                    + " AND Passwort = ?"
                    + " AND ROLLE = 'P'";
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








