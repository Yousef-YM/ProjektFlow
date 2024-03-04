/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.pf.haupt;

/**
 *
 * @author user
 */
public class Benutzer {

    private int benutzerId;
    private String benutzerVollName;
    private String rolle; //(Verwaltung =V/Projektleiter =P/Miotarbeiter = M))
    private String mail;
    private String telNummer;
    private String benutzerName;
    private String passwort;
    
    /*
    VerwaltungHandler-Klasse >> benutzerHinzufuegen(Benutzer benutzer)
    VJFrameMitarbeiterTabelle-Klasse>>jButtonBenutzerHinzufuegenActionPerformed
    */
    public Benutzer(String benutzerVollName, String rolle, String mail, String 
            telNummer, String benutzerName, String passwort) {
        this.benutzerVollName = benutzerVollName;
        this.rolle = rolle;
        this.mail = mail;
        this.telNummer = telNummer;
        this.benutzerName = benutzerName;
        this.passwort = passwort;
    }
    /*
    VerwaltungHandler-Klasse >> benutzerBearbeiten(Benutzer benutzer)
    VerwaltungHandler-Klasse >> gettAllMitarbeiter()
    VJFrameMitarbeiterTabelle-Klasse >> jButtonBearbeitenActionPerformed
    */
    public Benutzer(int benutzerId, String benutzerVollName, String rolle, 
            String mail, String telNummer,
            String benutzerName, String passwort) {
        this.benutzerId = benutzerId;
        this.benutzerVollName = benutzerVollName;
        this.rolle = rolle;
        this.mail = mail;
        this.telNummer = telNummer;
        this.benutzerName = benutzerName;
        this.passwort = passwort;
    }

    public String getBenutzerVollName() {
        return benutzerVollName;
    }

    public void setBenutzerVollName(String benutzerVollName) {
        this.benutzerVollName = benutzerVollName;
    }

    public int getBenutzerId() {
        return benutzerId;
    }

    public void setBenutzerId(int benutzerId) {
        this.benutzerId = benutzerId;
    }

    public String getBenutzerName() {
        return benutzerName;
    }

    public void setBenutzerName(String benutzerName) {
        this.benutzerName = benutzerName;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelNummer() {
        return telNummer;
    }

    public void setTelNummer(String telNummer) {
        this.telNummer = telNummer;
    }

}
