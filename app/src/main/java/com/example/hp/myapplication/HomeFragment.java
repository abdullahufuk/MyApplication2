package com.example.hp.myapplication;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    RecyclerView recyclerView;
    Bitmap []bitmaps;
    String []isimler=new String[9];
    int []images={R.drawable.aya_irini,R.drawable.ayasofya,R.drawable.eyup_sultan
    ,R.drawable.fatih,R.drawable.sivas_ulu,R.drawable.sultanahmet,R.drawable.suleymaniye,
    R.drawable.sehzade,R.drawable.zeyrek};
    public HomeFragment() {
        // Required empty public constructor


    }


    private Bitmap[] getBitmaps() {

        Bitmap []tempBitmaps=new Bitmap[9];
        tempBitmaps[0]= BitmapFactory.decodeResource(getResources(),R.drawable.aya_irini_cami);
        tempBitmaps[1]= BitmapFactory.decodeResource(getResources(),R.drawable.ayasofya_camii_istanbul);
        tempBitmaps[2]= BitmapFactory.decodeResource(getResources(),R.drawable.eyup_sultan_cami);
        tempBitmaps[3]= BitmapFactory.decodeResource(getResources(),R.drawable.fatih_camii);
        tempBitmaps[4]= BitmapFactory.decodeResource(getResources(),R.drawable.sivas_ulu_camii);
        tempBitmaps[5]= BitmapFactory.decodeResource(getResources(),R.drawable.sultanahmet_camii_istanbul);
        tempBitmaps[6]= BitmapFactory.decodeResource(getResources(),R.drawable.suleymaniye_camii);
        tempBitmaps[7]= BitmapFactory.decodeResource(getResources(),R.drawable.sehzade_camii);
        tempBitmaps[8]= BitmapFactory.decodeResource(getResources(),R.drawable.zeyrek_cami);

        isimler[0]="Aya İrini Camii";
        isimler[1]="Ayasofya Camii";
        isimler[2]="Eyüp Sultan Camii";
        isimler[3]="Fatih Camii";
        isimler[4]="Sivas Ulu Camii";
        isimler[5]="Sultan Ahmet Camii";
        isimler[6]="Süleymaniye Camii";
        isimler[7]="Şehzade Mehmed Camii";
        isimler[8]="Zeyrek Camii";

        return tempBitmaps;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(),isimler[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
               Intent intent=new Intent(getContext(),PopupActivity.class);
               intent.putExtra("images",images);
               intent.putExtra("isimler",isimler);
               startActivity(intent);
            }
        }));
        bitmaps=getBitmaps();
        MyRecyclerAdapter recyclerAdapter=new MyRecyclerAdapter(bitmaps);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<GridHolder>{

        Bitmap []bitmaps;

        public MyRecyclerAdapter(Bitmap[] bitmaps) {
            this.bitmaps = bitmaps;
        }

        @NonNull
        @Override
        public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(getContext()).inflate(R.layout.grid_recycle_view,parent,false);

            return new GridHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GridHolder holder, int position) {
            holder.imageView.setImageBitmap(bitmaps[position]);
            holder.textView.setText(isimler[position]);
        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }

    private class GridHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView textView;
        public GridHolder(View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageViewMainImage);
            textView=itemView.findViewById(R.id.textViewCaption);
        }
    }

}
