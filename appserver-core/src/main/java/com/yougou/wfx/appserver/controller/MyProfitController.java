package com.yougou.wfx.appserver.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yougou.wfx.appserver.annotation.NeedLoginAction;
import com.yougou.wfx.appserver.vo.BooleanResult;
import com.yougou.wfx.appserver.vo.PageSearchResult;
import com.yougou.wfx.appserver.vo.finance.BankCardInfo;
import com.yougou.wfx.appserver.vo.finance.CashApply;
import com.yougou.wfx.appserver.vo.finance.CashApplyListResult;
import com.yougou.wfx.appserver.vo.finance.CashApplySearcher;
import com.yougou.wfx.appserver.vo.finance.CashSetting;
import com.yougou.wfx.appserver.vo.finance.CommissionDetail;
import com.yougou.wfx.appserver.vo.finance.CommissionIdentity;
import com.yougou.wfx.appserver.vo.finance.CommissionList;
import com.yougou.wfx.appserver.vo.finance.CommissionSearcher;
import com.yougou.wfx.appserver.vo.finance.CommissionSummary;
import com.yougou.wfx.appserver.vo.finance.Incoming;
import com.yougou.wfx.appserver.vo.finance.IncomingSearcher;
import com.yougou.wfx.appserver.vo.finance.ProfitSummary;
import com.yougou.wfx.appserver.vo.login.UserInfo;

/**
 * 我的收益
 * Created by lizhw on 2016/4/8.
 */
@RestController
@RequestMapping("myProfit")
@EnableAutoConfiguration
//@PropertySource({"classpath:application.properties", "config/application.properties"})
public class MyProfitController extends BaseController {
	
	protected final Logger logger = LoggerFactory.getLogger(MyProfitController.class);

    /**
     * 我的收益汇总信息
     *
     * @return
     */
    @RequestMapping("summary")
    @NeedLoginAction
    public Object summary() {
        //该分销商账户信息（可用余额、提现中金额、已提现金额、账户总金额）
        ProfitSummary profitSummary = financeService.getProfitSummary(getUserInfo());
        return profitSummary;
    }

    /**
     * 获取佣金明细中的汇总信息
     *
     * @return
     */
    @RequestMapping("commission")
    @NeedLoginAction
    public Object commission() {
        //交易中、未结算和已结算的信息
        CommissionSummary commissionSummary = financeService.getCommissionSummary(getUserInfo());
        return commissionSummary;
    }

    /**
     * 获取佣金明细列表
     * 分销商ID、当前页、分页条数
     *
     * @return
     */
    @RequestMapping("getCommissionList")
    @NeedLoginAction
    public Object getCommissionList(CommissionSearcher searcher) {

        searcher.setUserInfo(getUserInfo());
        setUserContext(searcher);
        //订单号、时间、金额、总条数
        // 0:未结算,1:已结算,2:异常挂起,3:已关闭
        CommissionList result = financeService.getCommissionList(searcher);
        return result;
    }

    /**
     * 获取佣金明细详情
     * 订单号，分销商ID
     *
     * @return
     */
    @RequestMapping("getCommissionDetail")
    @NeedLoginAction
    public Object getCommissionDetail(CommissionIdentity commissionIdentity) {
        commissionIdentity.setUserInfo(getUserInfo());
        //在佣金明细列表中有一个向右的箭头，应该可以看订单明细，这个需要跟产品确认
        CommissionDetail result = financeService.getCommissionDetail(commissionIdentity);
        return result;
    }

    /**
     * 获取收支明细列表
     * 分销商ID、当前页、分页条数
     *
     * @return
     */
    @RequestMapping("getIncomingList")
    @NeedLoginAction
    public Object getIncomingList(IncomingSearcher searcher) {
        searcher.setUserInfo(getUserInfo());
        setUserContext(searcher);
        //总条数、收支明细ID、状态、时间、金额
        PageSearchResult<IncomingSearcher, Incoming> result = financeService.getIncomingList(searcher);
        return result;
    }


    /**
     * 取所有银行和编号
     *
     * @return
     */
    @RequestMapping(value = "getAllBank")
    public Object getAllBank() {
        Map<Integer, String> result = financeService.getAllBank();
        return result;
    }


    /**
     * 绑定银行卡
     * 分销商ID、真实姓名、身份证号、银行卡号、开户行
     *
     * @return
     */
    @RequestMapping(value = "bindBankCard", method = RequestMethod.POST)
    @NeedLoginAction
    public Object bindBankCard(@RequestBody BankCardInfo bankCardInfo) {
    	logger.info("bindBankCard===="+bankCardInfo.toString());
        bankCardInfo.setUserInfo(getUserInfo());
        //返回设置成功绑定的提现账户信息s
        BankCardInfo result = financeService.bindBankCard(bankCardInfo);
        return result;
    }

    /**
     * 查询绑定银行的银行卡
     * 分销商ID、真实姓名、身份证号、银行卡号、开户行
     *
     * @return
     */
    @RequestMapping(value = "getBankCard")
    @NeedLoginAction
    public Object getBankCard() {
        UserInfo userInfo = getUserInfo();
        BankCardInfo result = financeService.getBankCard(userInfo.getSellerId());
        return result;
    }

    /**
     * 更换绑定银行卡
     * 分销商ID，真实姓名、身份证号、银行卡号、开户行
     *
     * @return
     */
    @RequestMapping(value = "changeBankCard", method = RequestMethod.POST)
    @NeedLoginAction
    public Object changeBankCard(@RequestBody BankCardInfo bankCardInfo) {
    	logger.info("changeBankCard===="+bankCardInfo.toString());
        bankCardInfo.setUserInfo(getUserInfo());
        setUserContext(bankCardInfo);
        //返回设置成功绑定的提现账户信息
        BankCardInfo result = financeService.changeBankCard(bankCardInfo);
        return result;
    }

    /**
     * 申请提现
     * 分销商ID，提现账户ID、提现金额
     *
     * @return
     */
    @RequestMapping(value = "applyCash", method = RequestMethod.POST)
    @NeedLoginAction
    public Object applyCash(@RequestBody CashApply apply) {
        apply.setUserInfo(getUserInfo());
        setUserContext(apply);
        //true or false?
        BooleanResult result = financeService.applyCash(apply);
        return result;
    }

    /**
     * 提现明细列表
     *
     * @param searcher
     * @return
     */
    @RequestMapping(value = "applyCashList")
    @NeedLoginAction
    public Object applyCashList(CashApplySearcher searcher) {
        searcher.setUserInfo(getUserInfo());
        setUserContext(searcher);
        CashApplyListResult result = financeService.applyCashList(searcher);
        return result;
    }


    /**
     * 获取可提现金额的设置
     * 分销商ID
     *
     * @return
     */
    @RequestMapping("getCashSetting")
    @NeedLoginAction
    public Object getCashSetting() {
        //可提现金额
        //这个是考虑用户在提现的时候，是否有提现上限的设置，一期可以在APP中写死，不用开发
        CashSetting result = financeService.getCashSetting(getUserInfo());
        return result;
    }

    /**
     * 是否可提现
     *
     * @return
     */
    @RequestMapping("canApplyCash")
    @NeedLoginAction
    public Object canApplyCash() {
        BooleanResult result = financeService.getCanApplyCash(getUserInfo());
        return result;
    }
}
