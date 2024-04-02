package com.example.service;

import com.example.binding.Course;
import com.example.repo.CourseRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private CourseRepository courseRepository;

    public void generateExcel(HttpServletResponse httpServletResponse) throws IOException {
        List<Course> courses = courseRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();;

        HSSFSheet sheet = workbook.createSheet("Available Courses");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Course Price");

        int dataStartIndex = 1;

        for (Course course : courses){

            HSSFRow dataRow = sheet.createRow(dataStartIndex);
            dataRow.createCell(0).setCellValue(course.getCid());
            dataRow.createCell(1).setCellValue(course.getName());
            dataRow.createCell(2).setCellValue(course.getPrice());

            dataStartIndex++;
        }

        ServletOutputStream outputStream = httpServletResponse.getOutputStream();

        workbook.write(outputStream); // writing workbook to output stream
        workbook.close();
        outputStream.close();
    }
}
