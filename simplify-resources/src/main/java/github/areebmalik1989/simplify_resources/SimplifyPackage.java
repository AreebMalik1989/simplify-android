package github.areebmalik1989.simplify_resources;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Util for package
 */
public class SimplifyPackage {

    /**
     * Gets instance of PackageInfo
     *
     * @param context
     * @return
     */
    public static PackageInfo getPackageInfo(Context context){

        PackageInfo packageInfo = null;

        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return packageInfo;
    }
}
