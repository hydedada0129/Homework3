package util;

public class CreatePorder_Id {

	public static void main(String[] args) {
//		System.out.println(new CreatePorder_Id().generateTableId(2));
	}
	
	public String generateTableId(int id) {
	    String numberPart = String.format("%03d", id);
	    return "ORD" + numberPart;
	}


}
