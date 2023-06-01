package riccardogulin.u5d4jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import riccardogulin.u5d4jpa.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

}
