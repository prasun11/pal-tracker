package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	//@Value("${welcome.message}")
	public String massage;
	
	
	public WelcomeController(@Value("${welcome.message}") String massage) {
		// TODO Auto-generated constructor stub
		this.massage=massage;
		System.out.println("massage-------"+massage);
		//WELCOME_MESSAGE="hello";
	}
	public WelcomeController() {
		
	}
	

	@GetMapping("/")
    public String sayHello() {
        return "hello";
    }
}