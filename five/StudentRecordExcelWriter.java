package excelwrite;

import jxl.*;
import jxl.write.*;
import jxl.write.Number;
import java.io.*;
import java.util.Locale;
import java.util.Random;

public class StudentRecordExcelWriter {
    public static void main(String[] args) {
        try {
            String[] header = {"StudentName", "Subject1", "Subject2", "Subject3", "Total"};
            String[] sname = {"Carls", "James", "Paul", "Philip", "Smith", "Thomson", "Rhodey", "Stark", "Gary", "Anne Marie"};
            
            File file = new File("student_records.xls");
            WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setLocale(new Locale("en", "EN"));
            
            WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
            WritableSheet sheet = workbook.createSheet("Student Records", 0);
            
            // Write header
            for (int c = 0; c < header.length; c++) {
                Label label = new Label(c, 0, header[c]);
                sheet.addCell(label);
            }
            
            Random random = new Random();
            
            // Write student data
            for (int r = 1; r <= sname.length; r++) {
                // Student name
                sheet.addCell(new Label(0, r, sname[r-1]));
                
                int total = 0;
                // Subject marks
                for (int c = 1; c <= 3; c++) {
                    int mark = random.nextInt(51) + 50; // Random mark between 50 and 100
                    sheet.addCell(new Number(c, r, mark));
                    total += mark;
                }
                
                // Total
                sheet.addCell(new Number(4, r, total));
            }
            
            workbook.write();
            workbook.close();
            
            System.out.println("Excel file 'student_records.xls' has been created successfully!");
        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }
    }
}