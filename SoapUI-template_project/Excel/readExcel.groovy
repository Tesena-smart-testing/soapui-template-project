import jxl.*

// read values from excel by indexes
excelPath="C:/Users/radka/Desktop/data_rest.xls"

def readExcel(int i, int j)
  {
    Workbook workbook = Workbook.getWorkbook(new File(excelPath))
    Sheet sheet = workbook.getSheet(0)

    try {
    cell = sheet.getCell(i,j)
    } catch(Exception e1) {
  	  log.info("Index out of range")
  	  return 0
	}
    
     
    workbook.close()
    return cell.contents;
}


for(int i=0; i<3; i++) {
	for (int j=0; j<3; j++) {
		if (readExcel(i,j)==0) {
			return 1
		}
		log.info(readExcel(i,j));
	}
}