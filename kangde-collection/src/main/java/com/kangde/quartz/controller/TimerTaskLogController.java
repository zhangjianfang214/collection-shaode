package com.kangde.quartz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kangde.commons.vo.ParamCondition;
import com.kangde.commons.vo.SearchResult;
import com.kangde.commons.web.controller.AbstractController;
import com.kangde.quartz.model.TimerTaskLogModel;

/**
 * 定时任务日志 Controller
 * @author lisuo
 *
 */
@Controller
@RequestMapping("sys/timerTaskLog")
public class TimerTaskLogController extends AbstractController<TimerTaskLogModel,String>{
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		return super.pageIndex();
	}

	//首页页面,转发到getBaseName/index
	@RequestMapping(value = PAGE_INDEX, method = RequestMethod.GET)
	@Override
	public ModelAndView pageIndex() {
		return super.pageIndex();
	}
	

	//展示页面,转发到getBaseName/show
	@RequestMapping(value = PAGE_SHOW+"/{id}")
	@Override
	public ModelAndView pageShow(@PathVariable("id") String id) {
		TimerTaskLogModel model = super.findById(id);
		ModelAndView view = super.pageShow(id);
		view.addObject("model",model);
		return view;
	}
	
	/**
	 * 带分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = QUERY_PAGE, method = RequestMethod.GET)
	public SearchResult<TimerTaskLogModel> queryForPage() {
		ParamCondition condition = parseCondition("*");
		return super.queryForPage(condition);
	}
	
	@Override
	protected String getBaseName() {
		return "sys/timerTaskLog/";
	}
}
