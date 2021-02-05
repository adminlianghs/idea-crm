package cn.hp.crm.model;

/**
 * @author admin
 * 客户分类表 customer_category
 */
public class CustomerCategory {
    private int customerCategoryId;
    private String customerCategoryName;
    private String customerCategoryDesc;
    private int status;
    private String remark;
    private String createTime;
    private int creater;
    private String updateTime;
    private int updater;

    public CustomerCategory(String customerCategoryName) {
        this.customerCategoryName = customerCategoryName;
    }
    

    public CustomerCategory(int customerCategoryId) {
        this.customerCategoryId = customerCategoryId;
    }

    public CustomerCategory() {
    }

    public CustomerCategory(int customerCategoryId, String customerCategoryName, String customerCategoryDesc, int status, String remark, String createTime, int creater, String updateTime, int updater) {
        this.customerCategoryId = customerCategoryId;
        this.customerCategoryName = customerCategoryName;
        this.customerCategoryDesc = customerCategoryDesc;
        this.status = status;
        this.remark = remark;
        this.createTime = createTime;
        this.creater = creater;
        this.updateTime = updateTime;
        this.updater = updater;
    }

    public CustomerCategory(String customerCategoryName, String customerCategoryDesc, String remark) {
        this.customerCategoryName = customerCategoryName;
        this.customerCategoryDesc = customerCategoryDesc;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "customerCategory{" +
                "customerCategoryId=" + customerCategoryId +
                ", customerCategoryName='" + customerCategoryName + '\'' +
                ", customerCategoryDesc='" + customerCategoryDesc + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createTime='" + createTime + '\'' +
                ", creater=" + creater +
                ", updateTime='" + updateTime + '\'' +
                ", updater=" + updater +
                '}';
    }

    public int getCustomerCategoryId() {
        return customerCategoryId;
    }

    public void setCustomerCategoryId(int customerCategoryId) {
        this.customerCategoryId = customerCategoryId;
    }

    public String getCustomerCategoryName() {
        return customerCategoryName;
    }

    public void setCustomerCategoryName(String customerCategoryName) {
        this.customerCategoryName = customerCategoryName;
    }

    public String getCustomerCategoryDesc() {
        return customerCategoryDesc;
    }

    public void setCustomerCategoryDesc(String customerCategoryDesc) {
        this.customerCategoryDesc = customerCategoryDesc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getCreater() {
        return creater;
    }

    public void setCreater(int creater) {
        this.creater = creater;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }
}
