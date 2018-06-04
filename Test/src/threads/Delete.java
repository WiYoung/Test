package threads;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ThreadBean;



public class Delete extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBConnector db = new DBConnector();//DBConnectorをインスタンス化
		ThreadsDao dao = new ThreadsDao();//ThreadsDaoをインスタンス化
		ThreadBean one = dao.getThreadsid(db,request);//daoクラスでとってきた値を入れるための箱をList<>型で作る
		request.setAttribute("threads", one);
		request.getRequestDispatcher("/WEB-INF/views/delete.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		ThreadsDao dao = new ThreadsDao();
		dao.doDelete(request);
		response.sendRedirect("/Test/view");
	}

}
