/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.math.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
   public List getMijnReservaties(String usrStr)
   {
       BigDecimal usr = new BigDecimal(usrStr);
       List res = em.createQuery("SELECT r FROM Reservatie r WHERE r.huurder.gebruikersnaam = :match").setParameter("match", usr).getResultList();
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
   public void AnnuleerReservatie(String rnrStr)
   {
       BigDecimal rnr = new BigDecimal(rnrStr);
       Reservatie r = em.find(Reservatie.class,rnr);
       r.setHuurder(null);
       r.setBeschikbaar("j");
       em.persist(r);
       
   }
   public int getReservatiePrijs(String rnrStr)
   {
        BigDecimal rnr = new BigDecimal(rnrStr);
        int startuur=0;
        int einduur=0;
        int prijs=0;
        List start = em.createNamedQuery("Reservatie.findByRnr").setParameter("rnr", rnr).getResultList();
        if (!start.isEmpty())
        {
            startuur = ((BigInteger)(((Reservatie)(start.get(0))).getStartuur())).intValue();
            einduur = ((BigInteger)(((Reservatie)(start.get(0))).getEinduur())).intValue();
            prijs = ((BigInteger)(((Machine)(((Reservatie)(start.get(0))).getSerienr())).getUurprijs())).intValue();
        }
       int uren = einduur-startuur;
       return uren*prijs;
   }
   public int getUurprijs(String rnrStr)
   {
        BigDecimal rnr = new BigDecimal(rnrStr);
        int prijs=0;
        List start = em.createNamedQuery("Reservatie.findByRnr").setParameter("rnr", rnr).getResultList();
        if (!start.isEmpty())
        {
            prijs = ((BigInteger)(((Machine)(((Reservatie)(start.get(0))).getSerienr())).getUurprijs())).intValue();
        }
       return prijs;
   }
   public List getUurprijzen(List reservaties)
   {
       List<Integer> prijzen = new ArrayList<Integer>();
       for (int i=0;i<reservaties.size();i++)
       {
           prijzen.add((int)(((Reservatie)(reservaties.get(i))).getSerienr().getUurprijs().intValue()));
       }
       return prijzen;
   }
   public void reservatieMomentToevoegen(String datum, String startuur, String einduur, String mserienr){
        Reservatie r = new Reservatie();
        BigDecimal snr = new BigDecimal(mserienr);
        BigInteger start = new BigInteger(startuur);
        BigInteger eind = new BigInteger(einduur);

        //zoek hoogste rnr voor nieuwe aan te maken en toevoegen
        BigDecimal rnrmax  = (BigDecimal)(em.createQuery("SELECT max(rr.rnr) FROM Reservatie rr").getSingleResult());
        int nieuwRnr = rnrmax.intValue();
        nieuwRnr += 1;
        BigDecimal RnrFormaat = new BigDecimal(nieuwRnr);
        r.setRnr(RnrFormaat);
        System.out.println("***************************************************************");
        System.out.println(RnrFormaat);
        System.out.println("***************************************************************");
        
        //Serienr opzoeken en toevoegen
        Machine m = em.find(Machine.class,snr);
        r.setSerienr(m);
        System.out.println("***************************************************************");
        System.out.println(m);
        System.out.println("***************************************************************");
        
        //Datum toevoegen aan tabel
        try 
        {
            //Date d = df.parse(datum);
            r.setDatum((new SimpleDateFormat("dd/MM/yyyy")).parse(datum));
            System.out.println("***************************************************************");
            System.out.println((new SimpleDateFormat("dd/MM/yyyy")).parse(datum));
            System.out.println("***************************************************************");
        } 
        catch (ParseException ex) 
        {
            Logger.getLogger(Boon.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        //Start en einduur toevoegen
        r.setStartuur(start);
        r.setEinduur(eind);

        //een nieuw reservatie moment heeft geen huurder en is beschikbaar
        r.setBeschikbaar("j");
        //geen huurder
        r.setHuurder(null);

        em.persist(r);//toevoegen bij objecten->tabellen
   }
   public String GetOpleiding(String snrStr)
   {
       BigDecimal snr = new BigDecimal(snrStr);
       Machine m = em.find(Machine.class,snr);
       return m.getOpleiding().getNaam();
   }
}
