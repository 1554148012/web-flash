package cn.enilu.flash.api.controller.bussiness;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.entity.bussiness.ShopGoodsCategory;
import cn.enilu.flash.service.bussiness.ShopGoodsCategoryService;

import cn.enilu.flash.bean.core.BussinessLog;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.enumeration.BizExceptionEnum;
import cn.enilu.flash.bean.exception.ApplicationException;
import cn.enilu.flash.bean.vo.front.Rets;

import cn.enilu.flash.utils.factory.Page;


import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/goods/category")
public class ShopGoodsCategoryController extends BaseController {
	private  Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ShopGoodsCategoryService shopGoodsCategoryService;

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@RequiresPermissions(value = "/goods/category")
	public Object list(@RequestParam(required = false) String id) {
		Page<ShopGoodsCategory> page = new PageFactory<ShopGoodsCategory>().defaultPage();
		page.addFilter("id",id);
		page = shopGoodsCategoryService.queryPage(page);
		return Rets.success(page);
	}
	@RequestMapping(method = RequestMethod.POST)
	@BussinessLog(value = "新增分类", key = "name")
	@RequiresPermissions(value = "/goods/category/add")
	public Object add(@ModelAttribute ShopGoodsCategory shopGoodsCategory){
		shopGoodsCategoryService.insert(shopGoodsCategory);
		return Rets.success();
	}
	@RequestMapping(method = RequestMethod.PUT)
	@BussinessLog(value = "更新分类", key = "name")
	@RequiresPermissions(value = "/goods/category/update")
	public Object update(@ModelAttribute ShopGoodsCategory shopGoodsCategory){
		shopGoodsCategoryService.update(shopGoodsCategory);
		return Rets.success();
	}
	@RequestMapping(method = RequestMethod.DELETE)
	@BussinessLog(value = "删除分类", key = "id")
	@RequiresPermissions(value = "/goods/category/delete")
	public Object remove(Long id){
		if (id == null) {
			throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
		}
		shopGoodsCategoryService.delete(id);
		return Rets.success();
	}
}