package com.example.MyImageDiary10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// Dotenv dotenv = Dotenv.load();
		// System.setProperty("CLOUDINARY_CLOUD_NAME",
		// dotenv.get("CLOUDINARY_CLOUD_NAME"));
		// System.setProperty("CLOUDINARY_API_KEY", dotenv.get("CLOUDINARY_API_KEY"));
		// System.setProperty("CLOUDINARY_SECRET_KEY",
		// dotenv.get("CLOUDINARY_SECRET_KEY"));
		// System.setProperty("MONGODB_URI", dotenv.get("MONGODB_URI"));
		SpringApplication.run(Application.class, args);

	}

}
