package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;


public class BuyItemAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();
	private String itemName;
	private String itemPrice;
	private String count;
	private String pay;


	public String execute()throws SQLException {
		String result = SUCCESS;


		System.out.println("itemName : "+  itemName);
		System.out.println("itemPrice : " + itemPrice);
		System.out.println("count : " + count);

		String[] itemNameList = itemName.split(", " ,0);
		String[] itemPriceList = itemPrice.split(", " ,0);
		String[] countList = count.split(", " ,0);
		//ここで区分けとしては",スペース"でやらなくてはいけない。
		//ここで変数をコンマ(,)で分割するようにしている。配列をしている。
		int intCount = 0;
		int intPrice = 0;
		int total_price = 0;
		int total_count = 0;
//		buyItemList = buyItemDAO.getBuyItemInfo();

		for(int i=0; i<itemNameList.length; i++){
			BuyItemDTO dto = new BuyItemDTO();
			dto.setItemName(String.valueOf(itemNameList[i]));
			dto.setItemPrice(String.valueOf(itemPriceList[i]));
			dto.setCount(String.valueOf(countList[i]));
			//ここではdtoにListの情報を入れている。
			buyItemList.add(dto);

			intCount = Integer.parseInt(dto.getCount());
			intPrice = Integer.parseInt(dto.getItemPrice());
			total_price += intCount * intPrice;
			total_count += intCount ;
			//そしてここで其々のdtoに入れていた情報を演算子して貰う。
			//これによりtotal_priceが出る。
		}

		session.put( "total_price" , total_price );
		session.put( "total_count" , total_count);
		//ここでtotal_priceなるものをsession内に入れているが..
		//どうやらcountにコンマがついているようでうまくいかない。
		//何故コンマがつくのか不明である。セレクトでもコンマがつくのか...？
		String payment;
		if(pay.equals("1")){
			payment = "現金払い";
			session.put("pay",payment);
		}
		else{
			payment = "クレジットカード";
			session.put("pay",payment);
		}
		return result;
	}

	public ArrayList<BuyItemDTO> getBuyItemList() {
		return buyItemList;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay){
		this.pay = pay;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
	public ArrayList<BuyItemDTO> getBuyItemLIst(){
		return this.buyItemList;
	}
	public void setBuyItemList(ArrayList<BuyItemDTO> buyItemList){
		this.buyItemList= buyItemList;
	}
}
