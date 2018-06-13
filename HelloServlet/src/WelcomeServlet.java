

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public WelcomeServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    String username = request.getParameter("username");

    //ここでは以前貰っている名前を頂いている。　ここでresponse...というのは...なんだろう。
    //型式と覚えればいいのかな？

    System.out.println(username);

    //ここでusernameが何故表所されないのか？
    //こちらはコンソールに表示されていた為。　無くても構わないけどその裏と表の確認。

    PrintWriter out=response.getWriter();
    out.println("<html><head></head><body><br>"+username+"さん、ようこそ！</body></html>");
	}
   //ここのPrintWriterが表示されている。
}
