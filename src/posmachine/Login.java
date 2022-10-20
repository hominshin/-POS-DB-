package posmachine;

import java.util.Scanner;

public class Login {
	
	public void login2(DB db) {
		
		boolean login = false;
		String id = null;
		String pw = null;
		
		Scanner scr = new Scanner(System.in);
		do {

			System.out.print("아이디입력: ");
		    id = scr.nextLine();

			System.out.print("비밀번호입력: ");
			pw = scr.nextLine();

			login = db.login(id, pw);

			if (login == false) {
				System.out.println("로그인에 실패하였습니다. 다시 로그인 해주세요");
				System.out.println();
			}

		} while (login == false); // 로그인
		System.out.println(id + "님 안녕하세요");
			
	}

}
