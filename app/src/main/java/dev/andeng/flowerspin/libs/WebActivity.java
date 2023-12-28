package dev.andeng.flowerspin.libs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import dev.andeng.flowerspin.GlobalWebSetting;
import dev.andeng.flowerspin.R;

public class WebActivity extends AppCompatActivity {
    SharedPreferences MyPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        MyPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        GlobalWebSetting webApp = findViewById(R.id.webApp);
        webApp.addJavascriptInterface(new JSScript(this), "jsBridge");
        new Handler(Looper.getMainLooper()).postDelayed(() ->
                webApp.loadUrl(MyPrefs.getString("gameURL", ""))
                ,1000);
    }
}