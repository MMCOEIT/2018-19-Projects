package com.project.beans;

import java.io.Serializable;

public class UserProductBeans implements Serializable {
	
	// id, product_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, product_price
	
	
	int id;
	
	
	String product_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, product_price;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getProduct_Brand() {
		return product_Brand;
	}


	public void setProduct_Brand(String product_Brand) {
		this.product_Brand = product_Brand;
	}


	public String getProduct_SKU() {
		return product_SKU;
	}


	public void setProduct_SKU(String product_SKU) {
		this.product_SKU = product_SKU;
	}


	public String getProduct_SRP() {
		return product_SRP;
	}


	public void setProduct_SRP(String product_SRP) {
		this.product_SRP = product_SRP;
	}


	public String getGross_weight() {
		return gross_weight;
	}


	public void setGross_weight(String gross_weight) {
		this.gross_weight = gross_weight;
	}


	public String getNet_weight() {
		return net_weight;
	}


	public void setNet_weight(String net_weight) {
		this.net_weight = net_weight;
	}


	public String getRecyclable_package() {
		return recyclable_package;
	}


	public void setRecyclable_package(String recyclable_package) {
		this.recyclable_package = recyclable_package;
	}


	public String getLow_fat() {
		return low_fat;
	}


	public void setLow_fat(String low_fat) {
		this.low_fat = low_fat;
	}


	public String getUnits_per_case() {
		return units_per_case;
	}


	public void setUnits_per_case(String units_per_case) {
		this.units_per_case = units_per_case;
	}


	public String getCases_per_pallet() {
		return cases_per_pallet;
	}


	public void setCases_per_pallet(String cases_per_pallet) {
		this.cases_per_pallet = cases_per_pallet;
	}


	public String getShelf_width() {
		return shelf_width;
	}


	public void setShelf_width(String shelf_width) {
		this.shelf_width = shelf_width;
	}


	public String getShelf_height() {
		return shelf_height;
	}


	public void setShelf_height(String shelf_height) {
		this.shelf_height = shelf_height;
	}


	public String getShelf_depth() {
		return shelf_depth;
	}


	public void setShelf_depth(String shelf_depth) {
		this.shelf_depth = shelf_depth;
	}


	public String getProduct_price() {
		return product_price;
	}


	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	
	

}
