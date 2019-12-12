/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.math.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author r0618859
 */
@Stateless
public class Boon implements BoonLocal {
    
    @PersistenceContext 
    private EntityManager em;
    
    public List getAlleMachines(){
         List ml = em.createNamedQuery("Machine.findAll").getResultList();
         return ml;
   }
    
   public List getAlleReservaties(){
       List rl = em.createNamedQuery("Reservatie.findAll").getResultList();
       return rl;
   }
   
   public String getDocentOpleiding(String dnrStr){
        BigDecimal dnr = new BigDecimal(dnrStr);
        Docenten d = em.find(Docenten.class,dnr);
        String onaam = d.getOpleiding().getNaam();
        return onaam;
   } 
    
   public void machineToevoegen(String mnaam, String beschrijf,String lokaal, String opleiding, String snrStr, String aankoopStr, String huurStr){
       Machine m = new Machine();
       BigDecimal snr = new BigDecimal(snrStr);
       BigInteger aankoopprijs = new BigInteger(aankoopStr);
       BigInteger huurprijs = new BigInteger(huurStr);
       
       m.setNaam(mnaam);
       m.setBeschrijving(beschrijf);
       m.setLokaal(lokaal);
       Opleiding o = em.find(Opleiding.class,opleiding);
       m.setOpleiding(o);
       m.setReservatieCollection(null); //nog geen reservaties
       m.setSerienr(snr);
       m.setAankoopprijs(aankoopprijs);
       m.setUurprijs(huurprijs);
       em.persist(m);//toevoegen bij objecten->tabellen
       
       
   }
   
   public Machine zoekMachine(String snrStr){
       BigDecimal snr = new BigDecimal(snrStr);
       Machine mach = em.find(Machine.class,snr);
       return mach;
   }
   
   public void wijzigMachine(String snrStr, String mnaam, String beschrijf,String lokaal, String opleiding, String aankoopStr, String huurStr){
       BigDecimal snr = new BigDecimal(snrStr);
       Machine m = em.find(Machine.class,snr); 
       BigInteger aankoopprijs = new BigInteger(aankoopStr);
       BigInteger huurprijs = new BigInteger(huurStr);
       
       m.setNaam(mnaam);
       m.setBeschrijving(beschrijf);
       m.setLokaal(lokaal);
       Opleiding o = em.find(Opleiding.class,opleiding);
       m.setOpleiding(o);
       m.setReservatieCollection(null); //nog geen reservaties
       m.setSerienr(snr);
       m.setAankoopprijs(aankoopprijs);
       m.setUurprijs(huurprijs);
       em.persist(m);
   }
   
   public List getVrijeReservatiesVanMachine(String snrStr){
       BigDecimal snr = new BigDecimal(snrStr);
       Machine m = em.find(Machine.class,snr);
       List  vrije  =  em.createQuery("SELECT r FROM Reservatie r WHERE r.serienr = :mach AND r.beschikbaar ='j' ").setParameter("mach",m).getResultList();
       return vrije;
   }
   
   public List getAlleReservatiesVanMachine(String snrStr){
       BigDecimal snr = new BigDecimal(snrStr);
       Machine m = em.find(Machine.class,snr);
       List  res  =  em.createQuery("SELECT r FROM Reservatie r WHERE r.serienr = :mach ").setParameter("mach",m).getResultList();
       return res;
   }
   
   public void reserveerMachine(String rnrStr, String naam ){
       BigDecimal rnr = new BigDecimal(rnrStr);
       BigDecimal gebruikersnaam = new BigDecimal(naam);
       Reservatie r = em.find(Reservatie.class,rnr);
       Secgebruikers u = em.find(Secgebruikers.class,gebruikersnaam);
       r.setHuurder(u);
       r.setBeschikbaar("n");
       em.persist(r);
       
   }
   
   public void reservatieMomentToevoegen(String datum, String startuur, String einduur, String mserienr){
       Reservatie r = new Reservatie();
       BigDecimal snr = new BigDecimal(mserienr);
       BigInteger start = new BigInteger(startuur);
       BigInteger eind = new BigInteger(einduur);
       
       //zoek hoogste rnr voor nieuwe aan te maken
       BigDecimal rnrmax  = (BigDecimal) em.createQuery("SELECT max(rr.rnr) FROM Reservatie rr").getSingleResult();
       
       SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       Date d = null;
        try {
            d = df.parse(datum);
            r.setDatum(d);
        } catch (ParseException ex) {
            Logger.getLogger(Boon.class.getName()).log(Level.SEVERE, null, ex);
        }
       
 
       r.setStartuur(start);
       r.setEinduur(eind);
       
       Machine m = em.find(Machine.class,snr);
       r.setSerienr(m);
       
       //een nieuw reservatie moment heeft geen huurder en is beschikbaar
       r.setBeschikbaar("j");
       //geen huurder
       //r.setHuurder(null);
     
       em.persist(r);//toevoegen bij objecten->tabellen
       
       
   }

}
