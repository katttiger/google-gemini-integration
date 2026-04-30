package se.iths.cecilia.googlegeminiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.cecilia.googlegeminiintegration.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}
