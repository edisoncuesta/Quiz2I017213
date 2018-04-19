package URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Models.User;
import Parser.Json;

/**
 * Created by TOSHIBA1 on 19/04/2018.
 */

public class MainActivity {

    // Atributos de clase iniciales
    ProgressBar progressBar;
    Button button;
    TextView textView;

    List<User> postList = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.id_pb_data);
        button = (Button) findViewById(R.id.id_btn_loaddata);
        textView = (TextView) findViewById(R.id.id_tv_data);
    }

    // Metodo para validar la conexion a internet
    public Boolean isOnLine() {
        // Hacer llamado al servicio de conectividad utilizando el ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // Validar el estado obtenido de la conexion
        if (networkInfo != null) {
            return true;
        } else {
            return false;
        }
    }

    // Evento del boton
    public void loadData(View view) {
        if (isOnLine()) {
            // Hacer llamado a la tarea
            //MyTask task = new MyTask();
            //task.execute("https://jsonplaceholder.typicode.com/posts");


        }
    }

    // *************************************************************************************

    public void processData() {
        textView.setText("Numero: " + s);
        textView.setTextSize(Integer.parseInt(s));
        textView.append(s + "\n");


        for (User str : postList) {
            textView.append(str.getEmail() + "\n");
        }


        // Tarea para traer los datos de post
        class MyTask extends AsyncTask<String, String, String> {


            protected void onPreExecute() {
                super.onPreExecute();
                progressBar.setVisibility(View.VISIBLE);
            }


            protected String doInBackground(String... strings) {
            /*for (int i = 1; i <= 50; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(String.valueOf(i));
            }
            return "fin";*/

                String content = null;
                try {
                    content = HttpUsuarios.getDataJson(strings[0]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return content;
            }


            protected void onProgressUpdate(String... values) {
                super.onProgressUpdate(values);
            }


            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                try {
                    postList = Json.getData(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                processData();

                progressBar.setVisibility(View.GONE);
            }
        }
    }
        // *************************************************************************************

        // Tarea para traer los datos de paises


    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }


    protected String doInBackground(String... strings) {
        String content = null;
        try {
            content = HttpUsuarios.getDataJson(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }


    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }


}




