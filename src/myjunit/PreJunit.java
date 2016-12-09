package myjunit;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.ytzb.pojo.Pre;
import com.ytzb.service.PreService;

public class PreJunit {
	private Logger log = Logger.getLogger(PreJunit.class);
	private List<Pre> preList = null;
	private Pre pre=new Pre();
//	document.getElementsByName("checkbox").checked=true

	@Test
	public void dologinTest() {
		PreService preService = (PreService) UserJunit.ctx.getBean("preServiceImpl");
		
		preService.deletePre("超管");
		
//		preList=preService.findPreList();

//		pre=preService.findPreP_id(0);
		
		// 打印输出信息；
		if (preList != null) {
			log.info("遍历preList:");
			for (Pre pre : preList) {
				log.info(pre.getP_id()+"\t"+pre.getP_role());
			}
		} else{
			log.info(pre.getP_id());
		}
	}
}