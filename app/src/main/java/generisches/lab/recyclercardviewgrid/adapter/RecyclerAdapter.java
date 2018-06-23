package generisches.lab.recyclercardviewgrid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import generisches.lab.recyclercardviewgrid.model.Animal;
import generisches.lab.recyclercardviewgrid.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG = "RecyclerAdapter";
    List<Animal> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<Animal> data){
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View lView = mInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(lView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder" + position);

        Animal crtObj = mData.get(position);
        holder.setData(crtObj, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView imgThumb;
        int pos;
        Animal current;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txv_row);
            imgThumb = itemView.findViewById(R.id.img_row);
        }

        public void setData(Animal crtObj, int position) {
            this.title.setText(crtObj.getTitle());
            this.imgThumb.setImageResource(crtObj.getImageId());
            this.pos = position;
            this.current = crtObj;
        }
    }
}
