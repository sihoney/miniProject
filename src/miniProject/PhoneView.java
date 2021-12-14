package miniProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PhoneView {

	private BufferedReader br;
	
	public PhoneView() throws UnsupportedEncodingException {
		this.br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
	}
	
	public void showTitle() {
		System.out.println("******************************************");
		System.out.println("*              전화번호 관리 프로그램           *");
		System.out.println("******************************************");
	}
	
	public int showMenu() throws NumberFormatException, IOException {		
		System.out.println();
		System.out.println("1. 리스트  2. 등록  3. 삭제  4. 검색  5. 종료");
		System.out.println("------------------------------------------");
		System.out.print("> 메뉴번호: ");
		
		int menuNum = Integer.parseInt(br.readLine());	
		
		return menuNum;
	}
	
	public void showEnd() throws IOException {
		System.out.println("*********************************");
		System.out.println("*          감사합니다.              *");
		System.out.println("*********************************");

		br.close();
	}
	
	public void showList(ArrayList<Person> pList)  {

		System.out.println("<1. 리스트>");
		
		for(Person p : pList) {
			System.out.print((pList.indexOf(p)+1) + ".   ");
			p.print();
		}
	}
	
	public String getSearchKeyword() throws IOException {
		System.out.println("<4. 검색>");
		System.out.print("> 이름: ");
		
		String search = br.readLine();
		
		return search;
	}
	
	public int getRemoveNum() throws NumberFormatException, IOException {
		System.out.print("> 번호");
		
		int idx = Integer.parseInt(br.readLine());
		
		return idx;
	}
	
	public Person getPersonInfo() throws IOException {
		String name = "";
		String hp = "";
		String cn = "";
		
		System.out.println("<2. 등록>");
		System.out.print(">이름: ");
		name = br.readLine();
		System.out.print(">휴대전화: ");
		hp = br.readLine();
		System.out.print(">회사전화: ");
		cn = br.readLine();
		
		return new Person(name, hp, cn);
	}
	
}
