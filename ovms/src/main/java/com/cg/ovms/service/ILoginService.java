package com.cg.ovms.service;

import java.util.Map;

import com.cg.ovms.entities.Login;
import com.cg.ovms.exception.LoginException;

//import com.cg.salon.entity.Login;
//import com.cg.salon.exceptions.LoginException;

/*
 * Created By Titas Sarkar
 */
public interface ILoginService {

	public Login doLogin(Integer userId, String password) throws LoginException;

	public String encryptString(String str);

	public String decryptString(String str);

	public String encryptLogin(Login loginAcnt);

	public String generateToken(Login login);

	public Map<String, Login> getAuthMap();

	public boolean verifyLogin(String tokenId) throws LoginException;
}
