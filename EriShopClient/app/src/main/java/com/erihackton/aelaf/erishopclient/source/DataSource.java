package erihackton.com.aelaf.erishopclient.source;

/**
 * Created by aelaf on 1/29/19.
 */

public interface DataSource {
    interface getAuthenticUserCallBack{
        void onSuccess(String result);
        void onError(String err);
    }
    void getAuthenticUser(String name, String password,getAuthenticUserCallBack getAuthenticUserCallBack);
}
