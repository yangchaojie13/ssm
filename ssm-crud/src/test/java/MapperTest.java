import com.atguigu.crud.bean.Department;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试dao层的工作
 * @author shkstart
 * @create 2021-08-19-20:48
 * spring的项目可以使用spring的单元测试，可以自动注入需要的组件
 * 1.   导入springTest模块
 * 2.   ContextConfiguration指定spring配置文件的位置
 * 3.   直接autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;


    /**
     * 测试 DepartmentMapper
     */
    @Test
    public void testCRUD(){

        /*//1.    创建springIOC容器
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.    从容器中获取mapper
        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
        System.out.println(departmentMapper);

        //1.    插入几个部门
        departmentMapper.insertSelective(new Department(null,"开发部"));
        departmentMapper.insertSelective(new Department(null,"测试部"));

        //2.    生成员工数据，
        /*employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@atguigu.com",1));*/

        //3.    批量插入多个员工，使用可以执行批量操作的sqlSession
       /* EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@guigu.com",1));
        }
        System.out.println("批量完成");*/
    }
}
