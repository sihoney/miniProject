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
		
		PhoneManager phoneManager = new PhoneManager(pList);
		
		phoneManager.makeList(br);
		
		
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
			
			int menu = Integer.parseInt(br.readLine());	
			
			switch(menu) {
			case 1:
				phoneManager.showList();
				break;
			case 2:
				phoneManager.addPerson(br);
				break;
			case 3:
				phoneManager.removePerson(br);
				break;
			case 4:
				phoneManager.searchPerson(br);
				break;
			case 5:
				btn = false;
				br.close();
				break;
			default:
				System.out.println("[ 다시 입력해주세요. ]");
			}

		}
		
		phoneManager.updateFile();
		
		System.out.println("*********************************");
		System.out.println("*          감사합니다.              *");
		System.out.println("*********************************");
	}
	

}
