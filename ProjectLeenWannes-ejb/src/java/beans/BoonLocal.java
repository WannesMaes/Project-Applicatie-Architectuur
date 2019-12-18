/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leen
 */
@Local
public interface BoonLocal {
   public List getAlleMachines();
   public String getDocentOpleiding(String dnrStr);
   public void machineToevoegen(String mnaam, String beschrijf,String lokaal, String opleiding, String snrStr, String aankoopStr, String huurStr);
   public Machine zoekMachine(String snrStr);
   public void wijzigMachine(String snrStr, String mnaam, String beschrijf,String lokaal, String opleiding, String aankoopStr, String huurStr);
   public List getVrijeReservatiesVanMachine(String snrStr);
   public List getAlleReservatiesVanMachine(String snrStr);
   public void reserveerMachine(String rnrStr, String naam );
   public List getAlleReservaties();
   public void reservatieMomentToevoegen(String datum, String startuur, String einduur, String mserienr);
   public String GetOpleiding(String snrStr);
}
