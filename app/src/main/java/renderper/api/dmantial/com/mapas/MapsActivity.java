package renderper.api.dmantial.com.mapas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnInfoWindowClickListener,GoogleMap.OnMarkerDragListener,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker  MarkerList,Markerdraw,Chosica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).draggable(true).title("Lima").snippet("La ciudad de Lima").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng lima = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(lima).title("Lima").snippet("La ciudad de Lima").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

       //marcador de pueba
        LatLng rios = new LatLng(-34, 151);
        MarkerList  = googleMap.addMarker(new MarkerOptions().position(rios).title("prueba").draggable(true));

        LatLng draw = new LatLng(-34, 151);
        Markerdraw  = googleMap.addMarker(new MarkerOptions().position(draw).title("Daw").draggable(true));


        LatLng chosi = new LatLng(-34, 153);
        Chosica  = googleMap.addMarker(new MarkerOptions().position(chosi).title("Chosi").draggable(true).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        //
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lima,7));
        googleMap.setOnMarkerClickListener(this);
        //Arrastar el marcador otro metodo para arrastrar
        googleMap.setOnMarkerDragListener(this);
        //poner un texto de mas informacion
        googleMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.equals(MarkerList)){
            String lat,log;
            lat=Double.toString(marker.getPosition().latitude);
            log=Double.toString((marker.getPosition().longitude));
            Toast.makeText(this,"Mi primer event"+lat+","+log,Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        if(marker.equals(Markerdraw)){
            Toast.makeText(this,"Start",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if(marker.equals(Markerdraw)){
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_lating),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);

            setTitle(newTitle);

        }

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if(marker.equals(Markerdraw)){
            Toast.makeText(this,"Finish",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if(marker.equals(Chosica)){
            lugarFragment.newInstance(marker.getTitle(),getString(R.string.informacion_fragment))
                    .show(getSupportFragmentManager(),null);
        }

    }
}
