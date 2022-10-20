package posmachine;

import java.util.Scanner;

public class InputMenu {
	
	public void additem(DB db) {//물품추가
			
			Scanner scr = new Scanner(System.in);
			Scanner scr2 = new Scanner(System.in);	
			
			String choice;
			
			System.out.println("물품정보를입력해주세요");
			
			System.out.println();
			System.out.print("물품이름을 입력해주세요: ");
			String itemName = scr.nextLine();
			
			System.out.println();
			System.out.print("물품생산지를 입력해주세요: ");
			String placeOfProduction = scr.nextLine();
			
			System.out.println();
			System.out.print("바코드를 입력해주세요: ");
			Integer itemCode = scr.nextInt();
			
			System.out.println();
			System.out.print("폐기기간을 입력해주세요: ");
			String itemDisposal = scr2.nextLine();
			
			System.out.println();
			System.out.print("가격을 입력해주세요: ");
			Integer itemPrice = scr.nextInt();
						
			System.out.println();
			System.out.print("재고를 입력해주세요: ");
			Integer itemnum = scr.nextInt();
			
			System.out.println();
			System.out.println("성인용 물품입니까? ");
			System.out.println("=========y/n========");
			
			choice = scr.next();
			
			Boolean adult = null;
			if(choice.equals("y")) {
				System.out.println("성인용 물품으로 분리됩니다.");
			    adult = false;
			}else if(choice.equals("n")) {
				System.out.println("성인용 물품에서 제외합니다.");
				adult = true;
			}else {
				System.out.println("입력값을 읽지 못 하였습니다. 올바른 입력값으로 입력해주세요");
			}
			
			
			System.out.println("입력하신 정보를 상품관리 목록에 저장하는중");
			System.out.println();
			db.setitem(itemName, placeOfProduction, itemCode, itemDisposal, itemnum, itemPrice, adult);
			System.out.println("저장완료");
			
		}
	
	
	public void itemdelete(DB db) {//물품삭제
		Scanner scr = new Scanner(System.in);
		int choice = 0;
		int deletenum = 0;
		System.out.print("삭제할 물품의 코드: ");
		choice = scr.nextInt();
		
		if(db.getItemCode().indexOf(choice) > -1) {
			System.out.println("물품 삭제중");
			deletenum=db.getItemCode().indexOf(choice);
			db.removeitem(deletenum);
		}else {
			System.out.println("물품을 찾을 수 없습니다. 코드를 다시 확인해주세요");
		}
		
		
	}

}

