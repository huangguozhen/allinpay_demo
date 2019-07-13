package com.allinpay.syb.test;

import java.util.Map;

import com.allinpay.syb.lib.SybPayService;


public class ApiTestV2 {
	public static void main(String[] args) throws Exception{
		//testPay();
		//testCancel();
		scanqrpay();
		//testRefund();
		//testQuery();
	}
	
	public static void testQuery() throws Exception{
		SybPayService service = new SybPayService();
		Map<String, String> map = service.query("", "103276577");
		print(map);
	}
	
	public static void testRefund() throws Exception{
		SybPayService service = new SybPayService();
		String reqsn = String.valueOf(System.currentTimeMillis());
		Map<String, String> map = service.refund(1, reqsn, "", "20160712167578.2547");
		print(map);
	}
	
	public static void testCancel() throws Exception{
		SybPayService service = new SybPayService();
		String reqsn = String.valueOf(System.currentTimeMillis());
		Map<String, String> map = service.cancel(1, reqsn, "103759586", "");
		print(map);
	}
	
	public static void testPay() throws Exception{
		SybPayService service = new SybPayService();
		String reqsn = String.valueOf(System.currentTimeMillis());
		Map<String, String> map = service.pay(1, reqsn, "W04", "标题", "备注", "", "123","http://baidu.com","","","","");
		print(map);
	}
	
	public static void scanqrpay() throws Exception{
		SybPayService service = new SybPayService();
		String reqsn = String.valueOf(System.currentTimeMillis());
		Map<String, String> map = service.QRPay(1, reqsn, "标题", "备注", "授权码", "","","","","","");
		print(map);
	}
	
	public static void print(Map<String, String> map){
		System.out.println("返回数据如下:");
		if(map!=null){
			for(String key:map.keySet()){
				System.out.println(key+";"+map.get(key));
			}
		}
	}
	
	
}
