/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.pf.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class MitarbeiterHandler {

    
    public static void anfrageAnProjektleiterErstellen(Anfrage anfrage) {
        try {
            Connection conn = DbConnection.openConnection();

            String sql = "INSERT INTO Anfrage "
                    + "(ProjektleiterID, MitarbeiterID, Nachricht, ErstellDatum, "
                    + " AbsenderRolle) "
                    + " VALUES "
                    + " (?, ?, ?, CURRENT_DATE,  'M')";

            PreparedStatement pstmt;
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, anfrage.getProjektleiterId());
            pstmt.setInt(2, anfrage.getMitarbeiterId());
            pstmt.setString(3, anfrage.getNachricht());

            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }

    }

    
    public static ArrayList<Aufgaben> getAufgabenByMitarbeiterId(int mitarbeiterId) {
        ArrayList<Aufgaben> aufgabeList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();

            String sql = "SELECT A.AUFGABENID, A.PROJEKTID, A.PROJEKTLEITERID, U.BENUTZERVOLLNAME, "
                    + "A.ZEITRAUM_TAGE, A.STATUS, A.BESCHREIBUNG, A.ERSTELLUNGSDATUM "
                    + "FROM NEUE_AUFGABEN A "
                    + "JOIN BENUTZER U ON A.PROJEKTLEITERID = U.BENUTZERID "
                    + "WHERE A.MITARBEITERID = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mitarbeiterId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int aufgabeId = rs.getInt("AUFGABENID");
                int projektId = rs.getInt("PROJEKTID");
                int projektleiterId = rs.getInt("PROJEKTLEITERID");
                String projektleiterName = rs.getString("BENUTZERVOLLNAME");
                int zeitraumTage = rs.getInt("ZEITRAUM_TAGE");
                String status = rs.getString("STATUS");
                String beschreibung = rs.getString("BESCHREIBUNG");
                Date erstellungDatum = rs.getDate("ERSTELLUNGSDATUM");
                
                Aufgaben a = new Aufgaben(aufgabeId, projektId, projektleiterId, projektleiterName, zeitraumTage, status, erstellungDatum);
                aufgabeList.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aufgabeList;
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
            Logger.getLogger(VerwaltungHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beschreibung;
    }

    
    
    public static void statusAufgabeAndern(Aufgaben aufgabe) {
        try {
            Connection conn = DbConnection.openConnection();
            
            String sql = "UPDATE NEUE_AUFGABEN "
                    + " SET "
                    + " STATUS = 'Erledigt' "
                    + " WHERE AUFGABENID = ? "
                    + " AND MITARBEITERID = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, aufgabe.getAufgabeId());
            pstmt.setInt(2, aufgabe.getMitarbeiterId());
            pstmt.executeUpdate();

            conn.commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(MitarbeiterHandler.class.getName()).log
        (Level.SEVERE, null, ex);
        }
    }

    
    public static ArrayList<Projekt> getProjektByMitarbeiterId(int mitarbeiterId) {

        ArrayList<Projekt> projektList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();

            String sql = "SELECT p.ProjektID, p.Projektname, p.ProjektleiterID, b.BenutzerVollname AS ProjektleiterName "
                    + " FROM Projekt p"
                    + " JOIN NEUE_Aufgaben a ON p.ProjektID = a.ProjektID "
                    + " JOIN Benutzer b ON p.ProjektleiterID = b.BenutzerID "
                    + " WHERE a.MitarbeiterID = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mitarbeiterId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int projektId = rs.getInt("PROJEKTID");
                String projektName = rs.getString("PROJEKTNAME");
                int projektleiterId = rs.getInt("ProjektleiterID");
                String projektleiterName = rs.getString("ProjektleiterName");

                Projekt projekt = new Projekt(projektId, projektName, projektleiterId, projektleiterName);

                projektList.add(projekt);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return projektList;
    }

    
    public static ArrayList<Anfrage> getErstellteAnfragenAnProjektleiter(int mitarbeiterId) {
        ArrayList<Anfrage> anfragenList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();

            String sql = "SELECT A.AnfrageId, Nachricht, ErstellDatum "
                    + " FROM Anfrage A "
                    + " WHERE ABSENDERROLLE = 'M'"
                    + " AND MITARBEITERID = ? ";
            PreparedStatement pstmt;

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mitarbeiterId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int anfrageId = rs.getInt("AnfrageID");
                String nachricht = rs.getString("Nachricht");
                Date erstellDatum = rs.getDate("ErstellDatum");

                Anfrage anfrage = new Anfrage(anfrageId, nachricht, erstellDatum);
                // Weitere Eigenschaften zur Anfrage hinzufügen, falls notwendig

                anfragenList.add(anfrage);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProjektleiterHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return anfragenList;
    }

    
    public static int checkLoginMitarbeiter(String benutzerName, String passwort) {

        int benutzerId = -1;
        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT BenutzerID "
                    + " FROM Benutzer "
                    + " WHERE Benutzername = ? "
                    + " AND Passwort = ?"
                    + " AND ROLLE = 'M'";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, benutzerName);
            pstmt.setString(2, passwort);

            ResultSet rs = pstmt.executeQuery();

            // Wenn ein Datensatz gefunden wird, ist die Anmeldung erfolgreich
            if (rs.next()) {
                benutzerId = rs.getInt("BenutzerID");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return benutzerId;
    }

    public static void main(String[] args) {
      

    }
}
