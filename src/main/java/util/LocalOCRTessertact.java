package util;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LocalOCRTessertact {

	public static void main(String[] args) {
        ITesseract tesseract = new Tesseract();
        
		//model path
		String dataPath="/usr/share/tesseract-ocr/4.00/tessdata";
		
		//設定路徑
		tesseract.setDatapath(dataPath);
		
		//辨識圖片儲存路徑
		String image="/home/oem/javaOcp/ocp/HomeWork3-wholesale/img";
		//開新檔
		try {
			File imageFile=new File(image);
			//使用tesseract辨識method
			String result=tesseract.doOCR(imageFile);
	        System.out.println("OCR Result:\n" + result);
		}catch(TesseractException e) {
            e.printStackTrace();
		}
	}

}
