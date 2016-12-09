package myjunit;

import java.util.List;

import org.apache.log4j.Logger;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.ytzb.pojo.User;
import com.ytzb.service.UserService;

public class UserJunit {
	protected static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext-mybatis.xml");
	public static DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) ctx
			.getBean("transactionManager");
	private Logger log = Logger.getLogger(UserJunit.class);
	private User user = new User("", "", 0, "", 0);
	private List<User> userList = null;

	@Test
	public void dologinTest() {
		UserService userService = (UserService) ctx.getBean("userServiceImpl");
		user.setU_id(0);
		user.setU_email("youke50@qq.com");
		user.setU_name("youke4");
		user.setU_pwd("youke4");
		
		userList=userService.findU_nameLike("mlp");

//		userList = userService.findUserPageing(null);
		
//		userService.updateUser(user);
		
//		user=userService.findUserU_id(1);
		
//		user=userService.findU_name("mlp");

		// 打印输出信息；
		if (userList != null) {
			log.info("遍历userList:");
			for (User user : userList) {
				log.info(user.getU_name()+"\t"+user.getU_email());
//				log.info(user.getPre().getP_id());
			}
		} else if(user!=null){
			log.info("u_name---"+user.getU_name());
//			log.info(user.getPre().getP_role());
		}
	}
}