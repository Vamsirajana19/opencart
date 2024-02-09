package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="loginData")
	public String[][]getData() throws IOException{
		String path = ".//testData//Book1.xlsx";
		ExcelUtilities xl = new ExcelUtilities(path);
		int totalrows = xl.getRowCount("Sheet1");
		int totalcells =  xl.getCellCount("Sheet1",1);
		String loginData[][] = new String[totalrows][totalcells];
		for(int r=1;r<=totalrows;r++) {
			for(int c=0;c<totalcells;c++) {
				loginData[r-1][c]=xl.getCellData("Sheet1", r, c);
			}
		}
		return loginData;
		
	}

}
