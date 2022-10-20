package posmachine;

import java.util.Scanner;

public class ItemSearch {
	Scanner scr = new Scanner(System.in);
	
	public void itemsearch(DB db) { // 물품을 찾는 메소드
		System.out.println();
		System.out.print("찾으시는 물품: ");
		String item = scr.nextLine();
		
		if(db.getItemName().indexOf(item) > -1) {
			System.out.println("물품이름 :"+db.getItemName().get(db.getItemName().indexOf(item)));
			System.out.println("물품생산지 :"+db.getPlaceOfProduction().get(db.getItemName().indexOf(item)));
			System.out.println("물품코드 :"+db.getItemCode().get(db.getItemName().indexOf(item)));
			System.out.println("물품가격 :"+db.getItemPrice().get(db.getItemName().indexOf(item)));
			System.out.println("물품재고 :"+db.getItemnum().get(db.getItemName().indexOf(item)));
			System.out.println("물품폐기날짜:"+db.getItemDisposal().get(db.getItemName().indexOf(item)));
			if(db.getAdult().get(db.getItemName().indexOf(item))== false) { 
				System.out.println("성인용o");
			}else {
				System.out.println("성인용X");
			}
		}else {
			System.out.println("물품을 찾을 수 없습니다.");
		}	
		
	}

}
