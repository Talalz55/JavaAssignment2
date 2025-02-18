/*
    Talal Al-Zuhair
    ID: 991658377
 */

package ca.sheridan.alzuhait.assignment2.controllers;

import ca.sheridan.alzuhait.assignment2.beans.PasswordRecord;
import ca.sheridan.alzuhait.assignment2.repositories.PasswordRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PasswordRecordController {

    @Autowired
    private PasswordRecordRepository passwordRecordRepository;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("password", new PasswordRecord());
        return "index";
    }

    @Transactional
    @PostMapping("/addPassword")
    public String addPasswordRecord(PasswordRecord passwordRecord, Model model) {
        // Save the record to the repository
        passwordRecordRepository.save(passwordRecord);
        model.addAttribute("password", passwordRecord);
        model.addAttribute("recordAdded", true);
        return "index";
    }

    @GetMapping("/viewPasswordRecord")
    public String viewPasswordRecords(Model model) {
        List<PasswordRecord> passwordRecords = passwordRecordRepository.findAll();
        model.addAttribute("passwordRecords", passwordRecords);
        return "viewPasswordRecord";
    }

    @GetMapping("/searchPasswordRecord")
    public String getSearchPasswordRecord() {
        return "searchPasswordRecord";
    }

    @PostMapping("/searchPasswordRecord")
    public String postSearchPasswordRecord(@RequestParam("title") String title, Model model) {
        List<PasswordRecord> passwordRecords = passwordRecordRepository.findByTitleContainingIgnoreCase(title);

        model.addAttribute("passwordRecords", passwordRecords);

        return "searchPasswordRecord";
    }
}
