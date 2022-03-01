package service;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.Book;
import utility.ConnectionManager;
public class LibraryDao {
public void addBook(Book book){
    Transaction transaction = null;
		try (Session session=ConnectionManager.getSessionFactory().openSession()){
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(book);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
public void updateBook(Book book){
    Transaction transaction = null;
    try (Session session = ConnectionManager.getSessionFactory().openSession()) {
        // start a transaction
        transaction = session.beginTransaction();
        // save the student object
        session.update(book);
        // commit transaction
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
}

public Book viewBookById(int bookId){
    Transaction transaction = null;
		Book book = null;
		try (Session session = ConnectionManager.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			book = session.get(Book.class, bookId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return book;
}
public void deleteBook(int bookId)
{
	Transaction transaction = null;
		try (Session session = ConnectionManager.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Book book= session.get(Book.class, bookId);
			if (book != null) {
				session.delete(book);
				System.out.println("book is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
}
//Display  ALL Student Details
@SuppressWarnings("unchecked")
public List<Book> getAllBook() {

    Transaction transaction = null;
    List<Book> listOfbook = null;
    try (Session session = ConnectionManager.getSessionFactory().openSession()) {
        // start a transaction
        transaction = session.beginTransaction();
        // get an user object
        
        listOfbook = session.createQuery("from Book").getResultList();
        
        // commit transaction
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return listOfbook;
}
}
