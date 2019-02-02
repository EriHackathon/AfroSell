package erihackton.com.aelaf.erishopclient;

/**
 * Created by aelaf on 1/29/19.
 */

public abstract class UseCase<Q extends UseCase.RequestValues,P extends UseCase.ResponseValue> {
    private Q mRequestValues;
    private UseCaseCallback<P> mUseCaseCallback;

    public Q getmRequestValues() {
        return mRequestValues;
    }

    public void setmRequestValues(Q mRequestValues) {
        this.mRequestValues = mRequestValues;
    }

    public UseCaseCallback<P> getmUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setmUseCaseCallback(UseCaseCallback<P> mUseCaseCallback) {
        this.mUseCaseCallback = mUseCaseCallback;
    }
    void run() {
        executeUseCase(mRequestValues);
    }

    protected abstract void executeUseCase(Q requestValues);
    public interface RequestValues{

    }
    public interface ResponseValue{

    }
    public interface  UseCaseCallback<R>{
        void onSucess(R response);
        void onError();
    }
}
