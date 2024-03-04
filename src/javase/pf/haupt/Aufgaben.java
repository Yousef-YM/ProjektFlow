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
public class Aufgaben {

    private int aufgabeId;
    private int projektId;
    private String projektName;
    private int projektleiterId;
    private String projektleiterName;
    private int mitarbeiterId;
    private String mitarbeiterName;
    private Date erstellungDatum;
    private int zeitraumTage;
    private String status;
    private String beschreibung;

    //Verwaltung-Klasse >> getAllAufgaben()
    public Aufgaben(int aufgabeId, int projektId, String projektName, 
            int projektleiterId, String projektleiterName, int mitarbeiterId, 
            String mitarbeiterName, Date erstellungDatum, int zeitraumTage, 
            String status, String beschreibung) {
        this.aufgabeId = aufgabeId;
        this.projektId = projektId;
        this.projektName = projektName;
        this.projektleiterId = projektleiterId;
        this.projektleiterName = projektleiterName;
        this.mitarbeiterId = mitarbeiterId;
        this.mitarbeiterName = mitarbeiterName;
        this.erstellungDatum = erstellungDatum;
        this.zeitraumTage = zeitraumTage;
        this.status = status;
        this.beschreibung = beschreibung;
    }

//JFrameAufgabenMitarbeiter-Klasse>>jButtonAufgabeErledigenMarkierenActionPerformed
    public Aufgaben(int aufgabeId, int mitarbeiterId) {
        this.aufgabeId = aufgabeId;
        this.mitarbeiterId = mitarbeiterId;
    }
   
    //JFrameAufgabenProjektleiter >> jButtonErstellenActionPerformed
    public Aufgaben(int projektleiterId, int mitarbeiterId, int projektId, 
            int zeitraumTage, String beschreibung) {
        this.projektleiterId = projektleiterId;
        this.mitarbeiterId = mitarbeiterId;
        this.projektId = projektId;
        this.zeitraumTage = zeitraumTage;
        this.beschreibung = beschreibung;
    }

    //Projektleiter-Klasse >> getProjektByProjektLeiterId(int projektleiterId)
    public Aufgaben(int aufgabeId, int projektId, int mitarbeiterId, String benutzerVollName, Date erstellungDatum,
            int zeitraumTage, String status, String beschreibung) {
        this.aufgabeId = aufgabeId;
        this.mitarbeiterId = mitarbeiterId;
        this.projektId = projektId;
        this.mitarbeiterName = benutzerVollName;
        this.erstellungDatum = erstellungDatum;
        this.zeitraumTage = zeitraumTage;
        this.status = status;
        this.beschreibung = beschreibung;
    }

    //MitarbeiterHandler-Klasse >> getAufgabenByMitarbeiterId(int mitarbeiterId)
    public Aufgaben(int aufgabeId, int projektId, int projektleiterId,
            String projektleiterName, int zeitraumTage, String status,
            Date erstellungDatum) {
        this.aufgabeId = aufgabeId;
        this.projektId = projektId;
        this.projektleiterId = projektleiterId;
        this.projektleiterName = projektleiterName;
        this.zeitraumTage = zeitraumTage;
        this.status = status;
        this.erstellungDatum = erstellungDatum;
    }
    
        public String getProjektName() {
        return projektName;
    }

    public void setProjektName(String projektName) {
        this.projektName = projektName;
    }

    public String getProjektleiterName() {
        return projektleiterName;
    }

    public void setProjektleiterName(String projektleiterName) {
        this.projektleiterName = projektleiterName;
    }

    public String getMitarbeiterName() {
        return mitarbeiterName;
    }

    public void setMitarbeiterName(String mitarbeiterName) {
        this.mitarbeiterName = mitarbeiterName;
    }

    public int getAufgabeId() {
        return aufgabeId;
    }

    public void setAufgabeId(int aufgabeId) {
        this.aufgabeId = aufgabeId;
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

    public int getProjektId() {
        return projektId;
    }

    public void setProjektId(int projektId) {
        this.projektId = projektId;
    }

    public Date getErstellungDatum() {
        return erstellungDatum;
    }

    public void setErstellungDatum(Date erstellungDatum) {
        this.erstellungDatum = erstellungDatum;
    }

    public int getZeitraumTage() {
        return zeitraumTage;
    }

    public void setZeitraumTage(int zeitraumTage) {
        this.zeitraumTage = zeitraumTage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

}
