package Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {

    public void service(HttpServletRequest request,HttpServletResponse response){

        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");

            String action=request.getParameter("action");
            if(!(action.equals("")||action=="")){

                Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
                method.setAccessible(true);
                method.invoke(this,request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
