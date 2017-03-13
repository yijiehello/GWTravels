package com.gwtravel.view.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gwtravel.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonInfoActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.et_department)
    EditText et_department;
    @BindView(R.id.et_position)
    EditText et_position;
    @BindView(R.id.et_company_address)
    EditText et_company_address;
    @BindView(R.id.et_company_name)
    EditText et_company_name;
    @BindView(R.id.et_residential_address)
    EditText et_residential_address;

    @BindView(R.id.compile_tv)
    TextView compile_tv;
    @BindView(R.id.user_img)
    ImageView user_img;

    //编辑按钮的标签，false为不编辑状态，true为编辑状态
    private Boolean FLAG = false;
    private View contentView;
    //    private ListView lv;
//    private Lvadapter lvAdapter;
    private PopupWindow pop;
    private int width;
    private int height;
    private ColorDrawable dw;
    private TextView tv_no, tv_yes, tv_title;
    private View view;
    private String texts = "";
    private int flag = 1;
    //获取个人图像的照片路径
    private String pathss = "";
    //请求相机
    private static final int REQUEST_CAPTURE = 100;
    //请求相册
    private static final int REQUEST_PICK = 101;
    //请求截图
    private static final int REQUEST_CROP_PHOTO = 102;
    //头像1
    private ImageView headImage1;
    //头像2
    private ImageView headImage2;
    //调用照相机返回图片临时文件
    private File tempFile;
    // 1: qq, 2: weixin
    private int type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = getLayoutInflater().inflate(R.layout.activity_person_info, null);
        setContentView(view);
        ButterKnife.bind(this);
        init();
        createCameraTempFile(savedInstanceState);
    }

    private void init() {

        et_name.setText("赵五");
        et_department.setText("商务部");
        et_position.setText("总经理");
        et_company_name.setText("一合鱼");
        et_company_address.setText("武汉市洪山区光谷软件园");
        et_residential_address.setText("街道口");

        et_name.setFocusable(false);
        et_name.setFocusableInTouchMode(false);
        et_department.setFocusable(false);
        et_department.setFocusableInTouchMode(false);
        et_position.setFocusable(false);
        et_position.setFocusableInTouchMode(false);
        et_company_name.setFocusable(false);
        et_company_name.setFocusableInTouchMode(false);
        et_company_address.setFocusable(false);
        et_company_address.setFocusableInTouchMode(false);
        et_residential_address.setFocusable(false);
        et_residential_address.setFocusableInTouchMode(false);
    }


    @OnClick({R.id.btn_back, R.id.user_img,R.id.compile_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.user_img:
                if (FLAG) {
                    type = 1;
                    uploadHeadImage();
                } else {
//                    Intent intent=new Intent(PersonInfoActivity.this,LookForBigPicActivity.class);
//                    Bundle bl=new Bundle();
//                    bl.putString("msg",pathss);
//                    intent.putExtras(bl);
//                    startActivity(intent);
                }

                break;
            case R.id.compile_tv:
                if (!FLAG) {
                    compile_tv.setText("保存");
                    FLAG = true;
                    et_name.setFocusableInTouchMode(true);
                    et_name.setFocusable(true);
                    et_department.setFocusable(true);
                    et_department.setFocusableInTouchMode(true);
                    et_position.setFocusable(true);
                    et_position.setFocusableInTouchMode(true);
                    et_company_name.setFocusable(true);
                    et_company_name.setFocusableInTouchMode(true);
                    et_company_address.setFocusable(true);
                    et_company_address.setFocusableInTouchMode(true);
                    et_residential_address.setFocusable(true);
                    et_residential_address.setFocusableInTouchMode(true);

                } else {
                    compile_tv.setText("编辑");
                    FLAG = false;
                    et_name.setFocusable(false);
                    et_name.setFocusableInTouchMode(false);
                    et_department.setFocusable(false);
                    et_department.setFocusableInTouchMode(false);
                    et_position.setFocusable(false);
                    et_position.setFocusableInTouchMode(false);
                    et_company_name.setFocusable(false);
                    et_company_name.setFocusableInTouchMode(false);
                    et_company_address.setFocusable(false);
                    et_company_address.setFocusableInTouchMode(false);
                    et_residential_address.setFocusable(false);
                    et_residential_address.setFocusableInTouchMode(false);


                    submit();

                }
                break;

        }
    }


    private void submit() {


    }


    /**
     * 上传头像
     */
    private void uploadHeadImage() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow, null);
        TextView btnCarema = (TextView) view.findViewById(R.id.btn_camera);
        TextView btnPhoto = (TextView) view.findViewById(R.id.btn_photo);
        TextView btnCancel = (TextView) view.findViewById(R.id.btn_cancel);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        popupWindow.setOutsideTouchable(true);
        View parent = LayoutInflater.from(this).inflate(R.layout.activity_person_info, null);
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        //popupWindow在弹窗的时候背景半透明
        final WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.5f;
        getWindow().setAttributes(params);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1.0f;
                getWindow().setAttributes(params);
            }
        });

        btnCarema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到调用系统相机
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
                startActivityForResult(intent, REQUEST_CAPTURE);
                popupWindow.dismiss();
            }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到调用系统图库
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(intent, "请选择图片"), REQUEST_PICK);
                popupWindow.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }

    /**
     * 创建调用系统照相机待存储的临时文件
     *
     * @param savedInstanceState
     */
    private void createCameraTempFile(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey("tempFile")) {
            tempFile = (File) savedInstanceState.getSerializable("tempFile");
        } else {
            tempFile = new File(checkDirPath(Environment.getExternalStorageDirectory().getPath() + "/image/"),
                    System.currentTimeMillis() + ".jpg");
        }
    }

    /**
     * 检查文件是否存在
     */
    private static String checkDirPath(String dirPath) {
        if (TextUtils.isEmpty(dirPath)) {
            return "";
        }
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dirPath;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("tempFile", tempFile);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case REQUEST_CAPTURE: //调用系统相机返回
                if (resultCode == RESULT_OK) {
                    gotoClipActivity(Uri.fromFile(tempFile));
                }
                break;
            case REQUEST_PICK:  //调用系统相册返回
                if (resultCode == RESULT_OK) {
                    Uri uri = intent.getData();
                    gotoClipActivity(uri);
                }
                break;
            case REQUEST_CROP_PHOTO:  //剪切图片返回
                if (resultCode == RESULT_OK) {
                    final Uri uri = intent.getData();
                    if (uri == null) {
                        return;
                    }
                    String cropImagePath = getRealFilePathFromUri(PersonInfoActivity.this, uri);
                    pathss = cropImagePath;
                    Bitmap bitMap = BitmapFactory.decodeFile(cropImagePath);
//                    byte[] b =  getBitmapByte(bitMap);
                    if (type == 1) {
                        user_img.setImageBitmap(bitMap);
                    } else {
                        headImage2.setImageBitmap(bitMap);
                    }
                    //此处后面可以将bitMap转为二进制上传后台网络


                }
                break;
        }
    }


    /**
     * 打开截图界面
     *
     * @param uri
     */
    public void gotoClipActivity(Uri uri) {
        if (uri == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, ClipImageActivity.class);
        intent.putExtra("type", type);
        intent.setData(uri);
        startActivityForResult(intent, REQUEST_CROP_PHOTO);
    }

    /**
     * Try to return the absolute file path from the given Uri  兼容了file:///开头的 和 content://开头的情况
     *
     * @param context
     * @param uri
     * @return the file path or null
     */
    public static String getRealFilePathFromUri(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }
}
