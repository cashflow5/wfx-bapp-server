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
				<h1 class="mui-title">发现</h1>
			</header>
			<div class="mui-content">
				<#include "layouts/discover-menu.ftl"/>
				<div class="mui-slider mt10">
					<div class="mui-slider-group">
						<div class="mui-slider-item">
							<a href="#"><img src="static/images/imglist/slider1.png" alt="" /></a>
						</div>
						<div class="mui-slider-item">
							<a href="#"><img src="static/images/imglist/slider1.png" alt="" /></a>
						</div>
						<div class="mui-slider-item">
							<a href="#"><img src="static/images/imglist/slider1.png" alt="" /></a>
						</div>
						<div class="mui-slider-item">
							<a href="#"><img src="static/images/imglist/slider1.png" alt="" /></a>
						</div>
					</div>
					<div class="mui-slider-indicator">
						<div class="mui-indicator mui-active"></div>
						<div class="mui-indicator"></div>
						<div class="mui-indicator"></div>
						<div class="mui-indicator"></div>
					</div>
				</div>
				<section class="yg-cms-column-2-floor mt10">
					<a class="cms-column-item">
						<img src="static/images/imglist/block-1-0.png" alt="" />
						<p><span class="Red">[她他女鞋] </span>我的试穿之旅</p>
					</a>
					<a class="cms-column-item">
						<img src="static/images/imglist/block-1-1.png" alt="" />
						<p><span class="Red">[她他女鞋] </span>我的试穿之旅</p>
					</a>
				</section>
				<a class="yg-cms-column-1-floor mt10">
					<div class="cms-column-item">
						<img src="static/images/imglist/block-2-0.png" alt="" />
					</div>
					<div class="cms-column-item">
						<p><span class="Red">[百丽女鞋] </span>我的试穿之旅</p>
						<p class="date-item">2016年05月26日</p>
					</div>
				</a>
			</div>
		</div>
<#include "layouts/corejs.ftl"/>
</body>
</html>