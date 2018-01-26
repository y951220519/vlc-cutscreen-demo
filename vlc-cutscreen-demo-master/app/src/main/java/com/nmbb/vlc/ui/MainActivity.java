package com.nmbb.vlc.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.nmbb.vlc.R;
import com.nmbb.vlc.models.VideoInfo;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(MainActivity.this, VlcVideoActivity.class);
            VideoInfo video = new VideoInfo();
            video.setDisplayName("新闻联播");
            video.setDuration(1000000000);
//            video.setPath("/storage/emulated/0/Download/环保小视频.mp4");
//            video.setPath("/storage/emulated/0/Download/环保小视频.mp4");
            video.setPath("http://vod.cntv.lxdns.com/flash/mp4video50/TMS/2016/04/19/f1db9354900946a19a7fefc3bf040593_h264200000nero_aac16.mp4");
//            video.setPath("http://game-tq.oss-cn-beijing.aliyuncs.com/video/%E9%AC%BC%E5%90%B9%E7%81%AF%E4%B9%8B%E9%BB%84%E7%9A%AE%E5%AD%90%E5%9D%9F01.mp4");
            video.setSize(100000);
            video.setTitle("最後一滴水");
            //传递VideoInfo实例
            intent.putExtra(VideoInfo.class.getSimpleName(), video);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            /*Intent intent = new Intent(MainActivity.this, VideoActivity.class);
            VideoInfo video = new VideoInfo();
            video.setDisplayName("新闻联播");
            video.setDuration(1000000000);
//            video.setPath("/storage/emulated/0/Download/环保小视频.mp4");
//            video.setPath("/storage/emulated/0/Download/环保小视频.mp4");
            video.setPath("http://vod.cntv.lxdns.com/flash/mp4video50/TMS/2016/04/19/f1db9354900946a19a7fefc3bf040593_h264200000nero_aac16.mp4");
//            video.setPath("http://game-tq.oss-cn-beijing.aliyuncs.com/video/%E9%AC%BC%E5%90%B9%E7%81%AF%E4%B9%8B%E9%BB%84%E7%9A%AE%E5%AD%90%E5%9D%9F01.mp4");
            video.setSize(100000);
            video.setTitle("最後一滴水");
            //传递VideoInfo实例
            intent.putExtra(VideoInfo.class.getSimpleName(), video);
            startActivity(intent);*/
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(MainActivity.this, RecycleviewActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
