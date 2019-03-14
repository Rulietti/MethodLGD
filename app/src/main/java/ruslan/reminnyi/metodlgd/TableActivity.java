package ruslan.reminnyi.metodlgd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TableActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener, View.OnClickListener {

    private RecyclerViewAdapter adapter;
    private List<Double> entityList;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        entityList = LGDApplication.getUserList();

        button = (Button) findViewById(R.id.button_activity_main);
        button.setVisibility(View.GONE);
        button.setOnClickListener(this);

        textView =(TextView) findViewById(R.id.text_view_activity_main);
        textView.setText(LGDApplication.getStringEquation());
    }

    @Override
    protected void onResume() {
        super.onResume();

        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new RecyclerViewAdapter(this, entityList);
        adapter.notifyDataSetChanged();
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        if (LGDApplication.matchMatrix())
            button.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick (View view, int position){
        LGDApplication.setPositionValue(position);
        try {
            if (LGDApplication.getMatrix().get(position) != null) {
                Toast.makeText(this, "" + LGDApplication.getMatrix().get(position), Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "null", Toast.LENGTH_LONG).show();
        }
        new EnterValueDialog().show(getFragmentManager(), "EnterValueDialog");
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, RootsActivity.class));
    }


}
