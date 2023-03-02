package org.datadrivenframe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
private static final CellType String = null;
private static final CellType Numeric = null;

public static void main(String[] args) throws IOException {
	File file = new File("F:\\JAVA SELENIUM\\framework\\framework sathish sir\\employee detail.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	int numberOfSheets = workbook.getNumberOfSheets();
			Sheet sheet = workbook.getSheet("Employee Records 1");
			Sheet createSheet = workbook.createSheet("Employee records ");
			int rows = sheet.getPhysicalNumberOfRows();
			for(int i=0;i<rows; i++) {
		    		Row row = sheet.getRow(i);
		    		Row createRow = createSheet.createRow(i);
		    		int cells = row.getPhysicalNumberOfCells();
		    		for(int j=0; j<cells;j++) {
		        		Cell cell = row.getCell(j);
		        		Cell createCell = createRow.createCell(j);
		        	    String stringCellValue = cell.getStringCellValue();
		        	  
		        		System.out.println(stringCellValue);
		        		createCell.setCellValue(stringCellValue);
		    		}
			}
		        		FileOutputStream outputStream= new FileOutputStream(file);
		        		workbook.write(outputStream);
		
	}
}


	
		        		
//		        		switch(cellType) {
//		        		
//		        		case STRING:
//		        			
//		        			String stringCellValue = cell.getStringCellValue();
//		        			createCell.setCellValue(stringCellValue);
//		        			System.out.print( stringCellValue+"\t");
//		        			
//		        		break;
//		        		
//		        		case NUMERIC:
//		        				if(DateUtil.isCellDateFormatted(cell)){
//		        				Date dateCellValue = cell.getDateCellValue();
//		        				SimpleDateFormat date= new SimpleDateFormat("dd/MM/yyyy");
//		            			String format = date.format(dateCellValue);
//		            			createCell.setCellValue(format);
//		            			System.out.print(format+"\t");
//		            			
//		        			}
//		        		else
//		        				
//		        			{
//		        				double numericCellValue = cell.getNumericCellValue();
//		            			long l=(long )numericCellValue;
//		            			System.out.print(numericCellValue+"\t");
//		            			createCell.setCellValue(l);
//		        			}
//		        				
//		        	    default:
//		        			break;
//		        		}
		        		
		    	    		        	