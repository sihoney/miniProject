package miniProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class PhoneManager {
	
	// FIELD
	private ArrayList<Person> pList;
	
	
	// CONSTRUCTOR
	public PhoneManager() throws IOException {
		this.pList = new ArrayList<Person>();
		
		loadList();
	}

	// GETTER AND SETTER
	public ArrayList<Person> getpList() {
		return pList;
	}


	public void setpList(ArrayList<Person> pList) {
		this.pList = pList;
	}


	// METHOD
	public void searchPerson(String search) throws IOException {
		for(Person p : pList) {
			String pName = p.getName();
			
			if(pName.contains(search)) {
				System.out.print((pList.indexOf(p)+1) + ".   ");
				p.print();
			}
		}	
	}
	
	public void removePerson(int num) {		
		pList.remove(num - 1);
	}
	
	public void addPerson(Person p) {
		pList.add(p);
	}
	
	public void loadList() throws IOException {
		// 파일에서 정보 읽은 다음 Person 객체 리스트에 담기
		BufferedReader br = new BufferedReader(new FileReader("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt"));
		
		String line = "";
		
		while((line = br.readLine()) != null) {
			String[] arr = line.split(",");
			
			pList.add(new Person(arr[0], arr[1], arr[2]));
		}
		
		br.close();
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
	
}
