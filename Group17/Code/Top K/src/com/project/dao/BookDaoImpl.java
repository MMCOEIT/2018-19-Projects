package com.project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.project.beans.BookBeans;
import com.project.beans.UserBeans;
import com.project.beans.UserSearchBookBeans;
import com.project.connectionManger.ConnnectionUtil;

public class BookDaoImpl implements BookDao {

	Connection con=ConnnectionUtil.getConnection();
	
	@Override
	public ResultSet getBookInfromation(BookBeans bookBeans) {
		// TODO Auto-generated method stub
		
		//id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_price
		
		ResultSet rs=null;
		
		/*String sql="Select * from book_data_set where id=? ";*/
		
		String sql="Select * from final_product_data_set where id=? ";
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			
			ps.setInt(1, bookBeans.getBook_id());
			
			rs=ps.executeQuery();
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}

	@Override
	public int bookInsertUpgrowth(BookBeans bookBeans,String tableName) {
		// TODO Auto-generated method stub
		
		//id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, book_hit
		
		int m=1;
		
		String sql="insert into "+ tableName+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		System.out.println("sql insert is "+sql);
		
		System.out.println("table name is methods"+tableName);
		
		
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			
			ps.setInt(1, 0);

			ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBrand_name());
			
			ps.setString(4, bookBeans.getProduct_name());
			
			ps.setString(5, bookBeans.getSKU());
			
			ps.setString(6, bookBeans.getSRP());
			
			ps.setString(7, bookBeans.getGross_weirth());
			
			ps.setString(8, bookBeans.getNet_weigth());
			
			ps.setString(9, bookBeans.getRecylared());
			
			ps.setString(10, bookBeans.getLow_fat());
			
			ps.setString(11, bookBeans.getUnits_pre());
			
			ps.setString(12, bookBeans.getCase_pre());
		
			ps.setString(13, bookBeans.getShelf_heigth());
			
			ps.setString(14, bookBeans.getShelf_width());
			
			ps.setString(15, bookBeans.getShelf_depth());
			
            ps.setInt(16, 1);
            
            ps.setInt(17, 0);
            
            
			
