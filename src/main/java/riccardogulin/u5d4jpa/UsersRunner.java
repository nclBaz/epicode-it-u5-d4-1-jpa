package riccardogulin.u5d4jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import riccardogulin.u5d4jpa.dao.UsersService;
import riccardogulin.u5d4jpa.entities.User;
import riccardogulin.u5d4jpa.exceptions.ItemNotFoundException;

@Component
public class UsersRunner implements CommandLineRunner {
	@Autowired
	UsersService usersService;

	@Override
	public void run(String... args) throws Exception {
		User aldo = new User();
		aldo.setEmail("aldo@baglio.it");
		aldo.setName("Aldo");
		aldo.setSurname("Baglio");

//		usersService.create(aldo);

		System.out.println("*********************** FIND ALL ***********************");
		usersService.find().forEach(user -> System.out.println(user));

		System.out.println("*********************** FIND BY ID ***********************");
		try {
			System.out.println(usersService.findById(2));

		} catch (ItemNotFoundException e) {
			System.out.println(e);
		}

	}

}
