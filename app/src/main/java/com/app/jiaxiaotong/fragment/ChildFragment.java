package com.app.jiaxiaotong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.jiaxiaotong.R;
import com.app.jiaxiaotong.model.ChildModel;
import com.app.jiaxiaotong.utils.GlideCircleTransform;
import com.bumptech.glide.Glide;

/**
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ChildFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildFragment extends Fragment {

//    private View topView,userInfoView;//家长信息顶部视图，用户信息点击视图

    private ImageView topAvatarIv,avatarIv;//家长用户顶部头像，用户头像

    private TextView userNameTv,userSchoolTv,userClassTv;//家长顶部昵称、学校、班级

    private ChildModel childModel;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ChildFragment.
     */
    public static ChildFragment newInstance(ChildModel childModel) {
        ChildFragment fragment = new ChildFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.childModel = childModel;
        return fragment;
    }

    public ChildFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_child_info, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        topAvatarIv = (ImageView) view.findViewById(R.id.user_info_avatar_iv);
        userNameTv = (TextView) view.findViewById(R.id.user_info_username_tv);//用户姓名
        userSchoolTv = (TextView) view.findViewById(R.id.user_info_user_school_tv);//用户所在学校
        userClassTv = (TextView) view.findViewById(R.id.user_info_class_tv);//用户所在班级
        if (childModel.getGender().equalsIgnoreCase("m")) {
            userNameTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.user_icon_boy_nor, 0);
            Glide.with(this).load(childModel.getHeader()).transform(new GlideCircleTransform(getContext())).placeholder(R.mipmap.child_default_icon).into(topAvatarIv);
        }else {
            userNameTv.setCompoundDrawablesWithIntrinsicBounds(0,0,R.mipmap.user_icon_girl_nor,0);
            Glide.with(this).load(childModel.getHeader()).transform(new GlideCircleTransform(getContext())).placeholder(R.mipmap.child_default_icon).into(topAvatarIv);
        }
        userNameTv.setText(childModel.getName());
        userSchoolTv.setText(childModel.getSchoolName());
        userClassTv.setText(childModel.getClassName());
    }

}
