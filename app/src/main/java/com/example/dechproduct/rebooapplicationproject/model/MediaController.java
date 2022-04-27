package com.example.dechproduct.rebooapplicationproject.model;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MediaController {

    private MediaRecorder _recorder;
    private MediaPlayer _player;
    private String TEMP_FILENAME = "/_TEMP.3gp";

    private Audio _temp_audio;

    public MediaController() {
        /*
        File DIR = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        if(!DIR.exists())
            DIR.mkdirs();

         */
        _temp_audio = new Audio(Environment.getExternalStorageDirectory().getAbsolutePath() + TEMP_FILENAME);
    }

    public void startRecord(){
        try{
            //File.createTempFile("Audio",".3gp", new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS).getAbsolutePath()));

            _recorder = new MediaRecorder();
            _recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            _recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            _recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            _recorder.setOutputFile(_temp_audio.getPath());

            _recorder.prepare();
            _recorder.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopRecord(){
        try{
            _recorder.stop();
            _recorder.reset();
            _recorder.release();
            _recorder = null;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void startPlayback(Preset preset, Float speed){
        try{
            _player = new MediaPlayer();
            PlaybackParams Parameters = new PlaybackParams();
            Parameters.setPitch(preset.getPitch());
            Parameters.setSpeed(speed);

            _player.setDataSource(_temp_audio.getPath());
            _player.prepare();
            _player.setPlaybackParams(Parameters);
            _player.setVolume(.8f,.8f);
            this.looping();
            _player.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopPlayback(){
        try{
            _player.stop();
            _player.reset();
            _player.release();
            _player = null;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveToDevice(String Name) throws IOException {

        Log.w("File", Boolean.toString(_temp_audio.getFile().exists()));
        String Destination_Path = "";

        try (InputStream Writer = new FileInputStream(_temp_audio.getFile())) {
            Destination_Path = _temp_audio.getFile().getParentFile().getAbsolutePath() +
                    File.separator +Name+".3gp";
            try (OutputStream out = new FileOutputStream(Destination_Path)) {
                byte[] buf = new byte[1024];
                int len;
                while ((len = Writer.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
            }
        }
        finally {
            Log.w("File", Destination_Path);
            Log.w("File", _temp_audio.getPath());
            Log.w("File", Boolean.toString(new File(Destination_Path).exists()));
        }

    }

    public void removeFromDevice(String FileName) throws IOException{
        String Source_Path = _temp_audio.getFile().getParentFile().getAbsolutePath() +
                File.separator + FileName + ".3gp";
        try{
            File TargetFile = new File(Source_Path);
            if(TargetFile.exists()){
                TargetFile.delete();
            }
        }
        catch (Exception e){}
    }

    public void readAudio(String Name) throws IOException {

    }

    public boolean isPlaying() {
        if (_player == null) {
            return false;
        }
        return _player.isPlaying();
    }

    public void looping() {
        if (_player == null) {
            return;
        }
        if (_player.isLooping()) {
            _player.setLooping(false);
        } else {
            _player.setLooping(true);
        }
    }

}
