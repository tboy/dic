package com.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class CommUtil {
	/**
	 * 从请求中获取参数
	 * @param req
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> requestToMap(HttpServletRequest req) {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, String[]> temp = req.getParameterMap();
		Iterator iter = temp.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = entry.getKey().toString();
			String[] val = (String[]) entry.getValue();
			if (!val[0].equals("")) {
				params.put(key, val[0]);
			}
		}
		return params;
	}
    /**
     * 把参数复制到ModelAndView
     * @param mv
     * @param params
     */
	public static void mapToMV(ModelAndView mv, final Map<String, Object> params) {
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			mv.addObject(entry.getKey(), entry.getValue());
		}
	}
}
