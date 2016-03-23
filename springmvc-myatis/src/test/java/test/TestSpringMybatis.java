package test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.web.dao.BaUserMapper;
import com.web.model.ManagerUserQueryDto;
import com.web.util.PageDto;


@ContextConfiguration(locations = "classpath*:/spring/**/*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringMybatis {

	private Logger logger = LoggerFactory.getLogger(TestSpringMybatis.class);

	@Autowired
	private BaUserMapper baUserMapper;
	
	@Test
	public void test(){
		PageDto<ManagerUserQueryDto> pageResult = new PageDto<>();
		Page<?> page = PageHelper.startPage(1, 10);
		List<ManagerUserQueryDto> list = baUserMapper.selectAll();
		pageResult.setList(list);
		pageResult.setPageNo(page.getStartRow());
		pageResult.setPageSize(page.getPageSize());
		pageResult.setTotalCount(page.getTotal());
		logger.info(JSONObject.toJSONString(pageResult));
	}
	
}
