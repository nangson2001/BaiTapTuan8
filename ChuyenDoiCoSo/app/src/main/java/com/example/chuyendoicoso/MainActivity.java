package com.example.chuyendoicoso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText soCanChuyen;
    Spinner heCoSoDich;
    TextView dapAn;
    Button tinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soCanChuyen = findViewById(R.id.edt_so_can_chuyen);
        heCoSoDich = findViewById(R.id.spn_he_co_so_dich);
        dapAn = findViewById(R.id.txt_dap_an);
        tinh = findViewById(R.id.btn_tinh);
        Integer[] coSo = {2, 8, 10, 16};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(MainActivity.this ,R.layout.support_simple_spinner_dropdown_item, coSo);
        heCoSoDich.setAdapter(adapter);
        tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenDoi();
            }
        });
    }

    void chuyenDoi() {
        try {
            int number, coSo;
            number = Integer.parseInt(soCanChuyen.getText().toString());
            coSo = Integer.parseInt(heCoSoDich.getSelectedItem().toString());
            int ans = 0;
            switch (coSo) {
                case 2:
                    ans = Integer.parseInt(Integer.toBinaryString(number));
                    break;
                case 8:
                    ans = Integer.parseInt(Integer.toBinaryString(number));
                    break;
                case 16:
                    ans = Integer.parseInt(Integer.toHexString(number));
                    break;
                case 10:
                    ans = Integer.parseInt(Integer.toOctalString(number));
                    break;
            }
            dapAn.setText(String.valueOf(ans));
        } catch (Exception e) {
            dapAn.setText(e.toString());
        }

    }
}