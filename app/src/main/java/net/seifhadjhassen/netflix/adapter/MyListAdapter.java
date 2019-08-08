package net.seifhadjhassen.netflix.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.seifhadjhassen.netflix.R;
import net.seifhadjhassen.netflix.model.CategModel;
import net.seifhadjhassen.netflix.model.MyListModel;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{




    List<MyListModel> list;
    Context context;
    OnItemClickListener mOnItemClickListener;

    public MyListAdapter(Context context, List<MyListModel> categorie) {
        this.list = categorie;
        this.context = context;
    }


    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_list, parent, false);
        return new MyListAdapter.ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(final MyListAdapter.ViewHolder holder, final int position) {

        holder.imageView.setImageResource(list.get(position).getImg());


    }


    @Override
    public int getItemCount() {
        return list .size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img_list_background);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnItemClickListener!=null)
                        mOnItemClickListener.onItemClick(getAdapterPosition());
                }
            });



        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnclickItemListener(OnItemClickListener onclickItemListener){
        this.mOnItemClickListener=onclickItemListener;
    }
}
