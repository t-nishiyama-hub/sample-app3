package com.system.sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ログインユーザID.
	 */
	private final String USER_ID = "nishiyama";
	/**
	 * パスワード.
	 */
	private final String PASSWORD = "st1201515";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setContentType("text/html; charset=UTF-8");

	    String view = null;
	    RequestDispatcher dispatcher = null;

	    if (null == request.getAttribute("view")) {
	    	// 初回起動時はここを通る
	    	view = "/WEB-INF/view/Sample.jsp";
		    request.setAttribute("message", "");
	    } else {
	    	view = request.getAttribute("view").toString();
	    }

	    dispatcher = request.getRequestDispatcher(view);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	    // 入力されたユーザIDとパスワードが一致しているか確認する
	    if (this.canLogin(request.getParameter("id"), request.getParameter("password"))) {
		    // JSPに適当な文字列を渡す
		    request.setAttribute("id", request.getParameter("id"));
		    request.setAttribute("message", "");
		    request.setAttribute("view", "/WEB-INF/view/Main.jsp");
	    } else {
		    // エラーメッセージを返す
		    request.setAttribute("message", "ログインに失敗しました。");
		    request.setAttribute("view", "/WEB-INF/view/Sample.jsp");
	    }

		doGet(request, response);
	}

	/**
	 * ログイン可否を確認する.
	 *
	 * @param userId ユーザID.
	 * @param password パスワード.
	 * @return true:ログイン可、false:ログイン不可
	 */
	private boolean canLogin(String userId, String password) {

		// ユーザID,パスワードが一致した場合のみtrue
		if (USER_ID.equals(userId) && PASSWORD.equals(password)) {
			return true;
		}

		return false;
	}
}
