package es.ieslavereda.activities;

import android.os.Bundle;
import android.view.View;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.Root;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.activities.model.RecycleView;
import es.ieslavereda.base.CallInterface;


public class ContenidoActivity extends BaseActivity implements CallInterface, View.OnClickListener {

    private RecyclerView contenido;
    private RecycleView recycleView;
    private Root root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
        contenido = findViewById(R.id.recyclerViewContenido);

    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void doInUI() {
        hideProgress();
        RecycleView recycleView = new RecycleView(this, root);
        recycleView.setOnClickListener(this);
        contenido.setAdapter(recycleView);
        contenido.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {
    }
}
