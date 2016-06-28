package top.wuhaojie.white.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.RawRes;

import java.util.ArrayList;
import java.util.List;

import top.wuhaojie.white.entities.MediaPlayerWrapper;
import top.wuhaojie.white.entities.MusicItem;

/**
 * 建造者模式
 * Created by wuhaojie on 2016/6/27 22:33.
 */
public class MediaPlayerBuilder {

    private final Context mContext;
    private ArrayList<MediaPlayerWrapper> mMediaPlayers;

    public MediaPlayerBuilder(Context context) {
        this.mContext = context;
        mMediaPlayers = new ArrayList<>();
    }

    public MediaPlayerBuilder addItem(MusicItem item) {
        mMediaPlayers.add(new MediaPlayerWrapper(MediaPlayer.create(mContext, item.getResId()), item));
        return this;
    }

    public MediaPlayerBuilder addItem(@RawRes int resId) {
        mMediaPlayers.add(new MediaPlayerWrapper(MediaPlayer.create(mContext, resId), resId));
        return this;
    }

    public List<MediaPlayerWrapper> build() {
        return mMediaPlayers;
    }
}
