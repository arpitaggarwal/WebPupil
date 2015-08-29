package service;

import entities.Pupil;

import java.util.List;

/**
 * Created by bohdan on 13.08.15.
 * Interface class service that has the following methods
 * getAllPupils(), getPupilById(), getPupilByLevel(),
 * changePupil(), deletePupil(), addPupil()
 */
public interface PupilService {
    /**
     * Return all pupils
     * @return pupils list
     * */
    List<Pupil> getAllPupils();
    /**
     * Return pupil by id
     * @return pupil
     * */
    Pupil getPupilById(Long id);
    /**
     * Return pupil with level education equal level
     * @param level level education
     * @return list pupils
     * */
    List<Pupil> getPupilByLevel(String level);
    /**
     * Update information about pupil
     * @param id number record in database
     * @param pupil pupil for change
     * */
    void changePupil(Long id, Pupil pupil);
    /**
     * Delete pupil from database by id
     * @param id delete row with number equal id
     * */
    void deletePupil(Long id);
    /**
     * Add pupil in database
     * @param pupil new pupil
     * */
    Long addPupil(Pupil pupil);
}
