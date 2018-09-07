package com.rumo.service.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.bean.Blog;
import com.rumo.bean.BlogExample;
import com.rumo.bean.BlogExample.Criteria;
import com.rumo.mapper.BlogMapper;
import com.rumo.util.StringUtils;

@Service
public class BlogServiceImpl implements IBlogService {

	@Autowired
	private BlogMapper blogMapper;

	@Override
	public PageInfo<Blog> findBlogs(String keyStr, String sortDesc, int pageNo, int pageSize) {
		// 1：创建查询的参数条件类
		PageHelper.startPage(pageNo, pageSize);
		BlogExample blogExample = new BlogExample();

		if(!StringUtils.isEmpty(keyStr)) {
			// 2:创建查询条件
			Criteria criteria = blogExample.createCriteria();
			criteria.andNameLike("%" + keyStr + "%");
		}
		blogExample.setOrderByClause(sortDesc == null ? "create_time" : sortDesc);
		
		List<Blog> blogs = blogMapper.selectByExampleWithBLOBs(blogExample);
		// 3：设置排序
		// 4：设置分页
		PageInfo<Blog> pageInfo = new PageInfo<>(blogs);

		return pageInfo;
	}

}
