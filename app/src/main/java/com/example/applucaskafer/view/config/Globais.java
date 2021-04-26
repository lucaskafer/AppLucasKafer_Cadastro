package com.example.applucaskafer.view.config;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Globais {


    public static void  exibirMensagens(String texto, Context context) {
        try {
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Log.d("ERRO", ex.getMessage());
        }
    }

    public static String md5 (String texto) {
       try {
           MessageDigest md = MessageDigest.getInstance("MD5");
           byte[] messageDigest = md.digest(texto.getBytes());
           BigInteger number = new BigInteger(1,messageDigest);
           String md5 = number.toString(16);

           while (md5.length()<32)
           {
               md5 = "0" + md5;
               return md5;
           }

       }catch (NoSuchAlgorithmException e)
       {
           return  null;
       }

        return texto;
    }

}
