package dsalgo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonUtils {

	public static void readExcel(String sheetName) throws IOException {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("Config/Execute_PythonCode.xlsx");

		XSSFWorkbook pythonCodeWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet pythonCodeSheet = pythonCodeWorkbook.getSheet(sheetName);

		for (int i = 1; i < 5; i++) {

			Row row = pythonCodeSheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {

				System.out.print(row.getCell(j).getStringCellValue() + "|| ");

			}

			System.out.println();
		}

	}

	public static String readExcelWithRow(String sheetName, int rowNumber, int column) throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("Config/Execute_PythonCode.xlsx");

		XSSFWorkbook pythonCodeWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet pythonCodeSheet = pythonCodeWorkbook.getSheet(sheetName);

		Row row = pythonCodeSheet.getRow(rowNumber);
		return row.getCell(column).getStringCellValue();

	}

	public static void main(String args[]) {
		try {
			readExcelWithRow(
					"pythonCode",3,0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
