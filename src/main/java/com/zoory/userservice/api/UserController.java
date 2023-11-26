package com.zoory.userservice.api;

import com.zoory.userservice.dto.UserRequestDTO;
import com.zoory.userservice.entity.User;
import com.zoory.userservice.service.UserService;
import com.zoory.userservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addUser(
            @RequestPart String userName,
            @RequestPart String nicNo,
            @RequestPart byte[] nicImg,
            @RequestPart byte[] paymentSlipImg,
            @RequestPart String userAge,
            @RequestPart String gender,
            @RequestPart String email,
            @RequestPart String contactNo,
            @RequestPart String address,
            @RequestPart String password
            ){
            int age=Integer.parseInt(userAge);
        UserRequestDTO userRequestDTO=new UserRequestDTO(userName,nicNo,nicImg,paymentSlipImg,age,gender,email,contactNo
        ,address,password);
        userService.saveUser(userRequestDTO);
        return new ResponseUtil(200,"User Saved !!",userRequestDTO);
    }

    @GetMapping
    public ResponseUtil getAllUsers(){
        return new ResponseUtil(200,"Get All Users ",
                userService.getAllUsers());
    }
    @PutMapping("/{id}")
    public ResponseUtil updateUser(@PathVariable String id,
                                   @RequestPart String userName,
                                   @RequestPart String nicNo,
                                   @RequestPart byte[] nicImg,
                                   @RequestPart byte[] paymentSlipImg,
                                   @RequestPart String userAge,
                                   @RequestPart String gender,
                                   @RequestPart String email,
                                   @RequestPart String contactNo,
                                   @RequestPart String address,
                                   @RequestPart String password  ){
        int age=Integer.parseInt(userAge);
        UserRequestDTO userRequestDTO=new UserRequestDTO(userName,nicNo,nicImg,paymentSlipImg,age,gender,email,contactNo
                ,address,password);
        User user=userService.updateUser(id, userRequestDTO);
        return new ResponseUtil(200,"Update Success",user);

    }
    @DeleteMapping("/{id}")
    public ResponseUtil deleteUser(@PathVariable String id){
        User user = userService.deleteUser(id);
        return new ResponseUtil(200,"delete Success",user);

    }
}
