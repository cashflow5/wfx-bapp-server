package com.yougou.wfx.appserver.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.annotation.NeedLoginAction;
import com.yougou.wfx.appserver.vo.BooleanResult;
import com.yougou.wfx.appserver.vo.login.LoginError;
import com.yougou.wfx.appserver.vo.login.LoginVo;
import com.yougou.wfx.appserver.vo.login.MemberBindPhoneVo;
import com.yougou.wfx.appserver.vo.login.MemberForWXVo;
import com.yougou.wfx.appserver.vo.login.ModifyPasswordVo;
import com.yougou.wfx.appserver.vo.login.NewPasswordVo;
import com.yougou.wfx.appserver.vo.login.Sms;
import com.yougou.wfx.appserver.vo.login.UserInfo;
import com.yougou.wfx.appserver.vo.login.ValidCode;
import com.yougou.wfx.appserver.vo.login.ValidResult;
import com.yougou.wfx.appserver.vo.login.WXParam;
import com.yougou.wfx.enums.MemberTypeEnum;

/**
 * 用户中心 Created by lizhw on 2016/4/8.
 */
@RestController
@RequestMapping("userCenter")
@EnableAutoConfiguration
public class UserCenterController extends BaseController {

	/**
	 * 登录
	 *
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Object login(@RequestBody LoginVo loginVo) {

		String loginType = loginVo.getLoginType();
		if ("1".equals(loginType)) {
			// 1.验证页面输入(用户名或密码不能为空)
			if (StringUtils.isBlank(loginVo.getLoginName()) || StringUtils.isBlank(loginVo.getPassword())) {
				return new LoginError("用户名或密码不能为空！");
			}
		} else if ("2".equals(loginType)) {
			if (StringUtils.isBlank(loginVo.getOpendId())) {
				return new LoginError("opendId不能为空！");
			}
		} else {// 为了兼容老版本。loginType .和openID都可以不传。不传默认代表用户名登录。
			// 1.验证页面输入(用户名或密码不能为空)
			if (StringUtils.isBlank(loginVo.getLoginName()) || StringUtils.isBlank(loginVo.getPassword())) {
				return new LoginError("用户名或密码不能为空！");
			}
			loginVo.setLoginType("1");
		}

		// 2.判断是否符合登录要求
		setUserContext(loginVo);
		UserInfo userInfo = memberAccountService.login(loginVo);

		// 2.1用户是否存在
		if (userInfo == null) {
			return new LoginError("2".equals(loginVo.getLoginType()) ? " 您不是分销商，请关注微信公众号成为分销商" : "用户名或密码错误");

			// 2.2判断用户类型
		} else if (userInfo.getMemberType().intValue() == MemberTypeEnum.NORMAL_MEMBER.getKey()) {
			return new LoginError("您还没有成为分销商,不能登录");
		} else if (StringUtils.isBlank(userInfo.getSellerId()) || StringUtils.isBlank(userInfo.getShopId())) {
			LoginError loginError = new LoginError();
			loginError.setError("分销商或店铺信息不全");
			return loginError;

			// 2.3状态是否正常
		} else {
			int sellerStatus = sellerService.getSellerStatus(userInfo.getId());
			if (sellerStatus == 1) {// 1：停止合作 2：关店了3：正常
				LoginError loginError = new LoginError();
				loginError.setErrorCode("1");
				loginError.setError("优购微零售已停止与您的合作");
				return loginError;
			}
		}

		// 3.设置用户信息到session,登录成功^-^
		setUserInfo(userInfo);
		return userInfo;

		// 用户信息（登录失败返回空）{包括用户的普通信息、分销商ID、店铺ID}
	}

	/**
	 * 修改密码
	 *
	 * @return
	 */
	@NeedLoginAction
	@RequestMapping(value = "modifyPassword", method = RequestMethod.POST)
	public Object modifyPassword(@RequestBody ModifyPasswordVo mp) {
		BooleanResult result = new BooleanResult();

		// 1.验证页面输入(原密码或新密码不能为空)
		if (StringUtils.isBlank(mp.getPassword()) || StringUtils.isBlank(mp.getNewPassword())) {
			result.setError("原密码或新密码不能为空！");
			return result;
		}

		// 2.调用修改密码接口
		mp.setUserInfo(getUserInfo());
		setUserContext(mp);
		result = memberAccountService.modifyPassword(mp);
		return result;
	}

