package com.nmbb.vlc.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.AbsSeekBar;

/**
 * Created by admin on 2017/8/29.
 */

public class VolumeReceiver extends BroadcastReceiver {
    private AbsSeekBar sb_volume;

    public VolumeReceiver(AbsSeekBar sb_volume) {
        this.sb_volume = sb_volume;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        AudioManager audioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        //如果音量发生变化则更改seekbar的位置
        if(intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")){
            // 当前的媒体音量
            int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC) ;
            sb_volume.setProgress(currentVolume) ;
        }
    }
}
