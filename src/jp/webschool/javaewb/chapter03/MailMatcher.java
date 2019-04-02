package jp.webschool.javaewb.chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailMatcher
 */
public class MailMatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailMatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String mail = request.getParameter("mail");
		String mailCheck = request.getParameter("mail_check");

		String message = judge(mail, mailCheck);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(message);



		// TODO Auto-generated method stub
		//doGet(request, response);
	}

	protected String judge(String m, String c){

		String message;

		if(m != "" && c != ""){

			if(m.equals(c)){
				message = "メールアドレスが登録されました。";

			} else {
				message = "メールアドレスとメールアドレス（確認用）が異なります。";
				return message;
			}

		} else {
			message = "メールアドレスもしくはメールアドレス（確認用）が空白です。";
			return message;
		}

		return message;

	}

}
