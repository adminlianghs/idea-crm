package cn.hp.crm.model;

import java.sql.Timestamp;

/**
 * 客户模型类  codota
 */
public class Customer {
    private String customerId;
    private int customerStateId;
    private String customerStateName;
    private int customerSourceId;
    private String customerSourceName;
    private int customerCategoryId;
    private String customerCategoryName;
    private int userId;
    private String username;
    private String customerName;
    private byte customerIsMale;
    private String customerMobile;
    private String customerQq;
    private String customerAddress;
    private String customerEmail;
    private String customerRemark;
    private String customerPosition;
    private String customerBlog;
    private String customerTel;
    private Timestamp customerBirth;
    private String birth;
    private String customerCompany;
    private byte status;
    private String remark;
    private Timestamp createTime;
    private int creater;
    private Timestamp updateTime;
    private int updater;

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Customer(String username, String customerName, String customerMobile, String customerAddress,
                    String customerPosition, Timestamp customerBirth, String customerCompany) {
        this.username = username;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerAddress = customerAddress;
        this.customerPosition = customerPosition;
        this.customerBirth = customerBirth;
        this.customerCompany = customerCompany;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerStateId=" + customerStateId +
                ", customerStateName='" + customerStateName + '\'' +
                ", customerSourceId=" + customerSourceId +
                ", customerSourceName='" + customerSourceName + '\'' +
                ", customerCategoryId=" + customerCategoryId +
                ", customerCategoryName='" + customerCategoryName + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerIsMale=" + customerIsMale +
                ", customerMobile='" + customerMobile + '\'' +
                ", customerQq='" + customerQq + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerRemark='" + customerRemark + '\'' +
                ", customerPosition='" + customerPosition + '\'' +
                ", customerBlog='" + customerBlog + '\'' +
                ", customerTel='" + customerTel + '\'' +
                ", customerBirth=" + customerBirth +
                ", birth='" + birth + '\'' +
                ", customerCompany='" + customerCompany + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", creater=" + creater +
                ", updateTime=" + updateTime +
                ", updater=" + updater +
                '}';
    }

    public Customer(String customerName, String address, String birth, String company, String phone, String position,
                    int customerCategoryId, int customerSourceId, int customerStateId, int userId) {
        this.customerName = customerName;
        this.customerAddress = address;
        this.birth = birth;
        this.customerCompany = company;
        this.customerMobile = phone;
        this.customerPosition = position;
        this.customerCategoryId = customerCategoryId;
        this.customerSourceId = customerSourceId;
        this.customerStateId = customerStateId;
        this.userId = userId;
    }

    public String getCustomerCategoryName() {
        return customerCategoryName;
    }

    public void setCustomerCategoryName(String customerCategoryName) {
        this.customerCategoryName = customerCategoryName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getCustomerStateId() {
        return customerStateId;
    }

    public void setCustomerStateId(int customerStateId) {
        this.customerStateId = customerStateId;
    }

    public String getCustomerStateName() {
        return customerStateName;
    }

    public void setCustomerStateName(String customerStateName) {
        this.customerStateName = customerStateName;
    }

    public int getCustomerSourceId() {
        return customerSourceId;
    }

    public void setCustomerSourceId(int customerSourceId) {
        this.customerSourceId = customerSourceId;
    }

    public String getCustomerSourceName() {
        return customerSourceName;
    }

    public void setCustomerSourceName(String customerSourceName) {
        this.customerSourceName = customerSourceName;
    }

    public int getCustomerCategoryId() {
        return customerCategoryId;
    }

    public void setCustomerCategoryId(int customerCategoryId) {
        this.customerCategoryId = customerCategoryId;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public byte getCustomerIsMale() {
        return customerIsMale;
    }

    public void setCustomerIsMale(byte customerIsMale) {
        this.customerIsMale = customerIsMale;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerQq() {
        return customerQq;
    }

    public void setCustomerQq(String customerQq) {
        this.customerQq = customerQq;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    public String getCustomerPosition() {
        return customerPosition;
    }

    public void setCustomerPosition(String customerPosition) {
        this.customerPosition = customerPosition;
    }

    public String getCustomerBlog() {
        return customerBlog;
    }

    public void setCustomerBlog(String customerBlog) {
        this.customerBlog = customerBlog;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public Timestamp getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(Timestamp customerBirth) {
        this.customerBirth = customerBirth;
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
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
