package zioncosta.trabajopractico4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
   
   FragmentManager AdministradorDeFragments;
   FragmentTransaction TransaccionesDeFragment;
   
   DbHelper AccesoDb;
   SQLiteDatabase BaseDeDatosRicolina;
   
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
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
   
   public void botonRegistrar(View Vista)
   {
	  AdministradorDeFragments = getSupportFragmentManager();
	  
	  Fragment frgRegistrar;
	  frgRegistrar = new fragmentRegistrar();
	  
	  TransaccionesDeFragment = AdministradorDeFragments.beginTransaction();
	  TransaccionesDeFragment.replace(R.id.AlojadorDeFragment, frgRegistrar);
	  TransaccionesDeFragment.commit();
   }

	public void cambiarVista ()
	{
		AdministradorDeFragments = getSupportFragmentManager();

		Fragment frgIngreso;
		frgIngreso = new fragmentLogin();

		TransaccionesDeFragment = AdministradorDeFragments.beginTransaction();
		TransaccionesDeFragment.replace(R.id.AlojadorDeFragment, frgIngreso);
		TransaccionesDeFragment.commit();
	}
   
   public boolean ConexionBaseDatos()
   {
	  boolean Respuesta = false;
	  //Declaro el helper y la base de datos
	  AccesoDb = new DbHelper(this, "BaseTP4", null, 1);
	  BaseDeDatosRicolina = AccesoDb.getWritableDatabase();
	  //Verifico que la base de datos exista, comprobando que no sea null
	  if (BaseDeDatosRicolina != null)
	  {
		 Respuesta = true;
	  }
	  //BaseDeDatosRicolina.close();
	  return Respuesta;
   }
   public boolean ExisteEnLaBaseDeDatos(String Nombre) //Funciona
   {
	  if (ConexionBaseDatos())
	  {
		 //Ejecuto una consulta que devuelve los registros
		 Cursor Registros = BaseDeDatosRicolina.rawQuery("select NombreUsuario from Usuarios", null);
		 //Si hay registros entro al if y la repetitiva
		 if (Registros.moveToFirst())
		 {
			//Leo los registros hasta que encuentre un nombre igual al ingresado, o que termine de recorer los registros
			do
			{
			   //Si el nombre ingresado es igual al del registro, devuelvo true finalizando el do while
			   String NombreSQL = Registros.getString(0);
			   int Comparador = NombreSQL.compareTo(Nombre);
			   if (Comparador == 0)
			   {
				  return true;
			   }
			} while (Registros.moveToNext());
		 }
	  }
	  //BaseDeDatosRicolina.close();
	  //Si no encontre un nombre igual o no pude abrir la Db devuelvo false
	  return false;
   }
   public void AgregarABaseDatos(String NombreUsuario, String Contrasenia)
   {
	  if (ConexionBaseDatos())
	  {
		 ContentValues NuevoRegistro = new ContentValues();
		 NuevoRegistro.put("Nombre", NombreUsuario);
		 NuevoRegistro.put("Contrasenia", Contrasenia);
		 BaseDeDatosRicolina.insert("Usuarios", null, NuevoRegistro);
		 BaseDeDatosRicolina.close();
	  }
   }
   
}
