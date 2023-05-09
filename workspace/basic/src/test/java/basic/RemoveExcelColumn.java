package basic;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class RemoveExcelColumn {
	private void deleteColumn(Sheet sheet, int columnToDelete) {
		for (int rId = 0; rId < sheet.getLastRowNum(); rId++) {
			Row row = sheet.getRow(rId);
			for (int cID = columnToDelete; cID < row.getLastCellNum(); cID++) {
				Cell cOld = row.getCell(cID);
				if (cOld != null) {
					row.removeCell(cOld);
				}
				Cell cNext = row.getCell(cID + 1);
				if (cNext != null) {
					Cell cNew = row.createCell(cID, cNext.getCellType());
					cloneCell(cNew, cNext);
					// Set the column width only on the first row.
					// Other wise the second row will overwrite the original column width set
					// previously.
					if (rId == 0) {
						sheet.setColumnWidth(cID, sheet.getColumnWidth(cID + 1));

					}
				}
			}
		}
	}

	private void cloneCell(Cell cNew, Cell cOld) {
		cNew.setCellComment(cOld.getCellComment());
		cNew.setCellStyle(cOld.getCellStyle());

		if (CellType.BOOLEAN == cNew.getCellType()) {
			cNew.setCellValue(cOld.getBooleanCellValue());
		} else if (CellType.NUMERIC == cNew.getCellType()) {
			cNew.setCellValue(cOld.getNumericCellValue());
		} else if (CellType.STRING == cNew.getCellType()) {
			cNew.setCellValue(cOld.getStringCellValue());
		} else if (CellType.ERROR == cNew.getCellType()) {
			cNew.setCellValue(cOld.getErrorCellValue());
		} else if (CellType.FORMULA == cNew.getCellType()) {
			cNew.setCellValue(cOld.getCellFormula());
		}
	}
}
