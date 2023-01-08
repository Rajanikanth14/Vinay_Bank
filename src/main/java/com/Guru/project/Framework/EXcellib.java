package com.Guru.project.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EXcellib {
	public static FileInputStream inputstream = null;

	public static XSSFWorkbook workbook = null;

	// getrow count of a sheet
	public static int getRowCount(String filepath, String sheetName) throws IOException {
		int rowCount;
		File file = new File(filepath);

		inputstream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputstream);
		XSSFSheet worksheet = workbook.getSheet(sheetName);
		rowCount = worksheet.getLastRowNum() + 1;

		return rowCount;

	}

	public static int getColoumnCount(String filepath, String sheetName, int rowNumber) throws IOException {
		int ColoumnCount;
		File file = new File(filepath);

		inputstream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputstream);
		XSSFSheet worksheet = workbook.getSheet(sheetName);
		Row row = worksheet.getRow(rowNumber - 1);
		ColoumnCount = row.getLastCellNum();

		return ColoumnCount;

	}

	// get cell data
	public static String getCellData(String filepath, String sheetName, int rowNumber, int colNumbrer) {

		String cellText = null;

		try {

			File file = new File(filepath);
			inputstream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputstream);
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			Row row = worksheet.getRow(rowNumber - 1);
			cellText = row.getCell(colNumbrer).getStringCellValue();

		} catch (Exception e) {

		}

		return cellText;
	}

	// get cell data
	public static String[] getRowData(String filepath, String sheetName, int rowNumber, int colNumbrer)
			throws IOException {

		String[] rowData;

		File file = new File(filepath);
		inputstream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputstream);
		XSSFSheet worksheet = workbook.getSheet(sheetName);
		Row row = worksheet.getRow(rowNumber - 1);

		int ColoumnCount = row.getLastCellNum();

		rowData = new String[ColoumnCount];
		for (int iCol = 0; iCol < ColoumnCount; iCol++) {
			rowData[iCol] = row.getCell(iCol).getStringCellValue();
		}

		return rowData;
	}

	// ---------------------
	public static String[] getRowData(String filepath, String sheetName, String tcName) {

		String[] rowData = new String[10];
		boolean bTag = false;
		try {

			File file = new File(filepath);
			inputstream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputstream);
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			int rowcount = worksheet.getLastRowNum() + 1;
			// search for test case name in each row at coloumn 2
			for (int i = 1; i < rowcount; i++) {

				Row row = worksheet.getRow(i);
				String exlTCName = row.getCell(1).getStringCellValue();
				// verify testcase name matched
				if (tcName.equals(exlTCName.trim())) {
					int colLastIndexCount = row.getLastCellNum();
					// read test case row data to array
					

					for (int j = 2; j <= colLastIndexCount; j++) {

						rowData[j - 2] = row.getCell(j).getStringCellValue();
					}
					bTag = true;
					break;
				}
			} // outer for loop end

			if (bTag == false) {
				System.out.println(tcName + " - Teat case not found in test data sheet -" + sheetName);
			}

		} // try end

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return rowData;
	}

	//--------------------------------
	public static HashMap<String, String>getRowData2(String filepath, String sheetName, String tcName) {

		HashMap<String, String> rowData = new HashMap<String,String>();
		boolean bTag = false;
		try {

			File file = new File(filepath);
			inputstream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputstream);
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			int rowcount = worksheet.getLastRowNum() + 1;
			// search for test case name in each row at coloumn 2
			for (int i = 1; i < rowcount; i++) {

				Row row = worksheet.getRow(i);
				String exlTCName = row.getCell(1).getStringCellValue();
				// verify testcase name matched
				if (tcName.equals(exlTCName.trim())) {
					int colLastIndexCount = row.getLastCellNum();
					// read test case row data to array
					String cellText;

					for (int j = 2; j <= colLastIndexCount; j++) {

			cellText=row.getCell(j).getStringCellValue();
			String[] arr=cellText.split(":=");
			rowData.put(arr[0],arr[1]);
					}
					bTag = true;
					break;
				}
			} // outer for loop end

			if (bTag == false) {
				System.out.println(tcName + " - Teat case not found in test data sheet -" + sheetName);
			}

		} // try end

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return rowData;
	}
}
