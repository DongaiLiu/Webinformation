package Liu.Dongai.wis.hw2.Assignment2;
import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value="/rest/student")
class StudentService {
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Student addStudent(@RequestParam(value="name") String name,
			@RequestParam(value="subject",defaultValue="unknown") String subject) {
		Student student = new Student(name, subject);
		Assignment2Application.hmStudent.put(new Long(student.getId()), student);
		return student;		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) throws Exception{
		if(Assignment2Application.hmStudent.containsKey(new Long(student.getId()))) {
			Assignment2Application.hmStudent.put(new Long(student.getId()), student);
		}else {
			throw new Exception("Student "+student.getId()+" does not exists");
		}
		return student;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public Student deleteStudent(@PathVariable long id) throws Exception{
		Student student;
		if (Assignment2Application.hmStudent.containsKey(new Long(id))) {
			student = Assignment2Application.hmStudent.get(new Long(id));
			Assignment2Application.hmStudent.remove(new Long(id));
		}
		else {
			throw new Exception("Student "+id+"does not exists");
		}
		return student;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable long id) {
		return Assignment2Application.hmStudent.get(new Long(id));
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public HashMap<Long,Student> getAllStudents(){
		return Assignment2Application.hmStudent;
	}
	
}


















