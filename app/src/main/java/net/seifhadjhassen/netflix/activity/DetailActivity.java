package net.seifhadjhassen.netflix.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import net.seifhadjhassen.netflix.R;
import net.seifhadjhassen.netflix.adapter.ScreenShotAdapter;
import net.seifhadjhassen.netflix.model.MyListModel;
import net.seifhadjhassen.netflix.tools.Const;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MyListModel> listScreenShoot=new ArrayList<>();
    ScreenShotAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent=getIntent();
        MyListModel myListModel=intent.getParcelableExtra("params");


        listScreenShoot.add(new MyListModel(R.drawable.screen1));
        listScreenShoot.add(new MyListModel(R.drawable.screen2));
        listScreenShoot.add(new MyListModel(R.drawable.screen3));
        listScreenShoot.add(new MyListModel(R.drawable.screen4));
        listScreenShoot.add(new MyListModel(R.drawable.screen5));

        recyclerView=findViewById(R.id.recycler_detail);
        LinearLayoutManager lm=new LinearLayoutManager(getApplicationContext());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(lm);
        adapter=new ScreenShotAdapter(getApplicationContext(),listScreenShoot);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_fav:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

   /* public Bitmap crop(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());

        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }

        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap,
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);

        float r = size / 2f;
        //canvas.drawCircle(r, r, r, paint);
        RectF oval = new RectF(0, -source.getHeight(), source.getWidth(), source.getHeight());

        canvas.drawArc(oval,0,180,true,paint);
       // canvas.drawOval(oval,paint);
        //canvas.drawRoundRect(oval,Const.convertDpToPixel(25,getApplicationContext()),Const.convertDpToPixel(25,getApplicationContext()),paint);

        squaredBitmap.recycle();
        return bitmap;
    }

    private Bitmap processImage(Bitmap bitmap) {
        Bitmap bmp;

        bmp = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        BitmapShader shader = new BitmapShader(bitmap,
                BitmapShader.TileMode.CLAMP,
                BitmapShader.TileMode.CLAMP);

        float radius = bitmap.getWidth() / 2f;
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);

        RectF rect = new RectF(Const.convertDpToPixel(-100,getApplicationContext()), Const.convertDpToPixel(-300,getApplicationContext()),
                Const.convertDpToPixel(-100,getApplicationContext()), 0);
        canvas.drawOval(rect, paint);

        return bmp;
    }
    public  Bitmap getCircledBitmap(Bitmap bitmap) {

        Bitmap mask = BitmapFactory.decodeResource(getResources(),R.drawable.shape);

        //You can change original image here and draw anything you want to be masked on it.

        Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas tempCanvas = new Canvas(result);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        tempCanvas.drawBitmap(bitmap, 0, 0, null);
        tempCanvas.drawBitmap(mask, 0, 0, paint);
        paint.setXfermode(null);

        //Draw result after performing masking
        tempCanvas.drawBitmap(result, 0, 0, new Paint());
        return result;
    }*/
}
