package com.liyang.utils;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class VelocityUtil {

    public static void getVelocity() {
        String path = "templates/hello.vm";
        InputStream is = null;
        try {
            File file = File.createTempFile("tmp_", "");
            is = new ClassPathResource(path).getInputStream();
            FileUtils.copyInputStreamToFile(is, file);

            VelocityEngine ve = new VelocityEngine();
            String folder = file.getParent();
            String fileName = file.getName();
            Properties properties = new Properties();
            properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, folder);
            properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
            properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
            properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");

            ve.init(properties);
            Template t = ve.getTemplate(fileName, "UTF-8");

            VelocityContext context = new VelocityContext();
            context.put("name", "velocity");
            context.put("date", new Date().toString());

            List temp = new ArrayList();
            temp.add("1");
            temp.add("2");
            context.put("list", temp);

            StringWriter sw = new StringWriter();
            t.merge(context, sw);
            if(file.exists()){
                file.delete();
            }

            System.out.println(sw.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
