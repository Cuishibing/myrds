package cui.shibing.rdsserver.biz.dabatase.domain;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.sql.DataSource;


@Getter
@Setter
public class RdsDatabaseInfo {

    private Long ctime;

    private String defaultDb;

    private String host;

    private Long id;

    private String name;

    private String password;

    private Integer port;

    private String userName;

    private Long utime;

    private Integer valid;

    public void createNew(String name, String host, int port, String userName, String password, String defaultDb) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;

        this.defaultDb = defaultDb;

        this.ctime = System.currentTimeMillis();
        this.utime = System.currentTimeMillis();

        this.valid = 1;
    }

    public void updateInfo(String name, String host, int port, String userName, String password, String defaultDb) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.defaultDb = defaultDb;

        this.utime = System.currentTimeMillis();
    }

    /**
     * 以当前数据库信息创建一个DataSource对象，如果创建失败返回null
     * @return DataSource对象
     */
    @SneakyThrows
    public DataSource createDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(String.format("jdbc:mysql://%s/%s", host, defaultDb));
        mysqlDataSource.setPort(port);
        mysqlDataSource.setUser(userName);
        mysqlDataSource.setPassword(password);
        mysqlDataSource.setAllowMultiQueries(true);
        return mysqlDataSource;
    }
}
