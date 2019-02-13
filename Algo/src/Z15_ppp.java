/**
 * 자바 정리
 */


public class Z15_ppp {
	public static void main(String[] args) {
		// 변수 : 기본형, 참조형
		
		
		//이프문은 항상 위에서부터 보고 내려오기에 위쪽부터 우선순위가 있다.
//		if(true) {
//		} else if (true) {
//		} else {
//		}
//		
		
		int num = 'x'; //자동 형변환, 묵시적 형벼놘 : 데이터의 손실이 일어나지 않을때 컴파일러가 자동으로 해줌
		num = (int)3L; // 강제현변환을 해야한다.
		//우선순위가 없다. 그러기에 한번에 분기해서(자바한정) 이프문보다 속도면에서 빠르다.
		switch (num) { // 조건값 : int형 이내의 정수, String 두가지만 가능
		case 1:
		case 2:
		case 3:
			break;	//가장 가까운 반복문, switch~case문 하나만 빠져 나간다. 
		default:
			break;
		}
		
		Boy boy = new Boy();
		System.out.println(boy.name);
		
		CC c = new CC();
		c.pp();
	}
}

//this : 나 자신의 객체를 가리키는 참조변수
//super : 부모의 객체를 가리키는 참조변수
class GP {
	int x = 40;
}

class PP extends GP {
	int x = 30;
	
	int superx() {
		return super.x;
	}
}

class CC extends PP { // this, super 키워드
	int x = 20;
	
	void pp() {
		int x = 1;
		//참조 기본원칙 : 참조할 위치에서 가까운 곳에 선언된 변수를 참조한다.
		System.out.println(x);
		System.out.println(this.x); // 나의 전역변수 이상의 멤버에 접근할 수 있다.
		System.out.println(super.x); // 부모의 전역변수 이상의 멤버에 접근할 수 있다.
		System.out.println(superx());
	}
	
}


//class 에 사용할 수 있는 접근제어자 public, default
class Boy { //field, 전역변수 : 클래스 안쪽 && 메서드 바깥쪽 에 선언한 변수, 각 타입의 초기값으로 초기화 된다.
	int age;
	String name = ""; // 빈문자열로 초기화 안해주면 null이들어가있다.
	
	// 모든 클래스에는 반드시 하나 이상의 생성자가 있어야 한다.
	// 생성자를 하나도 작성하지 않으면, 컴파일러가 기본 생성자를 추가해준다.
	// 생성자를 뭔가 작성하면, 컴파일러는 더이상 생성자를 추가해주시 않는다.
	
	// 생성자는 클래스명과 동일한 이름을 쓴다, 리턴 값을 줄수 없다, 
	// 객체를 생성할때마다 가장먼저 한번씩 호출됨, 인스턴스 변수들의 초기화 작업을 주로 담당
	public Boy() { // 기본 생성자 - 매개변수가 하나도 없는 생성자
//		int z = 3; // 이렇게 하면 에러남
		this(1,"홍길동"); // 나의 클래스의 또다를 생성자 호출
	}
	
	// 모든 생성자의 첫번째 줄에는 또 다른 생성자를 호출해야한다.
	// 생성자에서 다른 생성자를 호출하지 않으면, 컴파일러가 부모의 기본생성자를 호출하는 super(); 를 삽입해준다.
	public Boy(int age, String name) { //생성자
		this.age = age;
		this.name = name;
	}
	
}