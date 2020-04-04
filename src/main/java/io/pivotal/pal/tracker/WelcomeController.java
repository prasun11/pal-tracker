package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	//@Value("${welcome.message}")
	public String message;
	
	
	public WelcomeController(@Value("${welcome.message}") String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
		System.out.println("massage-------"+message);
		//WELCOME_MESSAGE="hello";
	}
	
	

	@GetMapping("/")
    public String sayHello() {
        return message;
    }
}