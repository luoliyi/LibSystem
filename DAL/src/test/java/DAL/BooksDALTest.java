package DAL;

import Entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BooksDALTest {

    BooksDAL dal=null;

    @Before
    public  void before(){
       dal=new BooksDAL();
    }

    @Test
    public void selectBookByIsbn() {
       Book book=dal.selectBookByIsbn(2);
        System.out.println(book.toString());
    }

    @Test
    public void selectAllBooks() {
        List<Book> list=dal.selectAllBooksByPage(2,3);
        for (Book book:list){
            System.out.println(book.toString());
        }

    }

    @Test
    public void selectAllBooksByPage() {
        List<Book> list=dal.selectAllBooksByPage(2,3);
        for (Book book:list){
            System.out.println(book.toString());
        }
    }
    @Test
    public void selectTwo() {
    }

    @Test
    public void selectMohuByThreeLimit(){
        List<Book> list=dal.selectMohuByThreeLimit("","","",30,50);
        for (Book book:list){
            System.out.println(book.toString());
        }
    }
    @Test
    public void insertBook() {
    }

    @Test
    public void updateBook() {
      /*  Book book=new Book(12,"三体2","流星锤",11.2,"2018-03-21",null,null,2);
        int u=dal.updateBook(book);
        System.out.println(u);*/
    }

    @Test
    public void deleteBook() {
       /* int result=dal.deleteBook(12);
        System.out.println(result);*/
    }

    @Test
    public void deleteAllByIsbn() {
        System.out.println(dal.deleteBook(15));
    }

    @Test
    public void selectCount() {
        System.out.println(dal.selectCount());
    }
}