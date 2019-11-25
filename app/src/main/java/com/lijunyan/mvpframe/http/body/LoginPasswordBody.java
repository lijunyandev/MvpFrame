package com.lijunyan.mvpframe.http.body;

/**
 * Created by lijunyan on 2019-11-25
 */
public class LoginPasswordBody {
    /**
     * countryCode : 国家编码
     * phone : 手机号码
     * password : 密码
     */

    private String countryCode;
    private String phone;
    private String password;

    public LoginPasswordBody(String countryCode, String phone, String password) {
        this.countryCode = countryCode;
        this.phone = phone;
        this.password = password;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "LoginPasswordBody{" +
                "countryCode='" + countryCode + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
