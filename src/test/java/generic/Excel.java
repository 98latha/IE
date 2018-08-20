package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class Excel 
{ 
	
	public static String getCellValue(String path,String sheet,int row,int cell)
	{
		String v="";
		try{
			FileInputStream fis=new FileInputStream(path);
			Workbook w=WorkbookFactory.create(fis);
			Cell c = w.getSheet(sheet).getRow(row).getCell(cell);
			 v = c.toString();
			
		}
		catch(Exception e)
		{
			Reporter.log("no path",true);
		}
		return v;
		
	}

}
