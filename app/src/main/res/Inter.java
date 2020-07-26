/**
 * Created by Hrishita Mavani on 16-04-2018.
 */
public interface AccelerometerListener {

    public void onAccelerationChanged(float x, float y, float z);

    public void onShake(float force);

}