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

	public User findByName(String name) throws ItemNotFoundException {
		return usersRepo.findByName(name).orElseThrow(() -> new ItemNotFoundException());
	}

	public List<User> findByNameIgnoreCase(String name) {
		return usersRepo.findByNameStartingWithIgnoreCase(name);
	}

	public void findByIdAndUpdate(int id, User u) throws ItemNotFoundException {

		User found = this.findById(id);
		found.setId(id);
		found.setName(u.getName());
		found.setSurname(u.getSurname());
		found.setEmail(u.getEmail());
		usersRepo.save(found);
	}

	public void findByIdAndDelete(int id) throws ItemNotFoundException {
		User found = this.findById(id);
		usersRepo.delete(found);
	}

	public long count() {
		return usersRepo.count();
	}

}
