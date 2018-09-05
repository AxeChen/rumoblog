package com.rumo.service.blog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.rumo.bean.Blog;

public interface IBlogService {

	public PageInfo<Blog> findBlogs(String keyStr,String sortDesc,int pageNo,int pageSize);
}
