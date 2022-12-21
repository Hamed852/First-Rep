package excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel2 {







	static String ProjDir = System.getProperty("user.dir");

	static String excelpath ="./Data/Book1.xlsx";

	static 	XSSFWorkbook work ;

	static XSSFSheet sheet ;

public static void main(String[] args)
{

		GetRowCount();
		Getcelldata();

}


public Excel2(String excelpath , String Sheetname  )
{
		try
{
			 work = new XSSFWorkbook(excelpath);
			 sheet = work.getSheet(Sheetname);
}
		catch (IOException e)
{
			// TODO Auto-generated catch block
			e.printStackTrace();
}
}
public static void Getcelldata() {

		String value =sheet.getRow(1).getCell(1).getStringCellValue();

		System.out.println(value);
	}


	public static void GetRowCount() {

		try {
			XSSFWorkbook work = new XSSFWorkbook(excelpath);
			XSSFSheet sheet = work.getSheet("Sheet1");

			String value =sheet.getRow(1).getCell(0).getStringCellValue();

			System.out.println(value);



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}




