// Script creates new Excel file in project directory and write some data to it

import jxl.*
import jxl.write.*
def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context);

def projectPath = groovyUtils.projectPath
excelPath=projectPath+"/test1.xls"

WritableWorkbook workbook = Workbook.createWorkbook(new File(excelPath))
WritableSheet sheet = workbook.createSheet("Worksheet 1", 0)

// create cell label (index x, index y, content)
Label label = new Label(0, 2, "Column A, Row 3"); //column=0=A,row=0=1
sheet.addCell(label);

Label label2 = new Label(2, 2, "Column C, Row 3");
sheet.addCell(label2);

workbook.write()
workbook.close()