/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.pf.haupt;

import java.util.Date;

/**
 *
 * @author user
 */
public class Anfrage {

    private int anfrageId;
    private int projektleiterId;
    private String projektleiterName;
    private int mitarbeiterId;
    private String mitarbeiterName;
    private String nachricht;
    private Date erstellDatum;

    
    //JFrameAnfragenProjektleiter-Klasse >> jButtonErstellenActionPerformed
    public Anfrage(int projektleiter, String nachricht) {
        this.projektleiterId = projektleiter;
        this.nachricht = nachricht;
    }

    //JFrameAnfrageMitarbeiter-Klasse >> jButtonErstellenActionPerformed
    public Anfrage(int projektleiterId, int mitarbeiterId, String nachricht) {
        this.projektleiterId = projektleiterId;
        this.mitarbeiterId = mitarbeiterId;
        this.nachricht = nachricht;
    }

    /*
    Projektleiter-Klasse >> getErstellteAnfragenAnVerwaltung(int projektleiterId)
    MitarbeiterHandler-Klasse >> getErstellteAnfragenAnProjektleiter(int mitarbeiterId)
    */
    public Anfrage(int anfrageId, String nachricht, Date erstellDatum) {
        this.anfrageId = anfrageId;
        this.nachricht = nachricht;
        this.erstellDatum = erstellDatum;
    }

    /*
    Verwaltung-Klasse >> getAlleAnfragenVonProjektleiter() 
    Projektleiter-Klasse >> getAnfragenVonMitarbeiter(int projektleiterId)
    */
    public Anfrage(int anfrageId, int projektleiterId, String projektleiterName, String nachricht, Date erstellDatum) {
        this.anfrageId = anfrageId;
        this.projektleiterId = projektleiterId;
        this.projektleiterName = projektleiterName;
        this.nachricht = nachricht;
        this.erstellDatum = erstellDatum;
    }

    public String getMitarbeiterName() {
        return mitarbeiterName;
    }

    public void setMitarbeiterName(String mitarbeiterName) {
        this.mitarbeiterName = mitarbeiterName;
    }

    public String getProjektleiterName() {
        return projektleiterName;
    }

    public void setProjektleiterName(String projektleiterName) {
        this.projektleiterName = projektleiterName;
    }

    public Date getErstellDatum() {
        return erstellDatum;
    }

    public void setErstellDatum(Date erstellDatum) {
        this.erstellDatum = erstellDatum;
    }

    public int getAnfrageId() {
        return anfrageId;
    }

    public void setAnfrageId(int anfrageId) {
        this.anfrageId = anfrageId;
    }

    public int getProjektleiterId() {
        return projektleiterId;
    }

    public void setProjektleiterId(int projektleiterId) {
        this.projektleiterId = projektleiterId;
    }

    public int getMitarbeiterId() {
        return mitarbeiterId;
    }

    public void setMitarbeiterId(int mitarbeiterId) {
        this.mitarbeiterId = mitarbeiterId;
    }

    public String getNachricht() {
        return nachricht;
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
    }

}
