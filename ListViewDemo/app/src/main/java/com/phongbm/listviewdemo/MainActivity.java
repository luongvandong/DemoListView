package com.phongbm.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private GridView livFaces;
    private ArrayList<Face> faces;
    private FaceAdapter faceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initFaces();
    }

    private void initViews() {
        livFaces = (GridView) findViewById(R.id.liv_faces);
        livFaces.setOnItemClickListener(this);
        livFaces.setOnItemLongClickListener(this);
    }

    private void initFaces() {
        faces = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            faces.add(new Face("Beauty", R.drawable.ic_beauty));
            faces.add(new Face("Cry", R.drawable.ic_cry));
            faces.add(new Face("Dribble", R.drawable.ic_dribble));
            faces.add(new Face("Oh", R.drawable.ic_oh));
            faces.add(new Face("Sweet Kiss", R.drawable.ic_sweet_kiss));
        }

        faceAdapter = new FaceAdapter(this, faces);

        livFaces.setAdapter(faceAdapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,
                "Position: " + position,
                Toast.LENGTH_SHORT).show();

        faces.remove(position);
        faceAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,
                "Long clicked: " + position,
                Toast.LENGTH_SHORT).show();
        return true;
    }

}