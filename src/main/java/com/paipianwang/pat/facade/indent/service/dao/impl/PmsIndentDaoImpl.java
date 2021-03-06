package com.paipianwang.pat.facade.indent.service.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paipianwang.pat.common.core.dao.impl.BaseDaoImpl;
import com.paipianwang.pat.facade.indent.entity.PmsIndent;
import com.paipianwang.pat.facade.indent.service.dao.PmsIndentDao;

@Repository
public class PmsIndentDaoImpl extends BaseDaoImpl<PmsIndent> implements PmsIndentDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate = null;

	public static final String SQL_CHANGE_INDENT_TYPE = "changeIndentsType";

	public static final String SQL_SAVE_ORDER = "saveOrder";

	public static final String SQL_CHECK_STATUS = "checkStatus";

	public static final String SQL_UPDATE_FOR_CALCULATE = "updateForCalculate";
	
	public static final String SQL_UPDATE_REJECTED = "rejected";

	public static final String SQL_COUNT_SALEMAN = "countBySalesmanUniqueId";

	public static final String SQL_SUMPRICE_SALESMAN = "sumPriceBySalesmanUniqueId";

	public static final String SQL_UPDATE_CUSTOMERSERVICE = "updateCustomerService";

	public static final String SQL_GET_INDENTBYREQUIREID = "findIndentByRequireId";

	/**
	 * 根据订单id数组，批量修改订单状态
	 */
	@Override
	public long changeIndentsType(Map<String, Object> map) {
		return sessionTemplate.update(getStatement(SQL_CHANGE_INDENT_TYPE), map);
	}

	/**
	 * 前端下单
	 */
	@Override
	public long saveOrder(PmsIndent indent) {
		return sessionTemplate.insert(getStatement(SQL_SAVE_ORDER), indent);
	}

	/**
	 * 检测某状态的订单个数
	 */
	@Override
	public long checkStatus(int indentType) {
		return sessionTemplate.selectOne(getStatement(SQL_CHECK_STATUS), indentType);
	}

	/**
	 * 更新成本计算器订单
	 */
	@Override
	public long updateForCalculate(PmsIndent indent) {
		return sessionTemplate.update(getStatement(SQL_UPDATE_FOR_CALCULATE), indent);
	}

	@Override
	public long countBySalesmanUniqueId(String salesmanUniqueId, List<Integer> indentTypes) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("salesmanUniqueId", salesmanUniqueId);
		map.put("indentTypes", indentTypes);
		return sessionTemplate.selectOne(getStatement(SQL_COUNT_SALEMAN), map);
	}

	@Override
	public Double sumPriceBySalesmanUniqueId(String salesmanUniqueId, List<Integer> indentTypes) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("salesmanUniqueId", salesmanUniqueId);
		map.put("indentTypes", indentTypes);
		return sessionTemplate.selectOne(getStatement(SQL_SUMPRICE_SALESMAN), map);
	}

	@Override
	public long updateCustomerService(PmsIndent indent) {
		return sessionTemplate.update(getStatement(SQL_UPDATE_CUSTOMERSERVICE), indent);
	}

	@Override
	public PmsIndent findIndentByRequireId(long id) {
		return sessionTemplate.selectOne(getStatement(SQL_GET_INDENTBYREQUIREID), id);
	}

	@Override
	public long rejected(PmsIndent indent) {
		return sessionTemplate.update(getStatement(SQL_UPDATE_REJECTED), indent);
	}

}
