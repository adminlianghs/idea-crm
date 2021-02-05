package cn.hp.crm.util;

// 少了jar包

import com.alibaba.druid.pool.DruidDataSource;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
//      c3p0连接池类
//    private static ComboPooledDataSource dataSource = null;
//      druid连接池类
    private static DruidDataSource dataSource = null ;

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultset = null;

    /**
     * 初始化配置
     */
    static{
        try {
            dataSource = new DruidDataSource();
//            获取本地文件 需要使用 io流
//            I input 输入  O output 输出   流    输入输出流( 从数据传输方向进行区分 )
    //            入：相对于程序( 内存中 )而言 硬盘 --> 内存  InputStream  Read
    //            出：相对于程序而言 内存中 --> 硬盘中  OutputStream Writer
//            电脑中数据保存 ： 二进制 字节
//            按照数据类型   字节流 InputStream OutputStream  可以是任意类型的数据   word mp3 mp4 jpg png
//                          字符流  Read Writer  专门针对字符串数据进行数据  纯文本数据  txt java html xml
//          按照处理方式：
//                  处理流：    直接对数据文件进行操作     FileInputStream
//                  包装流：    通过处理流进行操作数据  BufferedInputStream

//            ClassLoader 类加载器 用来找到class文件在哪的 JVM
//            InputStream in = DBUtil.class.getClassLoader().getSystemResourceAsStream("db.properties");
//            创建 properties文件类  可以将 properties文件中的key-value 进行绑定
//            Properties properties = new Properties();
//            properties.load(in);

//           dataSource.setDriverClassName( properties.getProperty("driver"));
//           dataSource.setUrl(properties.getProperty("url"));
//           dataSource.setUsername(properties.getProperty("user"));
//           dataSource.setPassword(properties.getProperty("password"));

//            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//            dataSource.setUrl("jdbc:mysql://localhost:3306/hp_crm?useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
//           dataSource.setUsername("root");
//           dataSource.setPassword("root");
//           connection = dataSource.getConnection();
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm?relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&useSSL=false&characterEncoding=utf8&serverTimezone=UTC","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param sql sql语句
     * @param obj Object数组存储占位符内容
     * @return 影响的数据条数
     * 添加、修改、删除一条或多条数据
     */
    public static int update(String sql, Object [] obj){
        int update = 0;
        try {
            //获取连接
//            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if(obj.length > 0){
                for(int i = 0; i<obj.length; i++) {
                    preparedStatement.setObject(i+1,obj[i]);
                }
            }
            update = preparedStatement.executeUpdate();
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            close();
        }
        return update;
    }

    /**
     * @param sql sql语句
     * @param obj 条件数组
     * @return 查询到的数据结果集
     * 根据条件查询一条数据
     */
    public static ResultSet select(String sql,Object [] obj){
        try {
//            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if(obj.length > 0){
                for(int i = 0; i<obj.length; i++) {
                    preparedStatement.setObject(i+1,obj[i]);
                }
            }
            resultset = preparedStatement.executeQuery();
            return resultset;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     */
    public static void close(){
        try{
            if(resultset != null){
                resultset.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

