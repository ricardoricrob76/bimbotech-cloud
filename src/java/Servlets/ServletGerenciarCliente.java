/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.*;
import Conexao.*;
import Controlador.*;
import DAO.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ricardoricrob
 */
public class ServletGerenciarCliente extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
    } 

    // <editor-fold defaultstate="collapsed" desc="M�todos HttpServlet. Clique no sinal de + � esquerda para editar o c�digo.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        Fachada myFacade = new Fachada();
        Cliente myObj = new Cliente();
	int status = 0;

            List<Cliente> listagemgeral = new ArrayList<Cliente>();
            listagemgeral  = myFacade.listagemGeralCliente();
            if (listagemgeral!=null){
                for (Iterator<Cliente> it = listagemgeral.iterator(); it.hasNext();) {
                    Cliente municipio = it.next();
                    System.out.println("Listar cliente: " + municipio.getNome() );
                }

                request.getSession().setAttribute("listagemgeral",(Cliente[]) listagemgeral.toArray(new Cliente[0]));
                request.setAttribute("listagemgeral2",listagemgeral);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/list-gerenciar_cliente.jsp");
                rd.forward(request,response);
            }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       // processRequest(request, response);
        String pagDestino = "/OK.jsp";

        int codigofunc = Integer.parseInt(request.getParameter("idcli"));
        String nomefunc = request.getParameter("nomeclie");
        String emailfunc = request.getParameter("emailclie");
        String fonefunc = request.getParameter("foneclie");
        String assinantefunc = request.getParameter("assinanteclie");

        try {
                Fachada myFacade = new Fachada();
              //  List<Funcionario> lista = new ArrayList<Funcionario>();
                Cliente func = new Cliente();
                 // func.setIdfunc(codigofunc);
                  func.setNome(nomefunc);
                  func.setEmail(emailfunc);
                  func.setFone(fonefunc);
                  func.setAssinante(assinantefunc);

               int comando = myFacade.inserirCliente(func);

               if (comando > 0){
                  System.out.println("Dados Gravados com Sucesso!!!");
                  request.setAttribute("lista","Dados Gravados com Sucesso!!!");

               } else {
                  System.out.println("N�o foi Possivel Incluir o Cliente !!!");
                  request.setAttribute("lista","N�o foi Possivel Incluir o Cliente !!!");
               }
              }
               catch (Exception e) {
                         System.out.println("Erro ao Inserir no Banco de Dados.");
                }
               finally{
                   RequestDispatcher rd = getServletContext().getRequestDispatcher(pagDestino);
                   rd.forward(request, response);
                 
                }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
