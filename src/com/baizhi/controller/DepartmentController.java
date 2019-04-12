package com.baizhi.controller;

import com.baizhi.entity.Department;
import com.baizhi.entity.DepartmentSTO;
import com.baizhi.service.DepartmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("dept")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("select")
    public String select(ModelMap modelMap, Department department, Integer pageIndex) {
        /*System.out.println("DepartmentController的select.... ");
        List<Department> list = departmentService.select(new Department());
        modelMap.addAttribute("list",list);*/
        if (pageIndex == null) {
            pageIndex = 1;
        }
        int pageSize = 5;
        PageInfo<Department> pageInfo = departmentService.select(department, pageIndex, pageSize);
        List<Department> list = pageInfo.getList();
        int totalPage = pageInfo.getPages();
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("totalPage", totalPage);
        modelMap.addAttribute("pageIndex", pageIndex);
        return "forward:/manager/department/departmentList.jsp";
    }

    @RequestMapping("insert")
    public String insert(Department department) {
        departmentService.insert(department);
        return "redirect:/dept/select.do";
    }

    @RequestMapping("insertMany")
    public String insertMany(DepartmentSTO departmentSTO) {
        List<Department> list = departmentSTO.getList();
        for (Department department : list) {
            departmentService.insert(department);
        }
        return "redirect:/dept/select.do";
    }

    @RequestMapping("delete")
    public String delete(String id) {
        departmentService.delete(id);
        return "redirect:/dept/select.do";
    }

    @RequestMapping("deleteMany")
    public String deleteMany(String[] ids) {
        System.out.println(Arrays.toString(ids));
        departmentService.deleteMany(ids);
        return "redirect:/dept/select.do";
    }

    @RequestMapping("selectOne")
    public String selectOne(ModelMap modelMap, String id) {
        Department department = departmentService.selectOne(id);
        modelMap.addAttribute("department", department);
        return "forward:/manager/department/updatedepartment.jsp";
    }

    @RequestMapping("update")
    public String update(Department department) {
        departmentService.update(department);
        return "redirect:/dept/select.do";
    }

}
