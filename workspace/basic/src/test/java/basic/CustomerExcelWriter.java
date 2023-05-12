package basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CustomerExcelWriter {
	// .xls는 Excel2003 이전 형식으로 문서를 만든 경우 생성되는 확장자
	public void createExcelFileBefore2003(List<CustomerVo> list) {

		// 워크북 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 워크시트 생성
		HSSFSheet sheet = workbook.createSheet();
		// 행 생성
		HSSFRow row = sheet.createRow(0); // 현재 작업중인 row는 = 첫번째 행(index=0)
		// 셀 생성
		HSSFCell cell;

		// 헤더 정보 구성
		cell = row.createCell(0); // 1번째(index=0) 열에 셀을 생성, 현재 행은 0
		cell.setCellValue("아이디"); // 생성된 셀에 "아이디"라는 값을 설정한다.

		cell = row.createCell(1); // 2번째(index=1) 열에 셀을 생성, 현재 행은 0
		cell.setCellValue("이름"); // 생성된 셀에 "이름"라는 값을 설정한다.

		cell = row.createCell(2);
		cell.setCellValue("나이");

		cell = row.createCell(3);
		cell.setCellValue("이메일");

		cell = row.createCell(4);
		cell.setCellValue("전화번호");

		// 리스트의 size 만큼 row를 생성
		CustomerVo vo;
		for (int rowIdx = 0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx);

			// 행 생성
			row = sheet.createRow(rowIdx + 1);

			cell = row.createCell(0);
			cell.setCellValue(vo.getCustId());

			cell = row.createCell(1);
			cell.setCellValue(vo.getCustName());

			cell = row.createCell(2);
			cell.setCellValue(vo.getCustAge());

			cell = row.createCell(3);
			cell.setCellValue(vo.getCustEmail());

			cell = row.createCell(4);
			cell.setCellValue(vo.getCustTelno());

		}

		// 입력된 내용 파일로 쓰기
		File file = new File(MainApplication.FILE_BEFORE_2003);
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fos != null)
					fos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// .xlsx는 Excel2007 이후 형식으로 문서를 만든 경우 생성되는 확장자
	public void createExcelFileAfter2007(List<CustomerVo> list) {
		// 워크북 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 워크시트 생성
		XSSFSheet sheet = workbook.createSheet();
		// 행 생성
		XSSFRow row = sheet.createRow(0);
		// 쎌 생성
		XSSFCell cell;

		// 헤더 정보 구성
		cell = row.createCell(0);
		cell.setCellValue("아이디");

		cell = row.createCell(1);
		cell.setCellValue("이름");

		cell = row.createCell(2);
		cell.setCellValue("나이");

		cell = row.createCell(3);
		cell.setCellValue("이메일");

		cell = row.createCell(4);
		cell.setCellValue("전화번호");

		// 리스트의 size 만큼 row를 생성
		CustomerVo vo;
		for (int rowIdx = 0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx);

			// 행 생성
			row = sheet.createRow(rowIdx + 1);

			cell = row.createCell(0);
			cell.setCellValue(vo.getCustId());

			cell = row.createCell(1);
			cell.setCellValue(vo.getCustName());

			cell = row.createCell(2);
			cell.setCellValue(vo.getCustAge());

			cell = row.createCell(3);
			cell.setCellValue(vo.getCustEmail());

			cell = row.createCell(4);
			cell.setCellValue(vo.getCustTelno());

		}

		// 입력된 내용 파일로 쓰기
		File file = new File(MainApplication.FILE_AFTER_2007);
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fos != null)
					fos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
