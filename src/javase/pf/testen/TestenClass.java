/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.pf.testen;

import java.util.ArrayList;
import static javase.pf.handler.MitarbeiterHandler.getProjektByMitarbeiterId;
import static javase.pf.handler.VerwaltungHandler.aufgabeBeschreibungBayAufgabeId;
import javase.pf.haupt.Projekt;

/**
 *
 * @author user
 */
public class TestenClass {
    
    public static void main(String[] args) {
        
        //-----------MitarbeiterHandler-------------------------------------------------------------------------
          /*
        //Anfrage erstellen test----------------
        Anfrage anfrage = new Anfrage(21, 41, "Anfrage von der Mitarbeiterin Mari");
        anfrageAnProjektleiterErstellen(anfrage);
         */

 /*
        // getAlleAufgaben
        ArrayList<Aufgaben> aufgabeList = getAufgabenByMitarbeiterId(25);

        for(Aufgaben a : aufgabeList){
            System.out.println("AufgabenID: " + a.getAufgabeId());
            System.out.println("MitarbeiterID: " + a.getMitarbeiterId());
            System.out.println("ProjektID: " + a.getProjektId());
            System.err.println("Mitarbeiter: "+a.getMitarbeiterName());
            System.out.println("Erstellungsdatum: " + a.getErstellungDatum());
            System.out.println("Zeitraum Tage: " + a.getZeitraumTage());
            System.out.println("Status: " + a.getStatus());
            System.out.println("Beschreibung: " + a.getBeschreibung());
            System.out.println("--------------------------------------");   
        }
         */
 /*
        //Status ändern-----------------------
        Aufgaben aufgaben = new Aufgaben(22, 25);
        statusAufgabeAndern(aufgaben);
         */
 /*
        //getProjekteByMitarbeiterId
        ArrayList<Projekt> pList = getProjektByMitarbeiterId(25);

        for (Projekt p : pList) {
            System.out.println("ProjektId = " + p.getProjektId());
            System.out.println("Projektname = " + p.getProjektName());
            System.out.println("Projektleiter ID = " + p.getProjektleiterId());
            System.out.println("Projektleiter Name = " + p.getProjektleiterName());
            System.out.println("-----------------------------------------");

        }
        ------------------*/
 
 //----------------ProjektleiterHandler--------------------------------------------------------------------
 

        /*
        --getBy
        ArrayList<Projekt> pList = getProjektByProjektLeiterId(2);
        
        for(Projekt p : pList){
            System.out.println("ProjektId = "+p.getProjektId());               
            System.out.println("Projektname = " + p.getProjektName());
            System.out.println("ErstellDatum = "+p.getEndzeitraumDatum());
            System.out.println("EndZeitraumDatum = "+p.getEndzeitraumDatum());
            System.out.println("-----------------------------------------");
        }
        ------------------------*/
 /*
        //erstelleAufgabe
        Aufgaben neu = new Aufgaben
        (82, 121, 62, 30, "hier ist die Beschreibung für nil 121");
        neueAufgabeErstellen(neu);
     ------------------------*/
 /*

 /*  
        ArrayList<Aufgaben> aufgabeList = getAufgabenByProjektleiterID(21);

        for(Aufgaben a : aufgabeList){
            System.out.println("AufgabenID: " + a.getAufgabeId());
            System.out.println("MitarbeiterID: " + a.getMitarbeiterId());
            System.out.println("ProjektID: " + a.getProjektId());
            System.err.println("Mitarbeiter: "+a.getMitarbeiterName());
            System.out.println("Erstellungsdatum: " + a.getErstellungDatum());
            System.out.println("Zeitraum Tage: " + a.getZeitraumTage());
            System.out.println("Status: " + a.getStatus());
            System.out.println("Beschreibung: " + a.getBeschreibung());
            System.out.println("--------------------------------------");   
        }
            
     --------------------------*/
 /*
 //Anfrage erstellen---------------------------------
 
        Anfrage anfrage = new Anfrage(21, "neu Mitarbeiter finden");
        anfrageAnVerwaltungErstellen(anfrage);
         */
 /*
 //------------ getAnfrageVonMitarbeiter
 
 ArrayList<Anfrage> anfrage = getAnfragenVonMitarbeiter(21);
 
            for(Anfrage a : anfrage){
            System.out.println("AufgabenID: " + a.getAnfrageId());
            System.out.println("MitarbeiterID: " + a.getMitarbeiterId());
            System.err.println("Mitarbeiter Name: "+a.getMitarbeiterName());
            System.out.println("Nachricht: " + a.getNachricht());
            System.out.println("Erstellungsdatum: " + a.getErstellDatum());
            
            System.out.println("--------------------------------------");  
            }
         */
 
 // VerwaltungHandler-------------------------------------------------------------------------------------------------
 
  /* 
        // benutzerHinzufügen
         VerwaltungHandler v = new VerwaltungHandler
        ("Mari Müller", "Mari", "Mari", "M", 
                "mari@hotmail", "000999");
         benutzerHinzufuegen(v);
       -----------------*/

 /*
        //benutzerBearbeiten
        VerwaltungHandler verwalter = new VerwaltungHandler
        ("Paul", "Paul", "P", "paul@gmail.com", "222111", 2);
        benutzerBearbeiten(verwalter);
        -----------------*/
 /*
        //benutzerLoeschen
        benutzerLoeschen(24);
        -----------------*/
 /* 
        //getAllBenutzer
        ArrayList<Benutzer> be = gettAllMitarbeiter();
        for(Benutzer b : be){
            System.out.println("Id : "+b.getBenutzerId());
            System.out.println("VollName : "+b.getBenutzerVollName());
            System.out.println("Rolle : "+b.getRolle());
            System.out.println("Mail : "+b.getMail());
            System.out.println("Tel.Nummer : "+b.getTelNummer());
            System.out.println("BenutzerName : "+b.getBenutzerName());
            System.out.println("Passwort : "+b.getPasswort());
            
        }
       -----------------*/
 /* 
        //getAllAufgaben
         ArrayList<Aufgaben> aufgabenListe = getAllAufgaben();

        for (Aufgaben aufgabe : aufgabenListe) {
            System.out.println("AufgabenID: " + aufgabe.getAufgabeId());
            System.out.println("ProjektID: " + aufgabe.getProjektId());
            System.out.println("Projektname: " + aufgabe.getProjektName());
            System.out.println("ProjektleiterID: " + aufgabe.getProjektleiterId());
            System.out.println("ProjektleiterName: " + aufgabe.getProjektleiterName());
            System.out.println("MitarbeiterID: " + aufgabe.getMitarbeiterId());
            System.out.println("MitarbeiterName: " + aufgabe.getMitarbeiterName());
            System.out.println("Zeitraum Tage: " + aufgabe.getZeitraumTage());
            System.out.println("Erstellungsdatum: " + aufgabe.getErstellungDatum());
            System.out.println("Status: " + aufgabe.getStatus());
            System.out.println("Beschreibung: " + aufgabe.getBeschreibung());
            System.out.println("-------------------------");
        }

------------------------*/
 /*
 //Alle Anfrage-----------
        ArrayList<Anfrage> anfrageList = getAnfragenVonProjektleiter();
        
        for (Anfrage anfrage : anfrageList) {
            System.out.println("Anfrage ID: " + anfrage.getAnfrageId());
            System.out.println("Projektleiter ID: " + anfrage.getProjektleiterId());
            System.out.println("Projektleiter name : "+anfrage.getProjektleiterName());
            System.out.println("Nachricht: " + anfrage.getNachricht());
            System.out.println("Erstellungsdatum : "+anfrage.getErstellDatum());
            System.out.println("----------------------");
        }
         */
 /* 
        --gettAllProjekte
 
        ArrayList<Projekt> proList = getAllProjekte();
        
        for(Projekt pro : proList){
            System.out.println("ProjektId = "+pro.getProjektId());               
            System.out.println("Projektname = " + pro.getProjektName());
            System.out.println("ErstellDatum = "+pro.getEndzeitraumDatum());
            System.out.println("ProjektleiterId = "+pro.getProjektleiterId());
            System.out.println("EndZeitraumDatum = "+pro.getEndzeitraumDatum());
            System.out.println("------------------------------------");
                   }
         
        String beschreibung = aufgabeBeschreibungBayAufgabeId(21);
        System.out.println(beschreibung);
        */
 
 
 
    }
    
}
