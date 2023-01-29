//import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
class Account {
	private  int CN ;
	private int PN;
	double CB = 2000;
	double SB = 1000;
//	DecimalFormat df = new DecimalFormat("'Rupee '###,##0.00");
	Scanner s = new Scanner(System.in);
	
	 void setCustomerNumber(int CustomerNumber)
	{
		 CN  = CustomerNumber;
		 //System.out.println("CN ");
	}
	 void setPINNumber(int PINNumber)
	 {
		 PN = PINNumber;
		 //System.out.println("PN ");
	 }
	 int getCustomerNumber()
	 {
		 return CN;
	 }
	 int getPINNumber()

	 {
		  return PN;
	 }
	 
	 double getCurrentBalance()
	 {
		 return CB;
	 }
	 double getSavingBalance()
	 {
		 return SB;
	 }
	 
	 void getCurrentWithdrawInput()
	 {
		 System.out.println("Your Current Account Balance is :  "+ (CB));
		 
	 }
}
class OptionMenu extends Account 
{	
	Scanner s = new Scanner(System.in);
	HashMap <Integer, Integer> hm = new HashMap<Integer, Integer>();
	//DecimalFormat df = new DecimalFormat("'Rupee '###,##0.00");
	
	void getlogin()
	{
		int x = 1;
		
		do
		{
			try
			{
				
				
				System.out.print("Enter your Customer Number: ");
				setCustomerNumber(s.nextInt());
				
				System.out.print("Enter your Pin Number: ");
				setPINNumber(s.nextInt());
				
				hm.put(11111, 111);
				hm.put(22222, 222);
				hm.put(33333, 333);
				hm.put(44444, 444);
				hm.put(55555, 555);
				
				int a = getCustomerNumber();
				int b = getPINNumber();
				
				if(hm.containsKey(a)&& hm.get(a) == b)
				{
					System.out.println("\n\t\tlogin Secussfully");
					System.out.println("           __________________________ ");
					System.out.println("           __________________________\n ");
					getAccountType(); 
				}
				else
				{
					System.out.println("Opps ! Invalid Credential ! Plz Try Again");
					System.out.println("_________________________________________\n ");
				}
				
			}
			catch(Exception a)
			{
				System.out.println("Please enter only numbers." +"\nCharacters and symbols not Allowed !");
				x = 2;
			}
		} while(x == 1);
		
	}
	void getAccountType()
	{
		System.out.println("Select the Account type you want to access: \n");
		System.out.println("Type 1 : Current Account ");
		System.out.println("Type 2 : Savings Account ");
		System.out.println("Type 3 : Exit \n");
		System.out.print("\tSelect Choice : ");
		System.out.print("\n\t_____________");

		
		int choice = s.nextInt();
		
		switch(choice)
		{
		case 1:	getCurrent();
				break;
		case 2:	getSaving();
				break;		
		case 3:System.out.println("Thank you for Visiting ! Visit Again");
		getAccountType();
			break;
		default:System.out.println("Invalid Choice ! Please enter valid Choice! ");
			break;
		}
		
	}
	void getCurrent()
	{
		System.out.println("\n------You Have Entered In Current Account------------\n");
		System.out.println("Type 1 : View Balance ");
		System.out.println("Type 2 : Withdraw Funds");
		System.out.println("Type 3 : Deposit Funds");
		System.out.println("Type 4 : Exit");
		System.out.print("\n\tSelect Choice : ");
		System.out.println("\n\t_____________");
		
		int choice = s.nextInt();
		
		switch(choice)
		{
		case 1:System.out.println("Your Current Account balance : " +(getCurrentBalance()));
			break;
		case 2:getcurrentwithdrawinput();	
		    getCurrent();
			break;
		case 3:currentdeposit();
		System.out.println("Now your balace is : "+ CB);
			break;
		case 4:System.out.println("Thank you for visiting ! Visit Again ! ");
		getAccountType();
			break;
		default:System.out.println("Invalid Choice !");
		getCurrent();
			break;
		}
		
		
	}
	void getSaving()
	{
		System.out.println("-------------You Have Entered In Current Account\n");
		System.out.println("Type 1 : View Balance ");
		System.out.println("Type 2 : Withdraw Funds");
		System.out.println("Type 3 : Deposit Funds");
		System.out.println("Type 4 : Exit\n");
		System.out.print("\n\tSelect Choice : ");
		System.out.println("\n\t_____________");		
		int choice = s.nextInt();
		
		switch(choice)
		{
		case 1:System.out.println("Your Saving Account balance : " +(getSavingBalance()));
			break;
		case 2:getSavingwithdrawinput();
		System.out.println("now your money is :"+SB);
		 //   getAccountType();
			break;
		case 3:savingdeposit();
		System.out.println("Now your balace is : "+ SB +"\n");
		
		
			break;
		case 4:System.out.println("Thank you for visiting ! Visit Again ! ");
			break;
			
		default:System.out.println("Invalid Choice !");
		getSaving();
			break;
		}
	}
	double calsiCurrentWithdraw(double money) {
		CB=CB-money;
		return CB;
	}
	
	double calsiSavingWithdraw(double money) {
		SB=SB-money;
		return SB;
	}
	
	void getcurrentwithdrawinput() {
		System.out.println("your current account balance is :"+CB);
		System.out.println("Amount you want to withdraw from your current account :");
		double Amount=s.nextDouble();
		if((CB-Amount)>=0) {
			calsiCurrentWithdraw(Amount);
			
			//System.out.println("your new checking account balance is:"+" "+(CB-Amount));
		}
		else {
			System.out.println("insufficient balace for this transition");
		}
	}
	
	void getSavingwithdrawinput() {
		System.out.println("your current account balance is :"+SB);
		System.out.println("Amount you want to withdraw from your current account :");
		double Amount=s.nextDouble();
		if((SB-Amount)>=0) {
			calsiSavingWithdraw(Amount);
			//System.out.println("your new checking account balance is:"+" "+(SB-Amount));
		}
		else {
			System.out.println("insufficient balace for this transition !");
		}
	}
	
	  void currentdeposit() {
		 
		  System.out.println("amount you want to deposit :__");
		  double A=s.nextDouble();
		  if(CB+A>=0) {
			  CB+=A;
		  }
		  else {
			  System.out.println("Enter valid Amount");
		  }
	  }
	  void savingdeposit() {
		 
		  System.out.print("amount you want to deposit :__");
		  double A=s.nextDouble();
		  if(SB+A>=0) {
			  SB+=A;
		  }
		  else {
			  System.out.println("Enter valid Amount");
		  }
	  }
}


public class ATM_5_DEC extends OptionMenu 
{
	public static void main(String[] args) 
	{
		OptionMenu op  = new OptionMenu();
		System.out.println("\t\t** WEL_COME TO RSCOE ATM **");
		System.out.println("\t      ______________________________");
		System.out.println("\t      ______________________________\n");
		op.getlogin();
	}
	
}