package com.watchdog;

import com.watchdog.business.Device;
import com.watchdog.dao.user.UserDao;
import com.watchdog.services.VideoInsertDeleteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {


    private static File directory = new File("c:/ftp/video");

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);

        //Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        //To use JdbcTemplate
        UserDao userDao = ctx.getBean("userDaoImpl", UserDao.class); //first parameter is the id found in the spring.xml file


        VideoInsertDeleteService videoInsertDeleteService = new VideoInsertDeleteService();
        List<File> fileList = videoInsertDeleteService.getFiles(directory);

        for (final File file : fileList) {
            if (videoInsertDeleteService.overMaxAllowedAge(file)) {
                System.out.println("Delete file:  " + file.getName());

                // this method will be functional later but does nothing right now
                videoInsertDeleteService.deleteFile(file);
            } else {
                System.out.println("Keep for now.");
            }
        }

        videoInsertDeleteService.parseDays("hi");

        ctx.close();
    }





}
