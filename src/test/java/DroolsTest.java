import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import com.zpb.drools.model.insert1.Person;


/**
 * @author       pengbo.zhao
 * @description  DroolsTest
 * @createDate   2022/8/22 17:17
 * @updateDate   2022/8/22 17:17
 * @version      1.0
 */
@DisplayName("drools-test")
public class DroolsTest {

    private static KieContainer container = null;
    private KieSession statefulKieSession = null;

    @Test
    @DisplayName("基于-drools-规则文件")
    public void testDroolsByDrl(){
        // 创建 KIE 容器
        // 此代码编译在类路径上找到的所有规则文件，并将此编译的结果（一个KieModule对象）
        // 添加到KieContainer.
        // 最后，StatelessKieSession对象从 实例化KieContainer并针对指定数据执行：
        KieServices kieServices = KieServices.Factory.get();
        container = kieServices.getKieClasspathContainer();
        statefulKieSession = container.newKieSession("all-rules");
        Person person = new Person();

        person.setAge(12);
        person.setName("Test");

        statefulKieSession.insert(person);
        statefulKieSession.fireAllRules();
        statefulKieSession.dispose();
    }

}
