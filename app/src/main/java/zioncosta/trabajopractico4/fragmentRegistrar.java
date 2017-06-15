package zioncosta.trabajopractico4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 42100095 on 13/6/2017.
 */

public class fragmentRegistrar extends Fragment {
    public View onCreateView (LayoutInflater InfladorDeLayouts,ViewGroup GrupoDeLaVista,Bundle DatosRecibidos)
    {
        View VistaADevolver;
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.fragment_registrar, GrupoDeLaVista, false);

        return VistaADevolver;
    }
}
