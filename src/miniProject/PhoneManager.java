package miniProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PhoneManager {
	
	private ArrayList<Person> pList;
	
	public PhoneManager(ArrayList<Person> pList) {
		this.pList = pList;
	}

	public void makeList(BufferedReader br) throws IOException {
		// 파일에서 정보 읽은 다음 Person 객체 리스트에 담기
		String line = "";
		
		while((line = br.readLine()) != null) {
			String[] arr = line.split(",");
			
			pList.add(new Person(arr[0], arr[1], arr[2]));
		}
	}
	
	public void updateFile() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt"));
		
		String str = "";
		
		for(Person p : pList) {
			str += p.toString() + "\n";
		}
		
		bw.write(str);

		bw.close();
	}
	
	public void searchPerson(BufferedReader br) throws IOException {
		
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
	
	public void removePerson(BufferedReader br) throws IOException {

		System.out.print("> 번호");
		
		int idx = Integer.parseInt(br.readLine());
		
		pList.remove(idx - 1);
		
		System.out.println("[ 삭제되었습니다. ]");
	}
	
	public void addPerson(BufferedReader br) throws IOException {
		
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
	
	public void showList()  {

		System.out.println("<1. 리스트>");
		
		for(Person p : pList) {
			System.out.print((pList.indexOf(p)+1) + ".   ");
			p.print();
		}
	}
}
