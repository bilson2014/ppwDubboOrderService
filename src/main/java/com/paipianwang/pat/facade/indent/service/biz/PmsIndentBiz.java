package com.paipianwang.pat.facade.indent.service.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.facade.indent.entity.PmsIndent;
import com.paipianwang.pat.facade.indent.service.dao.PmsIndentDao;

/**
 * 订单--服务层接口
 * 事物管理层
 * @author Jack
 * @version 1.0
 *
 */
@Service
public class PmsIndentBiz {

	@Autowired
	private PmsIndentDao pmsIndentDao;
	/**
	 * DataGride 查询订单列表(含条件)
	 */
	public DataGrid<PmsIndent> listWithPagination(PageParam pageParam, Map<String, Object> paramMap) {
		return pmsIndentDao.listWithPagination(pageParam, paramMap);
	}
	/**
	 * 添加一条订单
	 */
	public long save(final PmsIndent pmsIndent) {
		return pmsIndentDao.insert(pmsIndent);
	}
	/**
	 * 更新一条订单
	 */
	public long update(final PmsIndent pmsIndent) {
		return pmsIndentDao.update(pmsIndent);
	}
	/**
	 * 根据ids数组删除订单
	 */
	public long delIndentByIds(long[] ids) {
		return pmsIndentDao.deleteByIds(ids);
	}
	/**
	 * 批量修改订单状态
	 */
	public long changeIndentsType(Map<String, Object> map) {
		return pmsIndentDao.changeIndentsType(map);
	}
	/**
	 * 查询list订单
	 */
	public List<PmsIndent> listWithCondition(Map<String, Object> paramMap) {
		return pmsIndentDao.listBy(paramMap);
	}

	/**
	 * 前端下单
	 */
	public long saveOrder(PmsIndent indent) {
		return pmsIndentDao.saveOrder(indent);
	}
	/**
	 * 检测某状态订单的个数
	 * @param status 状态
	 */
	public long checkStatus(int status) {
		return pmsIndentDao.checkStatus(status);
	}
	/**
	 * 更新成本计算器订单
	 */
	public long updateForCalculate(PmsIndent indent) {
		return pmsIndentDao.updateForCalculate(indent);
	}
	/**
	 * 查询某人订单总数
	 * @param salesmanUniqueId 某人唯一标识
	 * @param indentTypes 
	 */
	public long countBySalesmanUniqueId(String salesmanUniqueId, List<Integer> indentTypes) {
		return pmsIndentDao.countBySalesmanUniqueId(salesmanUniqueId,indentTypes);
	}
	/**
	 * 查询某人订单总金额
	 * @param salesmanUniqueId 某人唯一标识
	 * @param indentTypes 
	 */
	public Double sumPriceBySalesmanUniqueId(String salesmanUniqueId, List<Integer> indentTypes) {
		return pmsIndentDao.sumPriceBySalesmanUniqueId(salesmanUniqueId,indentTypes);
	}
	/**
	 * 更新订单客服
	 * @param indent
	 * @return
	 */
	public long updateCustomerService(PmsIndent indent) {
		return pmsIndentDao.updateCustomerService(indent);
	}
	public PmsIndent findIndentById(long id) {
		return pmsIndentDao.getById(id);
	}
	public PmsIndent findIndentByRequireId(long id) {
		return pmsIndentDao.findIndentByRequireId(id);
	}
	public long rejected(PmsIndent indent) {
		return pmsIndentDao.rejected(indent);
	}
}
