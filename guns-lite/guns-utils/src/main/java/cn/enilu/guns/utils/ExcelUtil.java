package cn.enilu.guns.utils;

import org.apache.poi.hssf.usermodel.*;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUtil {
    private static HSSFSheet initExcel(HSSFWorkbook workbook, String titles[], String title) {
        //第二步，在workbook中创建一个sheet对应excel中的sheet
        HSSFSheet sheet = workbook.createSheet(DateUtil.formatDate(new Date(), "yyyy年MM月dd日 HH时mm分ss秒生成"));
        HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，设置表头
        HSSFCell cell = row.createCell(0);
        for(int i = 0; i < titles.length; i ++) {
            cell.setCellValue(titles[i]);
            cell = row.createCell(i+1);
        }
        return sheet;
    }


    public static void save(HSSFSheet sheet, List<Object> objectList, int num) {
        //第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
        HSSFRow row1 = sheet.createRow(num);
        //创建单元格设值
        for(int i = 0; i < objectList.size(); i ++) {
            row1.createCell(i).setCellValue(objectList.get(i) == null ? "":objectList.get(i).toString());
        }
    }

    /**
     *
     * @param titles 标题
     * @param datas 每一行数据
     * @throws Exception
     */
    public static void generateXls(String titles[], List<List<Object>> datas, HttpServletResponse response, String title, String fileName) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        //Date date = list.get(0).getShipmentTime();
        HSSFSheet sheet = initExcel(workbook, titles, title);

        int row = 1;
        for(List<Object> objectList:datas) {
            save(sheet, objectList, row);
            row ++;
        }
        response.addHeader("Content-Disposition", "inline;filename=" + fileName + ".xls");
        response.setContentType("application/msexcel");
        workbook.write(response.getOutputStream());
    }

    public static void main(String[] args) {
        String titles [] = {"列1","列2","列3","列4"};
        List<List<Object>> datas = new ArrayList<>();
        List<Object> rowDate1 = new ArrayList<>();
        rowDate1.add(0, "1");
        rowDate1.add(1, "2");
        rowDate1.add(2, "3");
        rowDate1.add(3, "4");
        List<Object> rowDate2 = new ArrayList<>();
        rowDate2.add(0, "5");
        rowDate2.add(1, "6");
        rowDate2.add(2, "7");
        rowDate2.add(3, "8");
        datas.add(rowDate1);
        datas.add(rowDate2);
        try {
           // generateXls(titles,datas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
