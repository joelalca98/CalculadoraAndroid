package edu.upc.dsa.calculadoraentregable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import android.os.Bundle;

import java.sql.SQLInput;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    /**Variables globales */
    boolean decimal = false;
    boolean resta = false;
    boolean multiplicacion = false;
    boolean suma = false;
    boolean division = false;
    boolean radianes = false;
    boolean seno = false;
    boolean coseno = false;
    Double[] numero= new Double [20];
    Double dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /**  Señalizamos lo que serian los botones del diseño con las variables */
        Button button0 = (Button) findViewById(R.id.ceroBtn);
        button0.setOnClickListener(this);
        Button button1 = (Button) findViewById(R.id.unoBtn);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.dosBtn);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.tresBtn);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.cuatroBtn);
        button4.setOnClickListener(this);
        Button button5 = (Button) findViewById(R.id.cincoBtn);
        button5.setOnClickListener(this);
        Button button6 = (Button) findViewById(R.id.seisBtn);
        button6.setOnClickListener(this);
        Button button7 = (Button) findViewById(R.id.sieteBtn);
        button7.setOnClickListener(this);
        Button button8 = (Button) findViewById(R.id.ochoBtn);
        button8.setOnClickListener(this);
        Button button9 = (Button) findViewById(R.id.nueveBtn);
        button9.setOnClickListener(this);

        /** Señalizamos lo que serían las operaciones, incluyendo el punto del decimal    **/
        Button buttonSuma = (Button) findViewById(R.id.masBtn);
        buttonSuma.setOnClickListener(this);
        Button buttonMenos = (Button) findViewById(R.id.menosBtn);
        buttonMenos.setOnClickListener(this);
        Button buttonMult = (Button) findViewById(R.id.multBtn);
        buttonMult.setOnClickListener(this);
        Button buttonDel = (Button) findViewById(R.id.delBtn);
        buttonDel.setOnClickListener(this);
        Button buttonIgual = (Button) findViewById(R.id.igualBtn);
        buttonIgual.setOnClickListener(this);
        Button buttonComa = (Button) findViewById(R.id.comaBtn);
        buttonComa.setOnClickListener(this);

        /**Operaciones especiales como el seno y el coseno  */

        Button buttonSen = (Button) findViewById(R.id.senBtn);
        buttonSen.setOnClickListener(this);
        Button buttonCos = (Button) findViewById(R.id.cosBtn);
        buttonCos.setOnClickListener(this);
        Switch SwitchRad = (Switch) findViewById(R.id.switchRad);
        SwitchRad.setOnClickListener(this);






    }

    public void onClick(View v) {
        TextView screen = (TextView) findViewById(R.id.textView);
        int selector = v.getId();
        String x = screen.getText().toString();
        try{
            switch (selector){
                case  R.id.ceroBtn:
                    screen.setText(x + "0");
                    break;
                case  R.id.unoBtn:
                    screen.setText(x + "1");
                    break;
                case  R.id.dosBtn:
                    screen.setText(x + "2");
                    break;
                case  R.id.tresBtn:
                    screen.setText(x + "3");
                    break;
                case  R.id.cuatroBtn:
                    screen.setText(x + "4");
                    break;
                case  R.id.cincoBtn:
                    screen.setText(x + "5");
                    break;
                case  R.id.seisBtn:
                    screen.setText(x + "6");
                    break;
                case  R.id.sieteBtn:
                    screen.setText(x + "7");
                    break;
                case  R.id.ochoBtn:
                    screen.setText(x + "8");
                    break;
                case  R.id.nueveBtn:
                    screen.setText(x + "9");
                    break;
                case  R.id.delBtn:
                    screen.setText("");
                    decimal = false;
                    break;
                case R.id.comaBtn:
                    if(decimal== false) {
                        screen.setText(x + ".");
                        decimal = true;
                    }else return;
                    break;
                case  R.id.divBtn:
                    division = true;
                    numero [0] = Double.parseDouble(x);
                    screen.setText("");
                    decimal = false;
                    break;
                case R.id.multBtn: //Multiplicación
                    multiplicacion = true;
                    numero[0] = Double.parseDouble(x);
                    screen.setText("");
                    decimal = false;
                    break;
                case R.id.menosBtn: //Resta
                    resta = true;
                    numero[0] = Double.parseDouble(x);
                    screen.setText("");
                    decimal = false;
                    break;
                case R.id.masBtn: //Suma
                    suma = true;
                    numero[0] = Double.parseDouble(x);
                    screen.setText("");
                    decimal = false;
                    break;

                    /** aquí estan las operaciones (IGUAL) */



                case R.id.switchRad:
                    radianes = true;
                    break;
                case R.id.senBtn:
                    seno = true;
                    screen.setText(x + "");
                    break;
                case R.id.cosBtn:
                    seno = true;
                    screen.setText(x + "");
                    break;
                case R.id.igualBtn: //IGUAL
                    numero[1] = Double.parseDouble(x);
                    if (suma == true) {
                        dato = numero[0] + numero[1];
                        screen.setText(String.valueOf(dato));
                    } else if (resta == true) {
                        dato = numero[0] - numero[1];
                        screen.setText(String.valueOf(dato));
                    } else if (multiplicacion == true) {
                        dato = numero[0] * numero[1];
                        screen.setText(String.valueOf(dato));
                    } else if (division == true) {
                        dato = numero[0] / numero[1];
                        screen.setText(String.valueOf(dato));
                    }
                    else if (seno==true)
                    {
                        if (radianes==true) {
                            double radian = Math.toRadians(Double.parseDouble(x));
                            dato = Math.sin(radian);
                            screen.setText(String.valueOf(dato));
                        }
                        else {
                            double radian = Math.toRadians(Double.parseDouble(x));
                            dato = Math.sin(radian);
                            double res = Math.toDegrees(dato);
                            screen.setText(String.valueOf(res));
                        }

                    }
                    else if (coseno==true)
                    {
                        if (radianes==true) {
                            double radian = Math.toRadians(Double.parseDouble(x));
                            dato = Math.cos(radian);
                            screen.setText(String.valueOf(dato));
                        }
                        else {
                            double radian = Math.toDegrees(Double.parseDouble(x));
                            dato = Math.cos(radian);
                            double res = Math.toDegrees(dato);
                            screen.setText(String.valueOf(res));
                        }


                    }
                    decimal = false;
                    suma = false;
                    division = false;
                    multiplicacion = false;
                    resta = false;
                    break;








            }


        } catch (Exception e)
        {
            screen.setText("Error");
        }

    }
}