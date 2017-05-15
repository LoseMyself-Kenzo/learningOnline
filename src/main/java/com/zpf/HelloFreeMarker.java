package com.zpf;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :LoseMyself pengfei.zheng}@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/4/16 14:34
 */
public class HelloFreeMarker {
    private Configuration conf;

    public void first() throws Exception{
        conf = new Configuration();
        conf.setDirectoryForTemplateLoading(new File("/templates"));

    }

    private Template t;

    public void  second()throws Exception{
        t = conf.getTemplate("test.ftl");
    }

    private Map datamap;

    public void third(){
        datamap = new HashMap();
        datamap.put("name","zpf");
        datamap.put("msg","欢迎使用FreeMarker!");
    }

    public void four() throws Exception{
        t.process(datamap,new OutputStreamWriter(System.out));
    }

    public static void main(String[] args) throws Exception {
        HelloFreeMarker hfm = new HelloFreeMarker();
        hfm.first();
        hfm.second();
        hfm.third();
        hfm.four();
    }
}
