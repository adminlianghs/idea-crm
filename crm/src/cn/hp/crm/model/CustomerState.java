package cn.hp.crm.model;

/**
 * @author admin
 * 客户状态表
 */
public class CustomerState {
    private Integer customerStateId;
    private String customerStateName;
    private String customerStateDesc;
    private int status;
    private String remark;
    private String createTime;
    private int creater;
    private String updateTime;
    private int updater;

    public CustomerState(Integer customerStateId) {
        this.customerStateId = customerStateId;
    }

    public CustomerState(int updater) {
        this.updater = updater;
    }

    public CustomerState() {
        super();
    }

    public CustomerState(String customerStateName, String customerStateDesc, String remark) {
        this.customerStateName = customerStateName;
        this.customerStateDesc = customerStateDesc;
        this.remark = remark;
    }

    public CustomerState(Integer customerStateId, String customerStateName, String customerStateDesc, int status, String remark, String createTime, int creater, String updateTime, int updater) {
        this.customerStateId = customerStateId;
        this.customerStateName = customerStateName;
        this.customerStateDesc = customerStateDesc;
        this.status = status;
        this.remark = remark;
        this.createTime = createTime;
        this.creater = creater;
        this.updateTime = updateTime;
        this.updater = updater;
    }

    @Override
    public String toString() {
        return "CustomerState{" +
                "customerStateId=" + customerStateId +
                ", customerStateName='" + customerStateName + '\'' +
                ", customerStateDesc='" + customerStateDesc + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createTime='" + createTime + '\'' +
                ", creater=" + creater +
                ", updateTime='" + updateTime + '\'' +
                ", updater=" + updater +
                '}';
    }

    public Integer getCustomerStateId() {
        return customerStateId;
    }

    public void setCustomerStateId(Integer customerStateId) {
        this.customerStateId = customerStateId;
    }

    public String getCustomerStateName() {
        return customerStateName;
    }

    public void setCustomerStateName(String customerStateName) {
        this.customerStateName = customerStateName;
    }

    public String getCustomerStateDesc() {
        return customerStateDesc;
    }

    public void setCustomerStateDesc(String customerStateDesc) {
        this.customerStateDesc = customerStateDesc;
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
