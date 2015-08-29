package service.implement;

import dao.implement.PupilDAOImpl;
import entities.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PupilService;

import java.util.List;

/**
 * Created by bohdan on 13.08.15.
 *
 * Service
 */
@Service
public class PupilServiceImpl implements PupilService {

    @Autowired
    private PupilDAOImpl pupilDAO;

    public void setPupilDAO(PupilDAOImpl pupilDAO) {
        this.pupilDAO = pupilDAO;
    }

    /**
     * Get all pupils
     * @return all pupils from database
     * */
    public List<Pupil> getAllPupils() {
        List<Pupil> pupilList = pupilDAO.getAllPupils();
        return pupilList;
    }
    /**
     * Return pupil by id
     * @param id number record in database
     * @return pupil model
     * */
    public Pupil getPupilById(Long id) {
        Pupil pupil = pupilDAO.getPupilById(id);
        return pupil;
    }
    /**
     * Return pupil with level HI
     * @param level value level
     * @return list pupil with level HI
     * */
    public List<Pupil> getPupilByLevel(String level) {
        List<Pupil> pupilList = pupilDAO.getPupilByLevel(level);
        return pupilList;
    }
    /**
     * Edit exist pupil
     * @param id number pupil for edit
     * @param pupil new model pupil
     * */
    public void changePupil(Long id, Pupil pupil) {
        pupilDAO.changePupil(id, pupil);
    }
    /**
     * Delete pupil from database
     * @param id number pupil in database
     * */
    public void deletePupil(Long id) {
        pupilDAO.deletePupil(id);
    }
    /**
     * Add pupil in database
     * @param pupil model pupil
     * */
    public Long addPupil(Pupil pupil) {
        return pupilDAO.addPupil(pupil);
    }
}
