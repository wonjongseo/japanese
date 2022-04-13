import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelParser {
    public static Japanese japanese_level1 = getExcelFile(1);
    public static Japanese japanese_level2 = getExcelFile(2);
    public static Japanese japanese_level3 = getExcelFile(3);
    public static Japanese japanese_level4 = getExcelFile(4);
    public static Japanese japanese_level5 = getExcelFile(5);


    public static Japanese getExcelFile (int level) {

        Japanese japanese = new Japanese();


        try {
            FileInputStream file = new FileInputStream(Main.path + "/japan_level" + String.valueOf(level) + ".xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            int rowindex = 0;


            XSSFSheet sheet=workbook.getSheetAt(0); //행의 수
             int rows=sheet.getPhysicalNumberOfRows();
            for(rowindex=0 ; rowindex<rows; rowindex++) {
                //행을읽는다
                XSSFRow row = sheet.getRow(rowindex);

                XSSFCell rowKanji = row.getCell(0);
                XSSFCell rowHiragana = row.getCell(1);
                XSSFCell rowMeans = row.getCell(2);

                String strKanji = rowKanji.getStringCellValue() + "";
                String strHiragana = rowHiragana.getStringCellValue() + "";
                String strMeans = rowMeans.getStringCellValue() + "";

                japanese.getKanji().add(strKanji);
                japanese.getHiragana().add(strHiragana);
                japanese.getMeans().add(strMeans);
            }
            japanese.setTotalCount(rows);


        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(Main.mainFrame, e.getMessage());

        }
        return japanese;
    }
}

