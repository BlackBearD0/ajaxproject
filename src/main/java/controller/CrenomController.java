package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Crenom;
import beans.*;
import service.ClientService;
import service.CrenomService;
import service.SalleService;
 

/**
 * Servlet implementation class CrenomController
 */
@WebServlet(name = "CrenomController", urlPatterns = { "/CrenomController" })
public class CrenomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CrenomService ms= new CrenomService();
	SalleService ss = new SalleService();
	ClientService cs = new  ClientService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrenomController() {
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
		 
				if (request.getParameter("op") != null) {
					if (request.getParameter("op").equals("load")) {
						response.setContentType("application/json");
						List<Crenom> ls = ms.findAll();
						Gson gson = new Gson();
						response.getWriter().write(gson.toJson(ls));
					} else if (request.getParameter("op").equals("delete")) {
						int id = Integer.parseInt(request.getParameter("id"));
						ms.delete(ms.findById(id));
						response.setContentType("application/json");
						List<Crenom> ls = ms.findAll();
						Gson gson = new Gson();
						response.getWriter().write(gson.toJson(ls));
					} else if (request.getParameter("op").equals("update")) {

						int id = Integer.parseInt(request.getParameter("id"));
						String HeureDebut = request.getParameter("heureD");
						String HeureFin =  request.getParameter("heureF");
						String date =  request.getParameter("date");
						 
						ms.update(new Crenom(id, HeureDebut, HeureFin,null,null,date));
						response.setContentType("application/json");
						List<Crenom> ls = ms.findAll();
						Gson gson = new Gson();
						response.getWriter().write(gson.toJson(ls));

					} else if(request.getParameter("op").equals("loadR")) {
						int id = Integer.parseInt(request.getParameter("id"));
						response.setContentType("application/json");
						List<Crenom> ls = ms.findResrvationsByClient(id);
						Gson gson = new Gson();
						response.getWriter().write(gson.toJson(ls));
					}else if(request.getParameter("op").equals("getrooms")) {
						String date =  request.getParameter("date");
						response.setContentType("application/json");
						List<Salle> ls =ms.getRoomsBeforeDate(date);
						Gson gson = new Gson();
						response.getWriter().write(gson.toJson(ls));
					}
				} else {
					int id = Integer.parseInt(request.getParameter("room"));
					Salle Salle = ss.findById(id);
					Client c = cs.findById(12);
				
					String date = request.getParameter("date");
					//String salle = request.getParameter("room");
					String HeureDebut = request.getParameter("heureD");
					String HeureFin =  request.getParameter("heureF");
					ms.create(new Crenom( HeureDebut, HeureFin,Salle,c,date));
					response.setContentType("application/json");
					List<Crenom> ls = ms.findAll();
					Gson gson = new Gson();
					response.getWriter().write(gson.toJson(ls));
				}
	}

}
