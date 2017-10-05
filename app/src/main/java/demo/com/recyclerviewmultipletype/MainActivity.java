package demo.com.recyclerviewmultipletype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<Object> chatList;
    private ChatAdapter chatdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        // Set Layout Manager
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // Limiting the size
        //recyclerView.setHasFixedSize(true);
        // Initialize list items
        init();
    }
    private void init(){
        chatList =new ArrayList<>();

        chatList.add(new PhotoMessage("Obama","9:30 AM"));
        chatList.add(new PhotoMessage("Clinton","9:40 AM"));
        chatList.add(new TextMessage("Bush","Hey, what's up?","9:42 AM"));
        chatList.add(new PhotoMessage("Ronaldo","9:45 AM"));
        chatList.add(new TextMessage("Messi","Are you writing blog?","9:48 AM"));
        chatList.add(new PhotoMessage("Hung","9:50 AM"));
        chatList.add(new PhotoMessage("Lam","9:55 AM"));
        chatList.add(new TextMessage("Huong","Thanks dude","9:57 AM"));
        chatList.add(new PhotoMessage("Hang","10:00 AM"));
        chatList.add(new PhotoMessage("Hoa","10:05 AM"));
        chatList.add(new TextMessage("Lan","Let's hang up","10:10 AM"));
        chatList.add(new PhotoMessage("Hue","10:15 AM"));
        chatList.add(new PhotoMessage("A","10:20 AM"));
        chatList.add(new PhotoMessage("B","10:25 AM"));
        chatList.add(new PhotoMessage("C","10:30 AM"));
        chatList.add(new TextMessage("D","Bring me some chocolates","1035:10 AM"));
        chatList.add(new PhotoMessage("E","10:40 AM"));
        chatList.add(new PhotoMessage("F","10:45 AM"));

        chatdapter =new ChatAdapter(this, chatList);
        recyclerView.setAdapter(chatdapter);
    }
}

