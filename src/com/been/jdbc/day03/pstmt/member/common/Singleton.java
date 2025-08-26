package com.been.jdbc.day03.pstmt.member.common;

public class Singleton {
	/*
	 싱글톤 패턴 - 클래스의 인스턴스가 하나만 생성되도록 보장하는 디자인 패턴
	 * 데이터베이스 연결 작업은 부하가 큰 작업이고 반복될 수 록 데이터베이스에
	 무리가 갈 수 있다
	 > 데이터베이스 연결은 비용이 많이 드는 작업, 많은 메모리와 시스템 리소스가 필요한다
	 그런데 이러한 작업을 싱글톤으로 관리하면 한 번만 연결 객체를 생성하여 재사용할 수 있다
	 > 성능 향상, 새로운 연결을 생성할 때 마다 발생하는 비용 감소, 데이터베이스 부하 감소
	 */
	
	// static 이면서 Singleton 타입인 멤버 변수가 필요
	private static Singleton instance;
	// private 접근제한자인 생성
	private Singleton() {}
	// static 이면서 public 이고 리턴타입이 Singleton 인 메소드가 필요
	public static Singleton getInstance() {
		// if 문으로 멤버변수 null 체크 후 null 이면 객체 생성 (없으면 만든다)
		// null 이 아니면 그대로 리턴 (있으면 재사용)
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
