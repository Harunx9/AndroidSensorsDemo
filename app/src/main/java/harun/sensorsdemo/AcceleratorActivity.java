package harun.sensorsdemo;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class AcceleratorActivity extends Activity implements SensorEventListener {
    private SensorManager _sensorManager;
    private Sensor _sensor;

    private TextView _labelForceX;
    private TextView _labelForceY;
    private TextView _labelForceZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerator);
        getWindow().setTitle("Accelerometer Test");
        _labelForceX = (TextView) findViewById(R.id.lab_fx);
        _labelForceY = (TextView) findViewById(R.id.lab_fy);
        _labelForceZ = (TextView) findViewById(R.id.lab_fz);
        _sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        _sensor = _sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        _sensorManager.registerListener(this, _sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        _labelForceX.setText(String.format("%f m/s2",sensorEvent.values[0]));
        _labelForceY.setText(String.format("%f m/s2",sensorEvent.values[1]));
        _labelForceZ.setText(String.format("%f m/s2",sensorEvent.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        _sensorManager.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _sensorManager.unregisterListener(this);
    }
}
