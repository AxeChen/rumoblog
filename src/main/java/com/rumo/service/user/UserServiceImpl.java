package com.rumo.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumo.bean.User;
import com.rumo.mapper.UserMapper;
import com.rumo.util.StringUtils;
import com.rumo.vo.ResponseCode;
import com.rumo.vo.ServerResponse2;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 登录注册 验证账号密码是否存在
	 */
	@Override
	public ServerResponse2 getLogin(String account, String password) {
		
		if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
			return ServerResponse2.createByErrorCodeMessage(ResponseCode.ERROR_LOGIN.getCode(), "请输入账号或者密码");
		}
		
		// 2、再执行sql
		User user = userMapper.selectLogin(account, password);
		
		// 不存在的用户，就返回用户不存在
		if (user == null) {
			return ServerResponse2.createByErrorCodeMessage(ResponseCode.ERROR_LOGIN.getCode(), ResponseCode.ERROR_LOGIN.getDesc());
		}
		// 成功则返回正确
		return ServerResponse2.createBySuccess(user);
	}

}
