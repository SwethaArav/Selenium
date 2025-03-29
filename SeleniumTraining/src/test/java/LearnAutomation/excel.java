package LearnAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {

	public static void main(String[] args) throws Exception {
		File src = new File("C:\\Users\\swetha.sivaprakasam\\Documents\\Personal\\Cred.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fis);

	}

}
