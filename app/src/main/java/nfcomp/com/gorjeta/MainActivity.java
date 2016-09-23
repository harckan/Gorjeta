package nfcomp.com.gorjeta;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valorConta;
    private TextView seekText;
    private TextView resultado;
    private Button btn5;
    private Button btn10;
    private Button btn15;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorConta = (EditText) findViewById(R.id.contaId);
        seekText = (TextView) findViewById(R.id.seekValueId);
        resultado = (TextView) findViewById(R.id.resultadoId);
        btn5 = (Button) findViewById(R.id.btn5Id);
        btn10 = (Button) findViewById(R.id.btn10Id);
        btn15 = (Button) findViewById(R.id.btn15Id);
        seekBar = (SeekBar) findViewById(R.id.seekBarId);


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcula(5);

            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcula(10);

            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcula(15);

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                seekText.setText(progress + "%");
                calcula(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calcula(double perc) {

        String strConta = valorConta.getText().toString();


        if (strConta.isEmpty()) {
            seekBar.setProgress(0);
            resultado.setText("0");
        } else {
            double c = Double.parseDouble(strConta);
            double r = c * (perc / 100);
            String s = Double.toString(Math.round(r * 100.0)/100.0).replace(".", ",");

            seekBar.setProgress((int) perc);
            resultado.setText(s);
        }

    }
}
