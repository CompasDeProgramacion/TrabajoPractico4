package zioncosta.trabajopractico4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by 42100095 on 13/6/2017.
 */

public class fragmentRegistrar extends Fragment {
    public View onCreateView (LayoutInflater InfladorDeLayouts,ViewGroup GrupoDeLaVista,Bundle DatosRecibidos)
    {
        View VistaADevolver;
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.fragment_registrar, GrupoDeLaVista, false);
        EditText RegistroUsuarioo = (EditText)VistaADevolver.findViewById(R.id.RegistroNombre);
        EditText RegistroContraseñaa = (EditText)VistaADevolver.findViewById(R.id.RegistroContraseña);
        EditText RegistroConfirmarContraseñaa = (EditText)VistaADevolver.findViewById(R.id.RegistroConfirmarContraseña);

        String RegistroUsuario = RegistroUsuarioo.toString();
        String RegistroContraseña = RegistroContraseñaa.toString();
        String RegistroConfirmarContraseña = RegistroConfirmarContraseñaa.toString();


        if(RegistroUsuario.trim().matches("") || RegistroContraseña.trim().matches("") || RegistroConfirmarContraseña.trim().matches(""))
        {
            Toast MensajeError = Toast.makeText(getActivity(), "Uno o varios de los campos están vacíos. Por favor, verifique que todos los campos estén llenos antes de continuar", Toast.LENGTH_LONG);
            MensajeError.show();
        }
        else if(RegistroConfirmarContraseña != RegistroContraseña)
        {
            Toast MensajeError = Toast.makeText(getActivity(), "Las contraseñas no coinciden. Por favor, verifique que sean iguales. No tenemos todo el día, señor, somos Google", Toast.LENGTH_LONG);
            MensajeError.show();
        }
        else
        {
            AgregarABaseDatos
        }
    
    
        return VistaADevolver;
    }
}
