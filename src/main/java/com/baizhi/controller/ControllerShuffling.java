package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Shuffling;
import com.baizhi.service.ShufflingServiceDao;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/shu")
public class ControllerShuffling {
    @Autowired
    private ShufflingServiceDao shufflingServiceDao;
    @RequestMapping(value = "/shuff")
    @ResponseBody
    public List<Shuffling> shufflingQuery(){
        List<Shuffling> shufflings = shufflingServiceDao.queryAllShuffling();
        return shufflings;
    }
    @RequestMapping(value = "/add")
    public String shufflingAdd(HttpServletRequest request,MultipartFile img,String title,String status,String dese){
        System.out.println(img+"===============================");
        //获取项目当前路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //当前路径下创建一个文件
        File file=new File(realPath);
        //获取web项目的路径
        String parent = file.getParent();
        //文件上传路径
        File uploadPath=new File(parent+"/uoload");
        System.out.println(uploadPath);
        //创建上传文件夹
        if(!uploadPath.exists()){
            uploadPath.mkdir();
        }
        //获取原始文件名
        String filename = img.getOriginalFilename();
        //获取文件后缀名
        String extension = FilenameUtils.getExtension(filename);
        //使用uuid随机数，避免文件覆盖
        UUID uuid=UUID.randomUUID();
        String newName = uuid.toString();
        newName=newName+"."+extension;
        //上传到指定的文件
        try {
            img.transferTo(new File(uploadPath.getPath(),newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将数据存储到数据库
        Shuffling shuffling=new Shuffling();
        shuffling.setStatus(status);
        shuffling.setTitle(title);
        shuffling.setDese(dese);
        String s = uploadPath.toString();
       // shuffling.setImgPath(s+"uoload"+filename);
        shuffling.setImgPath("/uoload/"+newName);
        System.out.println(newName);
        System.out.println(img+"===============================2");
        System.out.println(shuffling);
        shufflingServiceDao.addShuffling(shuffling);
        System.out.println(img+"===============================4");
        return "redirect:/datagrid/banner.jsp";
    }
    @RequestMapping(value = "/update",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String shufflingUpdate(Integer id,String status){
        System.out.println(status+"----------------------");
        Shuffling shuffling = shufflingServiceDao.quertById(id);
        shuffling.setStatus(status);
        shufflingServiceDao.updateShuffling(shuffling);
        System.out.println(shuffling+"----------------------");
        return "修改成功";
    }
    @RequestMapping(value = "/delete",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String shufflingDelete(Integer id){
        System.out.println(id);
        shufflingServiceDao.deleteShuffling(id);
        //return "redirect:/main/main.jsp";
        return "删除成功";
    }
    //导出
    @ResponseBody
    @RequestMapping("/customerExport")
    public void customerExport(String titles, String fileds, HttpServletResponse response) {
        System.out.println("=================----------------");
        //标题行
        String[] title = titles.split(",");
        String[] allFiled = fileds.split(",");

        Workbook workbook = new HSSFWorkbook();

        DataFormat dataFormat = workbook.createDataFormat();

        short format = dataFormat.getFormat("yyyy-MM-dd");

        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setDataFormat(format);

        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        Sheet sheet = workbook.createSheet("工作表");
        Row row = sheet.createRow(0);

        for (int i = 0; i < title.length; i++) {
            String s = title[i];
            Cell cell = row.createCell(i);
            cell.setCellValue(s);
        }
        //数据行Integer id, String title, String imgPath, String dese, String status, Date date
       // List<Shuffling>  = Arrays.asList(new Shuffling(0, "小黑0", "1234560", new Date()), new User(1, "小黑1", "1234561", new Date()), new User(2, "小黑2", "1234562", new Date()), new User(3, "小黑3", "1234563", new Date()), new User(4, "小黑4", "1234564", new Date()));
        List<Shuffling> shufflings = shufflingServiceDao.queryAllShuffling();
        for (int i = 0; i < shufflings.size(); i++) {
            sheet.setColumnWidth(i,18*256);
            Row dataRow = sheet.createRow(i + 1);
            for (int j = 0; j < allFiled.length; j++) {
                Cell cell = dataRow.createCell(j);
                //填充 id  name  password
                Class<? extends Shuffling> userClass = shufflings.get(i).getClass();
                String methodName = "get" + allFiled[j].substring(0, 1).toUpperCase() + allFiled[j].substring(1);
                try {
                    Object invoke = userClass.getDeclaredMethod(methodName, null).invoke(shufflings.get(i), null);
                    if (invoke instanceof Date) {
                        sheet.setColumnWidth(j,28*256);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue((Date) invoke);
                    } else {
                        cell.setCellValue(invoke.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String name = "用户自定义导出的数据.xls";
        String fileName = "";
        try {
            fileName = new String(name.getBytes("UTF-8"), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;fileName=" + fileName);
        response.setContentType("application/vnd.ms-excel");
        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //导入
    @ResponseBody
    @RequestMapping("/customerExport2")
    public void customerExport2(String type, String filename) {
        System.out.println(type);
        System.out.println(filename);
    }
}
