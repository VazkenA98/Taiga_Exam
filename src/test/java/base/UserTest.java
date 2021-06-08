package base;

import helper.ApiHelper;

public class UserTest extends BaseTest{

    protected void login(String username, String password){
        ApiHelper.login(username,password);
    }
}
