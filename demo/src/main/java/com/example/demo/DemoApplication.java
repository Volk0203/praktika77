import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
	Personimport javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
}
import javax.persistence.*;
@Entity
@Table(name = "locations")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String address;
}
import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Service;
		import java.util.List;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
}
import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Service;
		import java.util.List;

@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepository;
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}
}
import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.web.bind.annotation.*;
		import java.util.List;
@RestController
@RequestMapping("/persons")

public class PersonController {
	@Autowired
	private PersonService personService;
	@GetMapping
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	@PostMapping
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
}
import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.web.bind.annotation.*;
		import java.util.List;
@RestController
@RequestMapping("/locations")

public class LocationController {
	@Autowired
	private LocationService locationService;
	@GetMapping
	public List<Location> getAllLocations() {
		return locationService.getAllLocations();
	}
	@PostMapping
	public Location saveLocation(@RequestBody Location location) {
		return locationService.saveLocation(location);
	}
}
