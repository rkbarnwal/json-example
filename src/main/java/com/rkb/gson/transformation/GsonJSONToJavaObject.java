package com.rkb.gson.transformation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.rkb.json.domain.Employee;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class GsonJSONToJavaObject {
	public static void main(String[] args) {

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.setPrettyPrinting().disableHtmlEscaping().create();

		try (Reader reader = new FileReader("c:\\workspaces\\gsonemployee.json")) {

			Type type = new TypeToken<List<Employee>>() {}.getType();
			JsonParser parser = new JsonParser();
			JsonElement je = parser.parse(reader);
			List<Employee> employeeList = gson.fromJson(je, type);

			employeeList.forEach(x -> System.out.println(x));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
