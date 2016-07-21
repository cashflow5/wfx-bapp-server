package com.yougou.wfx.appserver.vo.finance;

import java.io.Serializable;
import java.util.Date;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/5/3.
 */
public class CashDetail extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 提现申请单号
     */
    private String withdrawApplyNo;
    /**
     * 申请时间
     */
    private Date applyTime;

    public String getApplyTimeStr() {
        return format(applyTime);
    }

    /**
     * 账户余额
     */
    private Double accountBalance;
    /**
     * 实收费用
     */
    private Double actualReceivedAmount;
    /**
     * 服务费
     */
    private Double serviceAmount;
    /**
     * 提现金额
     */
    private Double withdrawAmount;
    /**
     * 支付方式编码，详见 BankCompanyEnum
     */
    @Deprecated
    private String paymentStyle;
    @Deprecated
    private String paymentStyleName;
    /**
     * 开户名
     */
    private String accountName;
    /**
     * 开户行
     */
    private String accountBankNo;


    /**
     * 开户行简称（例：招商银行）
     */
    private String accountBankName;
    /**
     * 开户行全称（例：某某银行支行）
     */
    private String accountBankAllName;

    /**
     * 开户账号
     */
    private String accountNo;
    /**
     * 付款时间，即提现时间
     */
    private Date modifyTime;

    public String getModifyTimeStr() {
        return format(modifyTime);
    }

    /**
     * 对应的交易明细ID
     */
    private String sellerDetailId;

    /**
     * 提现状态：1-待审核,2-已审核,3-已提现,4-审核不通过
     * 说明：提现中（待审核和已审核），已提现（已提现），提现失败（审核不通过）
     */
    private String billStatus;
    /**
     * 备注说明
     */
    private String remark;

    /**
     * 分销商帐号，即登录名
     */
    private String sellerAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWithdrawApplyNo() {
        return withdrawApplyNo;
    }

    public void setWithdrawApplyNo(String withdrawApplyNo) {
        this.withdrawApplyNo = withdrawApplyNo;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getAccountBalance() {
        return format(accountBalance);
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getActualReceivedAmount() {
        return format(actualReceivedAmount);
    }

    public void setActualReceivedAmount(Double actualReceivedAmount) {
        this.actualReceivedAmount = actualReceivedAmount;
    }

    public String getServiceAmount() {
        return format(serviceAmount);
    }

    public void setServiceAmount(Double serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public String getWithdrawAmount() {
        return format(withdrawAmount);
    }

    public void setWithdrawAmount(Double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getPaymentStyle() {
        return paymentStyle;
    }

    public void setPaymentStyle(String paymentStyle) {
        this.paymentStyle = paymentStyle;
    }

    public String getPaymentStyleName() {
        return paymentStyleName;
    }

    public void setPaymentStyleName(String paymentStyleName) {
        this.paymentStyleName = paymentStyleName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBankNo() {
        return accountBankNo;
    }

    public void setAccountBankNo(String accountBankNo) {
        this.accountBankNo = accountBankNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getSellerDetailId() {
        return sellerDetailId;
    }

    public void setSellerDetailId(String sellerDetailId) {
        this.sellerDetailId = sellerDetailId;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public String getAccountBankName() {
        return accountBankName;
    }

    public void setAccountBankName(String accountBankName) {
        this.accountBankName = accountBankName;
    }

    public String getAccountBankAllName() {
        return accountBankAllName;
    }

    public void setAccountBankAllName(String accountBankAllName) {
        this.accountBankAllName = accountBankAllName;
    }
}
