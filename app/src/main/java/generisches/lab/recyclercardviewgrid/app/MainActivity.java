package generisches.lab.recyclercardviewgrid.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import generisches.lab.recyclercardviewgrid.R;
import generisches.lab.recyclercardviewgrid.adapter.RecyclerAdapter;
import generisches.lab.recyclercardviewgrid.model.Animal;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener{
    Toolbar mToolbar;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Home Page");
        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setOnMenuItemClickListener(this);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerAdapter lAdapter = new RecyclerAdapter(this, Animal.getData());
        mRecyclerView.setAdapter(lAdapter);

        LinearLayoutManager lLinearLayoutManagerVertical = new LinearLayoutManager(this);
        lLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(lLinearLayoutManagerVertical);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg + " Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.lvh:
                LinearLayoutManager lh = new LinearLayoutManager(this);
                lh.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(lh);
                break;

            case R.id.gv:
                GridLayoutManager gv = new GridLayoutManager(this, 2);
                mRecyclerView.setLayoutManager(gv);
                break;

            case R.id.svh:
                StaggeredGridLayoutManager sh = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(sh);
                break;

            case R.id.svv:
                StaggeredGridLayoutManager sv = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(sv);
                break;

            case R.id.lvv:
                LinearLayoutManager lv = new LinearLayoutManager(this);
                lv.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(lv);
                break;
        }
        return true;
    }
}








