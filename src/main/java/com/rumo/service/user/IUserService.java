package com.rumo.service.user;

import com.rumo.vo.ServerResponse2;

public interface IUserService {

	public ServerResponse2 getLogin(String account,String password);
}
