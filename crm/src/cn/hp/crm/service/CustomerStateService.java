package cn.hp.crm.service;

import cn.hp.crm.model.CustomerState;
import cn.hp.crm.util.PageHelper;
import cn.hp.crm.util.ResultData;

public interface CustomerStateService {

    PageHelper list(String page, String limit ,CustomerState customerState);

    ResultData add(CustomerState customerState);

    ResultData edit(CustomerState customerState);

    ResultData delete(CustomerState customerState);
}
