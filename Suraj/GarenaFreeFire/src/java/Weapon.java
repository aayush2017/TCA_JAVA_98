
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
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

public class Weapon extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/freefire", "root", "9759447161");

            Statement stmt = con.createStatement();
            String sql = ("select * from gundetails");
            log(sql);
            ResultSet rs = stmt.executeQuery(sql);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Weapon</title>");
                out.println("</head>");
                out.println("<body bgcolor=pink>");
                out.println("<center><h1 style=color:red >All Weapon</h1></center>");
                out.println("<center><table border='1'>");
                out.println("<tr style=color:blue>");
                out.println("<td>No</td>");
                out.println("<td>Weapon</td>");
                out.println("<td>Damage</td>");
                out.println("<td>Range</td>");
                out.println("<td>Scope</td>");
                out.println("<td>Update</td>");
                out.println("<td>Delete</td>");
                out.println("</tr>");
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("No") + "</td>");
                    out.println("<td>" + rs.getString("weapon") + "</td>");
                    out.println("<td>" + rs.getString("damage") + "</td>");
                    out.println("<td>" + rs.getString("range") + "</td>");
                    out.println("<td>" + rs.getString("scope") + "</td>");
                    out.println("<td><a href=''>Delete</a></form></td>");
                    out.println("<td><a href=''>Update</a></form></td>");
                    out.println("</tr>");
                }
                out.println("</table></center>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Weapon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
