package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POITest4 {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream(new File("e:/e_other", "excel.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fin);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell = null;

			XSSFRow row = sheet.getRow(3);
			if (row != null) {
				sheet.removeRow(row);
			}

			cell = row.getCell(3);
			if (cell != null) {
				row.removeCell(cell);
			}
			fin.close();

			FileOutputStream fout = new FileOutputStream(new File("e:/e_other", "excel.xlsx"));
			workbook.write(fout);
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
