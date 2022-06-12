package com.this_project.controller;

//import com.this_project.config.Utils;
import com.this_project.config.Properties;
import com.this_project.config.Utils;
import com.this_project.dao.AttachmentDAO;
import com.this_project.dao.LocationDAO;
import com.this_project.dao.StatusDAO;
import com.this_project.dto.StatusDTO;
import com.this_project.dto.UserDTO;
import com.this_project.entity.Attachment;
import com.this_project.entity.Location;
import com.this_project.entity.Status;
import com.this_project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusDAO statusDAO;

    @Autowired
    private LocationDAO locationDAO;

    @Autowired
    private AttachmentDAO attachmentDAO;

    @GetMapping("/create")
    public ModelAndView create(Model model) {
        List<Location> locations = locationDAO.getLocationList();
        List<String> locationList = new ArrayList<>();

        for (Location location : locations) {
            locationList.add(location.getLocationName());
        }

        model.addAttribute("locationList", locationList);
        model.addAttribute("privacyList", Arrays.asList("Public", "Private"));
        model.addAttribute("statusDTO", new StatusDTO());

        return new ModelAndView("status/create", "model", model);
    }

    @PostMapping("/save")
    public String store(Model model, @ModelAttribute("statusDTO") StatusDTO statusDTO, @RequestParam("images") MultipartFile[] files) {

        Location location = locationDAO.getLocationByName(statusDTO.getLocation());
        List<Attachment> attachmentList = new ArrayList<>();

        for (MultipartFile file : files) {
            System.out.println("File name: " + file.getOriginalFilename());

            Attachment attachment = Utils.saveFile(file, Properties.STATUS_FOLDER);
            if (attachment != null) {
                attachmentList.add(attachment);
            }
        }

        attachmentDAO.insertBulks(attachmentList);

        Status status = new Status();
        status.setStatusTitle(statusDTO.getTitle());
        status.setStatusDescription(statusDTO.getDescription());
        status.setStatusPrivacy(statusDTO.getPrivacy());
        status.setLocation(location);
        status.setStatusAttachmentList(attachmentList);

        statusDAO.insert(status);

//        location.getStatusList().add(status);
        locationDAO.updateLocation(location);

        model.addAttribute("status", status);

        return "redirect:/status/show/" + status.getId();
    }

    @GetMapping(value = "/show/{id}")
    public String show(Model model, @PathVariable(value = "id") String id) {

        Status status = statusDAO.getById(Long.parseLong(id));

        model.addAttribute("status", status);

        return "status/show";
    }


    @GetMapping(value = "/update/{id}")
    public String update(Model model,  @PathVariable(value = "id") String id){

        Status status = statusDAO.getById(Long.parseLong(id));

//        List<Attachment> attachmentList = attachmentDAO.getAttachmentList();

        List<Location> locationList = locationDAO.getLocationList();
        List<String> stringLocationList = new ArrayList<>();

        for(Location location: locationList){
            stringLocationList.add(location.getLocationName());
        }
        model.addAttribute("stringLocationList", stringLocationList);
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setTitle(status.getStatusTitle());
        statusDTO.setDescription(status.getStatusDescription());
        statusDTO.setPrivacy(status.getStatusPrivacy());
        statusDTO.setLocation(status.getLocation().getLocationName());
//        statusDTO.setAttachmentPath(attachmentList);

        model.addAttribute("statusDTO", statusDTO);

        return "status/show";
    }

    @PostMapping(value = "/update")
    public String postUpdate(Model model, @ModelAttribute("statusDTO") StatusDTO statusDTO ){
        Location location = locationDAO.getLocationByName(statusDTO.getLocation());

//        It is creating a totally new user
        Status status = new Status();
        status.setStatusTitle(statusDTO.getTitle());
        status.setStatusDescription(statusDTO.getDescription());
        status.setStatusPrivacy(statusDTO.getPrivacy());
        status.setLocation(location);
//        status.setUser(userDTO.getUser().getUserName);
        statusDAO.update(status);

        location.getStatusList().add(status);
        locationDAO.updateLocation(location);

        return "redirect:/user/show/" + status.getId();
    }

    @GetMapping(value = "/delete/{id}")
    public String update(Model model, @PathVariable("id") Long id) {
        statusDAO.delete(id);
        return "status/list";
    }

    @GetMapping("/list")
    public String maintain(Model model) {

        List<Status> statusList = statusDAO.getAll();
        model.addAttribute("statusList", statusList);

        return "status/list";
    }
}
