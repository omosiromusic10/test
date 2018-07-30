package com.internousdev.sampleweb2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sampleweb2.dao.InquiryDAO;
import com.internousdev.sampleweb2.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;


public class InquiryCompleteAction extends ActionSupport implements SessionAware{
	private String userId;
	private String qtype;
	private String body;

	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();
	private Map<String, Object>session;

	public String execute(){
		String ret = ERROR;
		InquiryDAO dao = new InquiryDAO();
		int count  =dao.insert(session.get("userId").toString(), qtype, body);
		if(count > 0){
			inquiryDTOList = dao.select();
			session.put("inquiryDTOList", inquiryDTOList);
			ret = SUCCESS;
		}
		return ret;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<InquiryDTO> getInquiryDTOList() {
		return inquiryDTOList;
	}

	public void setInquiryDTOList(List<InquiryDTO> inquiryDTOList) {
		this.inquiryDTOList = inquiryDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
