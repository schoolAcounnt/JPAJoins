package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetClass;
import model.PetOwners;

/**
 * Servlet implementation class GetOwnerServlet
 */
@WebServlet("/GetOwnerServlet")
public class GetOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOwnerServlet() {
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
		String userEntry = request.getParameter("userEntry");
		String[] all = request.getParameterValues("allItemsToAdd");
		String path = "/Index.jsp";
		OwnerHelper gih = new OwnerHelper();
		List<PetClass> allPets = new ArrayList<PetClass>();
		if (userEntry.isEmpty() || allPets.isEmpty() || userEntry == null || allPets == null) {
			getServletContext().getRequestDispatcher(path).forward(request, response);
		}
		for(int i = 0; i < all.length; i++) 
		{
			PetClass pc = gih.searchForItemById(Integer.parseInt(all[i]));
			allPets.add(pc);
			System.out.println(pc);
		}
		PetOwners po = new PetOwners(userEntry,allPets);
		System.out.println(po);
		gih.addOwner(po);
		

		getServletContext().getRequestDispatcher(path).forward(request, response);

		
	}

}
