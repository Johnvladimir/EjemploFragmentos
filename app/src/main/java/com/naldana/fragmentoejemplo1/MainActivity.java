package com.naldana.fragmentoejemplo1;

// import android.app.FragmentManager;  // Este import se usa si no se trabaja con AppCompat

import android.support.v4.app.FragmentManager; // Con appcomapt
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FramentoComunicado.OnFragmentInteractionListener {

    private boolean fragmento1;
    private FramentoComunicado f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmento1 = false;

        addFragmentBasico2();

    }

    public void cambiar(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (fragmento1)
            fragmentTransaction.replace(R.id.fragment_container,new FragmentoBasico2());
        else {
            fragmentTransaction.replace(R.id.fragment_container, new FragmentoBasico());
        }

        fragmentTransaction.addToBackStack(null);
        fragmento1 = !fragmento1;
        fragmentTransaction.commit();
    }

    /**
     * Añade el Una instacia de {@link FragmentoBasico2}
     * al contenedor R.id.fragment_container
     * se hace en funcion para mejorar la legibilidad del código
     * considerar la mejor forma de hacer segun el caso
     */
    private void addFragmentBasico2() {
        // Obtenemos el el fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager(); // Con appCompat
        // fragmentManager = getFragmentManager(); // Sin appCompat
        // Iniciamos un transacion con el objetivo de intentra añadir un fragmento
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Creamos el fragmento que añadiremos al viewGroup
        //FragmentoBasico2 fragmentoBasico2 = new FragmentoBasico2();
        f = FramentoComunicado.newInstance("MEANSDKJBASJDG");
        // Indicamos que se quiere añadir el fragmento básico
        fragmentTransaction.add(R.id.fragment_container, f);
        // Indicamos que todas las acciones que se haran en la transaccion hagan efecto
        fragmentTransaction.commit();
    }


    @Override
    public void onTouchClose() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(f);
        fragmentTransaction.commit();
    }
}
