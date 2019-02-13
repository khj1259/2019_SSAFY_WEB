import java.awt.Checkbox;

/**
 *  자바정리2
 */
public class Z16_qqqq {
	
	public Z16_qqqq() {
	}
	
	public Z16_qqqq(int a) {
	}
	
	static void a(boolean x, int y) {}
	static void a(int y, boolean x) {}
	static void a(boolean x) {}
	static void a(int x) {}
	static void a() {}
	
	
	public static void main(String[] args) {
//		overloading 오버로딩 	: 하나의 클래스 내에서 동일한 메서드명을 사용하는 기법
//				조건	: 맥변수의 개수 or 타입  or 순서가 달라야한다.
//		overriding 오버라이딩 	: 두 클래스(부모, 자식)관계에서 부모클래스의 메서드를 자식클래스에서 재정의 하는 기법

		C c = new C();
		c.print();
		
//		new Man(); // abstract class 객체생성 불가
		new ManMan();
	}
	
}
interface Movable {
	void move();
}

interface Fightable {
	void move();
	void fight();
	
}

interface Attackable extends Movable, Fightable { // 인터페이스 끼리는 다중상속이 가능
	
}

class Attack implements Fightable {
	
	public void fight() {
		
	}
	
	public void move() {
		
	}
	
}

interface Aable { //알맹이는 하나도 없는 완전한 껍데기, 상수, 추상메서드만 포함 가능
	public static final int a = 3; // 상수
	int b = 4; // 부족한 제어자를 컴파일러가 추가해준다.
	
	public abstract void p();
	void q(); // 부족한 제어자를 컴파일러가 추가해준다.
}


abstract class Man { //abstract 메서드가 하나라도 있으면, class도 abstract로 선언해줘야만 한다.
	abstract void p(); // 추상 메서드 : 선언부만 작성한 메서드, abstract를 선언해줘야만 한다.
	int a;	// 변수
	static int b;
	void q() {	//일반 메서드
	}
}

class ManMan extends Man {
	@Override
	void p() { //오버라이딩
	}
}



//패키지명 : 첫글자 소문자
//클래스명 : 첫글자 대문자
//인터페이스명 : 첫글자 대문자, ~able
//생성자명 : 첫글자 대문자()
//메서드명 : 첫글자 소문자()
//변수명    : 첫글자 소문자








class P {
	int x = 10;
	void print() {
		System.out.println("안녕 난 P야");
	}
}

class C extends P {
	int x = 20;
	void print() {
		System.out.println("안녕 난 C야");
	}
}