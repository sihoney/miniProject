/*
 * main 함수에는 기본 구조만 구현 -> 전체의 흐름을 파악하기 좋다.
 * 
 * 주요기능은 phoneView, PhoneRepository 클래스 만들어서 구현
 * 
 * phoneView: 화면과 관련되 업무
 * PhoneManager: 리스트에 데이터를 추가, 삭제 등의 관리
 * 				리스트의 정보가 변할 경우 파일에 저장하는 업무
 */

package miniProject;

import java.io.IOException;

public class PhonDBApp {
	
	public static void main(String[] args) throws IOException {
		
		PhoneManager phoneManager = new PhoneManager();
		PhoneView phoneView = new PhoneView();
		
		boolean btn = true;
		
		// 1. 시작 화면
		phoneView.showTitle();
		
		while(btn) {
			
			int menu = phoneView.showMenu();
			
			switch(menu) {
			case 1:
				phoneView.showList(phoneManager.getpList());
				break;
				
			case 2:
				//phoneView.addPerson(phoneManager.getpList());
				
				Person p01 = phoneView.getPersonInfo();
				phoneManager.addPerson(p01);
				System.out.println("[ 등록되었습니다 ]");
				break;
				
			case 3:
				//phoneView.removePerson(phoneManager.getpList());
				
				int removeNum = phoneView.getRemoveNum();
				phoneManager.removePerson(removeNum);
				System.out.println("[ 삭제되었습니다. ]");
				break;
				
			case 4:
				//phoneView.searchPerson(phoneManager.getpList());
				
				String keyword = phoneView.getSearchKeyword();
				phoneManager.searchPerson(keyword);
				break;
				
			case 5:
				btn = false;
				break;
				
			default:
				System.out.println("[ 다시 입력해주세요. ]");
				break;
			}

		}
		
		phoneManager.updateFile();
		phoneView.showEnd();
	}
	

}
