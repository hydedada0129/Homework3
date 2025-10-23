# HW_3

巨匠作業3, 購物系統+OCR(Optical Character Recognition)影像辨識

# Windows 安裝  
## 使用本地安裝影像辨識套件: Tesseract OCR (jar檔案太大無法上傳github??) 
- 跑model需安裝：下載網址：tesseract-ocr-w64-setup-5.5.0.20241111.exe     
或使用下載檔：javaOcp/ocp/HomeWork3-wholesale/Windows_OCR/tesseract-ocr-w64-setup-5.5.0.20241111.exe

- Windows 環境設定  
Press Windows key → search “Environment Variables” → open Edit system environment variables.  
Click Environment Variables.  
Under System variables, find Path → click Edit.

- 確認安裝成功  
tesseract --version  
如下：  
tesseract v5.3.0  
leptonica-1.83.1  


# Ubunto 20.04 安裝
- 下載套件  
sudo apt update
sudo apt install tesseract-ocr libtesseract-dev

- 確認  
tesseract --version

- 查找套件安裝路徑  
dpkg -L tesseract-ocr | grep tessdata

/usr/bin下 or /usr/share下

- Maven pom.xml dependency

影像辨識 Tess4J for OCR : 辨識model    


\<dependency\>            
\<groupId>net.sourceforge.tess4j</groupId>            
\<artifactId>tess4j</artifactId>            
\<version>5.9.0</version>            
\</dependency>            

JavaCV / OpenCV : 圖片處理套件            
\<dependency>            
\<groupId>org.bytedeco</groupId>            
\<artifactId>javacv-platform</artifactId>            
\<version>1.5.10</version>            
\</dependency>            `
            
# java tesseract程式
需要改：    
tessert安裝路徑       
被辨識的圖片路徑    



