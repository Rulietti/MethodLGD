package ruslan.reminnyi.metodlgd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    private RecyclerViewAdapter adapter;
    private List<Double> entityList;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entityList = LGDApplication.getUserList();

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

    }

    @Override
    public void onItemClick (View view, int position){
        LGDApplication.setPositionValue(position);
        new EnterValueDialog().show(getFragmentManager(), "EnterValueDialog");
    }

}
