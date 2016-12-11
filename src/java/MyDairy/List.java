
package MyDairy;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class List extends HttpServlet {
            Connection con;
            Statement smt;
            ResultSet rs;
            StringBuilder sb;
            BufferedReader br;
            String st;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
      
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydairy","root","raj");
            smt=(Statement) con.createStatement();
            String st=request.getParameter("value");
            String Quary="select * from "+st;
            rs=smt.executeQuery(Quary);
            JSONArray j=Change(rs);
            JSONObject obj=new JSONObject();
            obj.put("DATA",j);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }       catch (JSONException ex) {
                    Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }
    public JSONArray Change(ResultSet rs) throws SQLException, JSONException
    {
        JSONArray JAR=new JSONArray();
        while(rs.next())
        {
            JSONObject obj=new JSONObject();
            obj.put("id",rs.getInt("id"));
            obj.put("name",rs.getString("name"));
            obj.put("img",rs.getString("img"));
            obj.put("about",rs.getString("about"));
            JAR.put(obj);
        }
        return JAR;
    }

}
