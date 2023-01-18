package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;

	public static ArrayList<String> readDataFromExcel(String filePath, String sheetName) throws IOException {
		String path = System.getProperty("user.dir") + filePath;
		ArrayList<String> excelRows = new ArrayList<String>();
		f = new FileInputStream(path);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);

		DataFormatter formatter = new DataFormatter();

		for (Row r : sh) {
			for (Cell c : r) {
				excelRows.add(formatter.formatCellValue(c));
			}
		}
		return excelRows;
	}
	public static String readDataFromExcel(int row, int column,String sheetName) throws IOException
	{
		f = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\Excel\\grocery.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheetName);
		Row r = sh.getRow(row);
		Cell c = r.getCell(column);
		return c.getStringCellValue();	
	}
}
