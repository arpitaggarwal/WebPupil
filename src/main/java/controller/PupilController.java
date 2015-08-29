package controller;

import entities.Pupil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.implement.PupilServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bohdan on 24.08.15.
 */
@RestController
public class PupilController {

    @Autowired
    private PupilServiceImpl pupilService;

    public PupilController() {
    }

    public void setPupilService(PupilServiceImpl pupilService) {
        this.pupilService = pupilService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        System.out.println("hello!");
        return "hello";
    }

    @RequestMapping(value = {"/","/main"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/get-all-pupils", method = RequestMethod.GET)
    public List<Pupil> getAllPupils(){
        List<Pupil> pupilList = pupilService.getAllPupils();
        return pupilList;
    }

    @RequestMapping(value = "/change-pupil/{id}", method = RequestMethod.GET)
    public String changePupil(@PathVariable("id") Long id, @ModelAttribute Pupil pupils){
        pupils.setId(id);
        pupilService.changePupil(id, pupils);
        return "redirect:/main";
    }

    @RequestMapping(value = "/change/{id}", method = RequestMethod.GET)
    public String change(@PathVariable("id") Long id, Model model){
        Pupil pupil = pupilService.getPupilById(id);
        model.addAttribute("pupil", pupil);
        return "change";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePupil(@PathVariable("id") Long id){
        pupilService.deletePupil(id);
        return "redirect:/main";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(){
        return "add";
    }
    @RequestMapping(value = "/add-pupil", method = RequestMethod.POST)
    public String addPupil(@ModelAttribute Pupil pupil){
        pupilService.addPupil(pupil);
        return "index";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getIdPage(){
        return "get-id";
    }

    @RequestMapping(value = "/get-id", method = RequestMethod.POST)
    public String getId(Long id, Model model){
        Pupil pupil = pupilService.getPupilById(id);
        model.addAttribute("model", pupil);
        return "get-by-id";
    }
}