	/**
	 * 退出登录
	 *
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public Object logout() {
		setUserInfo(null);
		BooleanResult result = new BooleanResult();
		result.setResult(true);
		result.setMsg("已经退出登录!");
		return result;
	}

	/**
	 * 发送短信
	 * 
	 * @param sms
	 * @return
	 */
	@RequestMapping(value = "sendSms", method = RequestMethod.POST)
	public Object sendSms(@RequestBody Sms sms) {
		setUserContext(sms);
		BooleanResult result = memberAccountService.sendSms(sms);
		if (result.isResult()) {
			getSession().setAttribute("_phone", sms.getPhone());
		}
		return result;
	}

	/**
	 * 发送短信
	 * 
	 * @param sms
	 * @return
	 */
	@RequestMapping(value = "sendSmsNew", method = RequestMethod.POST)
	public Object sendSmsNew(@RequestBody Sms sms) {
		setUserContext(sms);
		BooleanResult result = memberAccountService.sendSmsNew(sms);
		if (result.isResult()) {
			getSession().setAttribute("_phone", sms.getPhone());
		}
		return result;
	}

	/**
	 * 验证验证码
	 * 
	 * @param validCode
	 * @return
	 */
	@RequestMapping(value = "checkValidCode", method = RequestMethod.POST)
	public Object checkValidCode(@RequestBody ValidCode validCode) {
		setUserContext(validCode);
		validCode.setPhone(getSessionStr("_phone"));
		ValidResult result = memberAccountService.checkValidCode(validCode);
		if (result.isResult()) {
			getSession().setAttribute("_token", result.getToken());
		}
		return result;
	}

	/**
	 * 忘记密码
	 * 
	 * @param passwd
	 * @return
	 */
	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public Object changePassword(@RequestBody NewPasswordVo passwd) {
		setUserContext(passwd);
		passwd.setPhone(getSessionStr("_phone"));
		passwd.setSessiontoken(getSessionStr("_token"));
		BooleanResult result = memberAccountService.changePassword(passwd);
		return result;
	}

	/**
	 * 微信绑定
	 * 
	 * @param memberForWXVo
	 * @return
	 */
	@RequestMapping(value = "wxSellerBind")
	public Object wxSellerBind(MemberForWXVo memberForWXVo) {
		BooleanResult result = new BooleanResult();
		setUserContext(memberForWXVo);
		if (StringUtils.isBlank(memberForWXVo.getOpenId())) {
			result.setError("OpenId不能为空");
			return result;
		}
		if (StringUtils.isBlank(memberForWXVo.getNickname())) {
			result.setError("Nickname不能为空");
			return result;
		}
		if (StringUtils.isBlank(memberForWXVo.getHeadimgurl())) {
			result.setError("Headimgurl不能为空");
			return result;
		}
		if (StringUtils.isBlank(memberForWXVo.getMemberId())) {
			result.setError("MemberId不能为空");
			return result;
		}
		return memberAccountService.wxSellerBind(memberForWXVo);
	}

	/**
	 * 绑定手机号
	 * 
	 * @param memberBindPhoneVo
	 * @return
	 */
	@RequestMapping(value = "memberBindPhone")
	public Object memberBindPhone(MemberBindPhoneVo memberBindPhoneVo) {
		BooleanResult result = new BooleanResult();
		setUserContext(memberBindPhoneVo);
		if (StringUtils.isBlank(memberBindPhoneVo.getLoginName())) {
			result.setError("用户名不能为空！");
			return result;
		}
		if (StringUtils.isBlank(memberBindPhoneVo.getLoginPassword())) {
			result.setError("密码不能为空！");
			return result;
		}

		if (StringUtils.isBlank(memberBindPhoneVo.getOpenId())) {
			result.setError("openId不能为空！");
			return result;
		}
		if (StringUtils.isBlank(memberBindPhoneVo.getValidateCode())) {
			result.setError("验证码不能为空！");
			return result;
		}
		return memberAccountService.memberBindPhone(memberBindPhoneVo);
	}

	/**
	 * 获取微信参数
	 * 
	 * @return
	 */
	@RequestMapping(value = "getWXParam")
	public Object getWXParam() {
		WXParam wxParam = memberAccountService.getWXParam();
		return wxParam;
	}

	/**
	 * 注册
	 *
	 * @return
	 */
	public Object register() {
		return "";
	}

}
