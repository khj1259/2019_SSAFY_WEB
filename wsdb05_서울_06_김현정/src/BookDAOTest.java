import java.util.List;

public class BookDAOTest {
	public static void main(String[] args) {
		BookDAO dao = BookDAO.getInstance();
		
		//삽입 테스트
		BookVO book = new BookVO("111-1-11", "테스트용 책제목", "테스트 작가", "테스트 출판사", 20000, "테스트~~");
		int result = dao.insertBook(book);
		System.out.println("삽입 : "+result+"개 행 적용");
		book = new BookVO("222-2-22", "테스트용 책제목2", "테스트 작가2", "테스트 출판사2", 220000, "테스트22~~");
		result = dao.insertBook(book);
		System.out.println("삽입 : "+result+"개 행 적용");
		
		//수정 테스트
		BookVO book2 = new BookVO("111-1-11", "수정 책제목", "테스트 작가", "테스트 출판사", 20000, "수정 테스트~~");
		int result2 = dao.updateBook(book2);
		System.out.println("수정 : "+result2+"개 행 적용");
		
		//전체 검색
		List<BookVO> list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//한권 검색
		BookVO book3 = dao.selectOne("111-1-11");
		System.out.println(book3);
		
		//삭제 테스트
		int result4 = dao.deleteBook(book3);
		System.out.println("삭제 : "+result4+"개 행 적용");
		
	}//end main
}//end class
