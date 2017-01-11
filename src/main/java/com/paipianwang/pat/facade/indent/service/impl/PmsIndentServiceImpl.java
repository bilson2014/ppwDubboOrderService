package com.paipianwang.pat.facade.indent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
