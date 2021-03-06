package com.imobile3.groovypayments.ui.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.imobile3.groovypayments.R;
import com.imobile3.groovypayments.data.entities.UserEntity;
import com.imobile3.groovypayments.ui.BaseActivity;

import androidx.annotation.NonNull;

public class UserProfileActivity extends BaseActivity {



    @NonNull
    private final UserEntity mUser = new UserEntity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_activity);

        initUser();

        setUpMainNavBar();
        setUpViews();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void setUpMainNavBar() {
        super.setUpMainNavBar();
        mMainNavBar.showBackButton();
        mMainNavBar.showLogo();
        mMainNavBar.showSubtitle(getString(R.string.user_profile_subtitle_format,
                mUser.getFirstName() + " " + mUser.getLastName()));
    }

    @Override
    protected void initViewModel() {
        // No view model needed.
    }

    private void initUser() {
        SharedPreferences sharedpreferences = getSharedPreferences("UserName",
                Context.MODE_PRIVATE);
        String email = sharedpreferences.getString("name", "");
        String nameOnly = email.substring(0,email.indexOf('@'));
        mUser.setId(11111L);
        mUser.setUsername(nameOnly);
        mUser.setFirstName("Naresh Rao");
        mUser.setLastName("Madhavaram");
        mUser.setEmail(email);
        mUser.setPassword("qwerty");
    }

    private void setUpViews() {
        TextView lblUsername = findViewById(R.id.label_username);
        lblUsername.setText(mUser.getUsername());

        TextView lblEmail = findViewById(R.id.label_email);
        lblEmail.setText(mUser.getEmail());

        TextView lblHoursWeek = findViewById(R.id.label_hours_week);
        lblHoursWeek.setText(String.valueOf(mUser.getId()));
    }
}