package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import service.LibraryDao;

@WebServlet("/")
public class ServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibraryDao libraryDao;
	
	public void init() {
		libraryDao= new LibraryDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBook(request, response);
				break;
			case "/delete":
				deleteBook(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBook(request, response);
				break;
			default:
				listBook(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Book> listBook = libraryDao.getAllBook();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = libraryDao.viewBookById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookIndex.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		String bookDescription = request.getParameter("bookDescription");
		Book newBook = new Book(bookName, authorName, bookDescription);
		libraryDao.addBook(newBook);
		response.sendRedirect("book?action=list");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		String bookDescription = request.getParameter("bookDescription");
		Book book = new Book(bookId, bookName, authorName, bookDescription);
		libraryDao.updateBook(book);
		response.sendRedirect("book?action=list");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int BookId = Integer.parseInt(request.getParameter("id"));
		libraryDao.deleteBook(BookId);
		response.sendRedirect("book?action=list");
	}
}
