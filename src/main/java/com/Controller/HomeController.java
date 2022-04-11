package com.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showForm() throws IOException, InterruptedException {
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://ott-details.p.rapidapi.com/search?title=Endgame&page=1"))
//				.header("X-RapidAPI-Host", "ott-details.p.rapidapi.com")
//				.header("X-RapidAPI-Key", "e2981baa2cmshba895d5e9e3cecap1ad5a2jsnb18f8649ccfc")
//				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
//		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println(response.body());

		return "city";
	}

	@RequestMapping("/processForm")
	public String processingForm(@RequestParam("city") String city, @RequestParam("country") String country,
			Model model) throws IOException, InterruptedException {

		String url = "https://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=08afb7620310151eb868f4e7a1f6e580";
		String url1 = "https://api.openweathermap.org/data/2.5/weather?q=" + city
				+ "&appid=08afb7620310151eb868f4e7a1f6e580";
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url1)).build();
		HttpClient client = HttpClient.newBuilder().build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());
		System.out.println(response.statusCode());

		try {

			ObjectMapper mapper = new ObjectMapper();
			Weather weather = mapper.readValue(response.body(), Weather.class);
			model.addAttribute("weather", weather);
			System.out.println(weather);

		} catch (Exception exc) {
			exc.printStackTrace();
		}

		//model.addAttribute("response", response.body());
		model.addAttribute("city", city);
		model.addAttribute("country", country);
		return "weather";
	}
}
