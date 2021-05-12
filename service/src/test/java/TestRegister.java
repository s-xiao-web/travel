import cn.itcast.travel.utils.MailUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TestRegister {

    @Test
    public void test() {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }

    @Test
    public void test2() {
        String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date().getTime());
        System.out.println(format);
    }

    @Test
    public void test3() {
        boolean b = MailUtils.sendMail("15810954324@163.com", "我是内容", "邮件的名称");
        System.out.println(b);
    }
}
