package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class chatRoomActivity extends AppCompatActivity {
    private TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        content = findViewById(R.id.tv_content_info);
        Bundle bundle = getIntent().getExtras();
        String position = "Position: " + bundle.getInt("pos");

        content.setText(position);
    }
}
