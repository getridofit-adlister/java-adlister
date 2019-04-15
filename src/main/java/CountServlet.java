import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {
    int count = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/HTML");
        PrintWriter out = res.getWriter();
        out.println("<h1>" + count + "</h1>");

        if (req.getParameter("reset") != null) {
            count = 1;
        } else {
            count++;
        }

    }
}
