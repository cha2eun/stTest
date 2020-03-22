package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockVo {
	private int no;
	private String coname;
	private int p_price;
	private int upper;
	private int lower;
}
