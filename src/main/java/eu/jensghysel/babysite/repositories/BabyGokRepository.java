package eu.jensghysel.babysite.repositories;

import eu.jensghysel.babysite.models.BabyGok;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BabyGokRepository extends JpaRepository<BabyGok, Long> {
    List<BabyGok> findAllByEmail(String email);
}
