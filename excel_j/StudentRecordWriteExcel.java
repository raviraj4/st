import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

public class StudentRecordWriteExcel {
    public static void main(String[] args) throws IOException, WriteException {
        // Student data
        String[] headers = {"StudentName", "Subject1", "Subject2", "Subject3", "Total"};
        String[] sname = {"Carls", "James", "Paul", "Philip", "Smith", "Thomson", "Rhodey", "Stark", "Gary", "Anne Marie"};
        int[][] marks = {
            {50, 45, 60}, {55, 70, 45}, {67, 78, 89}, {90, 85, 90}, {40, 60, 65},
            {30, 45, 40}, {75, 80, 85}, {95, 92, 88}, {62, 55, 60}, {59, 61, 63}
        };

        // Creating Excel file
        File file = new File("student_records.xls");
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        workbook.createSheet("Student Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);

        // Creating the header row
        for (int c = 0; c < headers.length; c++) {
            Label label = new Label(c, 0, headers[c]);
            excelSheet.addCell(label);
        }

        // Filling student names and marks
        for (int r = 1; r <= sname.length; r++) {
            // Add student names
            Label nameLabel = new Label(0, r, sname[r - 1]);
            excelSheet.addCell(nameLabel);

            // Add marks for subjects
            int total = 0;
            for (int c = 1; c <= 3; c++) {
                int mark = marks[r - 1][c - 1]; // Marks for each subject
                total += mark;
                Number number = new Number(c, r, mark);
                excelSheet.addCell(number);
            }

            // Add total marks
            Number totalMarks = new Number(4, r, total);
            excelSheet.addCell(totalMarks);
        }

        // Writing to the workbook and closing it
        workbook.write();
        workbook.close();
        System.out.println("Excel file 'student_records.xls' created successfully.");
    }
}
