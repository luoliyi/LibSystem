package Controller;

import DAL.BooksDAL;
import Entity.Book;
import Entity.Standard;
import Utils.JSONUtil;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet( "/doServlet")
public class doServlet extends BaseServlet {
    BooksDAL dao=new BooksDAL();
    Standard style=null;

    public void getAllBooks(HttpServletRequest request,HttpServletResponse response){
        List<Book> getAllBooks=dao.selectAllBooks();
        style=new Standard(200,"success request!",getAllBooks);
        try {
            response.getWriter().print(JSONUtil.toJson(style));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getAllBooksByPage(HttpServletRequest request,HttpServletResponse response){
        int pageno=Integer.parseInt(request.getParameter("pageno"));
        int size=Integer.parseInt(request.getParameter("size"));
        List<Book>getAllBooks=dao.selectAllBooksByPage(pageno,size);
        style=new Standard(200,"success request!",getAllBooks);
        try {
            response.getWriter().print(JSONUtil.toJson(style));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getCount(HttpServletRequest request,HttpServletResponse response){
        int count=dao.selectCount();
        try {
            response.getWriter().print(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insert(HttpServletRequest request,HttpServletResponse response){
        Book book=getInfo(request,response);
        try {
            int result=dao.insertBook(book);
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Book getInfo(HttpServletRequest request,HttpServletResponse response){
        String title=request.getParameter("title");
        String author=request.getParameter("author");
        double price=Double.parseDouble(request.getParameter("price"));
        String publishDate=request.getParameter("publishDate");
        String cover=request.getParameter("cover");
        String details=request.getParameter("details");
        int cid=Integer.parseInt(request.getParameter("cid"));
        return new Book(title,author,price,publishDate,cover,details,cid);
    }

    public  void update(HttpServletRequest request,HttpServletResponse response){

        int isbn=Integer.parseInt(request.getParameter("isbn"));
        Book book=getInfo(request,response);
        //添加id
        book.setIsbn(isbn);

        try {
            int result=dao.updateBook(book);
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public  void delete(HttpServletRequest request,HttpServletResponse response){
        int isbn=Integer.parseInt(request.getParameter("isbn"));
        try {
            int result= dao.deleteBook(isbn);
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAll(HttpServletRequest request,HttpServletResponse response){
        String items=request.getParameter("items");
        String[] item=items.split(",");
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<item.length;i++){
            list.add(Integer.parseInt(item[i]));
        }
        int result=dao.deleteAllByIsbn(list);
        try {
            if(result>0)
                response.getWriter().print(result);
            else
                System.out.println("error");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void  mohuSelect(HttpServletRequest request,HttpServletResponse response){
        String title=request.getParameter("title");
        String author=request.getParameter("author");
        String cname=request.getParameter("cname");
        double beginprice=0.0;
        double endprice=0.0;

        String price1=request.getParameter("price1");
        String price2=request.getParameter("price2");
        if(!(price1.equals("")||price1=="")){
            beginprice=Double.parseDouble(price1);
        }
        if(!(price2.equals("")||price2=="")){
            endprice=Double.parseDouble(price2);
        }

        System.out.println(title+author+cname+price1+price2);
        List<Book> list=dao.selectMohuByThreeLimit(title,author,cname,beginprice,endprice);
        style=new Standard(200,"success request!",list);
        try {
            response.getWriter().print(JSONUtil.toJson(style));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
