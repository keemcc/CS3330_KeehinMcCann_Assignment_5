package keehinmccann.assignment5.adoptme.model.filehandling;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

import keehinmccann.assignment5.adoptme.model.shelter.Shelter;

public class PetSaver {
	public static boolean saveShelter(Shelter<?> shelter) {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMDD_HHmmss");
		String timestamp = time.format(formatter);
		Gson gson = new Gson();
		
		try (FileWriter writer = new FileWriter("./src/main/savedshelters/" + timestamp + "_pets.json")) {
			gson.toJson(shelter, writer);
			System.out.println("Saving to " + new java.io.File("./src/main/savedshelters/").getAbsolutePath());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
