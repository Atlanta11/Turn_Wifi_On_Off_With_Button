package enterprise.sample.com.turn_wifi_on_off_with_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Switch WiFiButton;
    TextView textview;
    WifiManager wifimanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView)findViewById(R.id.textView1);

        WiFiButton = (Switch)findViewById(R.id.switch1);

        WiFiButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub

                if(isChecked)
                {
                    textview.setText("WiFi ON");

                    EnableWiFi() ;

                }
                else {
                    textview.setText("WiFi OFF");

                    DisableWiFi();

                }
            }
        });
    }

    public void EnableWiFi(){

        wifimanager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifimanager.setWifiEnabled(true);

    }

    public void DisableWiFi(){

        wifimanager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifimanager.setWifiEnabled(false);

    }

}
