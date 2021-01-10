package com.rocketmiles.register.cash.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rocketmiles.register.cash.denomination.MoneyDenomination;

/**
 * The main class for the Cash Register App
 * 
 * @author Ollie Dela Cueva
 * 
 */
public class CashRegister {

	private static MoneyDenomination money = new MoneyDenomination();
	static int newPriceToChange = 0;

	public static void main(String[] args) {

		System.out
				.println("Welcome to Cash Registry App. Kindly enter command.");
		handleOperation();
	}

	/**
	 * Handles all the inputs and operations
	 */
	public static void handleOperation() {

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			String input = inputReader.readLine();
			if (input != null || !"".equals(input)) {
				String[] arrayOfInput = input.split(" "); // stores all the
															// input
				String command = arrayOfInput[0]; // gets the command

				switch (command.toLowerCase()) {
				case "show":
					if (arrayOfInput.length > 1) {
						System.out.println("Invalid input.");
						handleOperation();
					} else if (arrayOfInput.length == 1) {
						int[] totalMoney = showTotal();
						printMessage(totalMoney[0], totalMoney[1],
								totalMoney[2], totalMoney[3], totalMoney[4],
								totalMoney[5]);
						handleOperation();
					}
					break;
				case "put":
					if (arrayOfInput.length == 6) {
						int numberToAddIn20 = Integer.valueOf(arrayOfInput[1]);
						int numberToAddIn10 = Integer.valueOf(arrayOfInput[2]);
						int numberToAddIn5 = Integer.valueOf(arrayOfInput[3]);
						int numberToAddIn2 = Integer.valueOf(arrayOfInput[4]);
						int numberToAddIn1 = Integer.valueOf(arrayOfInput[5]);

						if (numberToAddIn20 < 0 || numberToAddIn10 < 0
								|| numberToAddIn5 < 0 || numberToAddIn2 < 0
								|| numberToAddIn1 < 0) {

							System.out.println("Invalid input.");
							handleOperation();
						}

						int[] totalMoneyAfterPut = putBills(numberToAddIn20,
								numberToAddIn10, numberToAddIn5,
								numberToAddIn2, numberToAddIn1);
						printMessage(totalMoneyAfterPut[0],
								totalMoneyAfterPut[1], totalMoneyAfterPut[2],
								totalMoneyAfterPut[3], totalMoneyAfterPut[4],
								totalMoneyAfterPut[5]);
						handleOperation();
					} else {
						System.out.println("Invalid input.");
						handleOperation();
					}
					break;
				case "take":
					if (arrayOfInput.length == 6) {
						// TODO: error handling ie: non-integer, less than 0
						int numberToTakeIn20 = Integer.valueOf(arrayOfInput[1]);
						int numberToTakeIn10 = Integer.valueOf(arrayOfInput[2]);
						int numberToTakeIn5 = Integer.valueOf(arrayOfInput[3]);
						int numberToTakeIn2 = Integer.valueOf(arrayOfInput[4]);
						int numberToTakeIn1 = Integer.valueOf(arrayOfInput[5]);

						if (numberToTakeIn20 < 0 || numberToTakeIn10 < 0
								|| numberToTakeIn5 < 0 || numberToTakeIn2 < 0
								|| numberToTakeIn1 < 0) {

							System.out.println("Invalid input.");
							handleOperation();
						}

						if (isNumberToTakeMoreThanTotalNumberOfBills(
								numberToTakeIn20, numberToTakeIn10,
								numberToTakeIn5, numberToTakeIn2,
								numberToTakeIn1)) {
							System.out.println("Invalid input.");
							handleOperation();
						}

						int[] totalMoneyAfterTake = takeBills(numberToTakeIn20,
								numberToTakeIn10, numberToTakeIn5,
								numberToTakeIn2, numberToTakeIn1);
						printMessage(totalMoneyAfterTake[0],
								totalMoneyAfterTake[1], totalMoneyAfterTake[2],
								totalMoneyAfterTake[3], totalMoneyAfterTake[4],
								totalMoneyAfterTake[5]);
						handleOperation();
					} else {
						System.out.println("Invalid input.");
						handleOperation();
					}
					break;
				case "change":
					if (arrayOfInput.length == 2) {
						int priceToChange = Integer.valueOf(arrayOfInput[1]);
						int[] totalMoneyAfterChange = changeBills(priceToChange);
						if (totalMoneyAfterChange != null) {
							printMessage(totalMoneyAfterChange[0],
									totalMoneyAfterChange[1],
									totalMoneyAfterChange[2],
									totalMoneyAfterChange[3],
									totalMoneyAfterChange[4],
									totalMoneyAfterChange[5]);
							handleOperation();
						} else {
							System.out.println("Sorry not enough funds.");
							handleOperation();
						}

					} else {
						System.out.println("Invalid input.");
						handleOperation();
					}
					break;
				case "quit":
					System.out.println("Thanks!");
					break;
				default:
					System.out.println("Invalid input.");
					handleOperation();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid parameters.");
			handleOperation();
		}
	}

	/**
	 * This displays the current total number of each dividends.
	 * 
	 * @return array of int
	 */
	public static int[] showTotal() {

		int totalMoney = money.getTotalMoney();
		int totalNumberOf20 = money.getTotalNumberOf20();
		int totalNumberOf10 = money.getTotalNumberOf10();
		int totalNumberOf5 = money.getTotalNumberOf5();
		int totalNumberOf2 = money.getTotalNumberOf2();
		int totalNumberOf1 = money.getTotalNumberOf1();
		int[] returnValue = { totalMoney, totalNumberOf20, totalNumberOf10,
				totalNumberOf5, totalNumberOf2, totalNumberOf1 };
		return returnValue;
	}

	public static boolean handlePutBills(int numberToAddIn20, int numberToAddIn10,
			int numberToAddIn5, int numberToAddIn2, int numberToAddIn1) {
		if (numberToAddIn20 < 0 || numberToAddIn10 < 0
				|| numberToAddIn5 < 0 || numberToAddIn2 < 0
				|| numberToAddIn1 < 0) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * This method adds the user inputted number of dividends to the current
	 * number of each dividends.
	 * 
	 * @param numberToAddIn20
	 * @param numberToAddIn10
	 * @param numberToAddIn5
	 * @param numberToAddIn2
	 * @param numberToAddIn1
	 * @return
	 */
	public static int[] putBills(int numberToAddIn20, int numberToAddIn10,
			int numberToAddIn5, int numberToAddIn2, int numberToAddIn1) {

		int totalNumberOf20 = money.addToTotalNumberOf20(numberToAddIn20);
		int totalNumberOf10 = money.addToTotalNumberOf10(numberToAddIn10);
		int totalNumberOf5 = money.addToTotalNumberOf5(numberToAddIn5);
		int totalNumberOf2 = money.addToTotalNumberOf2(numberToAddIn2);
		int totalNumberOf1 = money.addToTotalNumberOf1(numberToAddIn1);
		int totalMoney = money.getTotalMoney();
		int[] returnValue = { totalMoney, totalNumberOf20, totalNumberOf10,
				totalNumberOf5, totalNumberOf2, totalNumberOf1 };
		return returnValue;
	}

	/**
	 * This removes the user inputted number of dividends to the current number
	 * of each dividends.
	 * 
	 * @param numberToTakeIn20
	 * @param numberToTakeIn10
	 * @param numberToTakeIn5
	 * @param numberToTakeIn2
	 * @param numberToTakeIn1
	 * @return
	 */
	public static int[] takeBills(int numberToTakeIn20, int numberToTakeIn10,
			int numberToTakeIn5, int numberToTakeIn2, int numberToTakeIn1) {

		int totalNumberOf20 = money.deductToTotalNumberOf20(numberToTakeIn20);
		int totalNumberOf10 = money.deductToTotalNumberOf10(numberToTakeIn10);
		int totalNumberOf5 = money.deductToTotalNumberOf5(numberToTakeIn5);
		int totalNumberOf2 = money.deductToTotalNumberOf2(numberToTakeIn2);
		int totalNumberOf1 = money.deductToTotalNumberOf1(numberToTakeIn1);
		int totalMoney = money.getTotalMoney();
		int[] returnValue = { totalMoney, totalNumberOf20, totalNumberOf10,
				totalNumberOf5, totalNumberOf2, totalNumberOf1 };
		return returnValue;
	}

	/**
	 * Checks the input before deducting to the total number of each dividends.
	 * 
	 * @param numberToTakeIn20
	 * @param numberToTakeIn10
	 * @param numberToTakeIn5
	 * @param numberToTakeIn2
	 * @param numberToTakeIn1
	 * @return
	 */
	private static boolean isNumberToTakeMoreThanTotalNumberOfBills(
			int numberToTakeIn20, int numberToTakeIn10, int numberToTakeIn5,
			int numberToTakeIn2, int numberToTakeIn1) {

		if (numberToTakeIn20 > money.getTotalNumberOf20()) {
			return true;
		}

		if (numberToTakeIn10 > money.getTotalNumberOf10()) {
			return true;
		}

		if (numberToTakeIn5 > money.getTotalNumberOf5()) {
			return true;
		}

		if (numberToTakeIn2 > money.getTotalNumberOf2()) {
			return true;
		}

		if (numberToTakeIn1 >money.getTotalNumberOf1()) {
			return true;
		}

		return false;
	}

	/**
	 * @param origPriceToChange
	 * @return
	 */
	public static int[] changeBills(int origPriceToChange) {

		int totalPriceOf20 = money.getTotalPriceOf20();
		int totalNumberOf20 = money.getTotalNumberOf20();

		int totalPriceOf10 = money.getTotalPriceOf10();
		int totalNumberOf10 = money.getTotalNumberOf10();

		int totalPriceOf5 = money.getTotalPriceOf5();
		int totalNumberOf5 = money.getTotalNumberOf5();

		int totalPriceOf2 = money.getTotalPriceOf2();
		int totalNumberOf2 = money.getTotalNumberOf2();

		int totalPriceOf1 = money.getTotalPriceOf1();
		int totalNumberOf1 = money.getTotalNumberOf1();

		newPriceToChange = origPriceToChange;

		int toBeTaken20 = getNumberOfDenominationToBeTaken(totalPriceOf20,
				totalNumberOf20, MoneyDenomination.VALUEOF20);
		int toBeTaken10 = getNumberOfDenominationToBeTaken(totalPriceOf10,
				totalNumberOf10, MoneyDenomination.VALUEOF10);
		int toBeTaken5 = getNumberOfDenominationToBeTaken(totalPriceOf5,
				totalNumberOf5, MoneyDenomination.VALUEOF5);
		int toBeTaken2 = getNumberOfDenominationToBeTaken(totalPriceOf2,
				totalNumberOf2, MoneyDenomination.VALUEOF2);
		int toBeTaken1 = getNumberOfDenominationToBeTaken(totalPriceOf1,
				totalNumberOf1, MoneyDenomination.VALUEOF1);

		if (newPriceToChange == 0) {
			return takeBills(toBeTaken20, toBeTaken10, toBeTaken5, toBeTaken2,
					toBeTaken1);
		}

		return null;
	}

	/**
	 * This method does the updating of number of each dividends after change.
	 * 
	 * @param totalPriceOfDenomination
	 * @param totalNumberOfDenomination
	 * @param denominationValue
	 * @return
	 */
	private static int getNumberOfDenominationToBeTaken(
			int totalPriceOfDenomination, int totalNumberOfDenomination,
			int denominationValue) {

		int neededNumberOfDenomination = 0;
		int numberOfDenominationToBeTaken = 0;
		if (totalPriceOfDenomination != 0
				&& newPriceToChange >= denominationValue) {
			neededNumberOfDenomination = newPriceToChange / denominationValue;
			if (neededNumberOfDenomination <= totalNumberOfDenomination
					&& neededNumberOfDenomination > 0) {
				numberOfDenominationToBeTaken = neededNumberOfDenomination;
				if (numberOfDenominationToBeTaken == 0) {
					numberOfDenominationToBeTaken = 1;
				}
				newPriceToChange = newPriceToChange
						- (numberOfDenominationToBeTaken * denominationValue);
			} else if (totalNumberOfDenomination < neededNumberOfDenomination) {
				numberOfDenominationToBeTaken = totalNumberOfDenomination;
				newPriceToChange = newPriceToChange
						- (numberOfDenominationToBeTaken * denominationValue);
			}
		}
		return numberOfDenominationToBeTaken;
	}

	/**
	 * Prints the updated number of each dividends as per specs.
	 * 
	 * @param totalMoney
	 * @param total20
	 * @param total10
	 * @param total5
	 * @param total2
	 * @param total1
	 */
	private static void printMessage(int totalMoney, int total20, int total10,
			int total5, int total2, int total1) {

		System.out.println("$" + totalMoney + " " + total20 + " " + total10
				+ " " + total5 + " " + total2 + " " + total1);
	}

}
