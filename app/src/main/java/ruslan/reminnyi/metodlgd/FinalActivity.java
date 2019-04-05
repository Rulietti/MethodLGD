package ruslan.reminnyi.metodlgd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * @author Ruslan Reminnyi
 * @version 1.0
 */
public class FinalActivity extends AppCompatActivity {
    /* User see this activity if the calculation was correct */

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        imageView = (ImageView) findViewById(R.id.congratulations);
        imageView.setImageResource(R.drawable.final_picture);
    }
}
