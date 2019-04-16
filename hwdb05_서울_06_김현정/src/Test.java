import java.util.List;

public class Test {
	public static void main(String[] args) {
		ProductDAO dao = ProductDAO.getInstance();

		// 삽입 테스트
		int result = dao.insertProduct(new Product("BB001", "LG 김치냉장고", 1000000));
		System.out.println("삽입 : " + result + "개 행 적용");
		int result2 = dao.insertProduct(new Product("BB002", "LG 스타일러", 1500000));
		System.out.println("삽입 : " + result + "개 행 적용");

		// 수정 테스트
		int result3 = dao.updateBook(new Product("BB001", "LG 김치냉장고 - 수정", 800000));
		System.out.println("수정 : " + result3 + "개 행 적용");

		// 전체 검색
		List<Product> list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// 한개 검색
		Product product = dao.selectOne("BB001");
		System.out.println("한개 검색 : "+product);

		// 삭제 테스트
		int result4 = dao.deleteBook(new Product("BB002", "LG 스타일러", 1500000));
		System.out.println("삭제 : " + result4 + "개 행 적용");

	}// end main
}// end class
