package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StockDao;
import com.example.demo.vo.OrderStockVo;
import com.example.demo.vo.StockVo;
import com.google.gson.Gson;

@RestController
public class StockController {
	@Autowired
	public StockDao dao;

	public void setDao(StockDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "listStock",produces = "application/json;charset=UTF-8")
	public String listStock() {
		String str="";
		str= new Gson().toJson(dao.listStock());
		return str;
	}
	@RequestMapping(value = "detailStock",produces = "application/json;charset=UTF-8")
	public String detailStock(String coname) {
		String str="";
		str= new Gson().toJson(dao.detail(coname));
		return str;
	}
	@RequestMapping(value = "insertorderstock",produces = "application/json;charset=UTF-8")
	public String insertOrderStock(OrderStockVo o) {
		String str="매수실패";
		int re=dao.insertOrderStock(o);
		if(re>0) {
			str="매수성공";
		}
		str=new Gson().toJson(str);
		return str;
	}
	@RequestMapping(value = "listMyStock",produces = "application/json;charset=UTF-8")
	public String mystockList() {
		String str="";
		str=new Gson().toJson(dao.mystockList());
		return str;
	}
	@RequestMapping(value = "deleteStock",produces = "application/json;charset=UTF-8")
	public String deleteStock(String coname) {
		String str="매도실패";
		int re=dao.deleteStock(coname);
		if(re>0)
			str="매도 성공";
		str=new Gson().toJson(str);
		return str;
	}
}
