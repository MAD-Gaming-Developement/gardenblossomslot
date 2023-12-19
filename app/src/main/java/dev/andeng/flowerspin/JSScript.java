package dev.andeng.flowerspin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSScript {
    private final Context context;

    public JSScript(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void postMessage(String name, String data) {
        Map<String, Object> eventValue = new HashMap<>();
        if ("openWindow".equals(name)) {
            try {
                JSONObject extLink = new JSONObject(data); // Assuming the data is a JSON string
                Intent newWindow = new Intent(Intent.ACTION_VIEW);
                newWindow.setData(Uri.parse(extLink.getString("url")));
                newWindow.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(newWindow);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            eventValue.put(name, data);
        }
    }
}
