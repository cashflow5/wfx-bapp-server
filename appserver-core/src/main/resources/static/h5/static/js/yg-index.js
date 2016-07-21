var YG_Index = (function($, M) {
	function Init() {
		InfoExt();
		LazyImage();
		LinkJump();
	}

	function InfoExt() {
		M('.yg-shop-infos').on('tap', '.yg-shop-info-detail-ext', function(e) {
			var $this = $(this),
				isext = $this.data('infoExt');
			if (!isext) {
				$('.yg-shop-info-detail').css('height', 'auto');
				$this.data('infoExt', true).addClass('on-ext');
			} else {
				$('.yg-shop-info-detail').css('height', 20);
				$this.data('infoExt', false).removeClass('on-ext');
			}
		});
	}
	
	function LinkJump(){
		M('#indexMenu').on('tap', '.mui-tab-item', function(e) {
			location.href = $(this).attr('href');
		});
		M('.yg-header').on('tap','#myList',function(){
			location.href = "orders.shtml";
		});
	}
	
	function LazyImage() {
		M('.yg-floor').imageLazyload({
			placeholder: 'static/images/thum.png'
		});
	}

	$(function() {
		Init();
	});

	return {};
}(Zepto, mui));