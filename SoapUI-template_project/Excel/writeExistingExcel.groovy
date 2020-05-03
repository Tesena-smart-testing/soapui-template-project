// Script shows how to write to existing Excel sheet. It is neccessary to copy content of existing file to a new file.

import jxl.*
import jxl.write.*

excelPath="C:/Users/radka/Desktop/data_rest.xls"
newExcelPath="C:\\Users\\radka\\Desktop\\output1.xls\\"

def groovyUtils = new com.eviware.soapui.support.GroovyUtils( context ) 


Workbook existingWorkbook = Workbook.getWorkbook(new File(excelPath));
WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(newExcelPath), existingWorkbook);
WritableSheet sheetToEdit = workbookCopy.getSheet(0);
WritableCell cell;

// create cell label (index x, index y, content)
label = new Label(2, 1, "cell content");
cell = (WritableCell) label; 
sheetToEdit.addCell(cell);

workbookCopy.write();
workbookCopy.close();
existingWorkbook.close();
