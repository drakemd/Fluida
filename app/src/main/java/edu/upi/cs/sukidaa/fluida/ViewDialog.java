package edu.upi.cs.sukidaa.fluida;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.Latihan.Soal;

/**
 * Created by drake on 6/17/2017.
 */

public class ViewDialog {

    public void showDialogExit(final Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.exit_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView tekskonfirmasi = (TextView)dialog.findViewById(R.id.tekskonfirmasi);
        TextView titlekonfirmasi = (TextView)dialog.findViewById(R.id.titlekonfirmasi);
        Typeface textfont= Typeface.createFromAsset(activity.getAssets(),"BENGUIAN.TTF");
        tekskonfirmasi.setText("Apakah anda ingin keluar dari aplikasi?");
        titlekonfirmasi.setText("Konfirmasi Keluar");
        tekskonfirmasi.setTypeface(textfont);
        titlekonfirmasi.setTypeface(textfont);
        ImageButton dialogBtn_cancel = (ImageButton) dialog.findViewById(R.id.buttonno);
        dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                    Toast.makeText(getApplicationContext(),"Cancel" ,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        ImageButton dialogBtn_okay = (ImageButton) dialog.findViewById(R.id.buttonyes);
        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                    Toast.makeText(getApplicationContext(),"Okay" ,Toast.LENGTH_SHORT).show();
                activity.finish();
                dialog.cancel();
            }
        });

        dialog.show();
    }

    public void showConfirmation(final Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.exit_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        TextView tekskonfirmasi = (TextView)dialog.findViewById(R.id.tekskonfirmasi);
        TextView titlekonfirmasi = (TextView)dialog.findViewById(R.id.titlekonfirmasi);
        Typeface textfont= Typeface.createFromAsset(activity.getAssets(),"BENGUIAN.TTF");
        tekskonfirmasi.setText("Apakah anda yakin?");
        titlekonfirmasi.setText("Konfirmasi Selesai");
        tekskonfirmasi.setTypeface(textfont);
        titlekonfirmasi.setTypeface(textfont);
        ImageButton dialogBtn_cancel = (ImageButton) dialog.findViewById(R.id.buttonno);
        dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                    Toast.makeText(getApplicationContext(),"Cancel" ,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        ImageButton dialogBtn_okay = (ImageButton) dialog.findViewById(R.id.buttonyes);
        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                    Toast.makeText(getApplicationContext(),"Okay" ,Toast.LENGTH_SHORT).show();
                ((Soal)activity).cekNilai();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
