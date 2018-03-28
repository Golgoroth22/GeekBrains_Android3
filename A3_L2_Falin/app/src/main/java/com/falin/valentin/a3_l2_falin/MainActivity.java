package com.falin.valentin.a3_l2_falin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.falin.valentin.a3_l2_falin.model.Model;
import com.falin.valentin.a3_l2_falin.presenter.Presenter;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    TextView userNickNameTextView;
    ImageView userAvatarImageView;
    Button loadButton;
    ProgressBar loadProgressBar;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initPresenter();
    }

    private void initPresenter() {
        Model model = new Model();
        presenter = new Presenter(model);
        presenter.attachView(this);
    }

    private void initUI() {
        textView = findViewById(R.id.content_text);
        editText = findViewById(R.id.content_edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                textView.setText(editable.toString());
            }
        });
        userNickNameTextView = findViewById(R.id.content_user_nickname);
        userAvatarImageView = findViewById(R.id.content_user_image);
        loadButton = findViewById(R.id.content_start_load_button);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadButtonClick();
            }
        });
        loadProgressBar = findViewById(R.id.content_load_progress_bar);
    }

    private void loadButtonClick() {
        presenter.loadButtonClick();
    }

    public void changeNickName(String newUserName) {
        userNickNameTextView.setText(newUserName);
    }
}
