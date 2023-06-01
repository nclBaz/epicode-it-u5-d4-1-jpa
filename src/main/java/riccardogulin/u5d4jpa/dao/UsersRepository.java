package riccardogulin.u5d4jpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import riccardogulin.u5d4jpa.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
	Optional<User> findByName(String name); // "SELECT u FROM User u WHERE name = :name"

	List<User> findByNameStartingWithIgnoreCase(String name);
	// "SELECT u FROM User u WHERE LOWER(u.name) LIKE CONCAT(LOWER(:name), '%')"

	List<User> findByNameAndSurname(String name, String surname); // "SELECT u FROM User u WHERE name = :name AND
																	// surname = :surname"
}
