package Action;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by zll on 2017/7/31 0031.
 */
@MultipartConfig
@WebServlet("/Upload")
public class UploadFile extends HttpServlet {
    private static final String SAVE_DIR = "uploadFiles";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        upload(req, resp);
    }


    /**
     *
     * @param request
     * @param response
     * @return JSONObject
     * @throws ServletException
     * @throws IOException
     */
    public void upload(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String appPath = request.getServletContext().getRealPath("");

        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        List<String> fileNames = new ArrayList<>();

        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            String fileName = part.getSubmittedFileName();


            if(!StringUtils.isEmpty(fileName)){
                part.write(savePath + File.separator + fileName);
                fileNames.add(fileName);
            }
        }

        Map<String, Object> resultData = new HashMap<>();
//        resultData.put("savePath", savePath);
//        resultData.put("files", fileNames);
        resultData.put("code", "200");
        resultData.put("msg", "上传成功！");
        JSONObject jsonObject = JSONObject.fromObject(resultData);
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().print(jsonObject);
        response.getWriter().close();
    }

    /**

     * form-data; name="dataFile"; filename="PHOTO.JPG"
     *
     * @param part
     * @return
     */
    @SuppressWarnings("unused")
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

}
