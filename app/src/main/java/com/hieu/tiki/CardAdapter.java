package com.hieu.tiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends BaseAdapter {
    private List<CardItem> lc;
    private Context context;
    private LayoutInflater layoutInflater;

    public CardAdapter(Context context,List<CardItem> lc){
        this.context=context;
        this.lc=lc;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return lc.size();
    }

    @Override
    public Object getItem(int position) {
        return lc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.card_item,null);
            viewHolder=new ViewHolder();
            viewHolder.image=(ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.ten=(TextView) convertView.findViewById(R.id.ten);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder=(ViewHolder) convertView.getTag();

        CardItem cardItem=this.lc.get(position);
        viewHolder.image.setImageResource(cardItem.getImage());
        viewHolder.ten.setText(cardItem.getTen());
        return convertView;
    }

    private class ViewHolder {
        ImageView image;
        TextView ten,mota;
    }
}
