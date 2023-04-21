package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
   XSSFWorkbook wb;
  // constructor for reading excel path
   public ExcelFileUtil(String ExcelFile)throws Throwable
   {
	   FileInputStream fi =new FileInputStream(ExcelFile);
	   wb =new XSSFWorkbook(fi);
   }
   //method for counting no of rows in sheet
    public int rowcount(String sheetname)
    {
    	return wb.getSheet(sheetname).getLastRowNum();
    }
    // method for reading cell data
    public String getCellData(String sheetname,int row,int column)
    {
    	String data ="";
    	if (wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC) 
    	{
    		int Celldata =(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
    		data =String.valueOf(Celldata);
    	}
    	else
    	{
    		data =wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
    	}
    	return data;
    }
    // method for set cell data
    public void setcelldata(String sheetName,int row,int column,String status,String writeExcel) throws Throwable
    {
    	//get sheet from wb
    	XSSFSheet ws =wb.getSheet(sheetName);
    	//get row from sheet
    	XSSFRow rowNum =ws.getRow(row);
    	//create cell 
    	XSSFCell  cell =rowNum .createCell(column);
    	cell.setCellValue(status);
    	if (status.equalsIgnoreCase("pass")) 
    	{
    		XSSFCellStyle style =wb.createCellStyle();
    		XSSFFont font =wb.createFont();
    		font.setColor(IndexedColors.GREEN.getIndex());
    		font.setBold(true);
    		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
    		style.setFont(font);
    		rowNum.getCell(column).setCellStyle(style);
    	}
    	else if (status.equalsIgnoreCase("fail")) 
    	{
    		XSSFCellStyle style =wb.createCellStyle();
    		XSSFFont font =wb.createFont();
    		font.setColor(IndexedColors.RED.getIndex());
    		font.setBold(true);
    		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
    		style.setFont(font);
    		rowNum.getCell(column).setCellStyle(style);
    	}
    	else if (status.equalsIgnoreCase("Blocked")) 
    	{	
    		XSSFCellStyle style =wb.createCellStyle();
    		XSSFFont font =wb.createFont();
    		font.setColor(IndexedColors.RED.getIndex());
    		font.setBold(true);
    		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
    		style.setFont(font);
    		rowNum.getCell(column).setCellStyle(style);
    	}	
		FileOutputStream fo =new FileOutputStream(writeExcel);
		wb.write(fo);
    }	
    		
			
		}
    	
    	
    	
    	
    
			
		
    	