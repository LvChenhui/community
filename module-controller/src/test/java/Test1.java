import com.wl.lch.core.SubscriberMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-servlet.xml");
        SubscriberMapper mapper = ac.getBean("subscriberMapper",SubscriberMapper.class);
        System.out.println(mapper.deleteByPrimaryKey(1));

    }

    @Test
    public void test2(){

    }
}