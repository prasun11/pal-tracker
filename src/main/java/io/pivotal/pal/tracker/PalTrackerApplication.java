package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

//@ComponentScan(basePackages = "io.pivotal.pal.tracker")
@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
    @Bean
	public TimeEntryRepository timeEntryRepository() {
		// TODO Auto-generated method stub 
		 return new InMemoryTimeEntryRepository();
	}

	//@Override
	@Bean
	//@JsonInclude(JsonInclude.Include.NON_NULL)
	public ObjectMapper jsonObjectMapper() {
		// TODO Auto-generated method stub
		return Jackson2ObjectMapperBuilder.json()
	            .serializationInclusion(JsonInclude.Include.NON_NULL) // Don’t include null values
	            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) //ISODate
	            .modules(new JavaTimeModule())
	            .build();
	}
}