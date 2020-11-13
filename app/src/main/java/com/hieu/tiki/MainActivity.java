package com.hieu.tiki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    CardAdapter cardAdapter;
    List<CardItem> lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView);
        lc=getListData();
        cardAdapter=new CardAdapter(this,lc);
        gridView.setAdapter(cardAdapter);
        registerForContextMenu(this.gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CardItem cardItem=(CardItem) getListData().get(position);
                Intent intent=new Intent(MainActivity.this,GridContext.class);
                intent.putExtra("noidung",cardItem.getMota());
                startActivity(intent);
            }
        });
    }

    private List<CardItem> getListData() {
        List<CardItem> cardItemList=new ArrayList<>();
        CardItem cardItem1=new CardItem(R.drawable.ic_launcher_foreground,"Điện thoại Nokia","Điện Nokia siêu xịn");
        CardItem cardItem3=new CardItem(R.drawable.ic_launcher_foreground,"Điện thoại Samsung","Điện Samsung siêu xịn");
        CardItem cardItem4=new CardItem(R.drawable.ic_launcher_foreground,"Điện thoại LG","Điện LG siêu xịn");
        CardItem cardItem5=new CardItem(R.drawable.ic_launcher_foreground,"Điện thoại Xiaomi","Điện Xiaomi siêu xịn");
        CardItem cardItem6=new CardItem(R.drawable.ic_launcher_foreground,"Điện thoại Realme","Điện Realme siêu xịn");
        CardItem cardItem7=new CardItem(R.drawable.ic_launcher_foreground,"Điện thoại Oppo","Điện Oppo siêu xịn");

        cardItemList.add(cardItem1);
        cardItemList.add(cardItem3);
        cardItemList.add(cardItem4);
        cardItemList.add(cardItem5);
        cardItemList.add(cardItem6);
        cardItemList.add(cardItem7);
        return cardItemList;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Chọn hành động");
        menu.add(0,1,0,"Xóa");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final CardItem cardItemSelected=(CardItem) this.getListData().get(info.position);
        if(item.getItemId() == 1){
            // Ask before deleting.
            new AlertDialog.Builder(this)
                    .setMessage(cardItemSelected.getTen()+". Bạn có muốn xoá?")
                    .setCancelable(false)
                    .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            deleteItem(info.position);
                        }
                    })
                    .setNegativeButton("Không", null)
                    .show();
        }
        else
            return false;
        return true;
    }
    private void deleteItem(int item)  {
        lc.remove(item);
        cardAdapter.notifyDataSetChanged();
    }
}