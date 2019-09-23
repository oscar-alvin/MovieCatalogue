package dicoding.com.moviecatalogue.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import dicoding.com.moviecatalogue.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

public class About extends AppCompatActivity implements View.OnClickListener{

    private Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
		
		Toolbar toolbar = findViewById(R.id.toolbarAbout);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnEmail = findViewById(R.id.btn_Email);
        btnEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent sendEmail = new Intent(Intent.ACTION_SEND);
        sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{btnEmail.getText().toString()});
        sendEmail.setType("application/octet-stream");
        startActivity(sendEmail);
    }
}
