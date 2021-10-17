import java.util.Scanner;

public class CPS1231_W04_HongBao_Group9 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Number of money: ");
		double money=input.nextDouble();
		System.out.print("Number of people: ");
		int numberofpeople=input.nextInt();
		
		System.out.println("Do you want to improve the probability of someone to winning?\n"
				+ "enter 1 as yes    enter 2 as no");
		int want=input.nextInt();
		if (want==2) {
			ramdomhongbao(money,numberofpeople);
		}
		else {
			System.out.print("Please enter which one you want give the biggest Hongbao: ");
			int expect=input.nextInt();
			defined(money,numberofpeople,(expect-1));
			System.out.print("\n");
			defined(money,numberofpeople,(expect-1));
			System.out.print("\n");
			defined(money,numberofpeople,(expect-1));
		}
	}
	
	public static void ramdomhongbao(double money, int numberofpeople) {
			//achieve random
		double[]people=new double [numberofpeople];
	    int m=(int)(money*100);
	    double finalmoney=money*100;
		for(int i=0;i<numberofpeople;i++) {
			if(i<numberofpeople-1) {
				people[i]=Math.floor((Math.random()*(m-(numberofpeople-i-1))+1))/100;
				m=m-(int)(people[i]*100); 	
			}
			else{
				for(int j=0;j<i;j++) {
					finalmoney=finalmoney-people[j]*100;
				}
				people[i]=Math.ceil(finalmoney)/100;  
			}
		} 
			double[]exchange=new double [numberofpeople];
			double index=0;
			for(int i=0;i<numberofpeople;i++) {
			    int k=(int)(Math.random()*numberofpeople);
			    if(people[k]!=0) {
			    	index=people[k];
			        people[k]=0;
				    exchange[i]=index;
				    System.out.printf("%-10.2f",exchange[i]); 
			    }
			    else {
			    	i--;
			    }	   
		}
			}	
	
	public static void defined (double money, int numberofpeople,int special) {
		//achieve random
	double[]people=new double [numberofpeople];
    int m=(int)(money*100);
    double finalmoney=money*100;
	for(int i=0;i<numberofpeople;i++) {
		if(i<numberofpeople-1) {
			people[i]=Math.floor((Math.random()*(m-(numberofpeople-i-1))+1))/100;
			m=m-(int)(people[i]*100); 	
		}
		else{
			for(int j=0;j<i;j++) {
				finalmoney=finalmoney-people[j]*100;
			}
			people[i]=Math.ceil(finalmoney)/100;  
		}
	} 
		double index=0;
		double max=0;
		int record=0;
		for(int i=0;i<numberofpeople;i++) {
			max=Math.max(people[i],index);
			index=max;
			if (index==people[i]) {
				record=i;
			}
		}
		people[0]=people[special];
		people[special]=max;
		for(int i=0;i<numberofpeople;i++) {System.out.printf("%-10.2f",people[i]); }	
}
}


