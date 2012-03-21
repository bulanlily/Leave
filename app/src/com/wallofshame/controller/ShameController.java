package com.wallofshame.controller;


import com.wallofshame.domain.leave.CSVProcessor;
import com.wallofshame.domain.leave.Employee;
import com.wallofshame.domain.leave.TimeSheet;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ShameController {


    private TimeSheet timeSheet = new TimeSheet();
    private CSVProcessor csvProcessor = new CSVProcessor();

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index(Model model) throws IOException {
        timeSheet.clear();
        csvProcessor.pickUpLatestFolder();
        timeSheet.addAllEmployeeToListByStrings(csvProcessor.getEmployeeInfo());
        timeSheet.addAllLeaveToListByStrings(csvProcessor.getTakeOffInfo());
        Object[] employees = timeSheet.getEmployeeHashMap().values().toArray();
        model.addAttribute("employees", employees);
        model.addAttribute("time",csvProcessor.getFileForderName());
        return "index";
    }


    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/history/{userId}", method = RequestMethod.GET)
    public String history(Model model,
                          @PathVariable("userId") String userId,
                          HttpServletResponse resp) throws IOException {
        Employee employee = timeSheet.findEmployeeById(Integer.parseInt(userId));
        model.addAttribute("employee", employee);
        model.addAttribute("leaves",employee.getHistoryLeaves());
        return "history";

    }
//
//    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
//    public String postCredential(HttpServletRequest request, Model model) {
//        String username = StringUtils.trimToEmpty(request.getParameter("username"));
//        String password = StringUtils.trimToEmpty(request.getParameter("password"));
//
//        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
//            model.addAttribute("error", "User name and password required.");
//            return "login";
//        }
//
//        Credential.getInstance().save(username, password);
//        return "redirect:/index.html";
//    }
//    @RequestMapping(value = Array("/login.html"), method = Array(RequestMethod.POST))
//    def save(request:HttpServletRequest){
//        Credential.save(request.getParameter("username"), request.getParameter("password"))
//        "redirect:/wallofshame/china"
//    }

//    @RequestMapping(value = Array("/login.html"), method = Array(RequestMethod.GET))
//    def login = {
//            new ModelAndView("login")
//    }
//
//    @RequestMapping(value = Array("/login.html"), method = Array(RequestMethod.POST))
//    def save(request:HttpServletRequest){
//        Credential.save(request.getParameter("username"), request.getParameter("password"))
//        "redirect:/wallofshame/china"
//    }

}
