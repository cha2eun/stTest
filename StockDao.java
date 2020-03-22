package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MyStockVo;
import com.example.demo.vo.OrderStockVo;
import com.example.demo.vo.StockVo;

@Repository
public class StockDao {
	public static List<StockVo> listStock() {
		return DBManager.listStock();
	}
	public static StockVo detail(String coname) {
		return DBManager.detail(coname);
	}
	public static List<MyStockVo> mystockList(){
		return DBManager.mystockList();
	}
	public static int insertOrderStock(OrderStockVo o) {
		return DBManager.insertOrderStock(o);
	}
	public static int deleteStock(String coname) {
		return DBManager.deleteStock(coname);
	}
	
}
