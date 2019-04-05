package ruslan.reminnyi.metodlgd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Ruslan Reminnyi
 * @version 1.0
 */
public class RootsActivity extends AppCompatActivity implements View.OnClickListener {
    /* User enters roots in this activity */

    /**
     * editTextX1 for root X1
     */
    private EditText editTextX1;

    /**
     * editTextX2 for root X2
     */
    private EditText editTextX2;

    /**
     * editTextX3 for root X3
     */
    private EditText editTextX3;

    private Button button;
    private boolean rightRoot1;
    private boolean rightRoot2;
    private boolean rightRoot3;
//    Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roots);

        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextX1 = (EditText) findViewById(R.id.x1_edit_text_roots_layout);
        editTextX2 = (EditText) findViewById(R.id.x2_edit_text_roots_layout);
        editTextX3 = (EditText) findViewById(R.id.x3_edit_text_roots_layout);

        button = (Button) findViewById(R.id.button_roots_activity);
        button.setOnClickListener(this);

//        button2 = (Button) findViewById(R.id.button_check_roots);
//        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

//        switch (view.getId()) {
//            case R.id.button_check_roots:
//                Toast.makeText(this, "" + LGDApplication.getX1() + "  " +
//                        + LGDApplication.getX2() + "  " +
//                        + LGDApplication.getX3(), Toast.LENGTH_LONG).show();
//                break;
//            case R.id.button_roots_activity:
                try {

                    if (editTextX1.getText() != null & editTextX1.length() > 0) {
                        rightRoot1 = checkRoot(LGDApplication.getX1()
                                     , Double.parseDouble(editTextX1.getText().toString()));
                    } else {
                        Toast.makeText(this, R.string.not_all_roots, Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (editTextX2.getText() != null & editTextX2.length() > 0) {
                        rightRoot2 = checkRoot(LGDApplication.getX2()
                                     , Double.parseDouble(editTextX2.getText().toString()));
                    } else {
                        Toast.makeText(this, R.string.not_all_roots, Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (editTextX3.getText() != null & editTextX3.length() > 0) {
                        rightRoot3 = checkRoot(LGDApplication.getX3()
                                     , Double.parseDouble(editTextX3.getText().toString()));
                    } else {
                        Toast.makeText(this, R.string.not_all_roots, Toast.LENGTH_LONG).show();
                        return;
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(this, R.string.toast_not_numeric, Toast.LENGTH_LONG).show();
                }


                if (rightRoot1 & rightRoot2 & rightRoot3) {    // if all roots which user entered are correct
                    startActivity(new Intent(this, FinalActivity.class));
                } else {
                    Toast.makeText(this, R.string.wrong_roots, Toast.LENGTH_LONG).show();
                }

//        }

    }

    /**
     * Checking of root
     *
     * @param root correct root
     * @param userRoot root which user entered
     * @return  true - if user is right, false - if user is wrong
     */
    public boolean checkRoot(Double root, Double userRoot) {
        if (root.equals(userRoot)) {
            return true;
        } else {
            return false;
        }
    }
}
