package core.my.test.service;

import dao.PupilDAO;
import entities.Pupil;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import service.implement.PupilServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by bohdan on 29.08.15.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestService {
    @Mock
    private PupilDAO pupilDao;
    @InjectMocks
    private PupilServiceImpl pupilService;
    final Long ID = 1l;
    private static Pupil testPupil1;
    private static Pupil testPupil2;

    @BeforeClass
    public static void setUp(){
        testPupil1 = new Pupil("Name1", "Last1", "Group1", "HI", "Address1");
        testPupil2 = new Pupil("Name2", "Last2", "Group2", "HI", "Address2");
    }

    @Test
    public void testGetAllPupils() {
        List<Pupil> pupilList = new ArrayList<Pupil>();
        pupilList.add(testPupil1);
        pupilList.add(testPupil2);
        when(pupilDao.getAllPupils()).thenReturn(pupilList);
        assertThat(pupilList, sameInstance(pupilService.getAllPupils()));
    }

    @Test
    public void testAddPupil(){
        when(pupilDao.addPupil(testPupil1)).thenReturn(ID);
        Long index = pupilService.addPupil(testPupil1);
        assertThat(ID, is(index));
    }

    @Test
    public void testGetPupilById(){
        when(pupilDao.getPupilById(ID)).thenReturn(testPupil1);
        assertThat(testPupil1, is(pupilService.getPupilById(ID)));
    }

    @Test
    public void testGetPupilByLevel(){
        List<Pupil> pupilList = new ArrayList<Pupil>();
        pupilList.add(testPupil1);
        pupilList.add(testPupil2);
        when(pupilDao.getPupilByLevel("HI")).thenReturn(pupilList);
        List<Pupil> actualList = pupilService.getPupilByLevel("HI");
        boolean checkResult = true;
        for (int i = 0 ; i < actualList.size(); i++){
            if (!actualList.get(i).getLevel().equals("HI")){
                checkResult = false;
            }
        }
        assertThat(checkResult, is(true));
    }

    @Test
    public void testDeletePupil(){
        pupilService.deletePupil(ID);
        verify(pupilDao).deletePupil(ID);
    }

    @Test
    public void testChangePupil(){
        pupilService.changePupil(ID, testPupil1);
        verify(pupilDao).changePupil(ID, testPupil1);
    }
}
