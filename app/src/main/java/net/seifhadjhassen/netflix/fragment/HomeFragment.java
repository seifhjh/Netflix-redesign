package net.seifhadjhassen.netflix.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.seifhadjhassen.netflix.R;
import net.seifhadjhassen.netflix.activity.DetailActivity;
import net.seifhadjhassen.netflix.adapter.CategorieAdapter;
import net.seifhadjhassen.netflix.adapter.HeaderAdapter;
import net.seifhadjhassen.netflix.adapter.MyListAdapter;
import net.seifhadjhassen.netflix.model.CategModel;
import net.seifhadjhassen.netflix.model.HeaderModel;
import net.seifhadjhassen.netflix.model.MyListModel;
import net.seifhadjhassen.recyclerviewpager.PagerAdapter;
import net.seifhadjhassen.recyclerviewpager.PagerModel;
import net.seifhadjhassen.recyclerviewpager.RecyclerViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {



    View view;
    RecyclerViewPager recycler_header;
    RecyclerView recycler_categ,recycler_my_list,recycler_popular;
    List<HeaderModel> listHeader=new ArrayList<>();
    List<CategModel> listCateg=new ArrayList<>();
    List<MyListModel> myList=new ArrayList<>();
    List<MyListModel> listPopular=new ArrayList<>();

    HeaderAdapter headerAdapter;
    CategorieAdapter categAdapter;
    MyListAdapter myListAdapter,popularAdapter;
    Timer timer=new Timer();
    int count=0;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_home, container, false);
        recycler_header=view.findViewById(R.id.recycler_home_header);
        recycler_categ=view.findViewById(R.id.recycler_home_categ);
        recycler_my_list=view.findViewById(R.id.recycler_home_my_list);
        recycler_popular=view.findViewById(R.id.recycler_home_pop);


        initHeader();
        initCateg();
        initMyList();
        initPopular();


        return view;
    }




    private void initHeader() {
        recycler_header.addItem(new PagerModel(R.drawable.cover1,"Vikings",getActivity()));
        recycler_header.addItem(new PagerModel(R.drawable.cover2,"The nutcracker and the four realms",getActivity()));
        recycler_header.addItem(new PagerModel(R.drawable.cover3,"Flash",getActivity()));
        recycler_header.start();
        recycler_header.setOnItemClickListener(new PagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("params",myList.get(position));

                startActivity(intent);
            }
        });

    }

    private void initCateg() {
        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_my_list.setLayoutManager(lm);
        listCateg.add(new CategModel(R.drawable.cover1,"Discover"));
        listCateg.add(new CategModel(R.drawable.cover2,"Categories"));
        listCateg.add(new CategModel(R.drawable.cover3,"Discover"));

        categAdapter=new CategorieAdapter(getActivity(),listCateg);
        recycler_categ.setAdapter(categAdapter);




        categAdapter.setOnclickItemListener(new CategorieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("params",myList.get(position));

                startActivity(intent);
            }
        });
    }

    private void initMyList() {
        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_my_list.setLayoutManager(lm);
        myList.add(new MyListModel(R.drawable.list1));
        myList.add(new MyListModel(R.drawable.list2));
        myList.add(new MyListModel(R.drawable.list3));

        myListAdapter=new MyListAdapter(getActivity(),myList);
        recycler_my_list.setAdapter(myListAdapter);




        myListAdapter.setOnclickItemListener(new MyListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("params",myList.get(position));

                startActivity(intent);

            }
        });
    }

    private void initPopular() {
        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_popular.setLayoutManager(lm);
        listPopular.add(new MyListModel(R.drawable.list4));
        listPopular.add(new MyListModel(R.drawable.list5));
        listPopular.add(new MyListModel(R.drawable.list6));

        popularAdapter=new MyListAdapter(getActivity(),listPopular);
        recycler_popular.setAdapter(popularAdapter);




        popularAdapter.setOnclickItemListener(new MyListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("params",myList.get(position));

                startActivity(intent);

            }
        });
    }


}
