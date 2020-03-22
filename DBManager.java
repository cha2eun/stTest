package com.example.demo.db;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.MyStockVo;
import com.example.demo.vo.OrderStockVo;
import com.example.demo.vo.StockVo;

public class DBManager {
	public static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
	}
	public static List<StockVo> listStock(){
		SqlSession session = factory.openSession();
		List<StockVo> list = session.selectList("stock.selectAll");
		session.close();
		return list;
	}
	public static StockVo detail(String coname) {
		SqlSession session = factory.openSession();
		StockVo s = session.selectOne("stock.detail",coname);
		session.close();
		return s;
	}
	public static List<MyStockVo> mystockList() {
		SqlSession session = factory.openSession();
		List<MyStockVo> list = session.selectList("stock.myselectAll");
		session.close();
		return list;
	}
	public static int insertOrderStock(OrderStockVo o) {
		SqlSession session = factory.openSession(true);
		int re = session.insert("stock.insertorderstock", o);
		session.close();
		return re;
	}
	public static int deleteStock(String coname) {
		SqlSession session = factory.openSession(true);
		int re = session.delete("stock.deleteStock",coname);
		session.close();
		return re;
	}	
}

