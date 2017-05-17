package com.paipianwang.pat.facade.indent.service.dao;

import java.util.Map;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.indent.entity.PmsIndent;

/**
 * 订单表数据访问接口
 * 
 * @author Jack
 * @version 1.0
 *
 */
public interface PmsIndentDao extends BaseDao<PmsIndent> {

	/**
	 * 批量修改订单状态
	 */
	long changeIndentsType(Map<String, Object> map);

	/**
	 * 前端下单
	 */
	long saveOrder(PmsIndent indent);

	/**
	 * 检测某状态订单的个数
	 */
	long checkStatus(int status);

	/**
	 * 更新成本计算器订单
	 */
	long updateForCalculate(PmsIndent indent);

	/**
	 * 查询某人订单总数
	 * 
	 * @param salesmanUniqueId
	 *            某人唯一标识
	 */
	long countBySalesmanUniqueId(String salesmanUniqueId);

	/**
	 * 查询某人订单总金额
	 * 
	 * @param salesmanUniqueId
	 *            某人唯一标识
	 */
	Double sumPriceBySalesmanUniqueId(String salesmanUniqueId);

	/**
	 * 更新订单客服
	 * 
	 * @param indent
	 * @return
	 */
	long updateCustomerService(PmsIndent indent);

}
