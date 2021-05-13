package com.example.recylceview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> mData;

    MyAdapter(List<String> data) {
        mData = data;
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private TextView txtItem;
        private Button btnRemove;

        ViewHolder(View itemView) {
            super(itemView);
            txtItem = (TextView) itemView.findViewById(R.id.txtItem);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "click " +getAdapterPosition(),Toast.LENGTH_SHORT).show();
                }
            });
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    removeItem(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 設置txtItem要顯示的內容
        holder.txtItem.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public void addItem(String text) {
        // 為了示範效果，固定新增在位置3。若要新增在最前面就把3改成0
        mData.add(0,text);
        notifyItemInserted(0);
        notifyItemRangeChanged(0,mData.size()-0);
    }

    // 刪除項目
    public void removeItem(int position){
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mData.size()-position);
    }
}
