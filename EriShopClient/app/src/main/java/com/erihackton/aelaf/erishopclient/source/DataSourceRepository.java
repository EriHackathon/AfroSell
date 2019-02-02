package erihackton.com.aelaf.erishopclient.source;

import javax.sql.*;

/**
 * Created by aelaf on 1/29/19.
 */

public class DataSourceRepository implements DataSource {
    static DataSourceRepository dataSourceRepository;
    public static DataSourceRepository getInstance(){
        if(dataSourceRepository==null)
            dataSourceRepository = new DataSourceRepository();
        return dataSourceRepository;
    }
    private DataSourceRepository(){

    }

    @Override
    public void getAuthenticUser(String name, String password, getAuthenticUserCallBack getAuthenticUserCallBack) {

    }
}
