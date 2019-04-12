package com.baizhi.controller;

import com.baizhi.entity.Department;
import com.baizhi.entity.Patient;
import com.baizhi.service.DepartmentService;
import com.baizhi.service.PatientService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PatientService patientService;

    @RequestMapping("select")
    public String select(ModelMap modelMap, Patient patient, Integer pageIndex) {
        /*System.out.println("DepartmentController的select.... ");
        List<Department> list = departmentService.select(new Department());
        modelMap.addAttribute("list",list);*/
        if (pageIndex == null) {
            pageIndex = 1;
        }
        int pageSize = 5;
        PageInfo<Patient> pageInfo = patientService.select(patient, pageIndex, pageSize);
        List<Patient> list = pageInfo.getList();
        int totalPage = pageInfo.getPages();
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("totalPage", totalPage);
        modelMap.addAttribute("pageIndex", pageIndex);
        return "forward:/manager/patient/PatientList.jsp";
    }

    //添加前查询所有的科室
    @RequestMapping("selectdept")
    public String select(ModelMap modelMap, Department department, Integer pageIndex, String id) {

        if (pageIndex == null) {
            pageIndex = 1;
        }
        int pageSize = 100;
        PageInfo<Department> pageInfo = departmentService.select(department, pageIndex, pageSize);

        List<Department> list = pageInfo.getList();
        Patient patient = patientService.selectOne(id);
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("patient", patient);
        return "forward:/manager/patient/PatientRegister.jsp";
    }


    @RequestMapping("insert")
    public String insert(Patient patient) {
        patientService.insert(patient);
        return "redirect:/patient/select.do";
    }

    @RequestMapping("delete")
    public String delete(String id) {
        patientService.delete(id);
        return "redirect:/patient/select.do";
    }

    @RequestMapping("deleteMany")
    public String deleteMany(String[] ids) {
        System.out.println(Arrays.toString(ids));
        patientService.deleteMany(ids);
        return "redirect:/patient/select.do";
    }

    @RequestMapping("selectOne")
    public String selectOne(ModelMap modelMap, String id) {
        Patient patient = patientService.selectOne(id);
        modelMap.addAttribute("patient", patient);
        return "forward:/manager/patient/updatePatient.jsp";
    }

    @RequestMapping("update")
    public String update(Patient patient) {
        patientService.update(patient);
        return "redirect:/patient/select.do";
    }

}
