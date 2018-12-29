package com.lay.mvc.controller;

import com.lay.mvc.entity.Person;
import com.lay.mvc.service.PersonService;
import com.lay.mvc.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("my")
@Controller
public class ParamController {

    @Autowired
    private PersonService personService;
    /**
     * 在无注解下获取参数，要求参数名称和HTTP请求参数名称一致
     * @param intVal
     * @param longVal
     * @param str
     * @return 响应JSON参数
     */
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String,Object> noAnnotation (Integer intVal,Long longVal,String str) {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("intVal",intVal);
        paramMap.put("longVal",longVal);
        paramMap.put("str",str);
        return paramMap;
    }
    /**
     *
     * @Description:通过注解获取参数
     * @param: intVal, longVal, strVal
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: lay
     * @date: 14:14 2018/11/13
     */
    @GetMapping("/annotation")
    @ResponseBody
    public Map<String,Object> annotation(
            @RequestParam("int_val") Integer intVal,
            @RequestParam("long_val") Long longVal,
            @RequestParam(value = "str_val",required = false) String strVal){
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("intVal",intVal);
        paramMap.put("longVal",longVal);
        paramMap.put("str",strVal);
        return paramMap;
    }
    /**
     *
     * @Description: 传递数组
     * @param: [intArr, longArr, strArr]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: lay
     * @date: 14:21 2018/11/13
     */
    @GetMapping("/requestArray")
    @ResponseBody
    public Map<String,Object> requestArray(
            int[] intArr,Long[] longArr,String[] strArr){
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("intVal",intArr);
        paramMap.put("longVal",longArr);
        paramMap.put("str",strArr);
        return paramMap;
    }
    /**
     *
     * @Description: 通过URL获得参数
     * @param: [id]
     * @return: com.lay.mvc.entity.Person
     * @auther: lay
     * @date: 14:34 2018/11/13
     */
    //{...}代表占位符，还可以配置参数名称
    @GetMapping("/{id}")
    @ResponseBody
    public Person get(@PathVariable("id") Long id){
        return personService.getPerson(id);
    }
    @GetMapping("/db2/{id}")
    @ResponseBody
    public Person getDb2(@PathVariable("id") Long id){
        return personService.getDb2Person(id);
    }
    //映射页面
    @GetMapping("/format/form")
    public String showFormat(){
        return "/format/formatter";
    }
    //获取提交参数
    @PostMapping("/format/commit")
    @ResponseBody
    public Map<String,Object> format(
            @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)Date date,
            @NumberFormat(pattern = "#,###.##") Double number){
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("date",date);
        dataMap.put("number",number);
        return dataMap;
    }

    /**
     *
     * @Description: 测试转换器
     * @param: [person]
     * @return: com.lay.mvc.entity.Person
     * @auther: lay
     * @date: 16:37 2018/11/13
     */
    @GetMapping("/converter")
    @ResponseBody
    public Person getPersonByConverter(Person person){
        return person;
    }

    /**
     *
     * @Description: 测试数组转换器
     * @param: List
     * @return: java.util.List<com.lay.mvc.entity.Person>
     * @auther: lay
     * @date: 16:47 2018/11/13
     */
    @GetMapping("/converterList")
    @ResponseBody
    public List<Person> personList(List<Person> personList){
        return personList;
    }
}
