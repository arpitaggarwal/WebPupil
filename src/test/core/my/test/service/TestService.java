package core.my.test.service;

import dao.PupilDAO;
import entities.Pupil;
import org.hamcrest.Matcher;
import org.junit.Before;
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

/*    @Before
    public void setUp(){
        List<Pupil> pupilList = pupilService.getAllPupils();
        for (int i = 0; i < pupilList.size(); i++) {
            pupilService.deletePupil(pupilList.get(i).getId());
        }
        Pupil pupil = new Pupil("Name", "Last", "Group", "HI", "Address");
        Long index = pupilService.addPupil(pupil);
        System.out.println(index);
    }
*/
    @Test
    public void testGetAllPupils() {
        List<Pupil> pupilList = new ArrayList<Pupil>();
        when(pupilDao.getAllPupils()).thenReturn(pupilList);
        assertSame(pupilList, pupilService.getAllPupils());
    }

    @Test
    public void testAddPupil(){
        Pupil pupil = new Pupil("Name", "Last", "Group", "HI", "Address");
        when(pupilDao.addPupil(pupil)).thenReturn(ID);
        Long index = pupilService.addPupil(pupil);
        verify(pupilDao, times(1)).addPupil(pupil);
        assertThat(ID, is(index));
    }
}
