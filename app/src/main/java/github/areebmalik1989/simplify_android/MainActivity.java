package github.areebmalik1989.simplify_android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import github.areebmalik1989.simplify_about.AboutActivityManager;

public class MainActivity extends AppCompatActivity {

    Button simplifyAboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simplifyAboutButton = findViewById(R.id.simplify_about_button);
        simplifyAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                AboutActivityManager aboutActivityManager = new AboutActivityManager(MainActivity.this);
                aboutActivityManager.startActivity("AppName", "Version", "VersionCode",
                        "DeveloperName", "DeveloperEmail", bitmap);
            }
        });
    }
}
