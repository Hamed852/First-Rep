package excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {


	public void getrowcount() {

		String excelpath ="C:\\Users\\QOYOD\\eclipse-workspace\\RestassuredProject\\Data";
		try {
			XSSFWorkbook work = new XSSFWorkbook(excelpath);
			XSSFSheet sheet = work.getSheet("Sheet1");

			String value =sheet.getRow(1).getCell(2).getStringCellValue();

			System.out.println(value);



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
