package kamau.mobile.shutdown;

import android.app.Dialog;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button ShutDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShutDown = (Button)findViewById(R.id.btn_shut_down);

        ShutDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Process process = Runtime.getRuntime().exec(new String[] {"su", "-c", "input keyevent 26"});
                    Toast.makeText(getApplicationContext(), "Worked!!",Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_SHORT).show();
                    Log.e("ERROR!!!", e.toString());
                    e.printStackTrace();
                }
            }

        });
    }


}
