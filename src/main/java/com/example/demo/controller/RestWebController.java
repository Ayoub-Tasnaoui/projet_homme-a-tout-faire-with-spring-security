package com.example.demo.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebController {
	@GetMapping(value = "/api/images")
	public ResponseEntity<InputStreamResource> getImage(@RequestParam("background") String background)
			throws IOException {

		ClassPathResource imgFile;

		switch (background) {
		case "electricite":
			imgFile = new ClassPathResource("static/images/electricite.png");
			break;
		case "maconnerie":
			imgFile = new ClassPathResource("static/images/maconnerie.png");
			break;
		case "menuisier":
			imgFile = new ClassPathResource("static/images/menuisier.png");
			break;
		case "montage":
			imgFile = new ClassPathResource("static/images/montage.png");
			break;
		case "peinture.png":
			imgFile = new ClassPathResource("static/images/peinture.png.png");
			break;
		case "plombie":
			imgFile = new ClassPathResource("static/images/plombie.png");
			break;
		case "logo":
			imgFile = new ClassPathResource("static/images/logo.png");
			break;
		default:
			imgFile = new ClassPathResource("static/images/brico.png");
			break;

		}

		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
				.body(new InputStreamResource(imgFile.getInputStream()));
	}
}
