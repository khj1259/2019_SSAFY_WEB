import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/**
 *	자바 정리 Collection Framework
 */
public class Z17_tttt {
	public static void main(String[] args) {
		
//		List	순서유지, 데이터의 중복가능
//			ArrayList, LinkedList
//		Set		순서없음, 데이터의 중복불가
//			HashSet, TreeSet
//		Map		키:값 의 구조로 되어있음
//				키는 중복불가, 값은 중복가능 - 키가 중복시 값이 덮어씌워짐
//			HashMap, TreeMap

//		Hash 기법을 사용하려면 hashCode(), equals() 를 Overriding 해야한다
		HashSet<Girl> hs = new HashSet<Girl>();
		hs.add(new Girl(26,"서민규"));
		hs.add(new Girl(26,"서민규")); // 같은 객체는 저장을 안해줌
		hs.add(new Girl(22,"수지"));
		
		System.out.println(hs);
		
		HashMap<Girl, Integer> hm = new HashMap<Girl, Integer>();
		hm.put(new Girl(26,"류현진"), 100);
		hm.put(new Girl(26,"서민규"), 100);
		hm.put(new Girl(26,"서민규"), 200); // 같은 객체가 들어오면 저장을 안해줌
		hm.put(new Girl(22,"수지"), 80);
		System.out.println("test");
		Set<Girl> ks = hm.keySet();
//		Map에서 키 셋 이용해서 순회
		for (Entry<Girl, Integer> girl : hm.entrySet()) {
			System.out.println(girl);
		}

		List<Integer> li = new ArrayList<>();
		ListIterator<Integer> a =  li.listIterator();
		a.nextIndex();
		Iterator<Girl> iter =  ks.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		for(Girl g : ks) { // for each;
			System.out.println(hm.get(g));
		}
		
//		트리셋으로 셋을 구분할때는 클레스내부에선 Comparable를 생성자 내부에선 Comparator 를 사용해서 비교값을 정해줘야한다.
//		외부의 비교기준이 우선순위가 더 높다.
		TreeSet<Cup> ts = new TreeSet<Cup>(new Comparator<Cup>() { // 클래스 외부의 비교기준을 작성
		@Override
		public int compare(Cup o1, Cup o2) {
			return o1.size - o2.size;
		}});
		ts.add(new Cup(100, "서민규"));
		ts.add(new Cup(100, "서민규"));
		ts.add(new Cup(70, "수지"));
		System.out.println(ts);
		
		
		HashSet<Integer> set = new HashSet<>();
		
		set.add(500);
		set.add(400);
		set.add(35120);
		set.add(5015120);
		set.add(512300);
		set.add(5021350);
		set.add(56400);
		set.add(5400);
		set.add(51235100);
		System.out.println(set);
		

		
		
	} // end of main
} // end of class


class Cup implements Comparable<Cup> { //클래스 내부의 비교기준
	
	int size;
	String name = "";
	
	public Cup() {
	}

	public Cup(int size, String name) {
		this.size = size;
		this.name = name;
	}

	public String toString() {
		return String.format("[%d,%s]", size, name);
	}
	
	@Override
	public int compareTo(Cup o) {
		return o.size - this.size;
	}
	
}


class Girl {
	
	int age;
	String name;
	
	public Girl() {
	}

	public Girl(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int hashCode() { // 각 키에 대한 유니크한 해쉬값을 만들어야함.
		super.hashCode();
		return (age+name).hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof Girl) {
			Girl g = (Girl) obj;
			return this.age == g.age && this.name.equals(g.name);
		}
		super.equals(obj);
		return false;
	}
	
	@Override
	public String toString() {
		return  String.format("[%d,%s]",age,name);
	}
	
}









