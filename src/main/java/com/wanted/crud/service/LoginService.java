package com.wanted.crud.service;
import com.wanted.crud.dao.LoginDAO;
public class LoginService {

    LoginDAO loginDAO = new LoginDAO();


    public boolean isValidUser(String userId, String userPwd) {
        // null 방지를 위해 상수를 앞에 두고 .equals() 사용
        // 아마 실제로는 userId 와 userPwd 를 DAO까지 전달하여 null값인지아닌지 확인할듯.
        if (loginDAO.admin.equals(userId) && loginDAO.adminPwd.equals(userPwd)) {
            return true;
        }

        if (loginDAO.user.equals(userId) && loginDAO.userPwd.equals(userPwd)) {
            return true;
        }

        // 조건에 맞지 않으면 로그인 실패
        return false;
    }
}
