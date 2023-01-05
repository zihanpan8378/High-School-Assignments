/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pet;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 44869
 */
public class Cat_NGTest {
    
    public Cat_NGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * eat方法的测试 (属于类Cat_)。
     */
    @Test
    public void testEat() {
        System.out.println("eat");
        Cat_ instance = new Cat_();
        instance.eat();
        // TODO 检查生成的测试代码并删除失败的默认调用。
        fail("\u6d4b\u8bd5\u7528\u4f8b\u4e3a\u539f\u578b\u3002");
    }

    /**
     * work方法的测试 (属于类Cat_)。
     */
    @Test
    public void testWork() {
        System.out.println("work");
        Cat_ instance = new Cat_();
        instance.work();
        // TODO 检查生成的测试代码并删除失败的默认调用。
        fail("\u6d4b\u8bd5\u7528\u4f8b\u4e3a\u539f\u578b\u3002");
    }
    
}
