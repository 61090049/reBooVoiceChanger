package com.example.dechproduct.rebooapplicationproject.model;

import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;

public class Audio {

    private String _Path;
    private File _File;
    private String _Name;
    private long _Duration;
    private long _CreatedDate;

    private MediaMetadataRetriever _Retriever;

    public Audio(String Path) {
        reloadPath(Path);
    }

    public void reloadMetaData(){
        try {
            _Retriever = new MediaMetadataRetriever();
            _Retriever.setDataSource(_Path);

            _File = new File(_Path);
            _Name = _File.getName();
            _Duration = Long.parseLong(
                    _Retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
            _CreatedDate = _File.lastModified();
        }
        catch (Exception e){
            ;
        }
    }

    public void reloadPath(String Path){
        _Path = Path;
        reloadMetaData();
    }

    public String getName(){
        return String.valueOf(_Name);
    }

    public String getDuration(){
        return String.valueOf(_Duration);
    }

    public String getCreatedDate() {
        return String.valueOf(_CreatedDate);
    }

    public String getPath(){
        return _Path;
    }

    public File getFile(){
        return _File;
    }
}
