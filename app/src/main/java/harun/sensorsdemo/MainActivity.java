package harun.sensorsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void demoActivity(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.btn_acc:
                i = new Intent(this, AcceleratorActivity.class);
                startActivity(i);
                break;
            case R.id.btn_magnetic:
                i = new Intent(this, MagneticActivity.class);
                startActivity(i);
                break;
            case R.id.btn_temp:
                i = new Intent(this, LightActivity.class);
                startActivity(i);
                break;
            case R.id.btn_location:
                Log.e("act", "Location");
                i = new Intent(this, LocationActivity.class);
                startActivity(i);
                break;

        }
    }
}
