package com.biye.response;

import org.springframework.validation.BindingResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
	// 操作成功
	public static final int SUCCESS = 200;
	// 操作失败
	public static final int FAILED = 500;
	// 参数校验失败
	public static final int VALIDATE_FAILED = 404;
	// 未认证
	public static final int UNAUTHORIZED = 401;
	// 未授权
	public static final int FORBIDDEN = 403;

	private int code;

	private String token;

	private String msg;

	// 0 代表后端管理平台，1 代表APP 端
	private int system_type = 0;

	private String time;

	private Object data;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getSystem_type() {
		return system_type;
	}

	public void setSystem_type(int system_type) {
		this.system_type = system_type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 普通成功返回
	 *
	 * @param data 获取的数据
	 */
	public com.biye.response.Result success(Object data) {
		this.code = SUCCESS;
		this.data = data;
		this.token = "";
		this.time = sdf.format(new Date());
		this.msg = "操作成功";
		return this;
	}

	/**
	 * 普通成功返回
	 *
	 */
	public com.biye.response.Result success() {
		this.code = SUCCESS;
		this.msg = "操作成功";
		this.data = "操作成功";
		this.time = sdf.format(new Date());
		return this;
	}

	/**
	 * 普通成功返回
	 */
	public com.biye.response.Result success(String msg, Object data) {
		this.code = SUCCESS;
		this.msg = msg;
		this.data = data;
		this.time = sdf.format(new Date());
		return this;
	}

	/**
	 * 普通失败提示信息
	 */
	public com.biye.response.Result failed() {
		this.code = FAILED;
		this.msg = "操作失败";
		this.time = sdf.format(new Date());
		return this;
	}

	public com.biye.response.Result failed(String msg) {
		this.code = FAILED;
		this.msg = msg;
		this.time = sdf.format(new Date());
		return this;
	}

	/**
	 * 参数验证失败使用
	 *
	 * @param msg 错误信息
	 */
	public com.biye.response.Result validateFailed(String msg) {
		this.code = VALIDATE_FAILED;
		this.msg = msg;
		this.time = sdf.format(new Date());
		return this;
	}

	/**
	 * 未登录时使用
	 *
	 * @param msg 错误信息
	 */
	public com.biye.response.Result unauthorized(String msg) {
		this.code = UNAUTHORIZED;
		this.msg = "暂未登录或token已经过期";
		this.data = msg;
		this.time = sdf.format(new Date());
		return this;
	}

	/**
	 * 未授权时使用
	 *
	 * @param msg 错误信息
	 */
	public com.biye.response.Result forbidden(String msg) {
		this.code = FORBIDDEN;
		this.msg = "没有相关权限";
		this.data = msg;
		this.time = sdf.format(new Date());
		return this;
	}

	/**
	 * 参数验证失败使用
	 *
	 * @param result 错误信息
	 */
	public com.biye.response.Result validateFailed(BindingResult result) {
		validateFailed(result.getFieldError().getDefaultMessage());
		return this;
	}

	/**
	 * 普通失败提示信息
	 */
	public com.biye.response.Result paramFailed() {
		this.code = FAILED;
		this.msg = "参数失败";
		this.time = sdf.format(new Date());
		return this;
	}

	public com.biye.response.Result paramFailed(String msg) {
		this.code = FAILED;
		this.msg = msg;
		this.time = sdf.format(new Date());
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [code=").append(code).append(", token=").append(token).append(", msg=").append(msg)
				.append(", system_type=").append(system_type).append(", time=").append(time).append(", data=")
				.append(data).append("]");
		return builder.toString();
	}
	
}
