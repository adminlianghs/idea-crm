package cn.hp.crm.model;

import java.sql.Timestamp;

// lombok 自动生成setter getter方法
public class User {
    private int userId ;
    private String username ;
    private  String password;
//    管理员
    private  byte isAdmin;
//    系统管理员
    private  byte isSystem;
    private int departmentId;
    private int roleId;
    private byte  isMale;
    private String mobile;
    private String  address;
    private int age;
    private String  tel;
    private String  idNum;
    private  String  email;
    private String  qq;
    private String  hobby;
//    学历
    private byte  education;
    private String  cardNum;
//    名族
    private String  nation;
    private byte  marry;
    private byte   status;
    private String remark;
    private Timestamp createTime;
    private int  creater;
    private Timestamp  updateTime;
    private int  updater;
    private String userImg ;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isSystem=" + isSystem +
                ", departmentId=" + departmentId +
                ", roleId=" + roleId +
                ", isMale=" + isMale +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", idNum='" + idNum + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", hobby='" + hobby + '\'' +
                ", education=" + education +
                ", cardNum='" + cardNum + '\'' +
                ", nation='" + nation + '\'' +
                ", marry=" + marry +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", creater=" + creater +
                ", updateTime=" + updateTime +
                ", updater=" + updater +
                ", userImg='" + userImg + '\'' +
                '}';
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    public byte getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(byte isSystem) {
        this.isSystem = isSystem;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public byte getIsMale() {
        return isMale;
    }

    public void setIsMale(byte isMale) {
        this.isMale = isMale;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public byte getEducation() {
        return education;
    }

    public void setEducation(byte education) {
        this.education = education;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public byte getMarry() {
        return marry;
    }

    public void setMarry(byte marry) {
        this.marry = marry;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getCreater() {
        return creater;
    }

    public void setCreater(int creater) {
        this.creater = creater;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }
}
