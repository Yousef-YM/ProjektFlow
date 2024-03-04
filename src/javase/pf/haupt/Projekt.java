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
public class Projekt {

    private int projektId;
    private String projektName;
    private int projektleiterId;
    private String projektleiterName;
    private Date erstellungDatum;
    private Date endzeitraumDatum;

    //VerwaltungHandler-Klasse >> getAllProjekte()
    public Projekt(int projektId, String projektName, int projektleiterId, 
            Date erstellungDatum, Date endzeitraumDatum) {
        this.projektId = projektId;
        this.projektName = projektName;
        this.projektleiterId = projektleiterId;
        this.erstellungDatum = erstellungDatum;
        this.endzeitraumDatum = endzeitraumDatum;
    }

    //Projektleiter-Klasse >> getProjektByProjektLeiterId(int projektleiterId)
    public Projekt(int projektId, String projektName, Date erstellungDatum, 
            Date endzeitraumDatum) {
        this.projektId = projektId;
        this.projektName = projektName;
        this.erstellungDatum = erstellungDatum;
        this.endzeitraumDatum = endzeitraumDatum;
    }

    //MitarbeiterHandler-Klasse >> getProjektByMitarbeiterId(int mitarbeiterId)
    public Projekt(int projektId, String projektName, int projektleiterId, 
            String projektleiterName) {
        this.projektId = projektId;
        this.projektName = projektName;
        this.projektleiterId = projektleiterId;
        this.projektleiterName = projektleiterName;
    }

    public String getProjektleiterName() {
        return projektleiterName;
    }

    public void setProjektleiterName(String projektleiterName) {
        this.projektleiterName = projektleiterName;
    }

    public int getProjektId() {
        return projektId;
    }

    public void setProjektId(int projektId) {
        this.projektId = projektId;
    }

    public String getProjektName() {
        return projektName;
    }

    public void setProjektName(String projektName) {
        this.projektName = projektName;
    }

    public int getProjektleiterId() {
        return projektleiterId;
    }

    public void setProjektleiterId(int projektleiterId) {
        this.projektleiterId = projektleiterId;
    }

    public Date getErstellungDatum() {
        return erstellungDatum;
    }

    public void setErstellungDatum(Date erstellungDatum) {
        this.erstellungDatum = erstellungDatum;
    }

    public Date getEndzeitraumDatum() {
        return endzeitraumDatum;
    }

    public void setEndzeitraumDatum(Date endzeitraumDatum) {
        this.endzeitraumDatum = endzeitraumDatum;
    }

}
