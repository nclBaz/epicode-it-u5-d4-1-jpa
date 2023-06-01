package riccardogulin.u5d4jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import riccardogulin.u5d4jpa.entities.User;
import riccardogulin.u5d4jpa.exceptions.ItemNotFoundException;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepo;

	public void create(User u) {
		// ..logica addizionale custom..
		usersRepo.save(u);
	}

	public List<User> find() {
		return usersRepo.findAll();
	}

	public User findById(int id) throws ItemNotFoundException {
//		Optional<User> found = usersRepo.findById(id);
//		if (found.isPresent()) {
//			return found.get();
//		} else {
//			throw new ItemNotFoundException(id);
//		}

		return usersRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}
}
