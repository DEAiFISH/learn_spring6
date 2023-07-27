package com.DEAiFISH.resource;

import org.springframework.core.io.UrlResource;

/**
 * 演示UrlResource访问网络资源
 */
public class UrlResourceDemo {

    //访问前缀时http、file
    public static void loadAndReadUrlResource(String path){
        // 创建一个 Resource 实现类的对象 UrlResource
        UrlResource url = null;
        try {
            url = new UrlResource(path);
            // 获取资源名
            System.out.println(url.getFilename());
            System.out.println(url.getURI());
            // 获取资源描述
            System.out.println(url.getDescription());
            //获取资源内容
            System.out.println(url.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //访问网络资源
        //http前缀
        loadAndReadUrlResource("http://www.baidu.com");

        System.out.println("******************************");

        //file前缀  根目录下的文件
        loadAndReadUrlResource("file:deaifish.txt");
    }
}