package DAL;

import Entity.Book;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class BooksDAL implements  IBooksMapper{
    //初始化
    InputStream stream=BooksDAL.class.getClassLoader().getResourceAsStream("mybatisconf.xml");
    SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(stream);
    SqlSession session=ssf.openSession();
    /*初始化一个映射文件*/
    IBooksMapper mapper=session.getMapper(IBooksMapper.class);

    /*注意，别关闭session.否则报错Executor was closed.*/

    public Book selectBookByIsbn(int isbn) {
        return mapper.selectBookByIsbn(isbn);
    }

    public List<Book> selectAllBooks() {
        return mapper.selectAllBooks();
    }

    public List<Book> selectAllBooksByPage(int pageno, int size) {
        int pagelimit = (pageno - 1) * size;
        return mapper.selectAllBooksByPage(pagelimit, size);
    }

    public List<Book> selectMohuByThreeLimit(String title, String author, String cname, double beginprice, double endprice) {
        return mapper.selectMohuByThreeLimit(title,author,cname,beginprice,endprice);
    }

    public List<Book> selectTwo() {
        return mapper.selectTwo();
    }

    public List<Book> selectTwoWithLimit(int cid) {
        return mapper.selectTwoWithLimit(cid);
    }

    public int insertBook(Book book) {
        int result=0;
        result=mapper.insertBook(book);
        session.commit();
        return result;
    }

    public int updateBook(Book book) {
        int result=0;
        result=mapper.updateBook(book);
        session.commit();
        return result;
    }

    public int deleteBook(int isbn) {
        int result=0;
        result=mapper.deleteBook(isbn);
        session.commit();
        System.out.println(result);
        return result;
    }

    public int deleteAllByIsbn(List<Integer> list) {
        int result=0;
        result=mapper.deleteAllByIsbn(list);
        session.commit();
        return result;
    }

    public int selectCount() {
        return mapper.selectCount();
    }
}
