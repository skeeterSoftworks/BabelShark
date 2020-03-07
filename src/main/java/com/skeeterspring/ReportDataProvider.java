package com.skeeterspring;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import models.Payment;
import models.Student;
import repositories.ApplicantFactory;
import repositories.MockGradeFactory;

@Service
public class ReportDataProvider {

	public Map<String, Object> getReportParameters(Student stu) {

		Map<String, Object> params = new HashMap<>();
		InputStream headerStream = this.getClass().getClassLoader().getResourceAsStream("static/reports/header.png");
		InputStream watermarkStream = this.getClass().getClassLoader()
				.getResourceAsStream("static/reports/watermark.png");

		params.put("studentName", stu.getName());
		params.put("gradesData",  new ArrayList<>(stu.getGrades()));
		//params.put("paymentsData",  new ArrayList<>(stu.getPayments()));
		params.put("reportDate", new Date());
		params.put("watermark", watermarkStream);
		params.put("header", headerStream);
		
		params.put("isPaymentsTableRendered", stu.getPayments().size()>0);
		params.put("isGradesTableRendered", stu.getGrades().size()>0);

		return params;
	}

}
