
package MyDairy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PDetail extends HttpServlet {
    Connection con;
    Statement smt;
    ResultSet rs;
    String Query;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydairy","root","raj");
            smt=con.createStatement();
            int id=Integer.parseInt(request.getParameter("id"));
            String table=request.getParameter("table");
            Query="select * from "+table+" where id="+id;
            rs= smt.executeQuery(Query);
            
            JSONArray ja=new List().Change(rs);
            JSONObject obj=new JSONObject();
            obj.put("DATA",ja);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(obj.toString());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PDetail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PDetail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(PDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


}
