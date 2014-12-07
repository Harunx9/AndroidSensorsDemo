package harun.sensorsdemo;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class LightActivity extends Activity implements SensorEventListener {
    private SensorManager _sensorManager;
    private Sensor _sensor;

    private TextView _labelTemperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        getActionBar().setTitle("Light Test");
        _sensorManager = (SensorManager)  getSystemService(Context.SENSOR_SERVICE);
        _sensor = _sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        _sensorManager.registerListener(this, _sensor, SensorManager.SENSOR_DELAY_NORMAL);

        _labelTemperature = (TextView) findViewById(R.id.lab_temp);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        _labelTemperature.setText(String.format("%f lx", sensorEvent.values[0]));
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
