package posmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DB {
	
	private String id = "신호민";
	private String pw = "8691";
	private ArrayList<String> itemName = new ArrayList<String>(Arrays.asList("호빵","초코칩","담배")); //물품이름
	private ArrayList<Integer> itemCode = new ArrayList<Integer>(Arrays.asList(11112,11113,11114));//물품코드
	private ArrayList<Integer> itemnum = new ArrayList<Integer>(Arrays.asList(15,20,30));//재고
	private ArrayList<Integer> itemPrice = new ArrayList<Integer>(Arrays.asList(2000,1500,5500));
	private ArrayList<String> placeOfProduction = new ArrayList<String>(Arrays.asList("서울","대전","울산"));//생산지
	private ArrayList<String> itemDisposal = new ArrayList<String>(Arrays.asList("20220523","20220817","20221012"));//폐기날짜
	private ArrayList<Boolean> adult = new ArrayList<Boolean>(Arrays.asList(true,true,false));//성인유무
	

	public void setpw(String pw) {
		this.pw = pw;
	}
	
	public void setitem(String itemName, String placeOfProduction, Integer itemCode, String itemDisposal,Integer itemnum, Integer itemPrice, Boolean adult){
		//물품 등록
		this.itemName.add(itemName);
		this.placeOfProduction.add(placeOfProduction);
		this.itemCode.add(itemCode);
		this.itemPrice.add(itemPrice);
		this.itemnum.add(itemnum);
		this.itemDisposal.add(itemDisposal);
		this.adult.add(adult);
		
	}
	
	
	public void removeitem(int i) { //물품삭제
		this.itemName.remove(i);
		this.placeOfProduction.remove(i);
		this.itemCode.remove(i);
		this.itemPrice.remove(i);
		this.itemnum.remove(i);
		this.itemDisposal.remove(i);
		this.adult.remove(i);
	}

			
	
	public void setItemnum(int i , int item) { //물품 구매시 재고량 수정
		this.itemnum.set(i, item);
	}


	public ArrayList<String> getItemName() {
		return itemName;
	}

	public ArrayList<Integer> getItemCode() {
		return itemCode;
	}

	public ArrayList<Integer> getItemnum() {
		return itemnum;
	}

	public ArrayList<Integer> getItemPrice() {
		return itemPrice;
	}

	public ArrayList<String> getPlaceOfProduction() {
		return placeOfProduction;
	}

	public ArrayList<String> getItemDisposal() {
		return itemDisposal;
	}

	public ArrayList<Boolean> getAdult() {
		return adult;
	}

	
	
	public boolean login(String id, String pw) {
		
	    if(!(this.id.equals(id))){
			System.out.println("아이디가 틀렸습니다.");
			System.out.println();
			return false;
		}else if(!(this.pw.equals(pw))) {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println();
			return false;
		}else {
			System.out.println();
			System.out.println("로그인 성공");
			return true;
		}
	}

}
