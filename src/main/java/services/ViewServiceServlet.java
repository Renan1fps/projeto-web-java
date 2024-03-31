package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Service;
import infra.InMemoryRepositoryService;

@WebServlet("/viewService")
public class ViewServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewServiceServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (!id.isEmpty()) {
			InMemoryRepositoryService serviceRepo = InMemoryRepositoryService.getInstance();
			Service service = serviceRepo.getById(id);

			if (service != null) {
				request.setAttribute("service", service);
				request.getRequestDispatcher("service/viewService.jsp").forward(request, response);
			} else {
				response.getWriter().println("<h1>ID invalido</h1>");
			}

		} else {
			response.getWriter().println("<h1>Nenhum ID fornecido na URL</h1>");
		}

	}
}
