package com.cjs.controller.base;

import com.cjs.util.exception.MessageException;
import com.cjs.util.string.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 2016/5/8
 */
public class BaseController {
    public Map<String, Object> generateFailureMsg(Exception e, String defaultMsg) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (e instanceof MessageException) {
            map.put("msg", ((MessageException) e).getMsg());
        } else if (!StringUtil.isEmpty(defaultMsg)) {
            map.put("msg", defaultMsg);
        }
        map.put("success", false);
        e.printStackTrace();
        return map;
    }

    public Map<String, Object> generateFailureMsg(String defaultMsg) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringUtil.isEmpty(defaultMsg)) {
            map.put("msg", defaultMsg);
            map.put("success", false);
            return map;
        }
        return map;
    }

    public Map<String, Object> generateSuccessMsg(String defaultMsg) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", defaultMsg);
        map.put("success", true);
        return map;
    }
}
