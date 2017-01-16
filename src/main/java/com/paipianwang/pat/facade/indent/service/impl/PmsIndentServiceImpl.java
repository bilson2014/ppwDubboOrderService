package com.paipianwang.pat.facade.indent.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.facade.indent.entity.PmsIndent;
import com.paipianwang.pat.facade.indent.service.PmsIndentFacade;
import com.paipianwang.pat.facade.indent.service.biz.PmsIndentBiz;

/**
 * 订单Dubbo服务接口实现
 * @author Jack
 * @version 1.0
 *
 */
@Service("pmsIndentFacade")
public class PmsIndentServiceImpl implements PmsIndentFacade {

	@Autowired
	private final PmsIndentBiz biz = null;
	
	/**
	 * 后台DataGride 查询订单列表(含条件)
	 */
	public DataGrid<PmsIndent> listWithPagination(PageParam pageParam, Map<String, Object> paramMap) {
		return biz.listWithPagination(pageParam,paramMap);
	}

	/**
	 * 后台添加一条订单
	 */
	@Override
	public long save(PmsIndent pmsIndent) {
		return biz.save(pmsIndent);
	}

	/**
	 * 后台更新一条订单
	 */
	@Override
	public long update(PmsIndent pmsIndent) {
		return biz.update(pmsIndent);
	}

	/**
	 * 后台根据ids数组删除订单
	 */
	@Override
	public long delIndentByIds(long[] ids) {
		return biz.delIndentByIds(ids);
	}

	/**
	 * 后台批量修改订单状态
	 */
	@Override
	public boolean changeIndentsType(long[] ids,int indentType) {
		Map<String, Object> map = new HashMap<>();
		map.put("array", ids);
		map.put("indentType", indentType);
		return biz.changeIndentsType(map) > 0;
	}

	/**
	 * 查询list订单
	 */
	@Override
	public List<PmsIndent> listWithCondition(Map<String, Object> paramMap) {
		return biz.listWithCondition(paramMap);
	}

	/**
	 * 前端下单
	 */
	@Override
	public boolean saveOrder(PmsIndent indent) {
		return biz.saveOrder(indent) > 0;
	}
	

	/**
	 * 检测某种状态订单的个数
	 * status 状态
	 */
	@Override
	public long checkStatus(int status) {
		return biz.checkStatus(status);
	}

	/**
	 * 更新成本计算器订单
	 */
	@Override
	public long updateForCalculate(PmsIndent indent) {
		return biz.updateForCalculate(indent);
	}

	/**
	 * 查询某人订单总数
	 * @param salesmanUniqueId 某人唯一标识
	 */
	@Override
	public long countBySalesmanUniqueId(String salesmanUniqueId) {
		return biz.countBySalesmanUniqueId(salesmanUniqueId);
	}

	/**
	 * 查询某人订单总金额
	 * @param salesmanUniqueId 某人唯一标识
	 */
	@Override
	public Double sumPriceBySalesmanUniqueId(String salesmanUniqueId) {
		return biz.sumPriceBySalesmanUniqueId(salesmanUniqueId);
	}
}
