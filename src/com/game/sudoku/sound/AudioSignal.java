package com.game.sudoku.sound;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;


/*
 * サウンドを作成するクラスです。
 *
 */

public class AudioSignal {
    //周波数
    public final static double FREQUENCY_C5 = 523.25;
    public final static double FREQUENCY_D5 = 587.33;
    public final static double FREQUENCY_E5 = 659.26;
    public final static double FREQUENCY_F5 = 698.46;
    public final static double FREQUENCY_G5 = 783.99;
    public final static double FREQUENCY_A5 = 880.00;
    public final static double FREQUENCY_B5 = 987.77;
    public final static double FREQUENCY_C6 = 1046.50;
    //AudioTrack
    private AudioTrack audioTrack;
    //サンプルレート
    private int sampleRate;
    //バッファーサイズ
    private int bufferSize;

    //コンストラクタ
    public AudioSignal(int sampleRate,int bufferSize) {
        this.sampleRate=sampleRate;
        this.bufferSize=bufferSize;
        //AudioTrackオブジェクトの作成
        this.audioTrack = new AudioTrack(
                AudioManager.STREAM_MUSIC,                //streamType
                this.sampleRate,                        //sampleRateInHz:サンプリング周波数
                AudioFormat.CHANNEL_CONFIGURATION_MONO,    //channelConfig(モノラル指定)
                AudioFormat.ENCODING_DEFAULT,            //audioFormat
                this.bufferSize,                        //bufferSizeInBytes:バッファサイズ(奇数だとエラーになる模様
                AudioTrack.MODE_STATIC);                //mode(STATICモード指定)
    }
    //矩形波作成(ファミコンみたいな音)
    public byte[] getSquareWave(double frequency) {
        byte[] b = new byte[this.bufferSize];
        for (int i = 0; i < b.length; i++) {
            double r = i / (this.sampleRate / frequency);
            b[i] = (byte)((Math.round(r) % 2 == 0) ? 100 : -100);
        }
        return b;
    }
    //getter
    public AudioTrack getAudioTrack() {
        return audioTrack;
    }
}