package cn.edu.jxnu.domain;


import java.util.Date;

/**
 * 实体类
 */
public class UserDomain {
    private long custId; //顾客的编号，系统自动编号
    private String custNo; //顾客名
    private String custPwd;
    private String email;
    private String custSex;
    private String custImg;
    private Date lastLogin;

    private String randomNum; //激活随机码

    private int state; //激活状态

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(String randomNum) {
        this.randomNum = randomNum;
    }



    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustPwd() {
        return custPwd;
    }

    public void setCustPwd(String custPwd) {
        this.custPwd = custPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex;
    }

    public String getCustImg() {
        return custImg;
    }

    public void setCustImg(String custImg) {
        this.custImg = custImg;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "custId=" + custId +
                ", custNo='" + custNo + '\'' +
                ", custPwd='" + custPwd + '\'' +
                ", email='" + email + '\'' +
                ", custSex='" + custSex + '\'' +
                ", custImg='" + custImg + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
