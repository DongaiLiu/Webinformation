package Liu.Dongai.wis.hw2_2.Assignment2_2;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
	private long id;
	private String name;
	private String subject;
	public Student() {
	}
	public Student(String name, String subject){
		this.id = (new Date()).getTime();
		this.name = name;
		this.subject = subject;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student {id=" + id + ", name= \'" + name + "\', subject= \'" + subject + "}";
	}	
}
@RestController
@RequestMapping(value="/rest/school")
class SchoolService{
	@RequestMapping(value="/students/{id}")
	public Student getStudent(@PathVariable String id) {
		String URL = "http://localhost:8080/rest/student/"+id;
		RestTemplate template = new RestTemplate();
		
		Student student = template.getForObject(URL, Student.class);
		
		return student;	
	}
}


















