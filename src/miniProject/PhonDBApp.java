package miniProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PhonDBApp {
	
	static ArrayList<Person> pList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt"));
		
		makeList(br);
		
		
		// 1. 시작 화면
		System.out.println("******************************************");
		System.out.println("*              전화번호 관리 프로그램           *");
		System.out.println("******************************************");
		
		br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		
		boolean btn = true;
		
		while(btn) {
			
			System.out.println();
			System.out.println("1. 리스트  2. 등록  3. 삭제  4. 검색  5. 종료");
			System.out.println("------------------------------------------");
			System.out.print("> 메뉴번호: ");
			
			String menu = br.readLine();	

			if(menu.equals("1")) {
				showList();	
				
			} else if(menu.equals("2")) {
				addList(br);
				
			} else if(menu.equals("3")) {
				removeList(br);
				
			} else if(menu.equals("4")) {
				searchList(br);
				
			} else if(menu.equals("5")) {
				btn = false;
				br.close();
				
			} else {
				System.out.println("[ 다시 입력해주세요. ]");
			}
			
		}
		
		updateFile();
		
		System.out.println("*********************************");
		System.out.println("*          감사합니다.              *");
		System.out.println("*********************************");
	}
	
	public static void makeList(BufferedReader br) throws IOException {
		// 파일에서 정보 읽은 다음 Person 객체 리스트에 담기
		String line = "";
		
		while((line = br.readLine()) != null) {
			String[] arr = line.split(",");
			
			pList.add(new Person(arr[0], arr[1], arr[2]));
		}
	}
	
	public static void updateFile() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt"));
		
		String str = "";
		
		for(Person p : pList) {
			str += p.toString() + "\n";
		}
		
		bw.write(str);

		bw.close();
	}
	
	public static void searchList(BufferedReader br) throws IOException {
		
		System.out.println("<4. 검색>");
		System.out.print("> 이름: ");
		
		String search = br.readLine();
		
		for(Person p : pList) {
			String pName = p.getName();
			
			if(pName.contains(search)) {
				System.out.print((pList.indexOf(p)+1) + ".   ");
				p.print();
			}
		}
		
	}
	
	public static void removeList(BufferedReader br) throws IOException {

		System.out.print("> 번호");
		
		int idx = Integer.parseInt(br.readLine());
		
		pList.remove(idx - 1);
		
		System.out.println("[ 삭제되었습니다. ]");
	}
	
	public static void addList(BufferedReader br) throws IOException {
		
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
		
		pList.add(new Person(name, hp, cn));
		
		System.out.println("[ 등록되었습니다 ]");
	}
	
	public static void showList()  {

		System.out.println("<1. 리스트>");
		
		for(Person p : pList) {
			System.out.print((pList.indexOf(p)+1) + ".   ");
			p.print();
		}
	}
}
