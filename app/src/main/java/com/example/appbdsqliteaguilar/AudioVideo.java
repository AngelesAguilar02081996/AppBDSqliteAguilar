package com.example.appbdsqliteaguilar;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;

public class AudioVideo extends AppCompatActivity implements View.OnClickListener { //Inicia clase

    public Button btnReproducir, btnDetener;
    public MediaPlayer reproductor;
    public VideoView videoPrueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//Inicia OnCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_video);

        btnReproducir=findViewById(R.id.btnReproducir);
        btnDetener=findViewById(R.id.btnDetener);
        videoPrueba=(VideoView)findViewById(R.id.vvPrueba);

        btnReproducir.setOnClickListener(this);
        btnDetener.setOnClickListener(this);

        //para reproducir video
        Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);//recursos externos
        MediaController mc = new MediaController(this);//instancia para controles de video y reproduccion
        videoPrueba.setMediaController(mc);//Coloca los botones de reprocur, pausa y detener
        videoPrueba.setVideoURI(path);//llamado del URI es para identificar el cursos video a reproducir
        videoPrueba.setMediaController(new MediaController(this));//Integra los controles y el recurso URI
        videoPrueba.start();//ejecucion

    }//Termina OncCreate

    @Override
    public void onClick(View view) { //Inicia metodo sobrecargado
        if(view.getId()==R.id.btnReproducir){
            play_mp1();
        }

        if(view.getId()==R.id.btnDetener){
            stop();
        }

    }//Termina metodo sobrecargado

    private void play_mp1(){//inicia metodo
        reproductor=MediaPlayer.create(this, R.raw.sonido);
        reproductor.start();
    }//termina metodo

    private void stop(){//inicia metodo
        reproductor.stop();
    }//termina metodo
} //Termina clase