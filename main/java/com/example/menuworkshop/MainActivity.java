package com.example.menuworkshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {

    Button button_option_menu, button_context_menu,button_popup_menu;
    private ActionMode mActionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_option_menu =findViewById(R.id.btn_option);
        button_context_menu=findViewById(R.id.btn_context);
        button_popup_menu=findViewById(R.id.btn_popup);
        button_option_menu.setOnClickListener(onViewclick);
        registerForContextMenu(button_context_menu);
        button_context_menu.setOnClickListener(onViewclick);
        button_popup_menu.setOnClickListener(onViewclick);

    }
    View.OnClickListener onViewclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case  R.id.btn_option:
                    Toast.makeText(MainActivity.this,"Click overflow Button In the ActionBar",Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_context:
                    Toast.makeText(MainActivity.this,"LongPress To Show ContextMenu",Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_popup:
                    showPopupMenu(view);
                    break;
                    default:
                        break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        switch (id) {
            case R.id.op_delete:
                Toast.makeText(this, "Delete.....", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op_save:
                Toast.makeText(this, "Save.....", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op_share:
                Toast.makeText(this, "Share...", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void showPopupMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);

        // This activity implements OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menus);
        popup.show();
    }



    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
       switch (menuItem.getItemId())
       {
           case R.id.item_setWal:
               Toast.makeText(this,"Wallpaper Changed" ,Toast.LENGTH_SHORT).show();
               break;
           case R.id.item_edit:
               Toast.makeText(this,"Edit Clicked",Toast.LENGTH_SHORT).show();
               break;
           case R.id.item_share:
               Toast.makeText(this,"Share Clicked",Toast.LENGTH_SHORT).show();
               break;

       }
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.co_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.co_delete:
                Toast.makeText(this, "Delete....", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.co_edit:
                Toast.makeText(this, "Edit...", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

