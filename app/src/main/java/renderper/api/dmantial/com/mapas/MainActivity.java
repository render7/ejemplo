package renderper.api.dmantial.com.mapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button boton,boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    boton = (Button) findViewById(R.id.turistico);
    boton2 = (Button) findViewById(R.id.tipo);

    boton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent(getApplicationContext(),MapsActivity.class);
            startActivity(intent);
            finish();
        }
    });
    }
    public  void Misitios(View v){
    Intent intent = new Intent(getApplicationContext(),otroMapa.class);
    startActivity(intent);

    }
    public  void Milocalizacion(View v){
        Intent intent = new Intent(getApplicationContext(),MapsActivity_Localizacion.class);
        startActivity(intent);

    }
}
