package zioncosta.trabajopractico4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrador on 21/6/2017.
 */

public class DbHelper extends SQLiteOpenHelper
{
   
   public  DbHelper(Context Contexto, String Nombre, SQLiteDatabase.CursorFactory Fabrica, int Version)
   {
	  super(Contexto, Nombre, Fabrica, Version);
   }
   
   @Override
   public void onCreate(SQLiteDatabase DatabaseLOL)
   {
	  //Creo la tabla personas con una columna "nombre"
	  String CrearTablaPersonas = "create table Personas (Nombre text)";
	  DatabaseLOL.execSQL(CrearTablaPersonas);
   }
   
   @Override
   public void onUpgrade(SQLiteDatabase Db, int versionAnterior, int versionNueva)
   {
   }
}