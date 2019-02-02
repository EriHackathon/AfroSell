package erihackton.com.aelaf.erishopclient;

/**
 * Created by aelaf on 1/29/19.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
