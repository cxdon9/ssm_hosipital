package com.baizhi.controller;

import com.baizhi.entity.Files;
import com.baizhi.service.FilesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("files")
public class FilesController {

    @Autowired
    private FilesService filesService;

    @RequestMapping("select")
    public String select(ModelMap modelMap, Files files, Integer pageIndex) {
        if (pageIndex == null) {
            pageIndex = 1;
        }
        int pageSize = 5;
        PageInfo<Files> pageInfo = filesService.select(files, pageIndex, pageSize);
        List<Files> list = pageInfo.getList();
        int totalPage = pageInfo.getPages();
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("totalPage", totalPage);
        modelMap.addAttribute("pageIndex", pageIndex);
        return "forward:/manager/file/FileList.jsp";
    }

    @RequestMapping("insert")
    public String insert(MultipartFile file) throws Exception {
        //1.获取源文件夹
        String oldName = file.getOriginalFilename();
        //2.将接收的文件复制到服务器上
        String uuid = UUID.randomUUID().toString();
//        System.out.println("action 文件名"+oldName);
        String newname = uuid + oldName.substring(oldName.lastIndexOf("."));

        file.transferTo(new File("G:\\服务器\\" + newname));

        Files files = new Files();
        files.setFile_name(oldName);
        files.setFile_path("G:\\服务器\\");
        files.setSave_name(newname);
        files.setFile_size(getPrintSize(file.getSize()));
        filesService.insert(files);
        return "redirect:/files/select.do";
    }

    @RequestMapping("down")
    public void down(String newname, HttpServletResponse resp, String file_name) throws Exception {
        InputStream is = new FileInputStream("G:\\服务器\\" + newname);
        //设置响应头 attachment  附件
        String s1 = URLEncoder.encode(file_name, "UTF-8");
        resp.setHeader("content-disposition", "attachment;filename=" + s1);
        OutputStream os = resp.getOutputStream();

        while (true) {
            int i = is.read();
            if (i == -1) {
                break;
            }
            os.write(i);
        }
    }


    public static String getPrintSize(long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "GB";
        }
    }
}
