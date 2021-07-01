package prvocisla;

import java.io.File;  
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class Prvocisla {
    
	public static boolean primeTest(int num) {
		int maxDiv = (int)Math.sqrt(num);
		if (num % 2 == 0) {
			return false;
		}
		for(int i = 3; i <= maxDiv ; i+=2){
			if(num % i == 0) {
				return false;
			}
		}
		System.out.println(num);
		return true;
	}
	
	public static boolean isPositiveInteger(String s){
	    if(s.isEmpty()){
	    	return false;
	    }
	    for(int i = 0; i < s.length(); i++){
	        if(s.charAt(i) > '9' || s.charAt(i) < '0'){	        	
	        	return false;
	        }
	    }
	    return true;
	}
	
    public static void main(String[] args){
    	ArrayList<Integer> numList = new ArrayList<Integer>();
        int maxNum = 0;
        try{  
        	File file = new File(args[0]);  
            FileInputStream fis = new FileInputStream(file);   
            XSSFWorkbook wb = new XSSFWorkbook(fis);   
            XSSFSheet sheet = wb.getSheetAt(0);    
            Iterator<Row> itr = sheet.iterator();
            while (itr.hasNext()){
                Row row = itr.next();  
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                Cell cell = cellIterator.next();
                String txt = cell.getStringCellValue();
                if(isPositiveInteger(txt)){
                	int tmp = Integer.parseInt(txt);
                	if(tmp > maxNum){
                		maxNum = tmp;
                	}
                	if(primeTest(tmp)){
                		numList.add(tmp);
                	}
                }
            wb.close();
            }
        }         
        catch(Exception e){  
            e.printStackTrace();  
        }
    }  
}  
