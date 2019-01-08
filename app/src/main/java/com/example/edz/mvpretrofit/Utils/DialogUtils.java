package com.example.edz.mvpretrofit.Utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogUtils {
    private static  ProgressDialog progressDialog;
    private static  DialogUtils utils;
    public DialogUtils(){
        if (utils==null)
            utils=new DialogUtils();
    }

    public static void showProgressDialog(Context context){//普通的加载框
        if (progressDialog==null)
            progressDialog=new ProgressDialog(context).show(context,"","正在加载",true,false);
        else
        {
            progressDialog.setTitle("");
            progressDialog.setMessage("正在加载");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }


    public static void showProgressDialog(Context context,String message)
    {
        if (progressDialog==null)
            progressDialog=new ProgressDialog(context).show(context,"",message,true,false);
        else
        {
            progressDialog.setTitle("");
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }

    public static void showProgressDialog(Context context,String title,String message)
    {
        if (progressDialog==null)
            progressDialog=new ProgressDialog(context).show(context,title,message,true,false);
        else
        {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }


    private static AlertDialog.Builder builder(Context context){
        return new AlertDialog.Builder(context);
    }
    public static void showAlertDialog(Context context,String title,String msg,String pbStr,DialogInterface.OnClickListener pbdo){
        builder(context).setMessage(msg)
                .setTitle(title)
                .setPositiveButton(pbStr,pbdo)
                .setCancelable(false)
                .show();
    }

    public static void showAlertDialog(Context context,String title,String msg,String pbStr,DialogInterface.OnClickListener pbdo,String nbStr,DialogInterface.OnClickListener nbdo){
        builder(context).setMessage(msg)
                .setTitle(title)
                .setPositiveButton(pbStr,pbdo)
                .setNegativeButton(nbStr,nbdo)
                .setCancelable(false)
                .show();
    }

    public static void DismssProgressDialog(){
        if (progressDialog!=null&&progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
