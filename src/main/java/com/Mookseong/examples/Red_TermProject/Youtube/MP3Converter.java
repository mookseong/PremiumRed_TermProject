package com.Mookseong.examples.Red_TermProject.Youtube;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.IOException;
import java.util.logging.Logger;

class MP3Converter {

   // private static final Logger LOG = Logger.getLogger(MP3Converter.class.getName());
    String mp4File = "./mp3/temp/tempVideos.mp4";
    String mp3File = "./mp3/temp/";

    private void mp4tomp3() throws IOException {
        FFmpeg ffmpeg = new FFmpeg("/usr/local/bin/ffmpeg");
        FFprobe ffprobe = new FFprobe("/usr/local/bin/ffprobe");

        FFmpegBuilder builder = new FFmpegBuilder()
                .overrideOutputFiles(true)
                .addExtraArgs("-i")
                .addInput(mp4File)
                .addOutput(mp3File + "mergeVideo.mp3")
                .done();
        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createJob(builder).run();
    }

    public static void main(String[] args){
        MP3Converter mp3Converter =new MP3Converter();
        try {
            mp3Converter.mp4tomp3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
