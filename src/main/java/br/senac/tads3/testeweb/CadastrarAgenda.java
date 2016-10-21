/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.testeweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import jdk.nashorn.internal.objects.NativeArray;

/**
  * @author Sibele nepomuceno
 */
@WebServlet(name = "CadastrarAgenda", urlPatterns = {"/cadastrar-Agenda"})
public class CadastrarAgenda extends HttpServlet {

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
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet FormularioServlet</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet FormularioServlet at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String nome = request.getParameter("nome");
    String dtNascStr = request.getParameter("dtnasc");
    String Telefone = request.getParameter("Telefone");
    String email = request.getParameter("email");

    DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    Date dtNasc = null;
    
    try {
      dtNasc = formatador.parse(dtNascStr);
    } catch (ParseException ex) {
        System.out.println("data invalida");
    }
      
      ConexaoDerby con = new ConexaoDerby();
      
      con.Incluir(nome, dtNascStr, Telefone, email);
      
      ArrayList<Pessoa> lista = null;
      
      lista = con.Listar();
     
      request.setAttribute("listaPessoas", lista);
      request.getRequestDispatcher("MostrarAgenda.jsp").forward(request,response);
  }
  
  @Override
  public String getServletInfo() {
    return "Short description";
  }
}
