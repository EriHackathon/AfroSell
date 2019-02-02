package erihackton.com.aelaf.erishopclient;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by aelaf on 1/29/19.
 */

public class ActivityUtil {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {


        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);

        transaction.commit();
    }

}
