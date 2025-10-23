package util;

public class StringHandler {

	public static void main(String[] args) {
		System.out.println(StringHandler.getNewNum("CUST001"));
	}
	public static String getNewNum(String id) {
		String prefix= id.replaceAll("[0-9]", "");	//"CUST", "P", "ORD"
		String numPart=id.replaceAll("[^0-9]", "");
		int newNum=Integer.parseInt(numPart) + 1;
		String format="%0"+numPart.length() +"d";
		return prefix + String.format(format, newNum);
	}

}
