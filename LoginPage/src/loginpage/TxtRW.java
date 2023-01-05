/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 *
 * @author 44869
 */
public class TxtRW {
    public static void main(String[] args) throws Exception{

        String path = TxtRW.class.getResource("").getPath()+"test.txt"; //这里填目标路径
 
        File file = new File(path); 
        
        String[][] content = new String[6][100];
        
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[0].length; j++) {
                content[i][j] = "";
            }
        }

        //------------------------------写------------------------------------------
        content[0][0] += "hello,shaonaiyi\n"; //字符串
        content[0][0] += "hello,shaonaiyi\n"; 
        FileOutputStream fileOutputStream = new FileOutputStream(file);  //创建output流
        fileOutputStream.write(content[0][0].getBytes()); //把content写进目标文件里，如果目标不存在，则会创建目标文件

        fileOutputStream.close(); //关闭输出流 （必须要）

        //------------------------------读------------------------------------------
        FileInputStream fileInputStream = new FileInputStream(path); //创建读取器

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream)); //读取文件

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line); //将每个字节打印出来
        }

        fileInputStream.close(); //关闭读取流（必须有）


    }

}
