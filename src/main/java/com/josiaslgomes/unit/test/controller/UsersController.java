package com.josiaslgomes.unit.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josiaslgomes.unit.test.model.Users;
import com.josiaslgomes.unit.test.repository.UsersRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.josiaslgomes.unit.test.constant.Paths.USERS;
import static com.josiaslgomes.unit.test.constant.Paths.VERSION;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@Controller
@RestController
@RequestMapping(value = VERSION + USERS)
@Api(value = VERSION + USERS)
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @ApiOperation(value = "Get all users")
    @RequestMapping(value = "all", method = GET)
    @ResponseBody
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @ApiOperation(value = "Get users by ID")
    @RequestMapping(value = "{id}", method = GET)
    @ResponseBody
    public Users getUsersById(@PathVariable(value = "id") int id) {
        return usersRepository.findAllById(id);
    }

    @ApiOperation(value = "Delete users by ID")
    @RequestMapping(value = "{id}", method = DELETE)
    @ResponseBody
    public void removeUsersById(@PathVariable(value = "id") int id) {
        usersRepository.deleteById(id);
    }

    @ApiOperation(value = "Add user data")
    @RequestMapping(method = POST)
    @ResponseBody
    public void setUserData(@RequestBody Map<String, String> user) throws IOException {
        ObjectMapper om = new ObjectMapper();
        Users u = om.readValue(new ObjectMapper().writeValueAsString(user), Users.class);
        usersRepository.save(u);
    }
}