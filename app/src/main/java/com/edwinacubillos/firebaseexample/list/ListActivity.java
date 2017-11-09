package com.edwinacubillos.firebaseexample.list;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.edwinacubillos.firebaseexample.R;
import com.edwinacubillos.firebaseexample.model.User;
import com.edwinacubillos.firebaseexample.sqlite.ContactosSQLiteHelper;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

//    final String[] nombres = new String[]{"Edwin", "Andres", "Carlos", "Melissa"};

/*    private User[] user = new User[] {
            new User("User0","Edwin","edwin@gmail.com","3146562451"),
            new User("User1","Andres","andres@gmail.com","3154578965"),
            new User("User2","Carlos","Carlos@gmail.com","3152662451"),
            new User("User3","Melissa","melissa@gmail.com","315451254")};*/

    ContactosSQLiteHelper contactosSQLiteHelper;
    SQLiteDatabase dbContactos;
    // private ListView listView;
    private ArrayList<User> users;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        users = new ArrayList<User>();

        contactosSQLiteHelper = new ContactosSQLiteHelper(this, "agendaBD", null, 1);
        dbContactos = contactosSQLiteHelper.getWritableDatabase();

        Cursor cursor = dbContactos.rawQuery("SELECT * FROM contactos", null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User(String.valueOf(cursor.getInt(0)),
                        cursor.getString(1),
                        cursor.getString(3),
                        cursor.getString(2));
                users.add(user);
            } while (cursor.moveToNext());
        }

        ContactosAdapter adapter = new ContactosAdapter(this, users);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);





 /*       ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,nombres);*/

 /*       FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("usuarios");*/

        //    listView = (ListView) findViewById(R.id.list);
        //       users = new ArrayList<User>();

        //      final Adapter adapter = new Adapter(this, users);

        //   listView.setAdapter(adapter);

 /*       myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot userSnapshot: dataSnapshot.getChildren()){
                    users.add(userSnapshot.getValue(User.class));
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });*/

/*        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, String.valueOf(position),Toast.LENGTH_LONG).show();
            }
        });*/
    }



 /*   class Adapter extends ArrayAdapter<User>{

        public Adapter(Context context, ArrayList<User> user) {
            super(context, R.layout.list_item, user);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item, null);

            User user = getItem(position);

            TextView tUid = item.findViewById(R.id.tID);
            tUid.setText(user.getUid());

            TextView tName = item.findViewById(R.id.tName);
            tName.setText(user.getName());

            TextView tEmail = item.findViewById(R.id.tEmail);
            tEmail.setText(user.getEmail());

            TextView tPhone = item.findViewById(R.id.tPhone);
            tPhone.setText(user.getPhone());

            return item;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){

            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }

     //Con un arreglo de objetos
    class Adapter extends ArrayAdapter<User>{

        public Adapter(Context context, User[] user) {
            super(context, R.layout.list_item, user);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item, null);

            TextView tUid = item.findViewById(R.id.tID);
            tUid.setText(user[position].getUid());

            TextView tName = item.findViewById(R.id.tName);
            tName.setText(user[position].getName());

            TextView tEmail = item.findViewById(R.id.tEmail);
            tEmail.setText(user[position].getEmail());

            TextView tPhone = item.findViewById(R.id.tPhone);
            tPhone.setText(user[position].getPhone());

            return item;
        }
    }*/

}
