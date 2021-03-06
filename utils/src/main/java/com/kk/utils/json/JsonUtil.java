package com.kk.utils.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * web工程使用
 */
public class JsonUtil {

    public static Map<Integer, String> code2msgMap = new HashMap<Integer, String>();

    public static final int JSON_CODE_OK = 0;
    public static final int JSON_CODE_ERROR = -1;

    public static final int PERMISSION_DENY = 1;
    public static final int PARAM_ILLEGAL = 2;

    public static final String JSON_MSG_OK = "ok";
    public static final String JSON_MSG_ERROR = "内部错误";

    static {
        code2msgMap.put(JSON_CODE_OK, JSON_MSG_OK);
        code2msgMap.put(JSON_CODE_ERROR, JSON_MSG_ERROR);
        code2msgMap.put(PERMISSION_DENY, "不允许的操作");
        code2msgMap.put(PARAM_ILLEGAL, "参数不合法");
    }


    public static JSONObject getJson(int code) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        return json;
    }

    public static JSONObject getJson(int code, String msg) {
        JSONObject json = new JSONObject();
        json.put("code", code + "");
        json.put("msg", msg);
        return json;
    }

    public static JSONObject getJson(int code, int left) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("left", left);
        return json;
    }

    public static JSONObject getJson(JSONObject obj, int code, String msg) {
        obj.put("code", code);
        obj.put("msg", msg);
        return obj;
    }

    public static JSONObject getErrJson() {
        return getErrJson(JsonUtil.JSON_CODE_ERROR);
    }

    public static JSONObject getErrJson(int code, String message) {
        final JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", message);
        return json;
    }

    public static JSONObject getErrJson(String msg) {
        return getJson(JsonUtil.JSON_CODE_ERROR, msg);
    }

    public static JSONObject getErrJson(final int code) {
        final JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", getMessageByCode(code));
        return json;
    }

    public static JSONObject getOkJson(String msg) {
        JSONObject json = new JSONObject();
        json.put("code", JSON_CODE_OK);
        json.put("msg", msg);
        return json;
    }

    public static JSONObject getOkJson() {
        return getOkJson(JSON_MSG_OK);
    }

    private static String getMessageByCode(int jsonCode) {
        String msg = code2msgMap.get(jsonCode);
        if (msg == null) {
            msg = "";
        }
        return msg;
    }

    public static JSONObject getOkJsonResult(JSONArray jar, boolean hasMore) {
        JSONObject obj = getOkJson();
        obj.put("hasMore", hasMore ? 1 : 0);
        obj.put("data", jar);
        return obj;
    }

    public static JSONObject getOkJsonResult(Object value) {
        JSONObject obj = getOkJson();
        obj.put("data", value);
        return obj;
    }

    public static JSONObject getOkJsonResult(String msg, Object obj) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", msg);
        json.put("data", obj);
        return json;
    }

    public static JSONObject getSuccessJsonResult(String msg, Object obj) {
        JSONObject json = new JSONObject();
        json.put("code", "0");
        json.put("msg", msg);
        json.put("body", obj);
        return json;
    }

    public static JSONObject getJsonObject(String key, String value) {
        JSONObject json = new JSONObject();
        json.put(key, value);
        return json;
    }
}