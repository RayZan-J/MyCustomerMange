package Action;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zll on 2017/8/15 0031.
 */
public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String req = request.getServletPath();
        if("/init.do".equals(req)){
            new Login().doGet(request,response);
        }else if("/upload.do".equals(req)){
            new UploadFile().doGet(request,response);
        }else if("/emp.do".equals(req)){
            new EmpInfo().doGet(request,response);
        }else{
            throw new RuntimeException("NO Page Found!");
        }

    }

}
