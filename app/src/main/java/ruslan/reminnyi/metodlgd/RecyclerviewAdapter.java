package ruslan.reminnyi.metodlgd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Double> entityList;
    private LayoutInflater inflater;
    private ItemClickListener mClickListener;
    private Context context;

    RecyclerViewAdapter(Context context, List entityList) {
        this.inflater = LayoutInflater.from(context);
        this.entityList = entityList;
        this.context = context;

    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Double entity = entityList.get(position);

        if (entityList.get(position).equals(0.0)) {
            holder.textView.setText("");
        } else if (!(entityList.get(position).equals(0.0))&(position < 4)) {
            Integer intEntity = entity.intValue();
            holder.textView.setText(intEntity.toString());
            holder.linearLayout.setEnabled(false);
            holder.linearLayout.setClickable(false);
        } else if (!(entityList.get(position).equals(0.0))&(position >= 4)) {
            holder.textView.setText(entity.toString());
        }

    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.info_text);
            linearLayout = itemView.findViewById(R.id.recyclerview_item_liner_layout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public long getItemId(int i) {      // возвращает id item'a
        return i;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}