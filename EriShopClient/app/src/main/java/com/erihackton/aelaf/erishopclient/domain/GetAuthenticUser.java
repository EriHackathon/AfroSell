package erihackton.com.aelaf.erishopclient.domain;

import erihackton.com.aelaf.erishopclient.UseCase;
import erihackton.com.aelaf.erishopclient.source.DataSourceRepository;

/**
 * Created by aelaf on 1/29/19.
 */

public class GetAuthenticUser extends UseCase<GetAuthenticUser.RequestValues,GetAuthenticUser.ResponseValues> {

    private DataSourceRepository dataSourceRepository;

    public GetAuthenticUser() {

        dataSourceRepository = DataSourceRepository.getInstance();

    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {

    }

    public static class RequestValues implements UseCase.RequestValues{
        private String name;
        private String password;

        public RequestValues(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
    }

    public class ResponseValues implements UseCase.ResponseValue{

    }
}
