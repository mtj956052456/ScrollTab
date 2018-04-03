package com.mtj.mytestlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mtj.mytestlist.R;
import com.mtj.mytestlist.entity.Entity;

import java.util.List;

/**
 * Created by lenovo on 2017/12/19.
 */

public class LeftControlAdapter extends BaseAdapter {

    private List<Entity> mListData;
    private Context context;

    public LeftControlAdapter(Context context, List<Entity> mListData) {
        this.mListData = mListData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.left_control_layout, null);
            holder.tvSite = convertView.findViewById(R.id.tv_site);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Entity entity = mListData.get(position);
        holder.tvSite.setText(entity.getSite());
        //设置左边数量与右边数据高度成对比
        if (holder.tvSite.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams p = holder.tvSite.getLayoutParams();
            int allLinSize = dp2px(context, entity.getData().size() - 1);//分割线的高度
            p.height = entity.getData().size() * dp2px(context, 30) + allLinSize;
            holder.tvSite.requestLayout();
        }
        return convertView;
    }

    class ViewHolder {
        TextView tvSite;//站点
    }

    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
