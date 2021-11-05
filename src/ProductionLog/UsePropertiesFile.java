package ProductionLog;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

class UsePropertiesFile {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();

        prop.load(new FileInputStream("data.properties"));
        String user = prop.getProperty("username");
        String pass = prop.getProperty("password");
        String port = prop.getProperty("port");

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:"
                + port + "/test", user, pass);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from PRODUCT");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }

    }
}