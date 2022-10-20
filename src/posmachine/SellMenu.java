package posmachine;

import java.text.ParseException;
import java.util.Scanner;

public class SellMenu {
	
	CustermerAge custermerAge = new CustermerAge();
	Scanner scr = new Scanner(System.in);
	Scanner scr2 = new Scanner(System.in);
	Scanner scr3 = new Scanner(System.in);
	
	public void menulist(DB db) {//상품리스트
		
		int i = 0;
		System.out.println();
		System.out.println("=====================상품목록====================");
		

		for(String str : db.getItemName() ) {
			System.out.print(++i + "." + str + " ");
			if(i%5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
	}
	
	
	public void sell(DB db) throws ParseException {//상품판매
		
		
		String choice = null;
		String card = null;
		int userAge = 0;
		int itmeAge = 0;
		int num = 0;
		int itemnum = 0;
		int price = 0;
		int year = 0;
		int month = 0;
		int day = 0
;		
		System.out.println();
		System.out.print("구입할 상품명: ");
		
		choice = scr3.nextLine();
		
		
		if(db.getItemName().indexOf(choice) > -1) {			
			
			if(ItemLife.IsDate(db.getItemDisposal().get(db.getItemName().indexOf(choice)))) {
				
				System.out.println("구입할 물품의 갯수를 입력해주세요");
				num = scr2.nextInt();
				
				if(db.getAdult().get(db.getItemName().indexOf(choice)) == false) {
					
					System.out.println("성인용 물품입니다. 고객님의 생년월일을 입력해주세요");	
					System.out.print("출생년도: ");
					year=scr2.nextInt();
					System.out.print("출생 달: ");
					month = scr2.nextInt();
					System.out.print("출생 일: ");
					day = scr2.nextInt();
					userAge=custermerAge.getAge(year, month , day);// 고객의 나이를 구함
					
					if(userAge > 20) {
						System.out.println("카드 결제입니까?");
						System.out.println("=====================y/n====================");
						
						card = scr3.nextLine();
						
						if(card.equals("y")) {
							
							if(num > 1) {
								System.out.println("카드결제중");
								System.out.println("가격은"+db.getItemPrice().get(db.getItemName().indexOf(choice))*num+"입니다.");
								db.setItemnum(db.getItemName().indexOf(choice), db.getItemnum().get((db.getItemName().indexOf(choice))) - num); //재고량 수정
							}else {
								System.out.println("카드결제중");
								System.out.println("가격은"+db.getItemPrice().get(db.getItemName().indexOf(choice))+"입니다.");
								db.setItemnum(db.getItemName().indexOf(choice), db.getItemnum().get((db.getItemName().indexOf(choice))) - num);//재고량 수정
							}
							
						}else if(card.equals("n")) {
							System.out.println("현금결제");
							System.out.print("액수: ");
							price = scr.nextInt();
							System.out.println("가격은"+db.getItemPrice().get(db.getItemName().indexOf(choice))+"입니다.");
							price-=db.getItemPrice().get(db.getItemName().indexOf(choice));
							System.out.println("거스름돈 : "+ price);
							db.setItemnum(db.getItemName().indexOf(choice), db.getItemnum().get((db.getItemName().indexOf(choice))) - num);//재고량 수정
							
						}
						
					}else {
						System.out.println("미성년자에게는 판매할 수 없는 물품입니다.");
					}
	
	
					
					
				}else if(db.getAdult().get(db.getItemName().indexOf(choice)) == true){
					System.out.println("카드 결제입니까?");
					System.out.println("=====================y/n====================");
					card = scr3.nextLine();
					
					if(card.equals("y")) {
						if(num > 1) {
							System.out.println("카드결제중");
							System.out.println("가격은"+db.getItemPrice().get(db.getItemName().indexOf(choice))*num+"입니다.");
							db.setItemnum(db.getItemName().indexOf(choice), db.getItemnum().get((db.getItemName().indexOf(choice))) - num);//재고량 수정
						}else {
							System.out.println("카드결제중");
							System.out.println(db.getItemPrice().get(db.getItemName().indexOf(choice))+"원 결제완료");
							db.setItemnum(db.getItemName().indexOf(choice), db.getItemnum().get((db.getItemName().indexOf(choice))) - num);//재고량 수정
						}
						
					}else if(card.equals("n")) {
						System.out.println("현금결제");
						System.out.print("액수: ");
						price = scr.nextInt();
						System.out.println("가격은"+db.getItemPrice().get(db.getItemName().indexOf(choice))*num+"입니다.");
						price-=db.getItemPrice().get(db.getItemName().indexOf(choice))*num;
						System.out.println("거스름돈 : "+ price);
						db.setItemnum(db.getItemName().indexOf(choice), db.getItemnum().get((db.getItemName().indexOf(choice))) - num);//재고량 수정
						
					}
					
				}
			}else {
				System.out.println("고르신 상품은 폐기기간이 지났습니다.");
			}
		}else {
			System.out.println("찾으시는 물품이 물품목록에 없습니다.");
		}
	}
}
