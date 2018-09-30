package com.ebrightmoon.bean;


/**
 */
public class ResponseCode {
	   //HTTP请求成功状态码
    public static final int HTTP_SUCCESS = 200;
    //条件不符合
    public static final int NOT_CONDITION = 299;
    //操作失败
    public static final int FAILED_OPERATE = 298;
    //账号或密码不正确
    public static final int LOGIN_FAILED = 297;
    //手势密码不正确
    public static final int LOGIN_GESTURE = 296;
    // 账号已经退出登录
    public static final int LOGIN_EXIT = 295;
    //  在其他设备登录
    public static final int OTHER_LOGIN = 294;
    //登录过期
    public static final int LOGIN_TIME_OUT = 293;
    //未实名
    public static final int USER_NOT_REAL = 289;
    //考试未通过
    public static final int EXAM_FAIL = 291;
    //没绑定银行卡
    public static final int ISBANK = 211;
    //创建证书失败
    public static final  int SIGN = 270;
    //接口异常
    public static final  int Exception =292;



    //AccessToken错误或已过期
    public static final int ACCESS_TOKEN_EXPIRED = 10001;
    //RefreshToken错误或已过期
    public static final int REFRESH_TOKEN_EXPIRED = 10002;
    //帐号在其它手机已登录
    public static final int OTHER_PHONE_LOGIN = 10003;
    //时间戳过期
    public static final int TIMESTAMP_ERROR = 10004;
    //缺少授权信息,没有AccessToken
    public static final int NO_ACCESS_TOKEN = 10005;
    //签名错误
    public static final int SIGN_ERROR = 10006;

    private ResponseCode() {
        /** cannot be instantiated **/
        throw new UnsupportedOperationException("cannot be instantiated");
    }



}
