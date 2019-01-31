package com.example.seccion05.adapters;

import android.content.Context;
import android.widget.BaseAdapter;

import com.example.seccion05.models.Board;

import java.util.List;

public class BoardAdapter extends BaseAdapter {

    private Context context;
    private List<Board> list;
    private int layout;

    public BoardAdapter(Context context, List<Board> boards, int layout){
        this.context = context;
        this.list = boards;
        this.layout = layout;
    }

    public Context getContext() {
        return context;
    }

 /*   public void setContext(Context context) {
        this.context = context;
    }*/

    public List<Board> getList() {
        return list;
    }

    public void setList(List<Board> list) {
        this.list = list;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }
}
