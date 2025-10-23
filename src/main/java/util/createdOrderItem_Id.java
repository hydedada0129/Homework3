package util;

public class createdOrderItem_Id {

	public static void main(String[] args) {
//		System.out.println(new createdOrderItem_Id().generateTableId(003));
	}
	public String generateTableId(int id) {
	    String numberPart = String.format("%03d", id);
	    return "OI" + numberPart;
	}
}
