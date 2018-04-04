
/*
 * Team members: Biniam, Darius, Elvis & Patrick
 */


import java.util.Scanner;

public class TRL_App {
	private static PatronList pStore;
	private static CopyStore cStore;
	private static Manage coManage;

	public static void main(String[] args) {

		pStore = new PatronList();
		cStore = new CopyStore();
		coManage = new Manage(pStore, cStore);
		System.out.println("Welcome...... ");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		boolean start = true;
		while (start) {
			System.out.println("======================= \nPlease choose from the following options:");
			System.out.println("\t- Enter 1 to start a check out transaction");
			System.out.println("\t- Enter 2 to display Patron's information");
			System.out.println("\t- Enter 3 to exit");
			String input = scan.nextLine();
			switch (input) {
			case "1":
				doCheckOut();
				break;
			case "2":
				displayPatronInfo();
				break;
			case "3":
				System.out.println("Thank you for using our program ");
				start = false;
				break;
			}
		}
	}

	private static void doCheckOut() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Patron's ID OR 1 to cancel transaction ");
		String PID = scan.next();
		if (PID.equals("1")) 
		{
			System.out.println("Transaction canceled.... ");
			return;
		}

		Patron Patron = coManage.startNewTransaction(PID);
		System.out.println(Patron);
		coManage.setPatron(Patron);

		String CID = " ";	
		while ( Patron != null ) {
			Copy copy=new Copy("0000");
			System.out
					.println("Please enter copy ID to check out, 0 to complete transaction OR 1 to cancel transaction");
			CID = scan.next();
			
			if (CID.equals("0")) {
				coManage.endTransaction();
				System.out.println("End of transaction... \n");
				break;
			}
			
		
			if (CID.equals("1")) 
			{
				coManage.cancelTransaction();
				System.out.println("Transaction canceled....");
				break;
			}
			
			copy = coManage.checkOutCopy(CID);
			System.out.println("copy checked out \t" + copy);
			
			if (copy == null)
				System.out.println("Bad input... Try again");
		}
		if (coManage.checkCopyList()) 
		{
			String dueDate = coManage.assignDueDate();
			System.out.println("Due date is:" + dueDate);
		}
	}

	private static void displayPatronInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Patron's ID OR 0 to quit");
		String PID = scan.next();
		if (PID.equals("0")) {
			System.out.println(" Thank you ");
			System.exit(0);
		}
		Patron p = coManage.getPatronInfo(PID);
		System.out.println(p);
	}

}
