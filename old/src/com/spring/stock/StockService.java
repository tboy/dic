package com.spring.stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.spring.stock.serviceinterface.IStockService;
import com.util.HttpUtil;
import com.util.StringUtil;

@SuppressWarnings("unchecked")
@Service
public class StockService extends BaseService<Stock> implements IStockService {
	@Autowired
	private StockDao dao;

	@Override
	public StockDao cuDao() {

		return dao;
	}

	@Override
	public Boolean updateByCode(String code) {
		String hql = " from " + Stock.class.getName() + " obj where obj.code =:code ";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Stock> rs = this.dao.queryByHql(hql, params, -1, -1);
		if (rs != null && rs.size() > 0) {
			String path = StringUtil.PATH + code;
			String dataStr = HttpUtil.sendGet(path, null);
			String name = StringUtil.getNameByStr(dataStr);
			Stock st = rs.get(0);
			st.setName(name);
			this.saveOrUpdate(st);
			return true;
		}
		return false;
	}

	@Override
	public Boolean insertByRange(String type, int begin, int end) {
		StringBuffer strArr = new StringBuffer();
		for(int i=begin;i<end;i++){
		 String code = type+StringUtil.sixLen(i);
		 strArr.append(code).append(",");
		}
		String code = strArr.toString().substring(0,strArr.toString().length()-1);
		String path = StringUtil.PATH+code;
		String dataStr = HttpUtil.sendPost(path, null);
		return updateByStr(dataStr);
	}
	
	private boolean updateByStr(String dataStr){
		String[] rows = dataStr.split("\n");
		for(String row:rows){
			String code = row.substring(11,row.indexOf("="));
			String name = StringUtil.getNameByStr(row);
			String hql = " from " + Stock.class.getName() + " obj where obj.code =:code ";
			Map<String, Object> params = new HashMap<String, Object>();
			List<Stock> rs = this.dao.queryByHql(hql, params, -1, -1);
			if (rs != null && rs.size() > 0) {
				
			}
		}
		return true;
	}

	
}
