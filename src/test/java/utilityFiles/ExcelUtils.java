package utilityFiles;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelUtils {
 
	public static FileInputStream fi;    // FileInputStream Global Variable
	public static FileOutputStream fo;   // FileOutputStream Global Variable
	public static XSSFWorkbook wb;       // Excel Workbook Global Variable
	public static XSSFSheet ws;			 // Excel Sheet Global Variable
	public static XSSFRow row;			 // Excel Row Global Variable
	public static XSSFCell cell;		 // Excel Cell Global Variable


	// write data on excel sheet cells 
	public void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);   
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	
}