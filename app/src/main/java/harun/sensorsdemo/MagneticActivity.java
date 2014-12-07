package harun.sensorsdemo;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MagneticActivity extends Activity implements SensorEventListener{

    private SensorManager _sensorManager;
    private Sensor _sensor;

    private TextView _xAxis;
    private TextView _yAxis;
    private TextView _zAxis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetic);
        getActionBar().setTitle("Magnetic Test");

        _sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        _sensor = _sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        _sensorManager.registerListener(this, _sensor, SensorManager.SENSOR_DELAY_NORMAL);
        _xAxis = (TextView) findViewById(R.id.lab_azim);
        _yAxis = (TextView) findViewById(R.id.lab_pit);
        _zAxis = (TextView) findViewById(R.id.lab_roll);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        _xAxis.setText(String.format("%f", sensorEvent.values[0]));
        _yAxis.setText(String.format("%f", sensorEvent.values[1]));
        _zAxis.setText(String.format("%f", sensorEvent.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _sensorManager.unregisterListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        _sensorManager.unregisterListener(this);
    }
}
