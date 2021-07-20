package Source;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by zll on 2017/8/17 0017.
 */
public class SqlFactory {
    private static SqlFactory factory = null;

    public SqlFactory(String sql) {
        Properties pp = new Properties();
        try {
            //获得tomcat所在的工作路径
            String dir = System.getProperty("user.dir");
            System.out.println(dir);
            InputStream in = new BufferedInputStream(new FileInputStream
                    (dir + File.separator + "resource" + File.separator + "database.properties"));
            pp.load(in);
            String url = pp.getProperty("jdbc.url");
            String driver = pp.getProperty("dirver");
            String username = pp.getProperty("jdbc.username");
            String password = pp.getProperty("jdbc.password");
            System.out.println(url);
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection conn;
    private static PreparedStatement ps;

    private static SqlFactory createInstance(String sql) {
        if (factory == null) {
            return new SqlFactory(sql);
        }
        return factory;
    }

    public void close() {
        try {
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
