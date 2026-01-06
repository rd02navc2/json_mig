package com.example.demo;

import com.example.demo.service.XsdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;

@Component
public class XsdGeneratorTest {

	 public static void main(String[] args) {
	        try {
	            // 初始化 Service
	            XsdGeneratorService xsdGeneratorService = new XsdGeneratorService();

	            // JSON Mapping 檔案
	            File jsonFile = new File("src/main/resources/N5107.json");
	            FileInputStream fis = new FileInputStream(jsonFile);

	            // 輸出 XSD 檔案
	            File outputXsd = new File("src/main/resources/Response.xsd");

	            // 根元素名稱
	            String rootEleName = "Response";
	            String msgName = "N5107";

	            // 生成 XSD
	            xsdGeneratorService.generateXsdFromJson(fis, outputXsd, rootEleName, msgName);

	            System.out.println("XSD 生成完成: " + outputXsd.getAbsolutePath());

	        } catch (Exception e) {
	            e.printStackTrace();
	            System.err.println("XSD 生成失敗！");
	        }
	    }
}
