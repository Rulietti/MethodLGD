package ruslan.reminnyi.metodlgd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton;
    private Button theoryButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.start_button);
        theoryButton = (Button) findViewById(R.id.theory_button);
        startButton.setOnClickListener(this);
        theoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_button:
                startActivity(new Intent(this, TableActivity.class));
                break;
            case R.id.theory_button:
                startActivity(new Intent(this, TheoryActivity.class));
                break;
        }
    }
}
