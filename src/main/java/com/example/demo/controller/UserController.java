package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Car;
import com.example.demo.model.User;
import com.example.demo.service.CarService;
import com.example.demo.service.UserService;


@Controller
public class UserController 
{
	@Autowired
	UserService service;
	@Autowired
	CarService cs;
	
	
//	@GetMapping("/")
//	public String viewHome()
//	{
//		return "Registration";
//	}
//	
	@GetMapping("/")
	public String viewRegistration()
	{
		return "Registration";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("user") User user )
	{
		System.out.println(user.toString());
		service.saveUser(user);
		return "login";
	}
	@GetMapping("/login")
	public String loginpage()
	{
		return "login";
	}
	@PostMapping("/login")
    public String login(@RequestParam("name") String username, @RequestParam("password") String password, Model model) {
        User user = service.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("user", user);
            return "carssell"; // Redirect to success page or perform further actions
        } else {
            return "error"; // Redirect to error page or display error message
        }
    }
	@PostMapping("/sell")
    public String carSell(@ModelAttribute("car") Car car) {
        cs.sellCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/cars")
    public String displayCarList(Model model) {
        List<Car> carList = cs.getCars();
        model.addAttribute("carList", carList);
        return "View";
    }
    @PostMapping("/cars")
    //to add car
    public String addCar(@ModelAttribute("car") Car car) {
        cs.sellCar(car);
        return "redirect:/cars";
    }
    @GetMapping("/logout")
    public String logout() {
        // Perform logout logic here
        return "logout";
    }
    @GetMapping("/contactus")
    public String Contact() {
        // Perform contact logic here
        return "contactus";
    }
//	@GetMapping("/list")
//    public String viewUserList(Model model) 
//	{
//        List<User> listuser = service.ListAll();
//        model.addAttribute("listuser", listuser);
//        //System.out.print("Get / ");
//        return "UserList";
//    }
}
