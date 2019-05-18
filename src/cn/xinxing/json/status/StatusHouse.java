package cn.xinxing.json.status;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 */
public class StatusHouse {

	
	public static StatusObject COMMON_STATUS_OK = new StatusObject(StatusCode.CODE_SUCCESS, "成功");
	public static StatusObject COMMON_STATUS_ERROR = new StatusObject(StatusCode.CODE_ERROR, "错误(" + StatusCode.CODE_ERROR + ")");
	public static StatusObject COMMON_STATUS_NO_LOGIN_OR_TIMEOUT = new StatusObject(StatusCode.CODE_ERROR_NO_LOGIN_OR_TIMEOUT, "超时(" + StatusCode.CODE_ERROR_NO_LOGIN_OR_TIMEOUT + ")");
	public static StatusObject COMMON_STATUS_ERROR_PROGRAM = new StatusObject(StatusCode.CODE_ERROR_PROGRAM, "程序错误(" + StatusCode.CODE_ERROR_PROGRAM + ")");
	public static StatusObject COMMON_STATUS_ERROR_PARAMETER = new StatusObject(StatusCode.CODE_ERROR_PARAMETER, "参数错误(" + StatusCode.CODE_ERROR_PARAMETER + ")");
	public static StatusObject COMMON_STATUS_EXIST_OPERATION = new StatusObject(StatusCode.CODE_ERROR_EXIST_OPERATION, "操作存在(" + StatusCode.CODE_ERROR_EXIST_OPERATION + ")");


}
