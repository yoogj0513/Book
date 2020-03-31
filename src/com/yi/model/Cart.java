package com.yi.model;

public class Cart {
	private int cNo;
	private int cCount;
	private int uNo;
	private int pNo;

	public Cart() {
		super();
	}

	public Cart(int cNo, int cCount, int uNo, int pNo) {
		super();
		this.cNo = cNo;
		this.cCount = cCount;
		this.uNo = uNo;
		this.pNo = pNo;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public int getcCount() {
		return cCount;
	}

	public void setcCount(int cCount) {
		this.cCount = cCount;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	@Override
	public String toString() {
		return String.format("Cart [cNo=%s, cCount=%s, uNo=%s, pNo=%s]", cNo, cCount, uNo, pNo);
	}

}
