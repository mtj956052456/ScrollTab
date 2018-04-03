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

public class RightControlAdapter extends BaseAdapter {

	private Context context;
	private List<Entity.Data> mListData;

	public RightControlAdapter(Context context, List<Entity.Data> mListData) {
		this.context = context;
		this.mListData = mListData;
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
			convertView = LayoutInflater.from(context).inflate(R.layout.right_control_layout, null);
			holder.tvSite = convertView.findViewById(R.id.tv_site);
			holder.tvWorksitetype = convertView.findViewById(R.id.tv_worksitetype);
			holder.tvTasktype = convertView.findViewById(R.id.tv_tasktype);
			holder.tvInspectiontiem = convertView.findViewById(R.id.tv_inspectiontiem);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
        Entity.Data entity = mListData.get(position);
        holder.tvSite.setText(entity.getWorkSite());
        holder.tvWorksitetype.setText(entity.getWorkSiteType());
        holder.tvTasktype.setText(entity.getTaskType());
        holder.tvInspectiontiem.setText(entity.getInspectionTime());

		return convertView;
	}

	class ViewHolder {
		TextView tvSite;
		TextView tvWorksitetype;
		TextView tvTasktype;
		TextView tvInspectiontiem;
	}
}
