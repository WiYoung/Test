package threads;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ThreadBean;

public class View extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBConnector db = new DBConnector();//DBConnectorをインスタンス化
		ThreadsDao dao = new ThreadsDao();//ThreadsDaoをインスタンス化
		List<ThreadBean> list = dao.getThreadsAll(db);//daoクラスでとってきた値を入れるための箱をList<>型で作る
		//get()メソッドでthreadsの中の値をとってくる
		request.setAttribute("threads", list);

		request.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}