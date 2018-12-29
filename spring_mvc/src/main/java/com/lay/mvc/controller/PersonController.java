package com.lay.mvc.controller;

import com.lay.mvc.entity.Person;
import com.lay.mvc.enumeration.SexEnum;
import com.lay.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 0:25 2018/11/11
 * @Modified By:IntelliJ IDEA
 */
@RequestMapping(value = "/person")
@Controller
public class PersonController {

    //注入用户服务类
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/getPerson")
    @ResponseBody
    public Person getPerson(@RequestParam("id") Long id) {
        return personService.getPerson(id);
    }

    //展示人员详情
    @RequestMapping("/details")
    public ModelAndView details(Long id) {
        //访问模型层得到数据
        Person perosn = personService.getPerson(id);
        //模型和视图
        ModelAndView mv = new ModelAndView();
        //定义模型视图
        mv.setViewName("person/details");
        //加入数据模型
        mv.addObject("person", perosn);
        //返回视图
        return mv;
    }

    //使用json视图
    @RequestMapping("/detailsForJson")
    public ModelAndView detailsForJson(Long id) {
        Person person = personService.getPerson(id);
        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        mv.setView(jsonView);
        mv.addObject("person", person);
        return mv;
    }

    //获取人员列表
    @RequestMapping("/table")
    public ModelAndView table() {
        List<Person> personList = personService.getAllPersons();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("person/table");
        mv.addObject("personList", personList);
        return mv;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Person> list(
            @RequestParam(value = "personName", required = false) String personName,
            @RequestParam(value = "note", required = false) String note) {
        List<Person> personList = personService.findPersons(personName, note);
        return personList;
    }

    @RequestMapping("/add")
    public String add() {
        return "/person/add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Person insert(@RequestBody Person person) {
        personService.insertPerson(person);
        return person;
    }

    /**
     * @Description:测试性别转换器
     * @param:SexEnum
     * @return: java.lang.String
     * @auther: lay
     * @date: 22:58 2018/11/11
     */
    @RequestMapping("/sex")
    @ResponseBody
    public String sex(@RequestParam("sex") SexEnum sexEnum) {
        String sexName = sexEnum.getName();
        return sexName;
    }


}
