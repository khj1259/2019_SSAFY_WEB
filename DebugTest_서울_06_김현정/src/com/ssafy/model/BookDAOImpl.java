package com.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.util.DBUtil;


public class BookDAOImpl implements IBookDAO {
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#insertBook(com.ssafy.model.Book)
	 */
	@Override
	public void insertBook(Book book) throws Exception{		
        String query = null;
        Connection conn = null;
        PreparedStatement pstmt = null;

        query = "insert into book (isbn,title,catalogue, nation, publish_date ,publisher, author,price,currency, description) values(?,?,?,?,str_to_date(?,'%Y.%m.%d'),?,?,?,?,?)";
        try {
        	
        	conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getCatalogue());
            pstmt.setString(4, book.getNation());
            pstmt.setString(5, book.getPublishDate());
            pstmt.setString(6, book.getPublisher());
            pstmt.setString(7, book.getAuthor());
            pstmt.setInt(8, book.getPrice());
            pstmt.setString(9, book.getCurrency());
            pstmt.setString(10, book.getDescription());
            
            pstmt.executeUpdate();

        } finally {
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }		
	}
	
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#search()
	 */
	@Override
	public List<Book> search() throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<Book>();        
        String query = "select isbn, title, catalogue, author from book";
        
        try {        	
        	conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);            
    		rs = pstmt.executeQuery();    		
    		while(rs.next()){
    			list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
    		}			
        } finally {
        	DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }	
        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#searchByTitle(java.lang.String)
	 */
	@Override
	public List<Book> searchByTitle(String title) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<Book>();        
        String query = "select isbn, title, catalogue, author from book where title like ?";
        
        try {        	
        	conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query); 
            pstmt.setString(1, "%"+title+"%");
    		rs = pstmt.executeQuery();    		
    		while(rs.next()){
    			list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
    		}			
        } finally {
        	DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }	
        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#searchByPublisher(java.lang.String)
	 */
	@Override
	public List<Book> searchByPublisher(String publisher) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<Book>();        
        String query = "select isbn, title, catalogue, author from book where publisher  like ?";
        
        try {        	
        	conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);   
            pstmt.setString(1, "%"+publisher+"%");
    		rs = pstmt.executeQuery();    		
    		while(rs.next()){
    			list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
    		}			
        } finally {
        	DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }	
        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#searchByPrice(int)
	 */
	@Override
	public List<Book> searchByPrice(int price) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<Book>();        
        String query = "select isbn, title, catalogue, author from book where  price <= ?";
        
        try {        	
        	conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);   
            pstmt.setInt(1, price);
    		rs = pstmt.executeQuery();    		
    		while(rs.next()){
    			list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
    		}			
        } finally {
        	DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }	
        return list;
	}
	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#search(java.lang.String)
	 */
	@Override
	public Book search(String isbn) throws Exception{
        String query = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
       Book b = null;
        
        query = "select * from book where isbn = ?";
        
        try {
        	
        	conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, isbn);

    		rs = pstmt.executeQuery();
    		
    		if(rs.next()){
    			b=new Book();
    			b.setIsbn(rs.getString("isbn"));
    			b.setTitle(rs.getString("title"));
    			b.setCatalogue(rs.getString("catalogue"));
    			b.setPublishDate(rs.getString("publish_date"));
    			b.setPublisher(rs.getString("publisher"));
    			b.setAuthor(rs.getString("author"));
    			b.setPrice(rs.getInt("price"));
    			b.setCurrency(rs.getString("currency"));
    			b.setDescription(rs.getString("description"));
    		}	  	
        } finally {
        	DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }	
        
        return b;
	}

	/* (non-Javadoc)
	 * @see com.ssafy.model.IBookDAO#delete(java.lang.String)
	 */
	@Override
	public void delete(String isbn) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;        
        String query = "delete from Book  where isbn=?";
        
        try {        	
        	conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, isbn);
    		pstmt.executeUpdate();
       } finally {
            DBUtil.close(pstmt);
            DBUtil.close(conn);
       }	   
	}
}
