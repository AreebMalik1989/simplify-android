package github.areebmalik1989.simplify_resources;

import android.app.Activity;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

/**
 * Util class to simplify using status bar
 */
public class SimplifyStatusBar {

    /**
     * Sets the color of status bar
     *
     * @param activity : Activity whose status bar color will be set
     * @param color : int value of color
     * @return
     */
    public static boolean setColor(Activity activity, int color){

        Window window = activity.getWindow();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(ContextCompat.getColor(activity, color));

            return true;
        }

        return false;
    }
}
