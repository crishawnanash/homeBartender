
package org.launchcode.homeBartender.controllers;

import org.apache.catalina.User;
import org.launchcode.homeBartender.Repositories.CocktailRepository;
import org.launchcode.homeBartender.Repositories.LoginRepository;
import org.launchcode.homeBartender.Repositories.RecipeRepository;
import org.launchcode.homeBartender.Repositories.UserRepository;
import org.launchcode.homeBartender.models.FormData;
import org.launchcode.homeBartender.models.Login;
import org.launchcode.homeBartender.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;


@Controller
public class signUpController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;

    @RequestMapping("/form")
    public String main(Model model) {
        model.addAttribute("formData", new FormData());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid @ModelAttribute FormData formData, BindingResult bindingResult, Model model) {



        Users users = new Users();

        Login login = new Login();

        String p1 = formData.getPassword();
        String p2 = formData.getConfirm_password();
        LocalDate currentDate = LocalDate.now();
        LocalDate givenDate = formData.getBirthdate();

        if(!p1.equals(p2)){
            bindingResult.rejectValue("confirm_password", "error.confirm_password", "Passwords do not match. Please enter matching passwords");
        }

        if (givenDate.isAfter(currentDate)) {
            bindingResult.rejectValue("birthdate", "error.birthdate", "It's impossible to be born in the future. Enter a valid date.");
        }

        if (bindingResult.hasErrors()) {
            // There were validation errors, so render the form again
            return "signUp";
        }

        users.setFirst_name(formData.getFirst_name());
        users.setLast_name(formData.getLast_name());
        users.setEmail(formData.getEmail());
        users.setBirthdate(formData.getBirthdate());

        login.setUsername(formData.getUsername());
        login.setEmail(formData.getEmail());
        login.setPassword(formData.getPassword());

        userRepository.save(users);
        loginRepository.save(login);

        return "main";
    }
}
