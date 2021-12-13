package com.example.schedulebuilder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    public interface OnLongClickListener{
        void onItemLongClicked(int position);
    }
    public interface OnClickListener{
        void onItemClicked(int position);
    }
    List<String> titleList;
    OnLongClickListener longClickListener;
    OnClickListener onClickListener;

    public ItemAdapter(List<String> titleList, OnLongClickListener longClickListener, OnClickListener onClickListener) {
        this.titleList = titleList;
        this.longClickListener = longClickListener;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Use layout inflater to inflate a view

        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        //wrap it inside a View Holder and return it
        return new ViewHolder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Grab the item at the position
        String item = titleList.get(position);
        //Bind the item into the specified view holder
        holder.bind(item);

    }
    //Tells the RV how many items are in the limit
    @Override
    public int getItemCount() {
        return titleList.size();
    }

    //Container to provide easy access to view that represent each row of the list
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById((android.R.id.text1));
        }
        //Update the view inside of the view holder with this data
        public void bind(String item) {
            tvItem.setText(item);
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override

                public boolean onLongClick(View v) {
                    //Notify the listener which position was long pressed
                    longClickListener.onItemLongClicked(getAdapterPosition());
                    return true;
                }
            });
            tvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onItemClicked(getAdapterPosition());
                }
            }

        );
        }
    }
}
