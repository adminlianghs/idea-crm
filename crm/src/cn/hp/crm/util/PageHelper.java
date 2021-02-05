package cn.hp.crm.util;

/**
 * 分页工具类
 */
public class PageHelper {
//    总记录数  总页数  每页条数  当前页  当前页的数据

//    分页 为了重新编写sql语句
    private int total ;     // 数据总数量
    private int totalPage ;  //总页数
    private int limit ;       // 每一页的数量
    private int page ;      // 当前是第几页
    private Object data ;   // 当前页的数据

    public int getTotalPage() {
        return totalPage;
    }
//      100条数据  每页10条  总页数： 10
    public void setTotalPage() {
        this.totalPage = total%limit > 0 ? total/limit +1 : total/limit; // 得到一个整数 100/10 = 10   102/10 = 10
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
