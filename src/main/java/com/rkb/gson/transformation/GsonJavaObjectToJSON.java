package com.rkb.gson.transformation;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rkb.json.domain.Employee;

public class GsonJavaObjectToJSON {

	public static void main(String[] args) {

		Employee employee = createDummyObject();
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee);
		employeeList.add(createDummyObject2());

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.setPrettyPrinting().disableHtmlEscaping().create();

		try (FileWriter writer = new FileWriter("c:\\workspaces\\gsonemployee.json")) {
			gson.toJson(employeeList, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Employee createDummyObject() {

		Employee employee = new Employee();

		employee.setName("Shyam");
		employee.setAge(35);
		employee.setPosition("Founder");
		employee.setSalary(new BigDecimal("20000"));

		List<String> skills = new ArrayList<>();
		skills.add("java");
		skills.add("python");
		skills.add("shell");

		employee.setSkills(skills);

		return employee;

	}

	private static Employee createDummyObject2() {

		Employee employee = new Employee();

		employee.setName("Ranjeet");
		employee.setAge(38);
		employee.setPosition("Founder");
		employee.setSalary(new BigDecimal("15000"));

		List<String> skills = new ArrayList<>();
		skills.add("java");
		skills.add("oracle");
		skills.add("react");

		employee.setSkills(skills);

		return employee;

	}
}
