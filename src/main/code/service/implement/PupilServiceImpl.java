package service.implement;

import entities.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PupilRepositories;
import service.PupilService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bohdan on 13.08.15.
 *
 * Service
 */
@Service
public class PupilServiceImpl implements PupilService {

    @Autowired
    private PupilRepositories pupilRepositories;

    public PupilServiceImpl() {
    }

    public void setPupilRepositories(PupilRepositories pupilRepositories) {
        this.pupilRepositories = pupilRepositories;
    }

    public List<Pupil> getAllPupils() {

        return null;
    }

    public Pupil getPupilById(Long id) {
        return null;
    }

    public List<Pupil> getPupilByLevel(String level) {
        return null;
    }

    public void changePupil(Long id, Pupil pupil) {

    }

    public void deletePupil(Long id) {

    }

    public Long addPupil(Pupil pupil) {
        Long index = pupilRepositories.count();
        System.out.println(index);
        return index;
    }
}
