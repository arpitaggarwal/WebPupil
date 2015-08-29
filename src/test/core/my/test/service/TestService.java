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

}
