package zioncosta.trabajopractico4;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ezequ on 27/6/2017.
 */

public class fragmentIniciado extends Fragment
{
   
   public View onCreateView(LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
   {
	  View VistaADevolver;
	  VistaADevolver = InfladorDeLayouts.inflate(R.layout.fragment_iniciado, GrupoDeLaVista, false);
	  ListaUsuariosRegistrados = new ArrayList<>();
	  SpinnerUsuarios = (Spinner) VistaADevolver.findViewById(R.id.SpinnerUsuarios);
   
	  return VistaADevolver;
   }
}
