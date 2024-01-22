package edu.nuyun.categorizeme.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 20/01/2024
 * @package edu.nuyun.categorizeme.Controllers
 * @project_Name CategorizeMe
 */


@CrossOrigin
@Controller
@RequestMapping("")
public class DashboardController {
    @GetMapping
    public String getSite(){
        return "dashboard";
    }
}
