package com.rkb.jackson.transformation;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rkb.json.domain.Employee;

public class JacksonJSONToJavaObject {
	public static void main(String[] args) {
		JacksonJSONToJavaObject obj = new JacksonJSONToJavaObject();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		try {

			Employee employee = mapper.readValue(new File("c:\\workspaces\\jacksonemployee.json"), Employee.class);
			System.out.println("Single->"+employee);
			Reader reader = new FileReader("c:\\workspaces\\jacksonemployeelist.json");
			List<Employee> employeeList = mapper.readValue(reader, new TypeReference<List<Employee>>(){});

			employeeList.forEach(x -> System.out.println(x));

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
