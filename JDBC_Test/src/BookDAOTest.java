import java.util.List;

public class BookDAOTest {
	public static void main(String[] args) {
		BookDAO dao = BookDAO.getInstance(); // 외부에서 생성을 못함, 하나만들어놓은 객체를 얻어온다
		BookVO book = new BookVO();
		book.setBookid(10);
		book.setTitle("=====");
		book.setPublisher("****");
		book.setYear("2020");
		book.setPrice(10000);
//		int result = dao.insertBook(book);
//		int result = dao.updateBook(book);
//		int result = dao.deleteBook(book);
//		System.out.println("결과 :" + result + " 개의 행이 영향을 받았습니다.");
		
//		List<BookVO> list = dao.selectAll();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		BookVO b = dao.selectOne(2);
		System.out.println(b);
		
	}//end main
}//end class
