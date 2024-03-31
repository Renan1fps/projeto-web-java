package services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Service;
import domain.Session;
import infra.InMemoryRepositoryService;
import infra.InMemoryRepositorySession;
import protocols.Repository;


@WebServlet("/addSession")
public class AddSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddSessionServlet() {
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Repository<Session> sessionRepo = InMemoryRepositorySession.getInstance();
    	Repository<Service> serviceRepo = InMemoryRepositoryService.getInstance();
    	Integer length = sessionRepo.fidAll().size() + 1;
    	String serviceId = request.getParameter("serviceId");
        String dateString = request.getParameter("date");
        LocalTime time = LocalTime.now();
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Session session = new Session(length.toString(), date, time, serviceId);
        sessionRepo.save(session);
        
        request.setAttribute("services", serviceRepo.fidAll());
        request.getRequestDispatcher("service/listServices.jsp").forward(request, response);
    }

}
