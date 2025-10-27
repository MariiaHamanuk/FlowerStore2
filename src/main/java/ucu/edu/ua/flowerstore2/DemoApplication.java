package ucu.edu.ua.flowerstore2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/list")
	// @RequestMapping(method = RequestMethod.GET, path = "/list")
	public List<String> getRandomUUID(){

		UUID.randomUUID();
		return Stream.generate(() -> UUID.randomUUID())
		.map(UUID::toString)
		.limit(10)
		.toList();
	}
}
