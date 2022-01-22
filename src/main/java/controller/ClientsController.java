package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.Client;
 
import service.ClientService;

/**
 * Servlet implementation class Clinet
 */
@WebServlet(name = "ClientsController", urlPatterns = { "/ClientsController" })
public class ClientsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientService ms = new ClientService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Client> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
			} else if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				ms.delete(ms.findById(id));
				response.setContentType("application/json");
				List<Client> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
			} else if (request.getParameter("op").equals("accept")) {

				int id = Integer.parseInt(request.getParameter("id"));
				
				boolean a = ms.accept(id);	
				response.setContentType("application/json");
				List<Client> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));

			} else if (request.getParameter("op").equals("disable")) {

				int id = Integer.parseInt(request.getParameter("id"));
				
				boolean a = ms.disable(id);	
				response.setContentType("application/json");
				List<Client> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));

			}else if(request.getParameter("op").equals("login")) {
				String password =  request.getParameter("pass");
				String mail =  request.getParameter("login");
				//System.out.println(password);
				Client client = ms.findUser(mail,password);
				 HttpSession session = request.getSession();
				  session.setAttribute("id",client.getId() );
				if(client.getId() == 0) {     
					response.sendRedirect("/Clients.jsp");
				}else if(client.getId() == -1) {
					response.sendRedirect("/login.jsp");
				}else {
				
					response.sendRedirect("/ClientInterface.jsp");
				}
				
			}
		} else {
			String password =  request.getParameter("password");
			String phone =  request.getParameter("phone");
			String mail =  request.getParameter("mail");
			String nom = request.getParameter("lname");
			String prenom =  request.getParameter("Fname");
			boolean a = ms.createUser(mail,password,new Client( nom, prenom,phone,"nonActive"));
		
			 response.setContentType("application/json");
				List<Client> ls = ms.findAll();
				Gson gson = new Gson();
				response.getWriter().write(gson.toJson(ls));
			
		}
	}

}
