package com.yi.model;

import java.util.Date;

public class Product {
	private int pNo;
	private String pName;
	private int pPrice;
	private String pWriter;
	private Date pRegDate;
	private String pDetail;
	private String pPublisher;
	private String pType;
	private String pFile;

	public Product() {
		super();
	}

	public Product(int pNo, String pName, int pPrice, String pWriter, Date pRegDate, String pDetail, String pPublisher,
			String pType, String pFile) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pWriter = pWriter;
		this.pRegDate = pRegDate;
		this.pDetail = pDetail;
		this.pPublisher = pPublisher;
		this.pType = pType;
		this.pFile = pFile;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getpWriter() {
		return pWriter;
	}

	public void setpWriter(String pWriter) {
		this.pWriter = pWriter;
	}

	public Date getpRegDate() {
		return pRegDate;
	}

	public void setpRegDate(Date pRegDate) {
		this.pRegDate = pRegDate;
	}

	public String getpDetail() {
		return pDetail;
	}

	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}

	public String getpPublisher() {
		return pPublisher;
	}

	public void setpPublisher(String pPublisher) {
		this.pPublisher = pPublisher;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public String getpFile() {
		return pFile;
	}

	public void setpFile(String pFile) {
		this.pFile = pFile;
	}

	@Override
	public String toString() {
		return String.format(
				"Product [pNo=%s, pName=%s, pPrice=%s, pWriter=%s, pRegDate=%s, pDetail=%s, pPublisher=%s, pType=%s, pFile=%s]",
				pNo, pName, pPrice, pWriter, pRegDate, pDetail, pPublisher, pType, pFile);
	}

}
