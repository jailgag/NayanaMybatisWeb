package com.tmybatis.member.model.vo;

import java.sql.Date;

public class Member {
	
	//필드명이랑 member-mapper에 쿼리문에 #중괄호안이랑
	//같아야함!!
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDate;
	
	public Member() {}
	
	
	
	//에러나서 일단9개짜리 만듬!!아니면 다시지우기!지웠음!!
	



	//MemberDAO꺼 login 3개!!
	public Member(String memberId, String memberName, String email) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.email = email;
	}




	//로그인서블릿!2개
	public Member(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}



	public String getMemberId() {
		return memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getHobby() {
		return hobby;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName + ", gender="
				+ gender + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", hobby=" + hobby + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