			m=ps.executeUpdate();
			
							
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return m;
	}

	@Override
	public ResultSet bookCheckUpgrowth(BookBeans bookBeans, String tableName) {
		// TODO Auto-generated method stub
		
		System.out.println("In Methods are "+tableName);
		
		//id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_hit,product_Buy
		
		ResultSet rs=null;
		
		String sql="Select * from "+tableName+" where product_id=? and brand_name=? and  product_name=? and  SKU=? and SRP=? and  gross_weirth=? and  net_weigth=? and recylared=? and  low_fat=? and  units_pre=?  and  Case_pre=? and shelf_heigth=? and  shelf_width=?  and shelf_depth=?  ";
		
		System.out.println("sql is "+sql);
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			
	        ps.setInt(1, bookBeans.getBook_id());
			
			ps.setString(2, bookBeans.getBrand_name());
			
			ps.setString(3, bookBeans.getProduct_name());
			
			ps.setString(4, bookBeans.getSKU());
			
			ps.setString(5, bookBeans.getSRP());
			
			ps.setString(6, bookBeans.getGross_weirth());
			
			ps.setString(7, bookBeans.getNet_weigth());
			
			ps.setString(8, bookBeans.getRecylared());
			
			ps.setString(9, bookBeans.getLow_fat());
			
			ps.setString(10, bookBeans.getUnits_pre());
			
			ps.setString(11, bookBeans.getCase_pre());
							
			ps.setString(12, bookBeans.getShelf_heigth());
			
			ps.setString(13, bookBeans.getShelf_width());
			
			ps.setString(14, bookBeans.getShelf_depth());

			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return rs;
	}

	@Override
	public int bookUpGrowthCount(BookBeans bookBeans, int count,String tableName) {
		// TODO Auto-generated method stub
		
		////id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_hit,product_Buy
		
		int n=1;
		
		String sql="update "+ tableName +" set product_hit=? where product_id=? and brand_name=? and  product_name=? and  SKU=? and SRP=? and  gross_weirth=? and  net_weigth=? and recylared=? and  low_fat=? and  units_pre=?  and  Case_pre=? and shelf_heigth=? and  shelf_width=?  and shelf_depth=?  ";
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			
			ps.setInt(1, count);
			
           ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBrand_name());
			
			ps.setString(4, bookBeans.getProduct_name());
			
			ps.setString(5, bookBeans.getSKU());
			
			ps.setString(6, bookBeans.getSRP());
			
			ps.setString(7, bookBeans.getGross_weirth());
			
			ps.setString(8, bookBeans.getNet_weigth());
			
			ps.setString(9, bookBeans.getRecylared());
			
			ps.setString(10, bookBeans.getLow_fat());
			
			ps.setString(11, bookBeans.getUnits_pre());
			
			ps.setString(12, bookBeans.getCase_pre());
		
			ps.setString(13, bookBeans.getShelf_heigth());
			
			ps.setString(14, bookBeans.getShelf_width());
			
			ps.setString(15, bookBeans.getShelf_depth());
			
	       
			n=ps.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return n;
	}

	@Override
	public int bookUpGrowthCountBuy(BookBeans bookBeans, int count,
			String tableName) {
		// TODO Auto-generated method stub
		
		//	////id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_hit,product_Buy
		
		int m=1;
		
		String sql="update "+ tableName +" set product_Buy=? where product_id=? and brand_name=? and  product_name=? and  SKU=? and SRP=? and  gross_weirth=? and  net_weigth=? and recylared=? and  low_fat=? and  units_pre=?  and  Case_pre=? and shelf_heigth=? and  shelf_width=?  and shelf_depth=?  ";
		
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			
			
			ps.setInt(1, count);
			
			  ps.setInt(2, bookBeans.getBook_id());
				
				ps.setString(3, bookBeans.getBrand_name());
				
				ps.setString(4, bookBeans.getProduct_name());
				
				ps.setString(5, bookBeans.getSKU());
				
				ps.setString(6, bookBeans.getSRP());
				
				ps.setString(7, bookBeans.getGross_weirth());
				
				ps.setString(8, bookBeans.getNet_weigth());
				
				ps.setString(9, bookBeans.getRecylared());
				
				ps.setString(10, bookBeans.getLow_fat());
				
				ps.setString(11, bookBeans.getUnits_pre());
				
				ps.setString(12, bookBeans.getCase_pre());
			
				ps.setString(13, bookBeans.getShelf_heigth());
				
				ps.setString(14, bookBeans.getShelf_width());
				
				ps.setString(15, bookBeans.getShelf_depth());
				
			m=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}

	@Override
	public int bookInsertUpGrowthBuy(BookBeans bookBeans, String tableName) {
		//id, book_id, book_author, book_name, book_prices, book_buy, book_hit, book_cat
		
				int m=1;
				
				String sql="insert into "+ tableName+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				System.out.println("sql insert is "+sql);
				
				System.out.println("table name is methods"+tableName);
				
				
				
				try {
					PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
					
					ps.setInt(1, 0);

					ps.setInt(2, bookBeans.getBook_id());
					
					ps.setString(3, bookBeans.getBrand_name());
					
					ps.setString(4, bookBeans.getProduct_name());
					
					ps.setString(5, bookBeans.getSKU());
					
					ps.setString(6, bookBeans.getSRP());
					
					ps.setString(7, bookBeans.getGross_weirth());
					
					ps.setString(8, bookBeans.getNet_weigth());
					
					ps.setString(9, bookBeans.getRecylared());
					
					ps.setString(10, bookBeans.getLow_fat());
					
					ps.setString(11, bookBeans.getUnits_pre());
					
					ps.setString(12, bookBeans.getCase_pre());
				
					ps.setString(13, bookBeans.getShelf_heigth());
					
					ps.setString(14, bookBeans.getShelf_width());
					
					ps.setString(15, bookBeans.getShelf_depth());
					
		            ps.setInt(16, 0);
		            
		            ps.setInt(17, 1);
		            
					m=ps.executeUpdate();
					
									
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				return m;
	}

	@Override
	public ResultSet bookGetRecordFromSearching(
			UserSearchBookBeans userSearchBookBeans) {
		// TODO Auto-generated method stub
		
		// id, book_id, book_author, book_name, book_prices, book_buy, book_hit, book_cat
		
		ResultSet rs=null;
		
		String sql="Select * from "+ userSearchBookBeans.getTable_name() ;
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int bookSearchRecordInsert(UserBeans userBeans,
			UserSearchBookBeans userSearchBookBeans) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_name, book_category, top_k_value, table_name
		
		
	    int n=1;
	    
	    String sql="insert into user_search_book value(?,?,?,?,?,?,?)";
	    
	    PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setInt(1, 0);
		       
		    ps.setInt(2, userBeans.getId());
		    
		    ps.setString(3, userBeans.getUser_email());
		    
		    ps.setString(4, userBeans.getUser_name());
		    
		    ps.setString(5, userSearchBookBeans.getUser_category());
		    
		    ps.setInt(6, userSearchBookBeans.getUser_top_k_value());
		    
		    ps.setString(7, userSearchBookBeans.getTable_name());
		    
		    n=ps.executeUpdate();
		    
		    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public ResultSet bookInfomationGet(String bookName, String bookCategory) {
		// TODO Auto-generated method stub
		
		//id, book_name, book_author, book_infomation, book_category
		
		System.out.println("in method of book Information");
		
		ResultSet rs=null;
		
		String sql="Select * from product_infomation where  book_name=? and book_category=? ";
		
		System.out.println("in method of book Information of book name "+bookName);
		
		System.out.println("in method of book Information book Category is "+bookCategory);
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, bookName);
			
			ps.setString(2, bookCategory);		
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}



}
