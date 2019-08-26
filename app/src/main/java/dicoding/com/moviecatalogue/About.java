package dicoding.com.moviecatalogue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity implements View.OnClickListener{

    private Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnEmail = (Button)findViewById(R.id.btn_Email);
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
