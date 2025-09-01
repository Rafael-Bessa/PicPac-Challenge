package bessa.morangon.rafael.picpay.repository;

import bessa.morangon.rafael.picpay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
