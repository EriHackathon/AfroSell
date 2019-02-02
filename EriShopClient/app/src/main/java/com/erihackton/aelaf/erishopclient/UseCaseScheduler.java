package erihackton.com.aelaf.erishopclient;

/**
 * Created by aelaf on 1/29/19.
 */

public interface UseCaseScheduler {
    void execute(Runnable runnable);
    <V extends UseCase.ResponseValue> void notifyResponse(final V Response, final UseCase.UseCaseCallback<V> callback);
    <V extends UseCase.ResponseValue> void onError(final UseCase.UseCaseCallback<V> callback);

}
