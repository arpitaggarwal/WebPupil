package repositories;

import entities.Pupil;
import org.springframework.data.repository.CrudRepository;

public interface PupilRepositories extends CrudRepository<Pupil, Long> {
    long count();
}
