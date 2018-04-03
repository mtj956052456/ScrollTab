package com.mtj.mytestlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mtj.mytestlist.adapter.LeftControlAdapter;
import com.mtj.mytestlist.adapter.RightControlAdapter;
import com.mtj.mytestlist.entity.Entity;
import com.mtj.mytestlist.util.DateUtil;
import com.mtj.mytestlist.view.NoscrollListView;
import com.mtj.mytestlist.view.SyncHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_site)
    TextView mTvSite;
    @BindView(R.id.tv_worksitetype)
    TextView mTvWorksitetype;
    @BindView(R.id.tv_tasktype)
    TextView mTvTasktype;
    @BindView(R.id.tv_inspectiontiem)
    TextView mTvInspectiontiem;
    @BindView(R.id.header_horizontal)
    SyncHorizontalScrollView mHeaderHorizontal;
    @BindView(R.id.lv_left)
    NoscrollListView mLvLeft;
    @BindView(R.id.lv_right)
    NoscrollListView mLvRight;
    @BindView(R.id.data_horizontal)
    SyncHorizontalScrollView mDataHorizontal;


    private LeftControlAdapter mLeftAdapter;
    private RightControlAdapter mRightAdapter;
    private List<Entity> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getData();
        initView();
    }


    private void initView() {
        mDataHorizontal.setScrollView(mHeaderHorizontal);  //设置绑定滚动监听
        mHeaderHorizontal.setScrollView(mDataHorizontal);

        mLeftAdapter = new LeftControlAdapter(this, mList);
        mLvLeft.setAdapter(mLeftAdapter);

        List<Entity.Data> mListData = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            List<Entity.Data> data = mList.get(i).getData();
            for (int j = 0; j < data.size(); j++) {
                mListData.add(data.get(j));
            }
        }
        mRightAdapter = new RightControlAdapter(this, mListData);
        mLvRight.setAdapter(mRightAdapter);
    }

    private void  getData() {
        for (int i = 0; i < 5; i++) {
            Entity entity = new Entity();
            entity.setSite("郑州站点"+i);
            List<Entity.Data> lists = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Entity.Data data = new Entity.Data();
                data.setInspectionTime(DateUtil.getNowDate());
                data.setTaskType("任务类型" + j);
                data.setWorkSite("工地" + j);
                data.setWorkSiteType("工地类型" + j);
                lists.add(data);
            }
            entity.setData(lists);
            mList.add(entity);
        }
    }
}
