package ca.sheridan.alzuhait.assignment2.repositories;
import ca.sheridan.alzuhait.assignment2.beans.PasswordRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PasswordRecordRepository extends JpaRepository<PasswordRecord, Long> {
    List<PasswordRecord> findByTitleContainingIgnoreCase(String title);
}
