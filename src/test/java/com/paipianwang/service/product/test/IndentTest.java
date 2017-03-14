package com.paipianwang.service.product.test;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.facade.indent.entity.PmsIndent;
import com.paipianwang.pat.facade.indent.service.biz.PmsIndentBiz;
public class IndentTest extends BaseTestAction {

	@Autowired
	private PmsIndentBiz biz = null;
	@Test
	public void testEasyUIListPage() {
		PageParam param = new PageParam();
		param.setBegin(0);
		param.setLimit(10);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("indentId", 715);
		DataGrid<PmsIndent> Indent = biz.listWithPagination(param, paramMap);
		System.err.println(Indent.getTotal());
		System.err.println(Indent.getRows().get(0).getIndentName());
	}
	
	@Test
	public void testSave() {
		PmsIndent indent = new PmsIndent();
		indent.setIndent_description("123");
		indent.setIndent_recomment("备注");
		indent.setIndent_tele("17778080667");
		indent.setIndentName("Name");
		indent.setIndentNum("");
		indent.setIndentType(1);
		indent.setServiceId(-1l);
		indent.setSalesmanUniqueId(null);
		indent.setProductId(-1);
		indent.setIndentPrice(1000);
		indent.setTeamId(-1l);
		long result = biz.save(indent);
		System.err.println(result);
	}
	@Test
	public void testUpdate() {
		PmsIndent indent = new PmsIndent();
		indent.setId(1000720l);
		indent.setIndent_description("123");
		indent.setIndent_recomment("备注");
		indent.setIndent_tele("17778080667");
		indent.setIndentName("Name222222222");
		indent.setIndentNum("");
		indent.setIndentType(1);
		indent.setServiceId(-1l);
		indent.setSalesmanUniqueId(null);
		indent.setProductId(-1);
		indent.setIndentPrice(1000);
		indent.setTeamId(-1l);
		long result = biz.update(indent);
		System.err.println(result);
	}
	@Test
	public void testdel() {
		long[] ids = {1000720,1000719};
		long result = biz.delIndentByIds(ids);
		System.err.println(result);
	}
	
	@Test
	public void testchangeIndentType() {
		Map<String, Object> map = new HashMap<>();
		map.put("array", new long[]{1000718,1000717});
		map.put("indentType", 3);
		long result = biz.changeIndentsType(map);
		System.err.println(result);
	}

	@Test
	public void testlistBy() {
		Map<String, Object> map = new HashMap<>();
		map.put("indentType", 3);
		long result = biz.listWithCondition(map).size();
		System.err.println(result);
	}
	@Test
	public void testsaveOrder() {
		PmsIndent indent = new PmsIndent();
		indent.setIndent_description("123");
		indent.setIndent_recomment("备注");
		indent.setIndent_tele("17778080667");
		indent.setIndentName("Name");
		indent.setIndentNum("");
		indent.setIndentType(1);
		indent.setServiceId(-1l);
		indent.setSalesmanUniqueId(null);
		indent.setProductId(-1);
		indent.setIndentPrice(1000);
		indent.setTeamId(-1l);
		long result = biz.saveOrder(indent);
		System.err.println(result);
	}
	@Test
	public void testnewOrder() {
		long result = biz.checkStatus(0);
		System.err.println(result);
	}
}
