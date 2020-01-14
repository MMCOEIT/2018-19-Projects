package com.project.dao;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.project.beans.BookBeans;
import com.project.beans.UserBeans;
import com.project.beans.UserSearchBookBeans;
import com.project.connectionManger.ConnnectionUtil;

public class UserDaoImpl implements UserDao{
	
	Connection con=ConnnectionUtil.getConnection();

	@Override
	public ResultSet isAlreadyRegister(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from user_reg where user_email=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_email());
			
			
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int userRegistration(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		// id, user_name, user_email, user_password, user_contact_number, user_otp, user_time
		
		int n=1;
		
		String sql="insert into user_reg values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setString(2, userBeans.getUser_name());
			
			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_password());
			
			ps.setString(5, userBeans.getUser_contact_number());
			
			ps.setString(6, userBeans.getUser_otp());
			
			ps.setInt(7, userBeans.getUser_time());
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet userLoginCheck(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		// id, user_name, user_email, user_password, user_contact_number, user_otp, user_time
		
		String sql="Select * from user_reg where user_name=? or user_email=? and  user_password=? ";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_email());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userBeans.getUser_password());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int userUpdateUserTime(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		String sql="update user_reg set user_time=? where user_email=? and  user_password=? ";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setInt(1, 1);
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userBeans.getUser_password());
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return n;
	}

	@Override
	public ResultSet userLoginCheckWithOtp(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from user_reg where user_email=? and  user_password=? and user_otp=? ";
		
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_email());
			
			ps.setString(2, userBeans.getUser_password());
			
			ps.setString(3, userBeans.getUser_otp());
			
			
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet userSelectBookCategory() {
		// TODO Auto-generated method stub
		
		// book_title, book_category, book_author, book_price, id
		
		//id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_price
		
		ResultSet rs=null;
		
		/*String sql="Select * from book_data_set";*/
		
		String sql="Select * from final_product_data_set";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}

	@Override
	public int userChangesPassword(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		//id, userFname, userLname, userEmail, userPassword, userPhoneNumber, userOtp, userTime
		
		int n=1;
		
		String sql="update user_reg set userPassword=? where userEmail= ? and userPassword=? ";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_new_password());
			
			/*ps.setString(2, userBeans.get);*/
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	@Override
	public ResultSet userGetBookInfomation(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
	//id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth
		
		ResultSet rs=null;
		
		String sql="Select * from final_product_data_set where brand_name=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_Category());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	/*@Override
	public int userInsertViewBook(BookBeans bookBeans,UserBeans userBeans,int userHitBook) {
		// TODO Auto-generated method stub
		
		//id, book_id, product_name, product_Brand, product_SKU, product_SRP,  gross_weight,  net_weight,  recyclable_package,  low_fat,  units_per_case,  cases_per_pallet,  shelf_width,  shelf_height,  shelf_depth
		
		int n=1;
		
		String sql="insert into user_view_product_details values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			//book_title, book_category, book_author, book_price, id
			
			ps.setInt(1, 0);

			ps.setInt(2,bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBook_title());
			
			ps.setString(4, bookBeans.getBook_author());
			
			ps.setString(5,bookBeans.getBook_price());
			
			ps.setString(6, bookBeans.getBook_category());
			
			ps.setInt(7, userBeans.getId());
			
			ps.setString(8, userBeans.getUser_name());
			
			ps.setString(9, userBeans.getUser_email());
			
			ps.setInt(10, userHitBook);
			
			n=ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}
*/
	/*@Override
	public ResultSet userCheckAddToCard(UserBeans userBeans, BookBeans bookBeans) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_fname, book_id, book_title, book_price, book_author, book_category
		
		ResultSet rs=null;
		
		String sql="Select * from user_book_add_to_card where user_id= ? and  user_email=? and  book_id=? and book_title=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userBeans.getId());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setInt(3, bookBeans.getBook_id());
			
			ps.setString(4, bookBeans.getBook_title());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}
*/
	/*@Override
	public int userInsertAddToCard(UserBeans userBeans, BookBeans bookBeans) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_fname, book_id, book_title, book_price, book_author, book_category
		
		int n=1;
		
		String sql="insert into user_book_add_to_card values(?,?,?,?,?,?,?,?,?) ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());

			ps.setString(3, userBeans.getUser_email());
			
			ps.setString(4, userBeans.getUser_name());
			
			ps.setInt(5, bookBeans.getBook_id());
			
			ps.setString(6, bookBeans.getBook_title());
			
			ps.setString(7, bookBeans.getBook_price());
			
			ps.setString(8, bookBeans.getBook_author());
			
			ps.setString(9, bookBeans.getBook_category());
			
			n=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return n;
	}
*/
	@Override
	public int userCalculatedCountBooksInCard(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		int count=0;
		
		ResultSet rs=null;
		
		String sql="select Count(id) from user_book_add_to_card WHERE user_id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, userBeans.getId());
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				count=rs.getInt(1);
				
				System.out.println("count is "+count);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
		return count;
	}

	@Override
	public int userGetlastCount() {
		// TODO Auto-generated method stub
		
		int lastRow=0;
		
		ResultSet rs=null;
		
		String sql="Select max(id) from user_book_add_to_card ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				lastRow=rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return lastRow;
	}

	@Override
	public ResultSet userGetInfomation(int max_id) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_email, user_fname, book_id, book_title, book_price, book_author, book_category
		
		//id, user_id, user_email, user_fname, book_id, book_title, book_price, book_author, book_category
		
		ResultSet rs=null;
		
		String sql="Select * from user_book_add_to_card where book_id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, max_id);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	/*@Override
	public ResultSet userCheckBookViewDetails(UserBeans userBeans,
			BookBeans bookBeans) {
		// TODO Auto-generated method stub
		
		//id, book_id, book_name, book_author, book_prices, book_cat, user_id, user_name, user_email, usere_hit_book
		
		ResultSet rs=null;
		
		String sql ="select * from user_view_books where book_id=? and  book_name=? and book_cat=? and  user_id=? and  user_email=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, bookBeans.getBook_id());
			
			ps.setString(2, bookBeans.getBook_title());
			
			ps.setString(3, bookBeans.getBook_category());
		
			ps.setInt(4, userBeans.getId());
			
			ps.setString(5, userBeans.getUser_email());
			
			rs=ps.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return rs;
	}*/

	/*@Override
	public int userChangestheViewCount(BookBeans bookBeans,
			UserBeans userBeans, int userHitBook) {
		// TODO Auto-generated method stub
		int n=1;
		
		String sql="update user_view_books set usere_hit_book=?  where  book_id=? and  book_name=? and book_cat=? and  user_id=? and  user_email=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userHitBook);
			
            ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBook_title());
			
			ps.setString(4, bookBeans.getBook_category());
		
			ps.setInt(5, userBeans.getId());
			
			ps.setString(6, userBeans.getUser_email());
			
			n=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}
*/
	@Override
	public int userGetlastCountView() {
	int lastRow=0;
		
		ResultSet rs=null;
		
		String sql="Select max(id) from user_view_products ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				lastRow=rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return lastRow;
	}

	@Override
	public ResultSet usergetViewDeatislBooks(int max_id,UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		//id, book_id, book_name, book_author, book_prices, book_cat, user_id, user_name, user_email, usere_hit_book
		
				ResultSet rs=null;
				
				String sql="Select * from user_view_products where book_id=? and user_id= ? and user_name=? and  user_email=?";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.setInt(1, max_id);
					
					ps.setInt(2, userBeans.getId());
					
					ps.setString(3, userBeans.getUser_name());
					
					ps.setString(4, userBeans.getUser_email());
					
					System.out.println("Max id is "+max_id);
					
					System.out.println("Max id is "+userBeans.getId());
					
					System.out.println("Max id is "+userBeans.getUser_email());
					
					rs=ps.executeQuery();
					
				} catch (SQLException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return rs;
		
		
	}

	@Override
	public int userInsertViewBook(BookBeans bookBeans, UserBeans userBeans,
			int userHitBook) {
		int m=1;
		
		String sql="insert into user_view_products values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		System.out.println("sql insert is "+sql);
		
		//id, book_id, product_name, product_Brands, product_SKU, product_SRP, gross_weigth, net_weight, recyclable_package, low_fat, units_pre_case, cases_pre_pallet, shelf_width, shelf_heighth, shelf_depth, user_email, user_name, user_id, user_hit_count

			PreparedStatement ps;
			try {
				ps = (PreparedStatement) con.prepareStatement(sql);
				
				ps.setInt(1, 0);

				ps.setInt(2, bookBeans.getBook_id());
				
				ps.setString(3, bookBeans.getProduct_name());
				
				ps.setString(4, bookBeans.getBrand_name());
				
				
				
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
				
						
				ps.setString(16, userBeans.getUser_email());
				
				ps.setString(17, userBeans.getUser_name());
			
				ps.setInt(18, userBeans.getId());
				
				ps.setInt(19,userHitBook );
				
				m=ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return m;
	}

	@Override
	public ResultSet userCheckAddToCard(UserBeans userBeans, BookBeans bookBeans) {
		// TODO Auto-generated method stub
	
		//id, user_id, user_email, user_fname, book_id, book_title, book_price, book_author, book_category
		
				ResultSet rs=null;
				
				String sql="Select * from user_book_add_to_card where user_id= ? and  user_email=? and  book_id=? and book_title=?";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.setInt(1, userBeans.getId());
					
					ps.setString(2, userBeans.getUser_email());
					
					ps.setInt(3, bookBeans.getBook_id());
					
					ps.setString(4, bookBeans.getProduct_name());
					
					rs=ps.executeQuery();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return rs;
		
	}

	@Override
	public int userInsertAddToCard(UserBeans userBeans, BookBeans bookBeans) {
		//id, user_id, user_email, user_fname, book_id, book_title, book_price, book_author, book_category
		
				int n=1;
				
				String sql="insert into user_book_add_to_card values(?,?,?,?,?,?,?,?,?,?) ";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.setInt(1, 0);
					
					ps.setInt(2, userBeans.getId());

					ps.setString(3, userBeans.getUser_email());
					
					ps.setString(4, userBeans.getUser_name());
					
					ps.setInt(5, bookBeans.getBook_id());
					
					ps.setString(6, bookBeans.getProduct_name());
					
					ps.setString(7, bookBeans.getSKU());
					
					ps.setString(8, bookBeans.getCase_pre());
					
					ps.setString(9, bookBeans.getProduct_name());
					
					ps.setString(10, bookBeans.getProduct_price());
					
					n=ps.executeUpdate();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				
				return n;
	}
	
	
	//user_view_Product_details
	@Override
	public ResultSet userCheckBookViewDetails(UserBeans userBeans,
			BookBeans bookBeans) {
		ResultSet rs=null;
		
		//id, book_id, product_name, product_Brands, product_SKU, product_SRP, gross_weigth, net_weight, recyclable_package, low_fat, units_pre_case, cases_pre_pallet, shelf_width, shelf_heighth, shelf_depth, user_email, user_name, user_id, user_hit_count
		
		String sql="Select * from user_view_products where book_id=? and product_name=? and product_Brands=? and  product_SKU=? and  product_SRP=? and  gross_weigth=? and net_weight=? and  recyclable_package=?  and  low_fat=? and units_pre_case=? and  cases_pre_pallet=? and  shelf_width=? and  shelf_heighth=? and  shelf_depth=? and  user_email=? and  user_name=? and user_id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, bookBeans.getBook_id());
			
			ps.setString(2, bookBeans.getProduct_name());
			
			ps.setString(3, bookBeans.getBrand_name());
			
		
			
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
			
					
			ps.setString(15, userBeans.getUser_email());
			
			ps.setString(16, userBeans.getUser_name());
			
			ps.setInt(17, userBeans.getId());
		
			
		
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}

	@Override
	public int userChangestheViewCount(BookBeans bookBeans,
			UserBeans userBeans, int userHitBook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet userBuyBooks(UserBeans userBeans, BookBeans bookBeans) {
		
		////id, user_id, user_name, user_email, book_id, product_name, product_Brands, product_SKU, product_SPR, gross_weigth, net_weight, recyclable_package, low_fat, units_pre_case, cases_pre_pallet, shelf_width, shelf_heigth, shelf_depth, user_hit_count
		ResultSet rs=null;
		
		String sql ="select * from user_buy_book where user_id=? and  user_name=? and  user_email=? and  book_id=? and  product_name=? and product_Brands=? and  product_SKU=? and  product_SPR=? and  gross_weigth=? and  net_weight=? and  recyclable_package=? and  low_fat=? and  units_pre_case=? and  cases_pre_pallet=? and  shelf_width=? and  shelf_heigth=? and  shelf_depth=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
             ps.setInt(1, userBeans.getId());
			
            ps.setString(2, userBeans.getUser_name());
			
			ps.setString(3, userBeans.getUser_email());

			ps.setInt(4,bookBeans.getBook_id());
			
            		
			ps.setString(5, bookBeans.getProduct_name());
			
			ps.setString(6, bookBeans.getBrand_name());
			
		
			
			ps.setString(7, bookBeans.getSKU());
			
			ps.setString(8, bookBeans.getSRP());
			
			ps.setString(9, bookBeans.getGross_weirth());
			
			ps.setString(10, bookBeans.getNet_weigth());
			
			ps.setString(11, bookBeans.getRecylared());
			
			ps.setString(12, bookBeans.getLow_fat());
			
			ps.setString(13, bookBeans.getUnits_pre());
			
			ps.setString(14, bookBeans.getCase_pre());
		
			ps.setString(15, bookBeans.getShelf_heigth());
			
			ps.setString(16, bookBeans.getShelf_width());
			
			ps.setString(17, bookBeans.getShelf_depth());
			
			rs=ps.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int userBuyBooksInsert(UserBeans userBeans, BookBeans bookBeans,
			int userBuyBooksCount) {
		//id, user_id, user_name, user_email, book_id, product_name, product_Brands, product_SKU, product_SPR, gross_weigth, net_weight, recyclable_package, low_fat, units_pre_case, cases_pre_pallet, shelf_width, shelf_heigth, shelf_depth, user_hit_count
		
		int n=1;
		
		String sql="insert into user_buy_book values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			//book_title, book_category, book_author, book_price, id
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());
			
            ps.setString(3, userBeans.getUser_name());
			
			ps.setString(4, userBeans.getUser_email());

			ps.setInt(5,bookBeans.getBook_id());
			
            		
			ps.setString(6, bookBeans.getProduct_name());
			
			ps.setString(7, bookBeans.getBrand_name());
			
		
			
			ps.setString(8, bookBeans.getSKU());
			
			ps.setString(9, bookBeans.getSRP());
			
			ps.setString(10, bookBeans.getGross_weirth());
			
			ps.setString(11, bookBeans.getNet_weigth());
			
			ps.setString(12, bookBeans.getRecylared());
			
			ps.setString(13, bookBeans.getLow_fat());
			
			ps.setString(14, bookBeans.getUnits_pre());
			
			ps.setString(15, bookBeans.getCase_pre());
		
			ps.setString(16, bookBeans.getShelf_heigth());
			
			ps.setString(17, bookBeans.getShelf_width());
			
			ps.setString(18, bookBeans.getShelf_depth());
			
																	
			ps.setInt(19, userBuyBooksCount);
			
			n=ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int userUpdateBookBuyFormat(UserBeans userBeans,
			BookBeans bookBeans, int userFinalBuyCount) {
		   int n=1;
			
			String sql="update user_buy_book set user_hit_count=?  where  user_id=? and  user_name=? and  user_email=? and  book_id=? and  product_name=? and product_Brands=? and  product_SKU=? and  product_SPR=? and  gross_weigth=? and  net_weight=? and  recyclable_package=? and  low_fat=? and  units_pre_case=? and  cases_pre_pallet=? and  shelf_width=? and  shelf_heigth=? and  shelf_depth=? ";
			
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setInt(1, userFinalBuyCount);
				
	            				
				ps.setInt(2, userBeans.getId());
				
				ps.setString(3, userBeans.getUser_email());
				
				ps.setString(4, userBeans.getUser_name());
				
				ps.setInt(5,bookBeans.getBook_id());
				
        		
				ps.setString(6, bookBeans.getProduct_name());
				
				ps.setString(7, bookBeans.getBrand_name());
				
			
				
				ps.setString(8, bookBeans.getSKU());
				
				ps.setString(9, bookBeans.getSRP());
				
				ps.setString(10, bookBeans.getGross_weirth());
				
				ps.setString(11, bookBeans.getNet_weigth());
				
				ps.setString(12, bookBeans.getRecylared());
				
				ps.setString(13, bookBeans.getLow_fat());
				
				ps.setString(14, bookBeans.getUnits_pre());
				
				ps.setString(15, bookBeans.getCase_pre());
			
				ps.setString(16, bookBeans.getShelf_heigth());
				
				ps.setString(17, bookBeans.getShelf_width());
				
				ps.setString(18, bookBeans.getShelf_depth());
				
				n=ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return n;
	}

	@Override
	public int userInsertOrderPlaced(UserBeans userBeans, BookBeans bookBeans) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public ResultSet userCheckHitCount(BookBeans bookBeans) {
     ResultSet rs=null;
		
		//id, book_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, user_hit_count, user_buy_count
		
		String sql="Select * from user_view_product_details where product_id=? and product_name=? and product_Brand=? and  product_SKU=? and  product_SRP=? and  gross_weight=? and net_weight=? and  recyclable_package=?  and  low_fat=? and units_per_case=? and  cases_per_pallet=? and  shelf_width=? and  shelf_height=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, bookBeans.getBook_id());
			
			System.out.println("Book isd is "+bookBeans.getBook_id());
			
			ps.setString(2, bookBeans.getProduct_name());
			
			System.out.println("getProduct_name isd is "+bookBeans.getProduct_name());
			
			
			ps.setString(3, bookBeans.getBrand_name());
		
			System.out.println("getBrand_name isd is "+bookBeans.getBrand_name());
			
			ps.setString(4, bookBeans.getSKU());
			
			System.out.println("getSKU isd is "+bookBeans.getSKU());
			
			ps.setString(5, bookBeans.getSRP());
			
			System.out.println("getSRP"+bookBeans.getSRP());
			
			ps.setString(6, bookBeans.getGross_weirth());
			
			System.out.println("getGross_weirth isd is "+bookBeans.getGross_weirth());
			
			ps.setString(7, bookBeans.getNet_weigth());
			
			System.out.println("getNet_weigth isd is "+bookBeans.getNet_weigth());
			
			ps.setString(8, bookBeans.getRecylared());
			
			System.out.println("getRecylared isd is "+bookBeans.getRecylared());
			
			ps.setString(9, bookBeans.getLow_fat());
			
			System.out.println("getLow_fat isd is "+bookBeans.getLow_fat());
			
			ps.setString(10, bookBeans.getUnits_pre());
			
			System.out.println("getUnits_pre getUnits_pre is "+bookBeans.getUnits_pre());
			
			ps.setString(11, bookBeans.getCase_pre());
			System.out.println("getCase_pre isd is "+bookBeans.getCase_pre());
			ps.setString(13, bookBeans.getShelf_heigth());
			
			
			System.out.println("getShelf_heigth isd is "+bookBeans.getShelf_heigth());
			ps.setString(12, bookBeans.getShelf_width());
			
			System.out.println("getShelf_width isd is "+bookBeans.getShelf_width());
			/*ps.setString(14, bookBeans.getShelf_depth());
			
				
			System.out.println("getShelf_depth isd is "+bookBeans.getShelf_depth());
			*/
			
			System.out.println("FIneshed Process for Checking ");
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int userInsertHitCount(BookBeans bookBeans) {
		
int m=1;
		
		String sql="insert into user_view_product_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		System.out.println("sql insert is "+sql);
		
	//id, product_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, user_hit_count, user_buy_count, product_price

			PreparedStatement ps;
			try {
				ps = (PreparedStatement) con.prepareStatement(sql);
				
				ps.setInt(1, 0);

				ps.setInt(2, bookBeans.getBook_id());
				
				ps.setString(4, bookBeans.getBrand_name());
				
				ps.setString(3, bookBeans.getProduct_name());
				
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
				
				String s=bookBeans.getShelf_depth();
				
				float f = Float.valueOf(s.trim()).floatValue();
				
				
				System.out.println("in insert into table Result is "+f);
				ps.setFloat(15, f);
				
				ps.setInt(16,1 );

				
				ps.setInt(17,0 );
				
				ps.setString(18, bookBeans.getProduct_price());
				
				
				m=ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return m;
				          
	}

	@Override
	public int userUpdateHitCount(BookBeans bookBeans, int userHitCountFinal) {
	int n=1;
		
	
	//id, book_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, user_hit_count, user_buy_count
		String sql="update user_view_product_details set user_hit_count=? where  book_id=? and product_name=? and product_Brand=? and  product_SKU=? and  product_SRP=? and  gross_weigth=? and net_weight=? and  recyclable_package=?  and  low_fat=? and units_pre_case=? and  cases_pre_pallet=? and  shelf_width=? and  shelf_heighth=? and  shelf_depth=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userHitCountFinal);

            ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getProduct_name());
			
			ps.setString(4, bookBeans.getBrand_name());
			
		
			
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
	public int userInsertBuyCount(BookBeans bookBeans) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userUpdateBuyCount(BookBeans bookBeans, int userBuyCountFinal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet userGetRecordsTable(UserSearchBookBeans userSearchBookBeans) {
	ResultSet rs=null;
	
	//id, book_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, user_hit_count, user_buy_count
		
		System.out.println("In methods of Sql");
		
		String sql="Select * from user_view_product_details where product_Brand=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userSearchBookBeans.getUser_category());
			
			System.out.println(" Brand Category is "+userSearchBookBeans.getUser_category());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet userGetRandamValues() {
	ResultSet rs=null;
		
		String sql="SHOW COLUMNS FROM user_view_product_details";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int userInsertTkoResult(ResultSet rs, String finalResult,
			String columeName) {


         boolean res;
		
		int index=0,columeIndex=0;
		
		//id, product_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, user_hit_count, user_buy_count, product_price
		
		int n=1;
		
		
		
		String sql="insert into tko_result_table values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		System.out.println("In Methods 11 ");
		
		//id, product_id, product_name, brand_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth
		
		String array[]={"id", "product_id", "product_name","product_Brand","product_SKU", "product_SRP", "gross_weight", "net_weight", "recyclable_package","low_fat","units_per_case","cases_per_pallet","shelf_width","shelf_height", "shelf_depth","product_price"};
		
		if(Arrays.asList(array).contains(columeName))
		{
			System.out.println("colume Name is "+columeName);
			
			System.out.println("In Methods 11 ");
			
			System.out.println("colume Name is "+Arrays.asList(array).indexOf(columeName));
			
			index=Arrays.asList(array).indexOf(columeName);
			
			System.out.println("index value is "+index);
			
			/*columeIndex=index+1;*/
			
			columeIndex=index;
			
			System.out.println("colume Index is .............. "+columeIndex);
			
			System.out.println("In Methods 11 ");
		}
		
		//id, product_id, product_name, SKN, SRP, Gross_weight, Net_weight, recyclared, lowfat, unit_pre, case_pre, shelf_height, shelf_width, shelf_Depth
		
		else
		{
			System.out.println("No Found !");
		}
		
		
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			
             if(columeIndex==2){
				
				System.out.println("columIndx  2222222222222  is "+columeIndex);
				
				System.out.println("Insert into Prodcut Id ");
											
				ps.setString(2, finalResult);
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setInt(2, rs.getInt(2));
			}
			
			
		
			if(columeIndex==3){
				
				
				System.out.println("Insert into Product Name ");
				ps.setString(3, finalResult);
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(3, rs.getString(3));
			}
			
               if(columeIndex==4){
				
            	   System.out.println("columIndx  3333333333333  is "+columeIndex);
            	   ps.setString(4, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(4, rs.getString(4));
			}
			
			
               if(columeIndex==5){
            	   
            	   System.out.println("columIndx  4444444444444444  is "+columeIndex);
   				
   				
            	   ps.setString(5, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(5, rs.getString(5));
			}
			
               
               if(columeIndex==6){
   				
            	   System.out.println("columIndx  555555555555555  is "+columeIndex);
            	   ps.setString(6, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setInt(6, Integer.parseInt(rs.getString(6)));
			}
			
               
               if(columeIndex==7){
      				
            	   System.out.println("columIndx  6666666666666666  is "+columeIndex);
      				
            	   ps.setString(7, Integer.toString(rs.getInt(7)));
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setInt(7, rs.getInt(7));
			}
               
               if(columeIndex==8){
     				
            	   System.out.println("columIndx  777777777777 is "+columeIndex);
            	   
           	
   				
   				ps.setString(8, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(8, rs.getString(8));
			}
               
               if(columeIndex==9){
      				
            	   System.out.println("columIndx  88888888888888  is "+columeIndex);
            	   
            	   ps.setString(9, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(9, rs.getString(9));
			}
			
               if(columeIndex==10){
     				
            	   System.out.println("columIndx  99999999999999999  is "+columeIndex);
            	   
            	   ps.setString(10, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(10, rs.getString(10));
			}
               
               if(columeIndex==11){
    				
            	   System.out.println("columIndx  101010101010101  is "+columeIndex);
            	   
            	   ps.setString(11, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(11, rs.getString(11));
			}
			
               if(columeIndex==12){
    				
            	   System.out.println("columIndx  111111111111111111111  is "+columeIndex);
            	   
            	   ps.setString(12, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(12, rs.getString(12));
			}
               
               if(columeIndex==13){
   				
            	   System.out.println("columIndx  111111111111111111111  is "+columeIndex);
            	   
            	   ps.setString(13, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(13, rs.getString(13));
			}
               
               if(columeIndex==14){
      				
            	   System.out.println("columIndx  111111111111111111111  is "+columeIndex);
            	   
            	   ps.setString(14, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(14, rs.getString(14));
			}
               
               
               if(columeIndex==15){
     				
            	   System.out.println("columIndx  111111111111111111111  is "+columeIndex);
            	   
            	   ps.setString(15, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(15, rs.getString(15));
			}
               
               
               if(columeIndex==16){
    				
            	   System.out.println("columIndx  111111111111111111116  is "+columeIndex);
            	   
            	   ps.setString(16, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(16, rs.getString(18));
			}
               
               
               n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		
		
		
		
		return n;
		
		
		
	}

	@Override
	public ResultSet userCheckTKOResultTable(ResultSet rs, int columeIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userDeleteTKOTablerecord(String userCategory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet userGetTKOValue(UserSearchBookBeans userSearchBookBeans) {
		   ResultSet rs=null;
		   
		   //id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_hit, product_Buy
			
			String sql="Select * from "+ userSearchBookBeans.getTable_name()   + " order by product_Buy DESC "  ;
			
			System.out.println("Table Name  for final TKU Call is "+userSearchBookBeans.getTable_name() );
			
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				
			
				
				
				rs=ps.executeQuery();
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
					
			
			return rs;
			
	}

	@Override
	public ResultSet userGetTKUValueHit(UserSearchBookBeans userSearchBookBeans) {

		  ResultSet rs=null;
			
		  //id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_hit, product_Buy
		  
		  
			String sql="Select * from "+ userSearchBookBeans.getTable_name()   + " order by product_hit DESC "  ;
			
			System.out.println("Table Name is  "+ userSearchBookBeans.getTable_name());
			
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				
			
				
				
				rs=ps.executeQuery();
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
					
			
			return rs;
		
	}

	@Override
	public int userInsertGraphTable(int topk, long tkuTime, long tkoTime,
			long totalTime, String bookCategory) {
int n=1;
		
		//id, top_k_value, tko_value, tku_value, tkowithtku_value

System.out.println("In Methoids Graoph");
		
		String sql="insert into result_graph values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, topk);
			
			ps.setLong(3, tkuTime);
			
			ps.setLong(4, tkoTime);
			
			ps.setLong(5, totalTime);
			
			//ps.setLong(5, 0);
			
			ps.setString(6, bookCategory);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public ResultSet userCheckREcommdationProcess(UserBeans userBeans) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userChangePassword(UserBeans userBeans) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userConatctUs(String userName, String userEmail,
			String userPhone, String userMsg) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Override
	public ResultSet userBuyBooks(UserBeans userBeans, BookBeans bookBeans) {
		
		//id, user_id, user_name, user_email, book_id, book_name, book_author, book_prices, book_cat, book_hit_count
		
				ResultSet rs=null;
				
				String sql ="select * from user_buy_book where book_id=? and  book_name=? and book_cat=? and  user_id=? and  user_email=? ";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.setInt(1, bookBeans.getBook_id());
					
					ps.setString(2, bookBeans.getBook_title());
					
					ps.setString(3, bookBeans.getBook_category());
				
					ps.setInt(4, userBeans.getId());
					
					ps.setString(5, userBeans.getUser_email());
					
					rs=ps.executeQuery();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
				
	}*/

	/*@Override
	public int userBuyBooksInsert(UserBeans userBeans, BookBeans bookBeans,
			int userBuyBooksCount) {
		//id, user_id, user_name, user_email, book_id, book_name, book_author, book_prices, book_cat, book_hit_count
		
				int n=1;
				
				String sql="insert into user_buy_book values(?,?,?,?,?,?,?,?,?,?)";
				
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					
					//book_title, book_category, book_author, book_price, id
					
					ps.setInt(1, 0);
					
					ps.setInt(2, userBeans.getId());
					
	                ps.setString(3, userBeans.getUser_name());
					
					ps.setString(4, userBeans.getUser_email());

					ps.setInt(5,bookBeans.getBook_id());
					
					ps.setString(6, bookBeans.getBook_title());
					
					ps.setString(7, bookBeans.getBook_author());
					
					ps.setString(8,bookBeans.getBook_price());
					
					ps.setString(9, bookBeans.getBook_category());
																			
					ps.setInt(10, userBuyBooksCount);
					
					n=ps.executeUpdate();
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				return n;
	}

	@Override
	public int userUpdateBookBuyFormat(UserBeans userBeans,
			BookBeans bookBeans, int userFinalBuyCount) {
		
		//id, user_id, user_name, user_email, book_id, book_name, book_author, book_prices, book_cat, book_hit_count
          int n=1;
		
		String sql="update user_buy_book set book_hit_count=?  where  book_id=? and  book_name=? and book_cat=? and  user_id=? and  user_email=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userFinalBuyCount);
			
            ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBook_title());
			
			ps.setString(4, bookBeans.getBook_category());
		
			ps.setInt(5, userBeans.getId());
			
			ps.setString(6, userBeans.getUser_email());
			
			n=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int userInsertOrderPlaced(UserBeans userBeans, BookBeans bookBeans) {
		// TODO Auto-generated method stub
		
		//id, user_id, user_name, user_email, book_id, book_name, book_author, book_category, book_price
		
		int n=1;
		
		String sql="insert into user_order_palced values(?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			//book_title, book_category, book_author, book_price, id
			
			ps.setInt(1, 0);
			
			ps.setInt(2, userBeans.getId());
			
            ps.setString(3, userBeans.getUser_name());
			
			ps.setString(4, userBeans.getUser_email());

			ps.setInt(5,bookBeans.getBook_id());
			
			ps.setString(6, bookBeans.getBook_title());
			
			ps.setString(7, bookBeans.getBook_author());
			
			ps.setString(8, bookBeans.getBook_category());
			
			ps.setString(9,bookBeans.getBook_price());
			
			
																	
		
			
			n=ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
		
		
	}

	@Override
	public ResultSet userViewProfile(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		// id, user_name, user_email, user_password, user_contact_number, user_otp, user_time
		
		ResultSet rs=null;
		
		String sql="Select * from user_reg where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userBeans.getId());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 
		
		return rs;
	}

	@Override
	public ResultSet userCheckHitCount(BookBeans bookBeans) {
		// TODO Auto-generated method stub
		
		//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count
		
		ResultSet rs=null;
		
		String sql="Select * from user_view_product_details where  book_id=? and book_name=? and  book_author=? and  book_price =? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, bookBeans.getBook_id());
			
			ps.setString(2, bookBeans.getBook_title());
			
			ps.setString(3, bookBeans.getBook_author());
			
			ps.setString(4, bookBeans.getBook_price());
			
			rs=ps.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return rs;
	}

	@Override
	public int userInsertHitCount(BookBeans bookBeans) {
		// TODO Auto-generated method stub
		
	//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
		
		int n=1;
		
		String sql="insert into user_view_product_details values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBook_title());
			
			ps.setString(4, bookBeans.getBook_author());
			
			ps.setString(5, bookBeans.getBook_price());
			
			ps.setInt(6, 1);
			
			ps.setInt(7, 0);
			
			ps.setString(8, bookBeans.getBook_category());
			
			
			n=ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return n;
	}

	@Override
	public int userUpdateHitCount(BookBeans bookBeans, int userHitCountFinal) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		String sql="update user_view_product_details set book_hit_count=? where  book_id=? and  book_name=? and book_author=? and  book_price=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userHitCountFinal);

            ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBook_title());
			
			ps.setString(4, bookBeans.getBook_author());
			
			ps.setString(5, bookBeans.getBook_price());
			
			n=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int userInsertBuyCount(BookBeans bookBeans) {
		// TODO Auto-generated method stub
		
		////id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
		
		int n=1;
		
		String sql="insert into user_view_product_details values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBook_title());
			
			ps.setString(4, bookBeans.getBook_author());
			
			ps.setString(5, bookBeans.getBook_price());
			
			ps.setInt(6, 1);
			
			ps.setInt(7, 1);
			
			ps.setString(8, bookBeans.getBook_category());
			
			n=ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return n;
	}
	@Override
	public int userUpdateBuyCount(BookBeans bookBeans, int userBuyCountFinal) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		String sql="update user_view_product_details set book_buy_count=? where  book_id=? and  book_name=? and book_author=? and  book_price=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userBuyCountFinal);

            ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBook_title());
			
			ps.setString(4, bookBeans.getBook_author());
			
			ps.setString(5, bookBeans.getBook_price());
			
			n=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet userGetRecordsTable(UserSearchBookBeans userSearchBookBeans) {
		// TODO Auto-generated method stub
		
		//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
		
		ResultSet rs=null;
		
		System.out.println("In methods of Sql");
		
		String sql="Select * from user_view_product_details where book_category=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userSearchBookBeans.getUser_category());
			
			System.out.println("book category is "+userSearchBookBeans.getUser_category());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public ResultSet userGetRandamValues() {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="SHOW COLUMNS FROM user_view_product_details";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public int userInsertTkoResult(ResultSet rs, String finalResult,
			String columeName) {
		// TODO Auto-generated method stub
		
		boolean res;
		
		int index=0,columeIndex=0;
		
		int n=1;
		
		String sql="insert into user_top_k_result values(?,?,?,?,?,?,?,?,?)";
		
		String array[]={"id", "book_id", "book_name", "book_author", "book_price", "book_hit_count", "book_buy_count", "book_category"};
		
		if(Arrays.asList(array).contains(columeName))
		{
			System.out.println("colume Name is "+columeName);
			
			System.out.println("colume Name is "+Arrays.asList(array).indexOf(columeName));
			
			index=Arrays.asList(array).indexOf(columeName);
			
			System.out.println("index value is "+index);
			
			columeIndex=index+1;
			
			System.out.println("colume Index is "+columeIndex);
			
			
		}
		
		//id, book_table_id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
		
		//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			
             if(columeIndex==1){
				
				System.out.println("columIndx  2222222222222  is "+columeIndex);
											
				ps.setString(2, finalResult);
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(2, Integer.toString(rs.getInt(1)));
			}
			
			
		
			if(columeIndex==2){
				
				ps.setString(3, finalResult);
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(3, Integer.toString(rs.getInt(2)));
			}
			
               if(columeIndex==3){
				
            	   System.out.println("columIndx  3333333333333  is "+columeIndex);
            	   ps.setString(4, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(4, rs.getString(3));
			}
			
			
               if(columeIndex==4){
            	   
            	   System.out.println("columIndx  4444444444444444  is "+columeIndex);
   				
   				
            	   ps.setString(5, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(5, rs.getString(4));
			}
			
               
               if(columeIndex==5){
   				
            	   System.out.println("columIndx  555555555555555  is "+columeIndex);
            	   ps.setString(6, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(6, rs.getString(5));
			}
			
               
               if(columeIndex==6){
      				
            	   System.out.println("columIndx  6666666666666666  is "+columeIndex);
      				
            	   ps.setString(7, Integer.toString(rs.getInt(7)));
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setInt(7, rs.getInt(6));
			}
               
               if(columeIndex==7){
     				
            	   System.out.println("columIndx  777777777777 is "+columeIndex);
            	   
           	
   				
   				ps.setString(8, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setInt(8, rs.getInt(7));
			}
               
               if(columeIndex==8){
      				
            	   System.out.println("columIndx  88888888888888  is "+columeIndex);
            	   
            	   ps.setString(9, finalResult);
				
			}
			
			else
			{
				//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
				ps.setString(9, rs.getString(8));
			}
			
               n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		
		
		
		
		return n;
	}

	@Override
	public int userDeleteTKOTablerecord(String userCategory) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		String sql="delete from user_top_k_result where book_category=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userCategory);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet userCheckTKOResultTable(ResultSet rs,int columeIndex) {
		// TODO Auto-generated method stub
		
		//id, book_table_id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count, book_category
		
		ResultSet rs1=null;
		
		String sql="Select * from user_top_k_result where book_category=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userCategory);
			
			
			rs=ps.executeQuery();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		
		return rs;
	}

	@Override
	public ResultSet userGetTKOValue(UserSearchBookBeans userSearchBookBeans) {
		// TODO Auto-generated method stub
		
		//id, book_id, book_author, book_name, book_prices, book_buy, book_hit, book_cat
		
        ResultSet rs=null;
		
		String sql="Select * from "+ userSearchBookBeans.getTable_name()   + " order by book_buy DESC "  ;
		
		System.out.println("Sql for final TKU Call is "+sql);
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
		
			
			
			rs=ps.executeQuery();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		
		return rs;
		
		
	}

	@Override
	public ResultSet userGetTKUValueHit(UserSearchBookBeans userSearchBookBeans) {
		
//id, book_id, book_author, book_name, book_prices, book_buy, book_hit, book_cat
		
        ResultSet rs=null;
		
		String sql="Select * from "+ userSearchBookBeans.getTable_name()   + " order by book_hit DESC "  ;
		
		System.out.println("Sql for final TKU Call when hit count  is "+sql);
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
		
			
			
			rs=ps.executeQuery();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		
		return rs;
	}

	@Override
	public int userInsertGraphTable(int topk, long tkuTime, long tkoTime,
			long totalTime,String bookCaegory) {
		// TODO Auto-generated method stub
		int n=1;
		
		//id, top_k_value, tko_value, tku_value, tkowithtku_value
		
		String sql="insert into result_graph values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setInt(2, topk);
			
			ps.setLong(3, tkuTime);
			
			ps.setLong(4, tkoTime);
			
			ps.setLong(5, totalTime);
			
			ps.setString(6, bookCaegory);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public ResultSet userCheckREcommdationProcess(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from user_view_books where  user_id=? and  user_name =? and user_email= ?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setInt(1, userBeans.getId());
			
			ps.setString(2, userBeans.getUser_name());
			
			ps.setString(3, userBeans.getUser_email());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return rs;
	}

	@Override
	public int userChangePassword(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		//id, user_name, user_email, user_password, user_contact_number, user_otp, user_time
		int n=1;
		
		String sql="update user_reg set  where user_password=? where user_email=? and  user_password=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, userBeans.getUser_new_password());
			
			ps.setString(2, userBeans.getUser_email());
			
			ps.setString(3, userBeans.getUser_password());
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int userConatctUs(String userName, String userEmail,
			String userPhone, String userMsg) {
int n=1;
		
		//id, userName, userEmail, userPhone, userMsg
		
		String sql="insert into contact_us values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
						
			ps.setString(2, userName);
			
			ps.setString(3, userEmail);
			
			ps.setString(4, userPhone);
			
			ps.setStrin
			
			
			
			
			
			g(5, userMsg);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}*/
	
	@Override
	public ResultSet userViewProfile(UserBeans userBeans) {
		// TODO Auto-generated method stub
		
		// id, user_name, user_email, user_password, user_contact_number, user_otp, user_time
		
		ResultSet rs=null;
		
		String sql="Select * from user_reg where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userBeans.getId());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 
		
		return rs;
	}

	@Override
	public ResultSet userGetInfomationFinal(int productId) {
        
		//id, product_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth
		
		ResultSet rs=null;
		
		String sql="Select * from tko_result_table where product_id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, productId);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 
		
		return rs;
	}

	@Override
	public int userTkoResultGraph(String bookCategory, int topk, long tkoValue) {
         
				
		int n=1;
		
		//id, user_Category, user_ToK, user_tkoTime

         System.out.println("In Methoids Graoph");
		
		String sql="insert into tko_result values(?,?,?,?)";
		
		
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, 0);
				
				ps.setString(2, bookCategory);
				
				ps.setInt(3, topk);
				
				ps.setLong(4, tkoValue);
								
				
				
				n=ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			return n;
					
	}

	@Override
	public int userTKUResultGrpah(String bookCategory, int topk, long tkuValue) {
int n=1;
		
		//id, user_Category, user_ToK, user_tkoTime

         System.out.println("In Methoids Graoph");
		
		String sql="insert into tku_result values(?,?,?,?)";
		
		
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, 0);
				
				ps.setString(2, bookCategory);
				
				ps.setInt(3, topk);
				
				ps.setLong(4, tkuValue);
								
				
				
				n=ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			return n;
	}

	@Override
	public int userMainResult(String bookCategory, int topk, long mainValue) {
int n=1;
		
		//id, user_Category, user_ToK, user_tkoTime

         System.out.println("In Methoids Graoph");
		
		String sql="insert into Main_result values(?,?,?,?)";
		
		
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, 0);
				
				ps.setString(2, bookCategory);
				
				ps.setInt(3, topk);
				
				ps.setLong(4, mainValue);
								
				
				
				n=ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			return n;
	}
}
