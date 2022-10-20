package posmachine;

import java.text.ParseException;
import java.util.Scanner;

public class FirstScreen {

	public static void main(String[] args) throws ParseException {
		

		SellMenu sellmenu = new SellMenu();
		Scanner scr = new Scanner(System.in);
		Scanner scr2 = new Scanner(System.in);
		InputMenu inputMenu = new InputMenu();
		ItemSearch itemsearch = new ItemSearch();
		Login login = new Login();
		DB db = new DB();

		String pw = null;
		int choice = 0;

		System.out.println("=====================ID/PW====================");
		System.out.println();
		System.out.println(" <ID와 PW를 입력하시면 프로그램이 시작합니다.>");
		System.out.println();// 로그인 안내문
		long start = System.currentTimeMillis();
		
		login.login2(db);//로그인 메소드
 
		
		while(true) {
			System.out.println();
			System.out.println("=====================메뉴선택====================");
			System.out.println("1. 물품판매  2. 물품검색  3. 물품추가  4. 물품삭제  5. 암호변경  6. 급료계산  7. 종료");
			System.out.print("메뉴선택 :");
			choice = scr.nextInt();
			
			if(choice == 1 ) {
				sellmenu.menulist(db);
				sellmenu.sell(db);
			}else if(choice == 2) {
				itemsearch.itemsearch(db);
			}else if(choice == 3) {
				inputMenu.additem(db);
			}else if(choice == 4) {
				inputMenu.itemdelete(db);
			}else if(choice == 5) {
					System.out.println("변경할 비밀번호를 입력해주세요");
					pw = scr2.nextLine();
					db.setpw(pw);
					login.login2(db);
			}else if(choice == 6) {
				long end = System.currentTimeMillis();
				System.out.println("급료는"+ ((end - start)/12000)*9800+"원 입니다.");
			}else if(choice == 7) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		}
		
		
	}
}