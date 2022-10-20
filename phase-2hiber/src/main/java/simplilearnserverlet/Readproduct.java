package simplilearnserverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Eproduct;
import utilclass.Hibernateutil;

/**
 * Servlet implementation class Readproduct
 */
@WebServlet("/read-product")
public class Readproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Readproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sessionfactory=Hibernateutil.buildsessionfactory();
		Session session =sessionfactory.openSession();
		List<Eproduct>list=session.createQuery("eproduct").list();
		PrintWriter out=response.getWriter();
		if(list!=null&&list.size()>0) {
		for (Eproduct product:list) {
			out.print(product.getId()+"<br/>");
			out.print(product.getName()+"<br/>");
			out.print(product.getPrice()+"<br/>");
		}
		
		
	}else {
		out.print("no records found in db");
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
