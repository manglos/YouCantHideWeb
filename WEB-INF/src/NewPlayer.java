/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import youcanthide.*;

/**
 *
 * @author Christopher Manglos
 */
@WebServlet(name = "NewPlayer", urlPatterns = {"/NewPlayer"})
public class NewPlayer extends HttpServlet {
    
    String title="New Player Sign-in";
    String debug="";
    LeaderBoard currentLeaderBoard = new LeaderBoard();
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse 
            response) throws ServletException, IOException {
        
        debug="";
        RequestDispatcher dispatcher = request.getRequestDispatcher("newplayer.jsp?debug="+debug);
        dispatcher.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        Database db = new Database();
        
        String fn, ln, un, pw, pwc, pn;
        int x=0;
        boolean on = false;
        boolean inGame=false;
        fn=null;
        ln=null;
        un=null;
        pw=null;
        pwc=null;
        pn=null;
        debug="";
        
        if(request.getParameter("firstName")!=null){
            fn=request.getParameter("firstName");
        }
        if(request.getParameter("lastName")!=null){
            ln=request.getParameter("lastName");
        }
        if(request.getParameter("userName")!=null){
            un=request.getParameter("userName");
        }
        if(request.getParameter("password")!=null){
            pw=request.getParameter("password");
        }
        if(request.getParameter("password-confirm")!=null){
            pwc=request.getParameter("password-confirm");
        }        
        if(request.getParameter("phoneNumber")!=null){
            pn=request.getParameter("phoneNumber");
        }
        if(request.getParameter("xp")!=null){
            x=Integer.parseInt(request.getParameter("xp"));
        }
        if(request.getParameter("ingame")!=null){
            if(!request.getParameter("ingame").equals("0")){
                inGame=true;
            }
            else{
                inGame=false;
            }
        }
        Player p = new Player(fn, ln, un, pw, pn, x, on);
        CurrentlyPlaying cp= new CurrentlyPlaying(10);
        
        if(inGame){
            cp.addPlayer(p);
            cp.sortBy("xp");
        }
        
        if(!pw.equals(pwc)){
            debug="Passwords do not match!";
            p=null;
        }
        if(db.getPlayerByUsername(un)!=null){
            debug="Username "+un+" is already in use, please choose another.";
            p=null;
        }
        
        if(p!=null){
            Database.getList().add(p);
            new LeaderBoard().addPlayer(p);
            LeaderBoard.sortBy("xp");
            request.getSession().setAttribute("user", p);
            dispatcher = request.getRequestDispatcher("ProfileControl?un="+p.getUsername()+"&amp;mode=full.jsp");
        }
        else
            dispatcher = request.getRequestDispatcher("newplayer.jsp?debug="+debug);
        
        dispatcher.forward(request, response);
        
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
}
