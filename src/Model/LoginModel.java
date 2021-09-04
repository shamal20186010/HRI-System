
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class LoginModel {
    static Logger log = Logger.getLogger(LoginModel.class.getName());
Connection connection;

    public LoginModel() {
        connection = Db.db_connection.getConnection();
    }
    public int isLogin(String username, String password) {
       int id = 0;
        String query = "SELECT * FROM hris_system.user_credential where username='" + username + "'and password='" + password + "'";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                
                id = rs.getInt("emp_details_id");

            }
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
        }

        return id;
    }

    public int getAuthorizer(int id) {
       int authorizerId = 0;
        String query = "SELECT isAuthorizer FROM hris_system.emp_details where id = '"+id+"'";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                
                authorizerId = rs.getInt("isAuthorizer");

            }
        } catch (Exception e) {
            e.printStackTrace();
             log.debug(e.getMessage());
        }

        return authorizerId;
    }
    
}
