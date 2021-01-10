package com.rocketmiles.register.cash.denomination;

/**
 * This class is for the Money Denomination.
 * Includes all the basic operations.
 * 
 * @author Ollie Dela Cueva
 *
 */
public class MoneyDenomination {
	
	public static final int VALUEOF20 = 20;
	public static final int VALUEOF10 = 10;
	public static final int VALUEOF5 = 5;
	public static final int VALUEOF2 = 2;
	public static final int VALUEOF1 = 1;

	private int totalNumberOf20;
	private int totalNumberOf10;
	private int totalNumberOf5;
	private int totalNumberOf2;
	private int totalNumberOf1;
	
	public int getTotalNumberOf20() {
		return totalNumberOf20;
	}
	public void setTotalNumberOf20(int totalNumberOf20) {
		this.totalNumberOf20 = totalNumberOf20;
	}
	public int getTotalNumberOf10() {
		return totalNumberOf10;
	}
	public void setTotalNumberOf10(int totalNumberOf10) {
		this.totalNumberOf10 = totalNumberOf10;
	}
	public int getTotalNumberOf5() {
		return totalNumberOf5;
	}
	public void setTotalNumberOf5(int totalNumberOf5) {
		this.totalNumberOf5 = totalNumberOf5;
	}
	public int getTotalNumberOf2() {
		return totalNumberOf2;
	}
	public void setTotalNumberOf2(int totalNumberOf2) {
		this.totalNumberOf2 = totalNumberOf2;
	}
	public int getTotalNumberOf1() {
		return totalNumberOf1;
	}
	public void setTotalNumberOf1(int totalNumberOf1) {
		this.totalNumberOf1 = totalNumberOf1;
	}
	
	public int getTotalPriceOf20() {
		return VALUEOF20 * totalNumberOf20;
	}
	
	public int getTotalPriceOf10() {
		return VALUEOF10 * totalNumberOf10;
	}
	
	public int getTotalPriceOf5() {
		return VALUEOF5 * totalNumberOf5;
	}
	
	public int getTotalPriceOf2() {
		return VALUEOF2 * totalNumberOf2;
	}
	
	public int getTotalPriceOf1() {
		return VALUEOF1 * totalNumberOf1;
	}
	
	public int deductToTotalNumberOf20(int numberToDeduct) {
		return totalNumberOf20 -= numberToDeduct;
	}
	
	public int deductToTotalNumberOf10(int numberToDeduct) {
		return totalNumberOf10 -= numberToDeduct;
	}
	
	public int deductToTotalNumberOf5(int numberToDeduct) {
		return totalNumberOf5 -= numberToDeduct;
	}
	
	public int deductToTotalNumberOf2(int numberToDeduct) {
		return totalNumberOf2 -= numberToDeduct;
	}
	
	public int deductToTotalNumberOf1(int numberToDeduct) {
		return totalNumberOf1 -= numberToDeduct;
	}
	
	public int addToTotalNumberOf20(int numberToAdd) {
		return totalNumberOf20 += numberToAdd;
	}
	
	public int addToTotalNumberOf10(int numberToAdd) {
		return totalNumberOf10 += numberToAdd;
	}
	
	public int addToTotalNumberOf5(int numberToAdd) {
		return totalNumberOf5 += numberToAdd;
	}
	
	public int addToTotalNumberOf2(int numberToAdd) {
		return totalNumberOf2 += numberToAdd;
	}
	
	public int addToTotalNumberOf1(int numberToAdd) {
		return totalNumberOf1 += numberToAdd;
	}
	
	public int getTotalMoney() {
		return getTotalPriceOf20() + getTotalPriceOf10() + getTotalPriceOf5() + getTotalPriceOf2() + getTotalPriceOf1();
	}
}
