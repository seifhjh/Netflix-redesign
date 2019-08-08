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
import net.seifhadjhassen.netflix.model.HeaderModel;

import java.util.List;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieAdapter.ViewHolder>{




    List<CategModel> list;
    Context context;
    OnItemClickListener mOnItemClickListener;

    public CategorieAdapter(Context context, List<CategModel> categorie) {
        this.list = categorie;
        this.context = context;
    }


    @Override
    public CategorieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categ, parent, false);
        return new CategorieAdapter.ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(final CategorieAdapter.ViewHolder holder, final int position) {

        holder.imageView.setImageResource(list.get(position).getImg());
        holder.textView.setText(list.get(position).getTitle());


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

            imageView=itemView.findViewById(R.id.img_categ_background);
            textView=itemView.findViewById(R.id.txt_categ);

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
