package com.baizhi.controller;

import com.baizhi.entity.Triage;
import com.baizhi.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("triage")
public class TriageController {

    @Autowired
    private TriageService triageService;

    @RequestMapping("select")
    public String select(ModelMap modelMap) {

        List<Triage> list = triageService.select();
        modelMap.addAttribute("list", list);
        return "forward:/manager/triage/TriageDepartmentList.jsp";
    }

    @RequestMapping("insert")
    public String insert(Triage triage) {
        triageService.insert(triage);
        return "redirect:/patient/select.do";
    }

    @RequestMapping("selectByDept")
    public String selectByDept(String did, String dname, ModelMap modelMap) {
        List<Triage> list = triageService.selectByDept(did);
        String deptName = dname;
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("deptName", deptName);
        return "forward:/manager/triage/TriageList.jsp";
    }

    @RequestMapping("updateStatus")
    public String updateStatus(String id) {
        triageService.updateStatus(id);
        return "redirect:/triage/selectByDept.do";
    }

}
