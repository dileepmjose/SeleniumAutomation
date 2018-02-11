package com.djose.selenium.automation.lib;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.djose.automation.constants.AppConst;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public final class ExcelReader {

	static Sheet workSheet;
	static Workbook workBook;
	public Hashtable<String, Integer> dict = new Hashtable<String, Integer>();
	
	public   ExcelReader(String fileName, String workSheetName)
			throws BiffException, IOException {
		workBook = Workbook.getWorkbook(new File(
				AppConst.RESOURCE_TEST_CASE_PATH + fileName));		
		workSheet = workBook.getSheet(workSheetName);
		ColumnDictionary();
	}

	
	/**
	 * Return rumber of Rows in Excel
	 * 
	 * @return int
	 */
	public  final int rowCount() {
		return workSheet.getRows();
	}
	
	
	/**
	 * Return rumber of coloum  in Excel workSheet
	 * 
	 * @return int
	 */
	public  final int columnCount() {
		return workSheet.getColumns();
	}


	/**
	 * Returns the Cell value by taking row and Column values as argument
	 * @param column
	 * @param row
	 * 
	 * @return String
	 */
	public  final String readCell(int column, int row) {
		return workSheet.getCell(column, row).getContents();
	}
    /**
     *  Returns the Cell value by taking row and ColumnName as argument
     *  
     * @param columnName
     * @param rowNumber
     * 
     * @return String
     */
	public  final String ReadCell(String columnName, int rowNumber) {
		return readCell(GetCell(columnName), rowNumber);
	}

	

	/**
	 *  Create Column Dictionary to hold all the Column Names
	 * 
	 *  Iterate through all the columns in the Excel sheet and store the
	 *  value in Hashtable
	 * 
	 */
	
	public  final void ColumnDictionary() {		
		for (int col = 0; col < workSheet.getColumns(); col++) {
			dict.put(readCell(col, 0), col);
		}
	}
	
	
	
	
	/**
	 * Read Column Names
	 * @param String :colName
	 * @return int
	 */
	public  int GetCell(String colName) {
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);

		}
	}
	
	
	
}