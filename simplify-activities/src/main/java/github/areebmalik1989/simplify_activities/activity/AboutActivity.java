package github.areebmalik1989.simplify_activities.activity;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import github.areebmalik1989.simplify_activities.R;
import github.areebmalik1989.simplify_activities.activity.iActivity.IAboutActivity;
import github.areebmalik1989.simplify_resources.SimplifyBitmap;
import github.areebmalik1989.simplify_resources.SimplifyNavigationBar;
import github.areebmalik1989.simplify_resources.SimplifyStatusBar;

public class AboutActivity extends AppCompatActivity implements IAboutActivity {

    private Bundle bundle;
    private Handler handler;
    private Bitmap appIconBitmap;

    private TextView version, versionCode, appName, developerName, developerEmail;
    private ImageView appIcon;

    private String versionString, versionCodeString, appNameString, developerNameString, developerEmailString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        handler = new Handler();

        appIcon = findViewById(R.id.about_app_icon);
        appName = findViewById(R.id.about_app_name);
        version = findViewById(R.id.info_version);
        versionCode = findViewById(R.id.info_version_code);
        developerName = findViewById(R.id.about_developer_name);
        developerEmail = findViewById(R.id.about_developer_email);

        setupView();
    }

    @Override
    public void setupView() {

        new Thread(() -> {

            bundle = getIntent().getBundleExtra(BUNDLE);

            appNameString = bundle.getString(APP_NAME);
            versionString = bundle.getString(VERSION);
            versionCodeString = bundle.getString(VERSION_CODE);
            developerNameString = bundle.getString(DEVELOPER_NAME);
            developerEmailString = bundle.getString(DEVELOPER_EMAIL);

            appIconBitmap = SimplifyBitmap.bitmapFromByteArray(bundle.getByteArray(APP_ICON));

            handler.post(setupUI);

        }).start();
    }

    Runnable setupUI = () -> {

        appName.setText(appNameString);
        version.setText(versionString);
        versionCode.setText(versionCodeString);
        developerName.setText(developerNameString);
        developerEmail.setText(developerEmailString);
        appIcon.setImageBitmap(appIconBitmap);

        SimplifyStatusBar.setColor(AboutActivity.this, R.color.primaryDark);
        SimplifyNavigationBar.setColor(AboutActivity.this, R.color.primaryDark);
    };
}
