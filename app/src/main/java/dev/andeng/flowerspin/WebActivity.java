package dev.andeng.flowerspin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class WebActivity extends AppCompatActivity {

    SharedPreferences MyPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        MyPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        GlobalWebSetting webApp = findViewById(R.id.webApp);
        webApp.addJavascriptInterface(new JSScript(this), "jsBridge");
        webApp.loadUrl(MyPrefs.getString("gameURL", ""));
    }
}