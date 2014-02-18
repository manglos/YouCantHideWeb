/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import youcanthide.*;

/**
 *
 * @author montynewman
 */
@WebServlet(name = "RemoteRegistrationControl", urlPatterns = {"/RemoteRegistrationControl"})
public class RemoteRegistrationControl extends HttpServlet {
    static final int PORT = 1231;
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    String un, pw, fn, ln, pn;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServerSocket echoServer = null;
        String output="";
        String line;
        DataInputStream is;
        PrintStream os;
        Socket clientSocket = null;
        BufferedReader b=null;
 
        // Try to open a server socket on port 9999
        try {
           echoServer = new ServerSocket(4890);
        }
        catch (IOException e) {
           System.out.println(e);
        }   
        // Create a socket object from the ServerSocket to listen and accept 
        // connections.
        // Open input and output streams

        try {
            clientSocket = echoServer.accept();
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());
            b = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
 
            // As long as we receive data, echo that data back to the client.
            line = b.readLine();
            while (line!=null && !line.equals("system:exit")) {  
                System.out.println("heres the line" + line);
                parseLine(line);
                
                if(createPlayer()){
                    System.out.println("Player Created Successfully!");
                }
                else{
                    System.out.println("Player could not be created");
                }
                    
             Player p = Database.getPlayerByUsername(un);
             System.out.println(p);
             os.println(line);
             line = b.readLine();
            }
            b.close();
            
        }   
        catch (IOException e) {
           System.out.println(e);
        }
    }
    
    void parseLine(String l){
        
        String v[];
        
        v = l.split("-");
        
        for(int i=0; i<v.length;i++)
            System.out.println(v[i]);
        
        un = v[0];
        pw = v[1];
        fn = v[2];
        ln = v[3];
        pn = v[4];
        
    }
    
    public boolean createPlayer(){
        
        Player x = new Player(fn, ln, un, pw, pn, 0, true);;
        Database db=new Database();
        LeaderBoard lb=new LeaderBoard();
        
        if(db.addPlayer(x)){
            lb.addPlayer(x);
            return true;
        }
        
        return false;
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
        processRequest(request, response);
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
