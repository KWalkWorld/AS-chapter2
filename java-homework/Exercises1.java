package chapter.android.aweme.ss.com.homework;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/*
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 * <p>
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
*/
public class Exercises1 extends AppCompatActivity {

    private static final String TAG = "LifeCycle";

    private static final String LIFECYCLE_CALLBACKS_TEXT_KEY = "callbacks";
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";
    private static final String ON_RESTORE_INSTANCE_STATE = "onRestoreInstanceState";

    private TextView lifeCycle;
    private TextView savedState;
    private static String log = "";

    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
        lifeCycle.append(lifecycleEvent + "\n");
        savedState.append(lifecycleEvent + "\n");
        log += lifecycleEvent + "\n";
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle);
        lifeCycle = findViewById(R.id.tv_log_lifecycle);
        savedState = findViewById(R.id.tv_save_instance);
        if(savedInstanceState != null) {
            if (savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)) {
                String content = "saved instance state:\n" +
                        (String) savedInstanceState.get(LIFECYCLE_CALLBACKS_TEXT_KEY);
                savedState.setText(content);
                Log.d(TAG, "saveState execute.");
            }
        }
        lifeCycle.setText(log);
        logAndAppend(ON_CREATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend(ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend(ON_RESUME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        logAndAppend(ON_STOP);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        logAndAppend(ON_DESTROY);
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logAndAppend(ON_SAVE_INSTANCE_STATE);
        String content = savedState.getText().toString();
        outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY, content);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logAndAppend(ON_RESTORE_INSTANCE_STATE);
    }

    public void resetLifecycleDisplay(View view) {
        lifeCycle.setText("");
        savedState.setText("");
        log = "";
    }
}
