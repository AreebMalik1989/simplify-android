package github.areebmalik1989.simplify_about;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import github.areebmalik1989.simplify_resources.SimplifyBitmap;
import github.areebmalik1989.simplify_resources.SimplifyNavigationBar;
import github.areebmalik1989.simplify_resources.SimplifyPackage;
import github.areebmalik1989.simplify_resources.SimplifyStatusBar;

public class AboutActivity extends AppCompatActivity implements IAboutActivity{

    private Bundle bundle;

    private TextView version, versionCode, appName, developerName, developerEmail;
    private ImageView appIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        bundle = getIntent().getBundleExtra(BUNDLE);

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

        appIcon.setImageBitmap(SimplifyBitmap.bitmapFromByteArray(bundle.getByteArray(APP_ICON)));
        appName.setText(bundle.getString(APP_NAME));
        version.setText(bundle.getString(VERSION));
        versionCode.setText(bundle.getString(VERSION_CODE));
        developerName.setText(bundle.getString(DEVELOPER_NAME));
        developerEmail.setText(bundle.getString(DEVELOPER_EMAIL));

        SimplifyStatusBar.setColor(this, R.color.primaryDark);
        SimplifyNavigationBar.setColor(this, R.color.primaryDark);

    }
}
