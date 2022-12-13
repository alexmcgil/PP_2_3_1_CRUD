package su.alexmcgil.crud_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.alexmcgil.crud_boot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
