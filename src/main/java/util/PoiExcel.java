/*
 * 1.FileOutputStream(寫入檔案) , FileInputStream(讀取檔案)
 * 
 * 
 * 2.HSSFWorkbook excelBook=new HSSFWorkbook(fis);-->產生excel物件
 * 3.HSSFSheet sheet=excelBook.getSheet(sheetName);-->產生工作表
 * 
 * ->int count=sheet.getPhysicalNumberOfRows();-->讀取目前工作表有內容的列數
 * 
 * 4.HSSFRow row=sheet.createRow(count);-->寫入第幾列
 * 5.row.createCell(0).setCellValue(name);-->同一列的儲存格位置
 * 
 * 
 * 
 * 
 * 
 * 
 */

package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import vo.ShoppingReportView;
import vo.service.impl.ViewServiceImpl;

//import po.Employee;

//

public class PoiExcel {

	public static void main(String[] args) {
		//建立Excel
		//PoiExcel.createExcelFile("excel_with_ext", "客戶付款明細");	
		/*
		Employee employee=new Employee("1", "A", "B");
		PoiExcel.inserValue("ExcelTest1", "員工資料", employee);
		*/
//		PoiExcel.createExcelFile("test.xls", "sheetTest");

		//porder_id, customer_name, product_name, qty, shipping_address, total
//		ShoppingReportView view=new ShoppingReportView("1","2","3",10,"4",20);
//		PoiExcel.inserValue("test.xls", "sheetTest", view);
		
		/*view test:
		PoiExcel.createExcelFile("test.xls", "sheetTest");
		List<ShoppingReportView> listView=new ArrayList();
		ViewServiceImpl vsi=new ViewServiceImpl();
		listView=vsi.findtView();
		System.out.println(list);
		PoiExcel.inserValue("test.xls", "sheetTest", listView);
		*/
	}
	
	//用view
//	public static void inserValue(String fileName,String sheetName, ShoppingReportView view) {
	public static void inserValue(String fileName,String sheetName, List<ShoppingReportView> listView) {

		//填入資料
		try {
			//讀取檔案轉乘byte 並存入記憶體
			FileInputStream fis=new FileInputStream(fileName);
			
			//將記憶體內的byte , 用Excel套件, 建立一個excel物件
			HSSFWorkbook excelBook=new HSSFWorkbook(fis);
			
			//讀取sheet
			HSSFSheet sheet=excelBook.getSheet(sheetName);
			
			//確認下一個row 是空的
//			int count=sheet.getPhysicalNumberOfRows();
//			System.out.println(count);
			
			//porder_id, customer_name, product_name, qty, shipping_address, total
			//資料填入cell
//			HSSFRow row=sheet.createRow(count);
			
			for(ShoppingReportView obj:listView) {	
				int count=sheet.getPhysicalNumberOfRows();
				System.out.println(count);
				HSSFRow row=sheet.createRow(count);
				
				row.createCell(0).setCellValue(obj.getPorder_id());
				row.createCell(1).setCellValue(obj.getCustomer_name());
				row.createCell(2).setCellValue(obj.getProduct_name());
				row.createCell(3).setCellValue(obj.getQty());
				row.createCell(4).setCellValue(obj.getShipping_address());
				row.createCell(5).setCellValue(obj.getTotal());
				
			}
			
			//寫回Excel檔案
			FileOutputStream fos=new FileOutputStream(fileName);
			excelBook.write(fos);
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void createExcelFile(String filename, String sheetname) {
//		String fileNameAddExt=filename+".xls";	//加入副檔名
		
		try {
			//建立檔案
			FileOutputStream excelFile=new FileOutputStream(filename);	
			//產生Excel物件
			HSSFWorkbook excelBook=new HSSFWorkbook();
			//產生工作表
			HSSFSheet excelSheet=excelBook.createSheet(sheetname);
			//第一個row, 設計填寫欄位columns
			//porder_id, customer_name, product_name, qty, shipping_address, total
			HSSFRow row=excelSheet.createRow(0);	//0-->第一個row
			row.createCell(0).setCellValue("訂單編號");
			row.createCell(1).setCellValue("客戶名字");
			row.createCell(2).setCellValue("產品名稱");
			row.createCell(3).setCellValue("產品數量");
			row.createCell(4).setCellValue("寄件地址");
			row.createCell(5).setCellValue("總金額");	
			
			excelBook.write(excelFile);
			excelFile.flush();
			excelFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

/*
public class CreateExcel {

	public static void main(String[] args) {
		
		//CreateExcel.createExcelFile("Test.xls", "員工資料表");
		
		Employee employee=new Employee("003","jackie","台北市","123456789");
		
		
		CreateExcel.inserValue("Test.xls","員工資料表", employee);
	
	
	
	
	
	}
	public static void inserValue(String fileName,String sheetName,Employee employee)
	{
		try {
			FileInputStream fis=new FileInputStream(fileName);
			HSSFWorkbook excelBook=new HSSFWorkbook(fis);
			HSSFSheet sheet=excelBook.getSheet(sheetName);
			int count=sheet.getPhysicalNumberOfRows();
			System.out.println(count);
			
			HSSFRow row=sheet.createRow(count);
			row.createCell(0).setCellValue(employee.getId());
			row.createCell(1).setCellValue(employee.getName());
			row.createCell(2).setCellValue(employee.getAddress());
			row.createCell(3).setCellValue(employee.getPhone());
			
			FileOutputStream fos=new FileOutputStream(fileName);
			
			excelBook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
	}
	*/
