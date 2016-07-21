package com.yougou.wfx.appserver.vo.supply;

import java.io.Serializable;

import com.yougou.wfx.appserver.vo.BaseVo;

/**
 * Created by lizhw on 2016/4/12.
 */
public class CategoryBrandInfo extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private String categoryId;
	/**
	 * 父分类ID
	 */
	private String parentCategoryId;

	/**
	 * 分类名称
	 */
	private String categoryName;
	/**
	 * 分类级别,1:一级分类，2:二级分类，3:叶子分类
	 */
	private String level;

	/**
	 * 品牌ID
	 */
	private String brandId;
	/**
	 * 品牌名称
	 */
	private String brandName;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
