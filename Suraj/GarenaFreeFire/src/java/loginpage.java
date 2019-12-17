
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginpage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("txtusername");
        String password = request.getParameter("txtpassword");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/freefire", "root", "9759447161");

            PreparedStatement ps = con.prepareStatement("select username,password from login where username=? and password=?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                response.sendRedirect("./Weapon");
                return;
            }
            response.sendRedirect("./index.html");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(loginpage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
