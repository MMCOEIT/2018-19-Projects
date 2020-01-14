package com.project.beans;

import java.io.Serializable;

public class BookBeans implements Serializable{

	//id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth
	
	int book_id;
	
	String brand_name, product_name, SKU, SRP,gross_weirth,net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth,tablename,product_price;

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getSRP() {
		return SRP;
	}

	public void setSRP(String sRP) {
		SRP = sRP;
	}

	public String getGross_weirth() {
		return gross_weirth;
	}

	public void setGross_weirth(String gross_weirth) {
		this.gross_weirth = gross_weirth;
	}

	public String getNet_weigth() {
		return net_weigth;
	}

	public void setNet_weigth(String net_weigth) {
		this.net_weigth = net_weigth;
	}

	public String getRecylared() {
		return recylared;
	}

	public void setRecylared(String recylared) {
		this.recylared = recylared;
	}

	public String getLow_fat() {
		return low_fat;
	}

	public void setLow_fat(String low_fat) {
		this.low_fat = low_fat;
	}

	public String getUnits_pre() {
		return units_pre;
	}

	public void setUnits_pre(String units_pre) {
		this.units_pre = units_pre;
	}

	public String getCase_pre() {
		return Case_pre;
	}

	public void setCase_pre(String case_pre) {
		Case_pre = case_pre;
	}

	public String getShelf_heigth() {
		return shelf_heigth;
	}

	public void setShelf_heigth(String shelf_heigth) {
		this.shelf_heigth = shelf_heigth;
	}

	public String getShelf_width() {
		return shelf_width;
	}

	public void setShelf_width(String shelf_width) {
		this.shelf_width = shelf_width;
	}

	public String getShelf_depth() {
		return shelf_depth;
	}

	public void setShelf_depth(String shelf_depth) {
		this.shelf_depth = shelf_depth;
	}

	
	
	
}
