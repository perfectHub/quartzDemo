package com.chen.POI;

import org.apache.poi.ss.formula.functions.Index;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.chen.POI
 * @Author chenh
 * @CreateDao 2016/12/1
 * @Description
 * @Version 1.0
 */
public class CalenderDemo {

    private static final String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    public static void main(String[] args) throws Throwable{

        //创建工作簿    // keep 100 rows in memory, exceeding rows will be flushed to disk
        SXSSFWorkbook workbook = new SXSSFWorkbook(100); //

        Map<String,CellStyle> styles = createStyle(workbook);

        Sheet sheet = workbook.createSheet();//创建表格

        Row title = sheet.createRow(0);//创建第一行
        for(int i = 0;i<7;i++){
            Cell cell = title.createCell(i);//创建表格
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));//合并单元格
            cell.setCellValue("课程表");//设置表格内容6
            cell.setCellStyle(styles.get("title"));//设置表格样式
        }

        Row row = sheet.createRow(1);
        for(int i = 0;i<days.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(days[i]);
            cell.setCellStyle(styles.get("weekend"));
        }
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop/aa.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.dispose();
    }

    private static Map<String,CellStyle> createStyle(Workbook wb){
        Map<String,CellStyle> styles = new HashMap<String,CellStyle>();

        short borderColor = IndexedColors.GREY_50_PERCENT.getIndex();

        CellStyle style ;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short)20);//设置字体
        titleFont.setColor(IndexedColors.BLUE_GREY.getIndex());//设置颜色
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//设置水平居中
        style.setVerticalAlignment(CellStyle.ALIGN_CENTER);//垂直居中

        style.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());//设置背景颜色
        style.setFillPattern(PatternFormatting.SOLID_FOREGROUND);//设置背景颜色时，必须设计模式

        style.setFont(titleFont);
        styles.put("title",style);

        //周末
        Font dayFont = wb.createFont();
        dayFont.setFontHeightInPoints((short)10);
        dayFont.setColor(IndexedColors.BLACK.getIndex());
        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

        style.setBorderBottom(IndexedColors.RED.getIndex());
        style.setBorderTop(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(IndexedColors.BLACK.getIndex());
        style.setBorderRight(IndexedColors.BLACK.getIndex());
        //style.set
//        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setFont(dayFont);
        styles.put("weekend",style);

        return styles;
    }
}
