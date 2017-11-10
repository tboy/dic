package com.spring.stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.action.BaseAction;
import com.base.service.PageUtil;
import com.util.CommUtil;
@Controller
@RequestMapping("/stock/")
public class StockAction extends BaseAction{
	@Autowired
	private StockService service;

	@RequestMapping("stock_list.htm")
	public ModelAndView stockList(HttpServletRequest req, HttpServletResponse res, String code, String name,
			Integer currentPage) {
		ModelAndView mv = getView("views/stock/stock_list");
		currentPage = currentPage == null ? 1 : currentPage;
		int pageSize = 15;
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer();
		hql.append(" from " + Stock.class.getName() + " obj where 1=1 ");
		if (!StringUtils.isEmpty(code)) {
			hql.append("and obj.code like:code ");
			params.put("code", "%" + code + "%");
		}
		if (!StringUtils.isEmpty(name)) {
			hql.append("and obj.name like:name ");
			params.put("name", "%" + name + "%");
		}
		CommUtil.mapToMV(mv,CommUtil.requestToMap(req));
		PageUtil page = this.service.list(hql.toString(), params, currentPage, pageSize);
        mv.addObject("page", page);
		return mv;
	}
}
