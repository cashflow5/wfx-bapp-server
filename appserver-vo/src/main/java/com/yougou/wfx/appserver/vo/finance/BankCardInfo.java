package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yougou.wfx.appserver.vo.BaseVo;
import com.yougou.wfx.appserver.vo.IUserContext;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * Created by lizhw on 2016/4/13.
 */

public class BankCardInfo extends BaseVo implements Serializable, IUserContext {

    private static final long serialVersionUID = 1L;
    //分销商ID、真实姓名、身份证号、银行卡号、开户行

    /**
     * 绑定成功后返回帐号id
     */
    private String accountId;
    /**
     * 分销商ID
     */
    @JsonIgnore
    private UserInfo userInfo;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String idCode;

    /**
     * 银行卡号
     */
    private String cardNo;

    /**
     * 开户行（eg:工商银行,建设银行,...）
     */
    private String bank;

    /**
     * 支行省份（eg:北京）
     */
    private String bankProvince;

    /**
     * 支行城市（eg:北京）
     */
    private String bankCity;

    /**
     * 开户支行(eg:富力城支行)
     */
    private String bankBranch;

    /**
     * 银行编号
     */
    private String bankNo;


    /**
     * 委托书扫描件地址
     */
    private String proxyPicUrl;

    /**
     * 身份证扫描件地址
     */
    private String idPicUrl;
    /**
     * 身份证反面地址
     */
    private String idPicUrlBack;


    /**
     * 审核状态 (已审核/待审核)
     */
    private String status = "1";

    private boolean operResult;
    
    private String operResultMsg;


    public String getStatusDesc() {
        return "1:待审核，2:审核通过，3:审核不通过";
    }


    /**
     * 余额
     */
    private double balance;

    public String getBalance() {
        return format(balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @JsonIgnore
    private String ip;
    @JsonIgnore
    private String referer;
    @JsonIgnore
    private String userAgent;
    @JsonIgnore
    private String sid;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String getReferer() {
        return referer;
    }

    @Override
    public void setReferer(String referer) {
        this.referer = referer;
    }

    @Override
    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String getSid() {
        return sid;
    }

    @Override
    public void setSid(String sid) {
        this.sid = sid;
    }


    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getProxyPicUrl() {
        return proxyPicUrl;
    }

    public void setProxyPicUrl(String proxyPicUrl) {
        this.proxyPicUrl = proxyPicUrl;
    }

    public String getIdPicUrl() {
        return idPicUrl;
    }

    public void setIdPicUrl(String idPicUrl) {
        this.idPicUrl = idPicUrl;
    }


    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isOperResult() {
        return operResult;
    }

    public void setOperResult(boolean operResult) {
        this.operResult = operResult;
    }

	public String getOperResultMsg() {
		return operResultMsg;
	}

	public void setOperResultMsg(String operResultMsg) {
		this.operResultMsg = operResultMsg;
	}

	public String getIdPicUrlBack() {
		return idPicUrlBack;
	}

	public void setIdPicUrlBack(String idPicUrlBack) {
		this.idPicUrlBack = idPicUrlBack;
	}

	@Override
	public String toString() {
		return "BankCardInfo [accountId=" + accountId + ", userInfo=" + userInfo + ", realName=" + realName + ", idCode=" + idCode + ", cardNo=" + cardNo + ", bank=" + bank + ", bankProvince=" + bankProvince + ", bankCity=" + bankCity + ", bankBranch=" + bankBranch + ", bankNo=" + bankNo + ", proxyPicUrl=" + proxyPicUrl + ", idPicUrl=" + idPicUrl + ", status=" + status + ", operResult=" + operResult + ", operResultMsg=" + operResultMsg + ", balance=" + balance + ", ip=" + ip + ", referer=" + referer + ", userAgent=" + userAgent + ", sid=" + sid + "]";
	}
}
