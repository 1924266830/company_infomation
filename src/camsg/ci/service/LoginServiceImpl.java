package camsg.ci.service;

import javax.servlet.http.HttpServletRequest;

import camsg.ci.Constant.Constants;



public class LoginServiceImpl implements LoginService {

	@Override
	public boolean isNormalCode(HttpServletRequest request) {
		String code = request.getParameter("rand");
		System.out.println("code:"+code);
		if(code == null)
			return false;
		
		String nCode = (String)request.getSession().getAttribute(Constants.CHECK_NUMBER_NAME);
		
		System.out.println("ncode:"+nCode);
		if(nCode == null)
			return false;
		
		if(!nCode.equalsIgnoreCase(code)){
			return false;
		}
		return true;
	}

	@Override
	public boolean isNormalLogin(String uid, String pwd) {
		return true;
	}

}
