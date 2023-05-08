package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	public static void writeExcelFile(List<StudentDTO> list) throws EncryptedDocumentException, IOException {
		String filePath = "e:/other/student_transfer.xlsx"; // 저장할 파일 경로

		FileOutputStream fos = new FileOutputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("studentList"); // sheet 생성

		XSSFRow curRow;

		int row = list.size(); // list 크기
		for (int i = 0; i < row; i++) {
			curRow = sheet.createRow(i); // row 생성
			curRow.createCell(0).setCellValue(list.get(i).getId()); // row에 각 cell 저장
			curRow.createCell(1).setCellValue(list.get(i).getName());
			curRow.createCell(2).setCellValue(list.get(i).getBirthDate());
		}

		workbook.write(fos);
		fos.close();

	}
}
