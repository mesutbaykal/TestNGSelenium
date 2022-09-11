package com.cybertek.tests.day10_file_upload;


import org.testng.annotations.Test;

public class FilePathExample {


    @Test
    public void test2(){
        //C:\Users\maXut\IdeaProjects\EU7TestNGSelenium\src\test\resources\textfile.txt
        System.out.println(System.getProperty("user.dir"));

        String projectPath=System.getProperty("user.dir");
        String filePath="src\\test\\resources\\textfile.txt";
        String fullPath=projectPath+"\\"+filePath;

        System.out.println("fullPath:"+fullPath);

    }
}
