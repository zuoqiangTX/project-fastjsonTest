package com.zuoqiang.method;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zuoqiang.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Think on 2017/6/3.
 */
public class TestFastJson {
    public static void main(String[] args) {
        Person person = new Person(20,"zuoqiang");
        List<Person> list = new ArrayList<Person>();
        list.add(person);
        list.add(new Person(23,"wangbin"));
        //将集合或者对象序列化成jsonObject
        System.out.println(JSON.toJSON(person));
        System.out.println(JSON.toJSON(list));
         //String 转成object
        String jsonString= "{\"name\":\"zuoqiang\",\"age\":20}";
        Person person2= (Person) JSON.parseObject(jsonString, Person.class);
        System.out.println(person2.getName());

        //string 转成Collection
        String jsonArayString= "[{\"name\":\"zuoqiang\",\"age\":20},{\"name\":\"wangbin\",\"age\":23}]";
        List<Person> listP= JSON.parseArray(jsonArayString,Person.class);
        for (Person p : listP) {
            System.out.println(p.getName()+"是！");
        }
        //没有对象直接解析jsonObject
        String jsonString2= "{\"name\":\"zuoqiang\",\"age\":20}";
        JSONObject jsonObject=JSON.parseObject(jsonString2);
        System.out.println(jsonObject.get("name"));

        //没有对象直接解析数组
        String jsonAs= "[{\"name\":\"zuoqiang\",\"age\":20},{\"name\":\"wangbin\",\"age\":23}]";
        JSONArray jsonArray=JSON.parseArray(jsonAs);
        for (Object o : jsonArray) {
            System.out.println(o.toString());
        }
        for(int i = 0;i<jsonArray.size();i++){
            JSONObject temp= (JSONObject) jsonArray.get(i);
            System.out.println(temp.get("name"));
        }
    }
}
