package service;

import entities.Pupil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.implement.PupilServiceImpl;

import static org.junit.Assert.*;
import java.util.List;

/**
 * Created by bohdan on 14.08.15.
 */
public class TestPupilServiceDAOImpl {

    private static PupilService pupilService;

    @BeforeClass
    public static void setUpClass(){
        pupilService = new PupilServiceImpl();
        List<Pupil> pupilList = pupilService.getAllPupils();
        for (int i = 0; i < pupilList.size(); i++) {
            pupilService.deletePupil(pupilList.get(i).getId());
        }
    }
    @Before
    public void setUp(){
        Pupil pupil = new Pupil("name", "last", "group", "HI", "address");
        pupilService.addPupil(pupil);
    }
    @After
    public void downUp(){
        List<Pupil> pupilList = pupilService.getAllPupils();
        for (int i = 0; i < pupilList.size(); i++) {
            pupilService.deletePupil(pupilList.get(i).getId());
        }
    }
    @Test
    public void testAddPupil(){
        Pupil pupil = new Pupil("is name", "is last", "is group", "HI", "is address");
        pupilService.addPupil(pupil);
        List<Pupil> pupilList = pupilService.getAllPupils();
        Long indexPupil = pupilList.get(1).getId();
        Pupil actualPupil = pupilService.getPupilById(indexPupil);
        assertTrue(pupil.equals(actualPupil));
    }
    @Test
    public void testDeleteById(){
        List<Pupil> pupilList = pupilService.getAllPupils();
        Long indexPupil = pupilList.get(0).getId();
        pupilService.deletePupil(indexPupil);
        List<Pupil> pupilListUpdate = pupilService.getAllPupils();
        boolean checkId = false;
        for(Pupil pupil : pupilListUpdate){
            if(pupil.getId() == indexPupil){
                checkId = true;
                break;
            }
        }
        assertFalse(checkId);
    }
    @Test
    public void testGetAll(){
        List<Pupil> pupilList = pupilService.getAllPupils();
        assertTrue(pupilList.size() > 0);
    }
    @Test
    public void testGetPupilsByLevel(){
        List<Pupil> pupilList = pupilService.getPupilByLevel("HI");
        boolean checkLevel = false;
        for(Pupil pupil : pupilList){
            if (!pupil.getLevel().equals("HI")){
                checkLevel = true;
                break;
            }
        }
        assertFalse(checkLevel);
    }
    @Test
    public void testChangePupil(){
        Pupil updatePupil = new Pupil("Mark", "last", "group","HI", "address");
        List<Pupil> pupilList = pupilService.getAllPupils();
        Long indexPupilForChange = pupilList.get(0).getId();
        pupilService.changePupil(indexPupilForChange, updatePupil);
        Pupil pupil = pupilService.getPupilById(indexPupilForChange);
        assertTrue(updatePupil.equals(pupil));
    }
    @Test
    public void testGetPupilById(){
        List<Pupil> pupilList = pupilService.getAllPupils();
        Long index = pupilList.get(0).getId();
        Pupil pupil = pupilService.getPupilById(index);
        assertNotNull(pupil);
        assertEquals(index, pupil.getId());
    }
}
