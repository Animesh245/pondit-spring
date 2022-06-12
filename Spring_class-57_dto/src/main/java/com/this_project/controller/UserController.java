package com.this_project.controller;



import com.this_project.config.Properties;
import com.this_project.config.Utils;
import com.this_project.dao.AttachmentDAO;
import com.this_project.dao.LocationDAO;
import com.this_project.dao.UserDAO;
import com.this_project.dto.UserDTO;
import com.this_project.entity.Attachment;
import com.this_project.entity.Location;
import com.this_project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private LocationDAO locationDAO;

    @Autowired
    private AttachmentDAO attachmentDAO;

    @GetMapping(value = "/create")
    public ModelAndView createUser(Model model){

//      retrieving location list from database
        List<Location> locationList = locationDAO.getLocationList();
        List<String> stringLocationList = new ArrayList<>();

        for (Location location: locationList){
            stringLocationList.add(location.getLocationName());
        }


        model.addAttribute("stringLocationList", stringLocationList);
        model.addAttribute("userDTO",new UserDTO());
        return new ModelAndView("/user/create","model", model);
    }

    @PostMapping(value = "/save")
    public String saveUser(Model model, @ModelAttribute("userDTO") UserDTO userDTO , @RequestParam("image") MultipartFile file) throws IOException{
        Location location = locationDAO.getLocationByName(userDTO.getLocation());

        Attachment attachment = Utils.saveFile(file, Properties.USER_FOLDER);

//        attachmentDAO.insert(attachment);

        User user = new User();
        user.setUserName(userDTO.getName());
        user.setUserEmail(userDTO.getEmail());
        user.setUserPassword(userDTO.getPassword());
        user.setLocation(location);
        user.setAttachment(attachment);
        userDAO.saveUser(user);

        location.getUserList().add(user);
        locationDAO.updateLocation(location);

        model.addAttribute("user", user);

        return "redirect:/user/show/" + user.getId();

    }

    @GetMapping(value = "/show/{id}")
    public String show(Model model, @PathVariable(value = "id") String id) {

        User user = userDAO.getUserById(Long.parseLong(id));
        model.addAttribute("user", user);

        return "user/show";
    }

    @GetMapping( value = "/list")
    public String allUsers(Model model) {

        List<User> userList = userDAO.getUserList();

        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping(value = "/update/{id}")
    public String update(Model model,  @PathVariable(value = "id") String id){

        User user = userDAO.getUserById(Long.parseLong(id));

        List<Location> locationList = locationDAO.getLocationList();
        List<String> stringLocationList = new ArrayList<>();

        for(Location location: locationList){
            stringLocationList.add(location.getLocationName());
        }
        model.addAttribute("stringLocationList", stringLocationList);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getUserName());
        userDTO.setEmail(user.getUserEmail());
        userDTO.setPassword(user.getUserPassword());
        userDTO.setLocation(user.getLocation().getLocationName());

        model.addAttribute("userDTO", userDTO);

        return "user/update";
    }

    @PostMapping(value = "/update")
    public String postUpdate(Model model, @ModelAttribute("userDTO") UserDTO userDTO ){
        Location location = locationDAO.getLocationByName(userDTO.getLocation());

//        It is creating a totally new user
        Long id = userDTO.getId();
        User user = userDAO.getUserById(id);
        user.setUserName(userDTO.getName());
        user.setUserEmail(userDTO.getEmail());
        user.setUserPassword(userDTO.getPassword());
        user.setLocation(location);
        userDAO.updateUser(user);


        location.getUserList().add(user);
        locationDAO.updateLocation(location);

        return "redirect:/user/show/" + user.getId();
//        return "user/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") Long id) {
        userDAO.deleteUser(id);
        return "user/list";
    }
}
