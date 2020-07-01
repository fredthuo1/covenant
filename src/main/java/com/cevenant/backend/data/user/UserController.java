package com.cevenant.backend.data.user;

import com.cevenant.backend.data.email.Email;
import com.cevenant.backend.data.email.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin( origins = "http://localhost:3000" )
public class UserController {
    @Autowired
    final private UserRepository userRepository;

    @Autowired
    final private UserService userService;

    @Autowired
    final private EmailController emailController;


    public UserController(UserRepository userRepository, UserService userService, EmailController emailController ) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.emailController = emailController;
    }

    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/getUser", method = RequestMethod.GET )
    @ResponseBody
    public User getUser( @RequestParam String email ) {
        ArrayList< User > users = ( ArrayList< User > ) userService.findAll();
        User user = new User();
        for ( int i = 0; i < users.size(); i++ ) {
            if ( users.get(i).getEmail().toLowerCase().equals( email.toLowerCase() ) ) {
                user = users.get( i );
            } else {
                user = null;
            }
        }
        System.out.println( user.toString() );
        return user;
    }

    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/confirmUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public void confirmUser( @RequestParam String password, @RequestParam String email ) {
        User user = getUser( email );
        user.setPassword( password );
        userService.save( user );
    }


    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/signUp", method = { RequestMethod.POST }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public User addUser(@RequestBody User user ) {
        Email email = new Email();
        boolean exists = false;

        ArrayList< User > users = (ArrayList<User>) userService.findAll();
        for ( int i = 0; i < users.size(); i++ ) {
            if ( users.get( i ).getEmail().toLowerCase().equals( user.getEmail().toLowerCase() ) ) {
                exists = true;
            }
        }

        if ( exists == false ) {
            email.setSender( "Fredthuo1@gmail.com" );
            email.setRecipient( user.getEmail() );
            email.setSubject( "Account Confirmation" );
            email.setMessage( "Hello " + user.getFirstName() + " " + user.getLastName() + " ,\n\n" +
                    "Thank you for signing up with us! \n" +
                    "Click the link below to confirm registration: \n" +
                    "http://localhost:3000/SetPassword/?email=" +
                    user.getEmail() +
                    " \n" +
                    "Sincerely,\n" +
                    "Fredrick Muikia " );
           // emailController.sendEmail( email );
            userService.save( user );
            return user;
        } else {
            System.out.println( "User already exists!" );
            return null;
        }
    }
}
