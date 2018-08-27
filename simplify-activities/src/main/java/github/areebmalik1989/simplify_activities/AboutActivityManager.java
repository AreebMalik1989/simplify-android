package github.areebmalik1989.simplify_activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import github.areebmalik1989.simplify_activities.activity.iActivity.IAboutActivity;
import github.areebmalik1989.simplify_activities.activity.AboutActivity;
import github.areebmalik1989.simplify_resources.SimplifyBitmap;

public class AboutActivityManager {

    Context context;

    public AboutActivityManager(Context context){
        this.context = context;
    }

    public void startActivity(String appName, String version, String versionCode,
                              String developerName, String developerEmail, Bitmap appIcon){

        Bundle bundle = new Bundle();
        bundle.putString(IAboutActivity.APP_NAME, appName);
        bundle.putString(IAboutActivity.VERSION, version);
        bundle.putString(IAboutActivity.VERSION_CODE, versionCode);
        bundle.putString(IAboutActivity.DEVELOPER_NAME, developerName);
        bundle.putString(IAboutActivity.DEVELOPER_EMAIL, developerEmail);
        bundle.putByteArray(IAboutActivity.APP_ICON, SimplifyBitmap.bytesFromBitmap(appIcon));

        Intent intent = new Intent(context, AboutActivity.class);
        intent.putExtra(IAboutActivity.BUNDLE, bundle);

        context.startActivity(intent);
    }
}
