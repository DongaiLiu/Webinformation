package Liu.Dongai.wis.hw2.Assignment2;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment2Application {
	public static HashMap<Long,Student> hmStudent;

	public static void main(String[] args) throws InterruptedException {
		hmStudent = new HashMap<Long,Student>();
		
		Student one = new Student("Dongai Liu", "WIS");
		hmStudent.put(new Long(one.getId()), one);
		Thread.sleep(1);
		Student two = new Student("Xuan Zhou", "WIS");
		hmStudent.put(new Long(two.getId()), two);
		Thread.sleep(1);
		SpringApplication.run(Assignment2Application.class, args);
	}
}
