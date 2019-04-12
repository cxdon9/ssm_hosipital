package com.baizhi.test;

import com.baizhi.service.TriageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test01 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

//        DepartmentDao departmentDao = (DepartmentDao) ac.getBean("departmentDao");
//        Department department =new Department();
//        department.setName("骨科");
//        List<Department> list = departmentDao.select(department);
//        for (Department departmen : list) {
//            System.out.println(departmen);
//        }
        /*PatientDao patientDao = (PatientDao) ac.getBean("patientDao");
        List<Patient> select = patientDao.select(new Patient());
        for (Patient patient : select) {
            System.out.println(patient);
        }*/
        /*PatientService patientService = (PatientService) ac.getBean("patientServiceImpl");
        PageInfo<Patient> select = patientService.select(new Patient(), 1, 20);
        List<Patient> list = select.getList();
        for (Patient patient : list) {
            System.out.println(patient);
        }*/

        /*TriageDao dao =  (TriageDao) ac.getBean("triageDao");
        List<Triage> list = dao.select();
        for (Triage triage : list) {
            System.out.println(triage);
        }*/


        TriageService service = (TriageService) ac.getBean("triageServiceImpl");
        List list = service.select();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
