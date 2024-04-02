package com.example.controller;

import com.example.service.ExcelService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @GetMapping("/excel")
    public void generateExcelReport(HttpServletResponse httpServletResponse) throws IOException {

        httpServletResponse.setContentType("application/octect-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attchment;filename=course.xls";

        httpServletResponse.setHeader(headerKey, headerValue);

        excelService.generateExcel(httpServletResponse);
    }
}
