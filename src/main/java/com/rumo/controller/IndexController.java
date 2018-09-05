package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.rumo.bean.Blog;
import com.rumo.service.blog.IBlogService;

/**
 * 主页Controller
 * 
 * @author 11373
 *
 */
@Controller
public class IndexController {

	@Autowired
	private IBlogService service;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@ResponseBody
	@GetMapping("/blogs/{pageNo}/{pageSize}")
	public PageInfo<Blog> findBlogs(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize,
			@RequestParam(value = "k", required = false) String keyStr,
			@RequestParam(value = "s", required = false) String sort) {
		PageInfo<Blog> blogs = service.findBlogs(keyStr, sort, pageNo, pageSize);
		return blogs;
	}
}
