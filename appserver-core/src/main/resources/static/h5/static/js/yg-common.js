/**
 * create by guoran
 */
var YG_Common = (function($, M) {
	function Init() {
		Menu();
		NavBar();
		CheckboxRadio();
	}

	function Menu() {
		M('.yg-header').on('tap', '#btnMenu', function(e) {
			$('.yg-menu').toggle();
		});
	}

	function NavBar() {
		M('.yg-nav-bar').on('tap', '.yg-nav-bar-item', function(e) {
			e.preventDefault();
			var $this = $(this);
			$('body').scrollTop($($this.attr('href')).offset().top);
			$this.addClass('active').siblings().removeClass('active');
		});
	}

	function CheckboxRadio() {
		//mui checkbox radio bug
		$('.mui-checkbox, .mui-radio').on('focus', 'input', function() {
			this.blur();
		});
	}

	$(function() {
		Init();
	});

	return {};
}(Zepto, mui));