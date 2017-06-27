package zioncosta.trabajopractico4;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
   MainActivity ActividadAnfitriona = (MainActivity)getActivity();
   
   public View onCreateView(LayoutInflater InfladorDeLayouts, ViewGroup GrupoDeLaVista, Bundle DatosRecibidos)
   {
	  View VistaADevolver = InfladorDeLayouts.inflate(R.layout.fragment_iniciado, GrupoDeLaVista, false);
	  
	  Spinner SpinnerCheto = (Spinner) VistaADevolver.findViewById(R.id.SpinnerUsuariosCapos);
	  
	  //Declaro e inicializo un ArrayList con la lista de usuarios usando el metodo ListarUsuarios
	  ArrayList<String> ListaUsuariosPiolas = ActividadAnfitriona.ListarUsuarios();
	  //lleno el arrayadapter con la lista de usuarios
	  ArrayAdapter<String> AdaptadorSoloParaSpinnersChetos = new ArrayAdapter<>(ActividadAnfitriona, android.R.layout.simple_spinner_item, ListaUsuariosPiolas);
	  //aca no se bien que hace pero segui el tutorial
	  AdaptadorSoloParaSpinnersChetos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	  //le digo al spinner que use el adapter "adaptador"
	  SpinnerCheto.setAdapter(AdaptadorSoloParaSpinnersChetos);
	  return VistaADevolver;
   }
}
