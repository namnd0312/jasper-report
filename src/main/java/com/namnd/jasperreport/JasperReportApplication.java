package com.namnd.jasperreport;

import com.namnd.jasperreport.report.Student;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class JasperReportApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JasperReportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try{
			String filePath = "E:\\CODE\\jasper-report\\src\\main\\resources\\ThirdReport.jrxml";


			Student student1 = new Student(1L, "namnd", 12, "Ha Noi", "namnd@gmail.com");
			Student student2 = new Student(2L, "namnd2", 12, "Ha Noi", "namnd@gmail.com");
			Student student3 = new Student(3L, "namnd3", 12, "Ha Noi", "namnd@gmail.com");

			List<Student> students = new ArrayList<>();

			for (int i = 0; i < 100; i++) {
				students.add(student1);
				students.add(student2);
				students.add(student3);
			}


			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);
			Map<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("reportTitle", "Production Report " +  new Date());
			parameter.put("copyRight", "@Copy right by Namnd");
			parameter.put("tableData", dataSource);

			JasperReport report = JasperCompileManager.compileReport(filePath);

			JasperPrint print = JasperFillManager.fillReport(report, parameter, new JREmptyDataSource());

			String destination = "E:\\CODE\\jasper-report\\src\\main\\resources\\reports\\ThirdReport.pdf";
			JasperExportManager.exportReportToPdfFile(print, destination);

			System.out.println("Report created");
		}catch (Exception e){
			System.out.println("Report create has error is: " + e.getMessage());
		}

	}
}
