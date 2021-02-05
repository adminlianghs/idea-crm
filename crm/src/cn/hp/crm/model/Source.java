package cn.hp.crm.model;

public class Source {
    private Integer customerSourceId;
    private String customerSourceName;
    private String customerSourceDesc;
    private String status;
    private String remark;
    private String createTime;
    private Integer creater;
    private String updateTime;
    private Integer updater;

    public Source(Integer customerSourceId, String customerSourceName, String customerSourceDesc, String status, String remark, String createTime, Integer creater, String updateTime, Integer updater) {
        this.customerSourceId = customerSourceId;
        this.customerSourceName = customerSourceName;
        this.customerSourceDesc = customerSourceDesc;
        this.status = status;
        this.remark = remark;
        this.createTime = createTime;
        this.creater = creater;
        this.updateTime = updateTime;
        this.updater = updater;
    }

    public Source() {
        super();
    }

    public Source(Integer customerSourceId) {
        this.customerSourceId = customerSourceId;
    }
    public Source(String customerSourceName, String customerSourceDesc, String remark) {
        this.customerSourceName = customerSourceName;
        this.customerSourceDesc = customerSourceDesc;
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Source{" +
                "customerSourceId=" + customerSourceId +
                ", customerSourceName='" + customerSourceName + '\'' +
                ", customerSourceDesc='" + customerSourceDesc + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime='" + createTime + '\'' +
                ", creater=" + creater +
                ", updateTime='" + updateTime + '\'' +
                ", updater=" + updater +
                '}';
    }

    public Integer getCustomerSourceId() {
        return customerSourceId;
    }

    public void setCustomerSourceId(Integer customerSourceId) {
        this.customerSourceId = customerSourceId;
    }

    public String getCustomerSourceName() {
        return customerSourceName;
    }

    public void setCustomerSourceName(String customerSourceName) {
        this.customerSourceName = customerSourceName;
    }

    public String getCustomerSourceDesc() {
        return customerSourceDesc;
    }

    public void setCustomerSourceDesc(String customerSourceDesc) {
        this.customerSourceDesc = customerSourceDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdater() {
        return updater;
    }

    public void setUpdater(Integer updater) {
        this.updater = updater;
    }
}
