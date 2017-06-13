package zioncosta.trabajopractico4;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager AdministradorDeFragments;
    FragmentTransaction TransaccionesDeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdministradorDeFragments = getSupportFragmentManager();

        Fragment frgIngreso;
        frgIngreso = new fragmentInicio();

        TransaccionesDeFragment = AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragment.replace(R.id.AlojadorDeFragment, frgIngreso);
        TransaccionesDeFragment.commit();

    }
    public void botonEntrar(View Vista)
    {
        AdministradorDeFragments = getSupportFragmentManager();

        Fragment frgIngreso;
        frgIngreso = new fragmentLogin();

        TransaccionesDeFragment = AdministradorDeFragments.beginTransaction();
        TransaccionesDeFragment.replace(R.id.AlojadorDeFragment, frgIngreso);
        TransaccionesDeFragment.commit();
    }
}
