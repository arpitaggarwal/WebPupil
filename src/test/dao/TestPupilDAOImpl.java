package dao;

import dao.implement.PupilDAOImpl;
import entities.Pupil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by bohdan on 14.08.15.
 */
public class TestPupilDAOImpl {

    @Mock
    private static PupilDAOImpl pupilDAO;

    @BeforeClass
    public static void setUpClass(){
        List<Pupil> pupilList = pupilDAO.getAllPupils();
        for (int i = 0; i < pupilList.size(); i++) {
            pupilDAO.deletePupil(pupilList.get(i).getId());
        }
    }
    @Before
    public void setUp(){
        Pupil pupil = new Pupil("name", "last", "group", "HI", "address");
        pupilDAO.addPupil(pupil);
    }
    @After
    public void downUp(){
        List<Pupil> pupilList = pupilDAO.getAllPupils();
        for (int i = 0; i < pupilList.size(); i++) {
            pupilDAO.deletePupil(pupilList.get(i).getId());
        }
    }
    @Test
    public void testGetAllPupils(){
        List<Pupil> pupilList = pupilDAO.getAllPupils();
        assertThat(pupilList.size(), not(0));
    }
    @Test
    public void testGetPupilById(){
        List<Pupil> pupilList = pupilDAO.getAllPupils();
        Long index = pupilList.get(0).getId();
        Pupil pupil = pupilDAO.getPupilById(index);
        assertThat(index, is(pupil.getId()));
    }
    @Test
    public void testGetPupilByLevel(){
        List<Pupil> pupilList = pupilDAO.getPupilByLevel("HI");
        boolean checkLevel = true;
        for(Pupil pupil : pupilList){
            if (!pupil.getLevel().equals("HI")){
                checkLevel = false;
                break;
            }
        }
        assertThat(checkLevel, is(true));
    }
    @Test
    public void testChangePupil(){
        Pupil updatePupil = new Pupil("Marks", "last", "group","HI", "address");
        List<Pupil> pupilList = pupilDAO.getAllPupils();
        Long indexPupilForChange = pupilList.get(0).getId();
        pupilDAO.changePupil(indexPupilForChange, updatePupil);
        Pupil pupil = pupilDAO.getPupilById(indexPupilForChange);
        assertThat(updatePupil, is(pupil));
    }
    @Test
    public void testDeletePupilById(){
        List<Pupil> pupilList = pupilDAO.getAllPupils();
        Long indexPupilForDelete = pupilList.get(0).getId();
        pupilDAO.deletePupil(indexPupilForDelete);
        List<Pupil> pupilListUpdate = pupilDAO.getAllPupils();
        boolean checkId = false;
        for(Pupil pupil : pupilListUpdate){
            if(pupil.getId() == indexPupilForDelete){
                checkId = true;
                break;
            }
        }
        assertThat(checkId, is(false));
    }
}
