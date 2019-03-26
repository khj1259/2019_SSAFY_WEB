package mvc.service;

import java.util.ArrayList;

import mvc.vo.Book;

//client(Controller)를 위한 서비스 내용 표시
public interface BookService {
	public ArrayList<Book> selectAll();
	public Book selectOne(String num);
	public void insert(Book b);
	public void delete(String num);
	public Book searchByIsbn(String isbn);
	public ArrayList<Book> searchByTitle(String title);
	public ArrayList<Book> searchByPublisher(String publisher);
	public ArrayList<Book> searchByPrice(int price);
}
