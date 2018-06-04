package threads;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import beans.ThreadBean;

public class ThreadsDao {
	//一覧表示する際の全レコードを取得する処理
	public List<ThreadBean> getThreadsAll(DBConnector db) {
		List<ThreadBean> threads = null;
		PreparedStatement st = null;//PreparedStatementクラス型のフィールド変数　stを定義
		ResultSet rs = null;//
		try {
			//ドライバロード.DB接続.SQLをセット

			st = db.connect().prepareStatement("select * from bbs order by id DESC");
			//prepareStatement()メソッドでSQL文をセットし準備しstの倉庫にしまう
			rs = st.executeQuery();//倉庫にあるものを出してき、出力
			threads = new ArrayList<>();//ArrayList型の箱を作る
			while (rs.next()) {//SQLで表示させた表の２つ目のレコードから値を順番に取ってくる
				//.nextは段落を一つ下げて見る
				ThreadBean thread = new ThreadBean();//ThreadBeanクラスをインスタンス化
				thread.setId(rs.getInt("id"));//1
				//rsに入ってるテーブルの値をsetgetしてくきてthreadのなかにれテイク
				thread.setTitle(rs.getString("title"));//"2"
				thread.setNickname(rs.getString("nickname"));//"3"
				thread.setMessage(rs.getString("message"));//"4"
				thread.setUpdate(rs.getDate("update_time"));//"5"
				thread.setInsert(rs.getDate("insert_time"));//"6"
				threads.add(thread);//1～6のthreadの箱をthreadsの大きい箱にならべテイク
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(st, rs);//close()メソッドを呼ぶ
		}
		return threads;//リターンで値を返す
	}
//新規書き込み用
	public void doInsert(HttpServletRequest request) throws IOException {

		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String nickname = request.getParameter("nickname");
		String message = request.getParameter("message");

		try {
			DBConnector db = new DBConnector();
			PreparedStatement st = null;//PreparedStatementクラス型のフィールド変数　stを定義
			st = db.connect().prepareStatement("insert into bbs values(null,?,?,?,now(),now())");
			st.setString(1, title);
			st.setString(2, nickname);
			st.setString(3, message);
			st.executeUpdate();//データベースがselect文でないのでexecuteUpdate

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
//更新データ取得用
	public ThreadBean getThreadsid(DBConnector db,HttpServletRequest request) {
		PreparedStatement st = null;//PreparedStatementクラス型のフィールド変数　stを定義
		ResultSet rs = null;//
		ThreadBean thread = null;
		String id =request.getParameter("id");
		try {
			//ドライバロード.DB接続.SQLをセット

			st = db.connect().prepareStatement("select * from bbs where id = ?");
			st.setString(1,id);
			rs = st.executeQuery();//倉庫にあるものを出してき、出力
			if(rs.next()) {//SQLで表示させた表の２つ目のレコードから値を順番に取ってくる
				//.nextは段落を一つ下げて見る
				thread = new ThreadBean();//ThreadBeanクラスをインスタンス化
				thread.setId(rs.getInt("id"));//1
				//rsに入ってるテーブルの値をsetgetしてくきてthreadのなかにれテイク
				thread.setTitle(rs.getString("title"));//"2"
				thread.setNickname(rs.getString("nickname"));//"3"
				thread.setMessage(rs.getString("message"));//"4"
				thread.setUpdate(rs.getDate("update_time"));//"5"
				thread.setInsert(rs.getDate("insert_time"));//"6"
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(st, rs);//close()メソッドを呼ぶ
		}
		return thread;
	}
//削除用
	public void doDelete(HttpServletRequest request) throws IOException {
		String id =request.getParameter("id");


	try {
		DBConnector db = new DBConnector();
		PreparedStatement st = null;//PreparedStatementクラス型のフィールド変数　stを定義
		st = db.connect().prepareStatement("delete from bbs where id = ?;");
		st.setString(1, id);
		st.executeUpdate();//
	} catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
	}
	//更新用データ
	public void doUp(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String id =request.getParameter("id");
		String title =request.getParameter("title");
		String nickname =request.getParameter("nickname");
		String message =request.getParameter("message");



	try {
		DBConnector db = new DBConnector();
		PreparedStatement st = null;//PreparedStatementクラス型のフィールド変数　stを定義
		st = db.connect().prepareStatement("update bbs set title = ?,nickname = ?,message = ? where id = ?;");
		st.setString(1, title);
		st.setString(2, nickname);
		st.setString(3, message);
		st.setString(4, id);
		st.executeUpdate();//
	} catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
	}
}



