package DAL;

import Entity.Book;
import org.apache.ibatis.annotations.Param;
import java.util.List;


/*各取所长，配置灵活，在代码中不需要引用很长的id名称，面向接口编程*/
public interface IBooksMapper {

    Book selectBookByIsbn(@Param("isbn")int isbn);
    List<Book>selectAllBooks();
    List<Book>selectAllBooksByPage(@Param("pagelimit")int pagelimit,@Param("size")int size);
    List<Book>selectMohuByThreeLimit(@Param("title") String title,@Param("author") String author,@Param("cname")String cname,
                                     @Param("beginprice")double beginprice,@Param("endprice")double endprice );
    List<Book>selectTwo();
    List<Book>selectTwoWithLimit(@Param("cid")int cid);
    int insertBook(Book book);
    int updateBook(Book book);
    int deleteBook(@Param("isbn") int isbn);
    int deleteAllByIsbn(@Param("list") List<Integer> list);
    int selectCount();
}
