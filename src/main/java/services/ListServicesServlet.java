package services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Service;
import infra.InMemoryRepositoryService;

@WebServlet("/listServices")
public class ListServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListServicesServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new Service();
		service.setDescription("Testes");
		service.setId("1");
		service.setName("Testessss");
		InMemoryRepositoryService serviceRepo = new InMemoryRepositoryService();
		serviceRepo.save(service);
		List<Service> services = serviceRepo.fidAllById();
		        request.setAttribute("services", services);

		        request.getRequestDispatcher("service/listServices.jsp").forward(request, response);
	}

}
