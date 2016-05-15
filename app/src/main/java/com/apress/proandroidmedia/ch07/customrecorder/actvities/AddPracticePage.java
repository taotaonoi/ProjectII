/*
package com.apress.proandroidmedia.ch07.customrecorder.actvities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apress.proandroidmedia.ch07.customrecorder.DAO.PracticeDAO;
import com.apress.proandroidmedia.ch07.customrecorder.DAO.UserDAO;
import com.apress.proandroidmedia.ch07.customrecorder.R;
import com.apress.proandroidmedia.ch07.customrecorder.model.Practice;
import com.apress.proandroidmedia.ch07.customrecorder.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by taohuh on 5/6/2016.
 */
/*
public class AddPracticePage extends Activity implements View.OnClickListener {
    public static final String TAG = "AddPracticePageActivity";

    public static final String EXTRA_ADDED_PRACTICE = "extra_key_added_practice";
    public static final String EXTRA_SELECTED_USER_ID = "extra_key_selected_user_id";

    public long mUserId = -1;
    public User currentUser;

    private PracticeDAO mPracticeDao;
    private UserDAO mUserDao;

    private Button mBtnSave, mBtnCancel;
    private EditText mEdtLevel, mEdtScore;

    int level, score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_practice_page);

        initWidget();
        this.mPracticeDao = new PracticeDAO(this);

        //รับ intent คือ id user จากหน้า main_page
        //แสดงข้อมูล User จาก Database
        mUserDao = new UserDAO(this);
        //รับข้อมูลจาก Intent ที่ส่งมาจากหน้าเลือกรายการผู้ใช้
        Intent intent = getIntent();
        if (intent != null) {
            this.mUserId = intent.getLongExtra(EXTRA_SELECTED_USER_ID, -1);
            Log.d(TAG, "User Id : " + mUserId);
            if (mUserId != -1) {
                //ผู้ใช้ปัจจุบันที่เลือกไว้จากหน้า main_page
                currentUser = mUserDao.getUserById(mUserId);
            }
        }
    }

    private void initWidget(){
        this.mEdtLevel = (EditText) findViewById(R.id.editTextLevelBPM);
        this.mEdtScore = (EditText) findViewById(R.id.editTextScore);
        this.mBtnSave = (Button)findViewById(R.id.btnSavePractice);
        this.mBtnCancel = (Button)findViewById(R.id.btnCancelPractice);

        this.mBtnSave.setOnClickListener(this);
        this.mBtnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == mBtnSave){
            Editable strLevel = mEdtLevel.getText();
            Editable strScore = mEdtScore.getText();

            if(!TextUtils.isEmpty(strLevel) && !TextUtils.isEmpty(strScore)){
                int level = Integer.valueOf(strLevel.toString());
                int score = Integer.valueOf(strScore.toString());

                //บันทึกข้อมูลลง Database
                //System.out.println("User id add practice : " + currentUser.getId());
                //System.out.println("User name add practice : " + currentUser.getName());
                //System.out.println("Level add practice : " + level);
                //System.out.println("Score id add practice : " + score);
                Practice createdPractice = mPracticeDao.createPractice(level, score, getDateTime(), currentUser.getId());
                Log.d(TAG, "added practice : " + createdPractice.getLevel_game()+ " " + createdPractice.getDate());

                Toast.makeText(AddPracticePage.this, "บันทึกข้อมูลเรียบร้อย.",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), ListPractice.class);
                intent.putExtra(ListPractice.EXTRA_ADDED_PRACTICE, createdPractice);
                intent.putExtra(ListPractice.EXTRA_SELECTED_USER_ID,currentUser.getId());
                setResult(RESULT_OK, intent);
                startActivity(intent);
            }
        }else if(view == mBtnCancel){
            Intent intent = new Intent(this, Main_page.class);
            intent.putExtra(Main_page.EXTRA_SELECTED_USER_ID,currentUser.getId());
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPracticeDao.close();
    }

    /*
     * get datetime
     */
/*
    private String getDateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
*/