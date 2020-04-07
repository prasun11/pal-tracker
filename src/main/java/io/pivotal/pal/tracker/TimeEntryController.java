package io.pivotal.pal.tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Sets the "root" for all TimeEntryController end-points
@RequestMapping("/time-entries")
public class TimeEntryController {
	
    
	private TimeEntryRepository timeEntriesRepo;

    public TimeEntryController(TimeEntryRepository timeEntriesRepo) {
        this.timeEntriesRepo = timeEntriesRepo;
    }

    // Create
    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = timeEntriesRepo.create(timeEntry);

        // Returning a ResponseEntity allows us to control the resulting HTTP status code
        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    // Retrieve a single record
    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        TimeEntry timeEntry = timeEntriesRepo.find(id);
        if (timeEntry != null) {
            return new ResponseEntity<>(timeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	 @GetMapping
	 public ResponseEntity<List<TimeEntry>> list() {
	        return new ResponseEntity<>(timeEntriesRepo.list(), HttpStatus.OK);
	    }
	 

	 // Update
	 @PutMapping("{id}")
	 public ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {
	        TimeEntry updatedTimeEntry = timeEntriesRepo.update(id, timeEntry);
	        if (updatedTimeEntry != null) {
	            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Delete
	  @DeleteMapping("{id}")
	  public ResponseEntity<TimeEntry> delete(@PathVariable Long id) {
	        timeEntriesRepo.delete(id);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
