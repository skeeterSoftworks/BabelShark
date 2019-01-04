package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.Wisdom;

public interface WisdomRepository extends JpaRepository< Wisdom, Integer> {
	
	@Query(value="select * from wisdom order by rand() limit 1", nativeQuery=true)
	public Wisdom getRandomWisdom();

}
