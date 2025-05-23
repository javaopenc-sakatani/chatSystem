package com.example.demo.chatsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class Chatdao {
	private final JdbcTemplate db;
	public Chatdao(JdbcTemplate db){
		this.db = db;
	}

	public void insertDb(ChatentForm chatentform) {
		System.out.println(chatentform.getName());
		System.out.println(chatentform.getComment());
		db.update("INSERT INTO chat (name,comment) VALUES(?,?)", chatentform.getName(), chatentform.getComment());
	}

	public List<ChatentForm> searchDb() {
		String sql = "SELECT * FROM chat";
		//データベースから取り出したデータをresultDB1に入れる
		List<Map<String, Object>> resultDb1 = db.queryForList(sql);
		//画面に表示しやすい形のList(resultDB2)を用意
		List<ChatentForm> resultDb2 = new ArrayList<ChatentForm>();
		//1件ずつピックアップ
		for (Map<String, Object> result1 : resultDb1) {
			//データ1件分を1つのまとまりとしたEntForm型の「entformdb」を生成
			ChatentForm chatentformdb = new ChatentForm();
			//id、nameのデータをentformdbに移す
			chatentformdb.setId((int) result1.get("id"));
			chatentformdb.setName((String) result1.get("name"));
			chatentformdb.setComment((String)result1.get("comment"));
			//移し替えたデータを持ったentformdbを、resultDB2に入れる
			resultDb2.add(chatentformdb);
		}
		//Controllerに渡す
		return resultDb2;

	}
}
