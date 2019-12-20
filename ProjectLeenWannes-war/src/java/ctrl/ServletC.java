/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author r0618859
 */
public class ServletC extends HttpServlet {
    
    @EJB
    private BoonLocal boon;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println("*********" + request.getUserPrincipal().getName());
        String user = request.getUserPrincipal().getName();
        getServletContext().setAttribute("user",user);
        RequestDispatcher view = null;
            if(request.isUserInRole("rolExtern")){
                view = request.getRequestDispatcher("extern.jsp");
                
            }
            else {
            
                if(request.isUserInRole("rolDocent")){
                    //stuurt docenten door naar overzicht voor docenten
                    view = request.getRequestDispatcher("docent.jsp");
                }
                else{
                    if(request.isUserInRole("rolStudent")){
                        view = request.getRequestDispatcher("student.jsp");
                    }
                    else{
                        view = request.getRequestDispatcher("loginError.jsp");
                    }
                }
            }
           
            view.forward(request,response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = null;
        String serieNrStr,uurprijsStr;
        int serienr,rnr,uurprijs,huurprijs;
        String mnaam,mbeschrijf,mlokaal, mopleiding,maankoop, mhuur, msnr;
        String usr = (String)getServletContext().getAttribute("user");
        Machine mach;
        List lm, lrv,larm,mrv,prijzen;
        String rnrStr;
        
        switch(request.getParameter("waarKomIkVan")){
            //DOCENTEN
            case "vanDocentOverzichtNaarDocentDetail":
                    serieNrStr = request.getParameter("serienr");
                    serienr = Integer.parseInt(serieNrStr);
                    getServletContext().setAttribute("sr",serienr);
                    String opleiding = boon.getDocentOpleiding( usr);
                    getServletContext().setAttribute("dop",opleiding);
                    view = request.getRequestDispatcher("docentDetail.jsp");
                    break;
            case "vanDocentOverzichtNaarDocentReservatie":
                    serieNrStr = request.getParameter("serienr");
                    String opleidingR = boon.GetOpleiding(serieNrStr);
                    getServletContext().setAttribute("opl",opleidingR);
                    serienr = Integer.parseInt(serieNrStr);
                    getServletContext().setAttribute("sr",serienr);
                    larm = boon.getAlleReservatiesVanMachine( serieNrStr);
                    getServletContext().setAttribute("larm",larm);
                    String opleiding2 = boon.getDocentOpleiding( usr);
                    getServletContext().setAttribute("dop",opleiding2);
                    view = request.getRequestDispatcher("docentreservatie.jsp");
                    break;
            case "vanDocentReservatieNaarReservatieToevoegen":
                    view = request.getRequestDispatcher("reservatietoevoegen.jsp");
                    break;
            case "vanReservatieMomentToevoegenNaarDocentReservatie":
                    String sr = Integer.toString((int) getServletContext().getAttribute("sr"));
                    String rdatum = request.getParameter("rdatum");
                    String rstart = request.getParameter("rstart");
                    String reind = request.getParameter("reind");
                    boon.reservatieMomentToevoegen( rdatum, rstart,  reind,  sr);
                    larm = boon.getAlleReservatiesVanMachine( sr);// update reservatie lijst van machine
                    getServletContext().setAttribute("larm",larm);
                    view = request.getRequestDispatcher("docentreservatie.jsp");
                    break;
            case "vanDocentOverzichtNaarMachineToevoegen":
                    view = request.getRequestDispatcher("machinetoevoegen.jsp");
                    break;
            case "vanMachineToevoegenNaarDocentOverzicht":
                    mnaam = request.getParameter("mnaam");
                    mbeschrijf = request.getParameter("mbeschrijving");
                    mlokaal = request.getParameter("mlokaal");
                    mopleiding = request.getParameter("mopleiding"); 
                    msnr = request.getParameter("mserienr");
                    maankoop = request.getParameter("maankoopprijs");
                    mhuur = request.getParameter("muurprijs");
                    boon.machineToevoegen(mnaam, mbeschrijf, mlokaal, mopleiding, msnr, maankoop, mhuur);
                    lm= boon.getAlleMachines();
                    getServletContext().setAttribute("lm",lm);// na toevoegen lijst updaten.
                    view = request.getRequestDispatcher("docent.jsp");
                    break;
            case "vanDocentDetailNaarMachineWijzigen":
                    serieNrStr = request.getParameter("serienr");
                    serienr = Integer.parseInt(serieNrStr);
                    getServletContext().setAttribute("sr",serienr);
                    mach = boon.zoekMachine(serieNrStr);
                    getServletContext().setAttribute("machine", mach);
                    view = request.getRequestDispatcher("machinewijzigen.jsp");
                    break;
            case "vanMachineWijzigenNaarMachineDocentOverzicht":
                    mnaam = request.getParameter("mnaam");
                    mbeschrijf = request.getParameter("mbeschrijving");
                    mlokaal = request.getParameter("mlokaal");
                    mopleiding = request.getParameter("mopleiding"); 
                    msnr = request.getParameter("mserienr");
                    maankoop = request.getParameter("maankoopprijs");
                    mhuur = request.getParameter("muurprijs");
                    boon.wijzigMachine(msnr, mnaam, mbeschrijf, mlokaal, mopleiding, maankoop, mhuur);
                    lm= boon.getAlleMachines();
                    getServletContext().setAttribute("lm",lm);
                    view = request.getRequestDispatcher("docent.jsp");
                    break;
                
           
            //STUDENTEN  
            case "vanStudentOverzichtNaarStudentDetail":
                serieNrStr = request.getParameter("serienr");
                serienr = Integer.parseInt(serieNrStr);
                getServletContext().setAttribute("sr",serienr);
                view = request.getRequestDispatcher("studentDetail.jsp");
                break;   

            case "vanStudentOverzichtNaarStudentReservatie":
                serieNrStr = request.getParameter("serienr");
                serienr = Integer.parseInt(serieNrStr);
                getServletContext().setAttribute("sr",serienr);
                lrv = boon.getVrijeReservatiesVanMachine(serieNrStr);
                getServletContext().setAttribute("lrv",lrv);
                view = request.getRequestDispatcher("studentreservatie.jsp");
                break;   
            case "vanStudentReservatieNaarStudentBevestiging":
                rnrStr = request.getParameter("resnr");
                usr = (String)getServletContext().getAttribute("user");
                boon.reserveerMachine(rnrStr, usr );
                view = request.getRequestDispatcher("student.jsp");
                break;
            //EXETERNEN
            case "vanExternOverzichtNaarExternDetail":
                serieNrStr = request.getParameter("serienr");
                serienr = Integer.parseInt(serieNrStr);
                getServletContext().setAttribute("sr",serienr);
                view = request.getRequestDispatcher("externDetail.jsp");
                break;   
            case "vanExternOverzichtNaarExternReservatie":
                serieNrStr = request.getParameter("serienr");
                serienr = Integer.parseInt(serieNrStr);
                getServletContext().setAttribute("sr",serienr);
                uurprijsStr = request.getParameter("uprijs");
                uurprijs = Integer.parseInt(uurprijsStr);
                getServletContext().setAttribute("up",uurprijs);
                lrv = boon.getVrijeReservatiesVanMachine(serieNrStr);
                getServletContext().setAttribute("lrv",lrv);
                view = request.getRequestDispatcher("externReservatie.jsp");
                break;
            case "vanExternReservatieNaarExternMijnReservaties":
                rnrStr = request.getParameter("resnr");
                usr = (String)getServletContext().getAttribute("user");
                boon.reserveerMachine(rnrStr, usr );
                mrv = boon.getMijnReservaties(usr);
                getServletContext().setAttribute("mrv",mrv);
                huurprijs = boon.getReservatiePrijs(rnrStr);
                getServletContext().setAttribute("rpr",huurprijs);
                uurprijs = boon.getUurprijs(rnrStr);
                getServletContext().setAttribute("upr",uurprijs);
                prijzen = boon.getUurprijzen(mrv);
                getServletContext().setAttribute("lpr",prijzen);
                
                view = request.getRequestDispatcher("externMijnReservaties.jsp");
                break;
            case "vanExternMijnReservatiesNaarExternMijnReservaties":
                rnrStr = request.getParameter("resnr");
                usr = (String)getServletContext().getAttribute("user");
                boon.AnnuleerReservatie(rnrStr);
                mrv = boon.getMijnReservaties(usr);
                getServletContext().setAttribute("mrv",mrv);
                huurprijs = boon.getReservatiePrijs(rnrStr);
                getServletContext().setAttribute("rpr",huurprijs);
                uurprijs = boon.getUurprijs(rnrStr);
                getServletContext().setAttribute("upr",uurprijs);
                prijzen = boon.getUurprijzen(mrv);
                getServletContext().setAttribute("lpr",prijzen);
                view = request.getRequestDispatcher("externMijnReservaties.jsp");
                break;
            default : view = request.getRequestDispatcher("index.jsp");
                    break;
        }
        view.forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    @Override
    public void init(){
        List lm= boon.getAlleMachines();
        getServletContext().setAttribute("lm",lm);
        List lr= boon.getAlleReservaties();
        getServletContext().setAttribute("lr",lr);
    }

}
