package ca.sheridan.alzuhait.assignment2.controllers;

import ca.sheridan.alzuhait.assignment2.beans.PasswordRecord;
import ca.sheridan.alzuhait.assignment2.repositories.PasswordRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class PasswordRecordController {

    @Autowired
    private PasswordRecordRepository passwordRecordRepository;

    @GetMapping("/")
    public String showHomePage(Model model) {
        // Generate a random ID for the form
        model.addAttribute("password", new PasswordRecord());
        return "index";
    }

    @Transactional
    @PostMapping("/addPassword")
    public String addPasswordRecord(PasswordRecord passwordRecord, Model model) {
        // Save the record to the repository
        passwordRecordRepository.save(passwordRecord);

        // Add a success message and the password object back to the model for rendering in the view
        model.addAttribute("password", passwordRecord);
        model.addAttribute("recordAdded", true);

        return "index"; // Stay on the same page
    }
}
