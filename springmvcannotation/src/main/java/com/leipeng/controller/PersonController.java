package com.leipeng.controller;

import com.leipeng.pojo.Person;
import com.leipeng.service.PersonService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class PersonController {

    @Resource
    private PersonService mPersonService;

    /**
     * 人员列表页面
     *
     * @param model 返回的model
     * @return 页面url
     */
    @RequestMapping(value = "person/all")
    public String findAll(Map<String, Object> model) {
        ArrayList<Person> persons = mPersonService.findAll();
        model.put("personList", persons);
        return "/person/jPersonList";
    }

    /**
     * 跳转新增页面
     *
     * @return 新增页面
     */
    @RequestMapping(value = "person/toCreatePersonInfo")
    public String toCreatePersonInfo() {
        return "/person/jPersonCreate";
    }

    /**
     * 跳转入人员修改信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "person/toUpdatePersonInfo")
    public String toUpdatePersonInfo(Integer id, Model model) {
        Person person = mPersonService.get(id);
        model.addAttribute("person", person);
        return "/person/jPersonUpdate";
    }

    /**
     * 添加人员并且更新数据
     *
     * @param person 新增的人员信息
     * @return 重定向人员列表页面
     */
    @RequestMapping(value = "person/updatePersonList")
    public String updatePersonList(HttpServletRequest request,
                                   Person person,
                                   @RequestParam(value = "photo") MultipartFile photoFile) throws IOException {
        if (person.getId() == null) {
            mPersonService.insert(person);
        } else {
            String dir = request.getSession().getServletContext().getRealPath("/") + "WEB-INF\\static\\";
            String fileName = photoFile.getOriginalFilename(); // 原始的文件名
            String extName = fileName.substring(fileName.lastIndexOf(".")); // 扩展名
            fileName = fileName.substring(0, fileName.lastIndexOf(".")) + System.nanoTime() + extName;
            FileUtils.writeByteArrayToFile(new File(dir + fileName), photoFile.getBytes());

            person.setPhotoPath("\\11\\" + fileName);
            mPersonService.update(person);
        }
        return "redirect:/person/all.action";
    }

    /**
     * 删除人员
     *
     * @param id person id
     * @return person list
     */
    @RequestMapping(value = "person/deleteById")
    public String remove(Integer id) {
        mPersonService.remove(id);
        return "redirect:/person/all.action";
    }

    /**
     * remove person is much
     *
     * @param ids remove persons id
     * @return person list
     */
    @RequestMapping(value = "person/deleteMuch")
    public String removeList(@RequestParam(value = "id") Integer[] ids) {
        for (int i = ids.length - 1; i >= 0; i--) {
            mPersonService.remove(ids[i]);
        }
        return "redirect:/person/all.action";
    }
}
