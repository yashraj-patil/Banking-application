package kelp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Bank {

	String accNo;
	String name;
	int saving;

	Bank() {
	}

	Bank(String acc, String name, int saving) {
		super();
		this.accNo = acc;
		this.name = name;
		this.saving = saving;

	}

	Bank(String acc, String name) {
		super();
		this.accNo = acc;
		this.name = name;

	}

	Bank(int saving) {
		super();
		this.saving = saving;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSaving() {
		return saving;
	}

	public void setSaving(int saving) {
		this.saving = saving;
	}

}

public class BankingApplication extends Bank {

	List<Bank> Info = new ArrayList<Bank>();

	public void data(String command, String accNo, String value) {

		
		switch (command) {

		case "CREATE":
			create(accNo, value);
			break;

		case "DEPOSIT":
			deposit(accNo, value);
			break;

		case "WITHDRAW":
			withdraw(accNo, value);
			break;

		}
	}

	public void data(String command, String accNo) {

		System.out.println(showBalance(accNo));
	}

	public void create(String accNo, String name) {

		Info.add(new Bank(accNo, name));

	}

	public void deposit(String accNo, String money) {

		Integer Balance = Integer.parseInt(money);

		for (Bank s : Info) {
			if (s.getAccNo().equals(accNo)) {

				Integer saving = s.getSaving();
				Balance += saving;

				s.setSaving(Balance);

			}
		}

	}

	public void withdraw(String accNo, String money) {

		Integer withdraw = Integer.parseInt(money);

		for (Bank s : Info) {

			if (s.getAccNo().equals(accNo)) {

				Integer amount = s.getSaving();
				
				
               if(amount>0) {
				amount -= withdraw;

				s.setSaving(amount);
               }
               else {
            	   System.out.println("Insufficient Balance");
               }
			}
		}
	}

	public String showBalance(String accNo) {

		String random = "";

		for (Bank s : Info) {

			if (s.getAccNo().equals(accNo)) {
				random = s.getName() + " " + s.getSaving();
			}

		}

		return random;

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String command;
		String accNo;
		String value;
		
		int opeLimit=15;

		BankingApplication obj = new BankingApplication();

		for (int i = 0; i <= opeLimit; i++) {

			String str = sc.nextLine();
			String[] input = str.split(" ");
			command = input[0];
			
			if (input.length == 2) {
				accNo = input[1];
				obj.data(command, accNo);
			} else {
				accNo = input[1];
				value = input[2];
				obj.data(command, accNo, value);
			}

		}

	}

}
