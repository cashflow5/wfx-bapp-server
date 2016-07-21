<!DOCTYPE html>
<html>

<head>
<#include "layouts/meta.ftl"/>
    <title>优购微店_关于优购微零售</title>
<#include "layouts/style.ftl"/>
</head>

<body>
<div class="viewport">
    <header class="mui-bar yg-header header-ext">
        <#--<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>-->

        <h1 class="mui-title">更多设置</h1>
    </header>
<#include "layouts/menu.ftl"/>
    <div class="mui-content">
        <section class="border-top tcenter pt50 pb20">
            <img src="static/images/logo.png" />

            <p class="f18 pt10">优购微零售</p>
        </section>
        <section class="border-top bg-white">
            <ul class="mui-table-view">
                <li class="mui-table-view-cell ">
                    <a href="help.shtml">优购微零售新手指引</a>
                </li>
                <li class="mui-table-view-cell ">
                    <a href="platform-protocol.shtml">优购微零售会员注册协议</a>
                </li>
                <li class="mui-table-view-cell ">
                    <a href="#">当前版本1.0.1</a>
                </li>
            </ul>
        </section>
        <!--<section class="yg-box">
            <p>送至： 广东深圳市南山区南海大道1057号科技大厦二期A座601房</p>
        </section>-->
    </div>
</div>
<#include "layouts/corejs.ftl"/>

</body>

</html>