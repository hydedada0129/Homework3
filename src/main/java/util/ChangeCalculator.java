package util;

public class ChangeCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public String cal(String payment, int totalAmount) {
		Integer pay=Integer.parseInt(payment);
		int totalA=(int)totalAmount;
		int change=pay - totalA;	
		String changeString = "";
		
		if((change<0) || (pay<0))		
			return "付款金額不能小於總價或小於零";
		else {			
			changeString+="找零金額： ";
			changeString+=change+"\n以下找零方式：\n";	//136
			
			if(change/1000>0){	//136/1000=0.xxx
				int thousand=change/1000;
				change%=1000;
				changeString+="\n千元：" + thousand +"張";
			}
			if(change/500>0){		//136/500=0.xxx
				int fivehundred=change/500;
				change%=500;
				changeString+="\n五百元：" + fivehundred+"張";
			}
			if(change/100>0){		//136/100=1.36
				int hundred=change/100;	//136/100=1
				change%=100;		//136%100=36
				changeString+="\n一百元：" + hundred+"張";
			}
			if(change/50>0){		//36/50=0.xxx
				int fifty=change/50;
				change%=50;
				changeString+="\n五十元：" + fifty+"張";
			}
			if(change/10>0){		//36/10=3.6
				int ten=change/10;			//36%10=6
				change%=10;
				changeString+="\n十元：" + ten+"張";
			}
			if(change/5>0){		//6/5=1.2
				int five=change/5;	//6%5=1
				change%=5;
				changeString+="\n五元：" + five+"張";

			}
			if(change/1>0){		//1/1=1
				int one=change/1;	//1%1=0
				changeString+="\n一元：" + one+"張";

			}
		}
		return changeString;
	}
}
