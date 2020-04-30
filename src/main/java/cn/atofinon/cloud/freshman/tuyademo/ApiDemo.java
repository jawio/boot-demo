package cn.atofinon.cloud.freshman.tuyademo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author atofinon
 * @Email yangjw@tuya.com
 * @Date 2019/10/11 10:49 AM
 * @Descrition
 */


public class ApiDemo {

    public static void main(String[] args) {
        // pisces
//        String data = readFileContent("/Users/atofinon/Projects/IdeaProjects/play/freshman/src/main/java/cn/atofinon/cloud/freshman/tuyademo/pisces_api_data.json");
        //paladin
        String data = readFileContent("/Users/atofinon/Projects/IdeaProjects/play/freshman/src/main/java/cn/atofinon/cloud/freshman/tuyademo/paladin_api_data.json");

        ApiData apiData = JSONObject.parseObject(data, ApiData.class);
        System.out.println(apiData);
        System.out.println(apiData.getRows().size());

        apiData.getRows().parallelStream().forEach(t -> {
            StringBuffer sb = new StringBuffer("| ");
            sb.append(t.getAppName() + " | ")
                    .append(t.getApiName() + "_" + t.getApiVersion() + " | ")
                    .append(t.getDescription() + " |");
            System.out.println(sb);
        });
    }


    public static String readFileContent(String path) {
        String str = "";


        try {
            File file = new File(path);


            FileInputStream in = new FileInputStream(file);

            // size  为字串的长度 ，这里一次性读完

            int size = in.available();

            byte[] buffer = new byte[size];

            in.read(buffer);

            in.close();

            str = new String(buffer, "utf-8");

        } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();
            return null;


        }

        return str;
    }
}


