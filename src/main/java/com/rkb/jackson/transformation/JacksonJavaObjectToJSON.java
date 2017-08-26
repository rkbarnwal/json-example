package com.rkb.jackson.transformation;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rkb.json.domain.Employee;

class JacksonJavaObjectToJSON {
	
	public static void main(String[] args) {
		JacksonJavaObjectToJSON obj = new JacksonJavaObjectToJSON();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		Employee employee = createDummyObject();
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee);
		employeeList.add(createDummyObject2());

		try {
			mapper.writeValue(new File("c:\\workspaces\\jacksonemployee.json"), employee);
			mapper.writeValue(new File("c:\\workspaces\\jacksonemployeelist.json"), employeeList);

			String jsonInString = mapper.writeValueAsString(employee);
			System.out.println(jsonInString);

			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Employee createDummyObject() {

		Employee employee = new Employee();

		employee.setName("Bill");
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
