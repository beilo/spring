package com.leipeng.controller

import com.leipeng.pojo.Person
import com.leipeng.service.PersonService
import org.apache.commons.io.FileUtils
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import java.io.File
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

@Controller
class PersonController {
    @Resource
    private lateinit var mService: PersonService // lateinit 设置为已经初始化了

    /**
     * person all list
     */
    @RequestMapping("person/all")
    fun findAll(model: HashMap<String, Any>): String {
        val persons = mService.findAll()
        model["personList"] = persons
        return "/person/jPersonList"
    }

    /**
     * to create person info
     */
    @RequestMapping("person/toCreatePersonInfo")
    fun toCreatePersonInfo(): String {
        return "/person/jPersonCreate"
    }

    /**
     * to update person info
     */
    @RequestMapping("person/toUpdatePersonInfo")
    fun toUpdatePersonInfo(id: Int, model: Model): String {
        val person = mService.get(id)
        model.addAttribute("person",person)
        return "/person/jPersonUpdate"
    }

    /**
     * add person and to all person list
     */
    @RequestMapping("person/updatePersonToAllList")
    fun updatePersonToAllList(request: HttpServletRequest,
                              person: Person,
                              @RequestParam("photo") photoFile: MultipartFile): String {

        val dir = """${request.session.servletContext.getRealPath("/")}WEB-INF\static\"""
        var fileName = photoFile.originalFilename
        val extName = fileName.lastIndexOf(".")
        if (extName != -1){
            fileName = fileName.substring(0, extName) + System.nanoTime() + extName
            FileUtils.writeByteArrayToFile(File(dir + fileName), photoFile.bytes)
            person.photoPath = """\11\$fileName"""
        }else{
            person.photoPath = ""
        }

        if (person.id == null) {
            mService.insert(person)
        } else {
            mService.update(person)
        }

        return "redirect:/person/all.action"
    }

    /**
     * remove person
     */
    @RequestMapping("person/deleteById")
    fun remove(id: Int): String {
        mService.remove(id)
        return "redirect:/person/all.action"
    }

    /**
     * remove person list
     */
    @RequestMapping("person/deleteList")
    fun removeList(@RequestParam id: Array<Int>): String {
        id.forEach {
            mService.remove(it)
        }
        return "redirect:/person/all.action"
    }

}