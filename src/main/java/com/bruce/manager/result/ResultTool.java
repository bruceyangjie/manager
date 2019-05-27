package com.bruce.manager.result;

public class ResultTool {
    private static ResultEntity tool = ResultEntity.getInstance();

    /**
     * 成功
     */
    public static ResultEntity ok() {
        clearData();
        ok(null);
        return tool;
    }

    public static ResultEntity ok(Object data) {
        clearData();
        tool.setCode(HttpResponseCode.OK.code);
        tool.setMsg(HttpResponseCode.OK.response);
        tool.setData(data);
        return tool;
    }

    public static ResultEntity ok(Object data, String msg) {
        clearData();
        tool.setCode(HttpResponseCode.OK.code);
        tool.setMsg(msg);
        tool.setData(data);
        return tool;
    }

    /**
     * 失败
     */
    public static ResultEntity fail() {
        clearData();
        tool.setCode(HttpResponseCode.FAIL.code);
        return tool;
    }

    public static ResultEntity fail(int code) {
        clearData();
        tool.setCode(code);
        return tool;
    }

    public static ResultEntity fail(HttpResponseCode code) {
        clearData();
        tool.setCode(code.code);
        return tool;
    }

    public static ResultEntity fail(int code, String msg) {
        clearData();
        tool.setCode(code);
        tool.setMsg(msg);
        return tool;
    }

    private static void clearData() {
        tool.setCode(0);
        tool.setMsg("");
        tool.setData(null);
    }

    /**
     * 统一的返回码
     */
    public enum HttpResponseCode {
        OK(200, "成功"),
        FAIL(400, "错误"),
        NOT_RIGHT(403, "没权限"),
        NOT_FOUND(404, "没找到"),
        SERVER_FAIL(500, "服务器错误");
        private int code;
        private String response;

        HttpResponseCode(int code, String response) {
            this.code = code;
            this.response = response;
        }
    }
}
