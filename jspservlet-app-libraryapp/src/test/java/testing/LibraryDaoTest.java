package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
 
import java.sql.Connection;
import java.sql.SQLException;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
 
import model.BlogList;
import service.LibraryDao;
 
class LibraryDaoTest {
     
    private static LibraryDao dao;
     
    @BeforeAll
    static void init() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao = new LibraryDao(conn);
    }
     
    @AfterAll
    static void teardown() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    @Test
    void addListTest() {
        Book list = new Book();
		list.setBookId(1);
        list.setBookName("Wings of fire");
        list.setAuthorName("APJ Abdul Kalam");
		list.setBookDescription("Biography");
        dao.addBook(list);
        Book listFromDb = dao.viewBookById(1);
        assertEquals("Wings of fire", listFromDb.getBookName(), "Book Name must be equal");
    }
    
    @Test
    void deleteListTest() {
        dao.deleteBook(1);
        Book listFromDb = dao.viewBookById(1);
        assertNull(listFromDb.getBookName(), "Book should be null");
    }
    
    @Test
    void updateListTest() {
        Book list = new Book();
		list.setBookId(1);
        list.setBookName("Wings of fire");
        list.setAuthorName("APJ Abdul Kalam");
		list.setBookDescription("Biography");
        dao.addBook(list);
        list.setBookName("Life biography");
        dao.updateBook(list);
        Book listFromDb = dao.viewBookById(1);
        assertEquals("Life biography", listFromDb.getBookName(), "Book Name must be equal");
    }
 
}