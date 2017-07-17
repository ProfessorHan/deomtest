import org.junit.Test;
import org.springframework.util.DigestUtils;

/**
 * @Author: Hanfei
 * @Date: 2017/7/15
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:TestClass
 */
public class TestClass {

    @Test
    public void test1() throws Exception{
        String password = DigestUtils.md5DigestAsHex("1234".getBytes("utf-8"));
        System.out.println(password);
    }
}
