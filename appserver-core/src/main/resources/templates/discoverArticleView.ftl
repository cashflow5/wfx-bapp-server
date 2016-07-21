<!DOCTYPE html>
<html>

<head>
<#include "layouts/meta.ftl"/>
    <title>优购微店_关于优购微零售</title>
<#include "layouts/style.ftl"/>
</head>
<body>


<div class="viewport yg-cms-detail">
			<#--<header class="mui-bar yg-header header-ext">
				<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
				<h1 class="mui-title">详情${discoverArticle.title}</h1>
			</header>-->
			<div class="mui-content">
				<div class="cms-content">
					<div class="cms-title-box">
						<div class="cms-item">
						
							<strong>${discoverArticle.title}</strong>
							<p class="Gray">${discoverArticle.showTime}</p>
						</div>
						<div class="cms-item">
							<span class="recommend"><i class="iconfont"></i>
							      <#if discoverArticle.authorType==2 >
							                        推荐
							       <#else>
							                            官方
							       </#if>                 
							   </span>
							<#--<p>作者：${discoverArticle.authorAccount}</p>-->
						</div>
					</div>
					<#--<article class="cms-text-box">
					    
						盼望着，盼望着，东风来了，春天的脚步近了。 一切都像刚睡醒的样子，欣欣然张开了眼。山朗润起 来了，水涨起来了，太阳的脸红起来了
					</article>
					<a class="cms-shop-box" href="http://m.yougou.net">
						<div class="cms-item"><img src="static/images/imglist/user-logo.png" alt="" /></div>
						<div class="cms-item">
							<p>店铺编号xxxxxx</p>
							<p class="Gray">店铺公告店铺公告店铺公告店铺公告店铺公告店铺公告铺铺铺铺铺铺铺...</p>
						</div>
					</a>-->
					<#--<div class="cms-img-box">
						<img src="${discoverArticle.picCover}" onclick="void(0);" />
					</div>-->
					${discoverArticle.content}
					<#--<a class="cms-goods-box" href="http://m.yougou.net">
						<div class="cms-item"><img src="static/images/imglist/goods-img.png" alt="" /></div>
						<div class="cms-item">
							<p>百丽2016夏季专柜同款女凉鞋</p>
							<p class="Gray">百丽推崇“百变所以美丽”的精品 穿着概念......
							</p>
						</div>
					</a>
					<articale class="cms-text-box">
						草偷偷地从土地里钻出来，嫩嫩的，绿绿的。 园子里，田野里，瞧去，一大片一大片满是的。坐 着，躺着，打两个滚，踢几脚球，赛几趟跑，捉几 回迷藏。风轻俏俏的，草软绵绵的。
					</articale>-->
					<#if shopInfoDetail??>
					<#if discoverArticle.authorType==2>
					<a class="cms-shop-box" href="${shopInfoDetail.storeUrl!''}">
						<div class="cms-item"><img src="${shopInfoDetail.storeHeaderImg!''}" alt="" /></div>
						<div class="cms-item">
							<p>店铺编号:${shopInfoDetail.shopCode!''}</p>
							<p class="Gray"><#--店铺公告店铺公告店铺公告店铺公告店铺公告店铺公告铺铺铺铺铺铺铺...-->${shopInfoDetail.storeNotice!''}</p>
						</div>
					</a>
					</#if>
					</#if>
				</div>
			</div>
		</div>
<#include "layouts/corejs.ftl"/>
</body>
</html>