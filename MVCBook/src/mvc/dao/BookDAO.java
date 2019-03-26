package mvc.dao;

import java.util.ArrayList;

import mvc.service.BookService;
import mvc.vo.Book;

// 실제로 DB작업하는 객체(CRUD)
// DAO(Data Access Object)
public class BookDAO implements BookService{
	ArrayList<Book> list;
	
	public BookDAO() {
		//ArrayList 생성, db연결 준비 작업
		list = new ArrayList<>();
		list.add(new Book("111-111-111", "title1", "소설", "국내", "2019.03.02", "동아", "홍길동", 5000, "원", "test~~~"));
		list.add(new Book("222-111-111", "title2", "소설", "국내", "2019.03.02", "동아", "홍길동", 6000, "원", "test~~~"));
		list.add(new Book("333-111-111", "title3", "소설", "국내", "2019.03.02", "동아", "홍길동", 7000, "원", "test~~~"));
	}
	
	@Override
	public ArrayList<Book> selectAll() {
		//db에서 모든 데이터 가져와서 ArrayList에 넣어 리턴
		return list;
	}

	@Override
	public Book selectOne(String isbn) {
		Book bb = null;
		for (Book b : list) {
			if(b.getIsbn().equals(isbn)) {
				bb = b;
				break;
			}
		}
		return bb;
	}

	@Override
	public void insert(Book b) {
		list.add(b);
		
	}

	@Override
	public void delete(String isbn) {
		for (Book b : list) {
			if(b.getIsbn().equals(isbn)) {
				list.remove(b);
				break;
			}
		}
		
	}
	
	public ArrayList<Book> search(){
		return list;
	}
	
	public Book searchByIsbn(String isbn) {
		for (Book book : list) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> rlist = new ArrayList<Book>();
		for (Book book : list) {
			if(book.getTitle().contains(title)) {
				rlist.add(book);
			}
		}
		return rlist;
	}

	public ArrayList<Book> searchByPublisher(String publisher) { 
		ArrayList<Book> rlist = new ArrayList<Book>();
		for (Book book : list) {
			if(book.getPublisher().contains(publisher)) {
				rlist.add(book);
			}
		}
		return rlist;
		
	}
	
	public ArrayList<Book> searchByPrice(int price) {
		ArrayList<Book> rlist = new ArrayList<Book>();
		for (Book book : list) {
			if(book.getPrice() <= price) {
				rlist.add(book);
			}
		}
		return rlist;
		
	}

}
