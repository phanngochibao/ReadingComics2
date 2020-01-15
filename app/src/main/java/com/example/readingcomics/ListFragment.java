package com.example.readingcomics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements ComicAdapter.onClick_comicItem {
    RecyclerView recyclerView;
    List<ComicModel> comicList;
    ImageButton add_comic;
    ComicDB_CRUD comicDB_crud;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        comicList = new ArrayList();
        comicDB_crud = ComicDB_CRUD.getInstance(getContext());
        comicList = comicDB_crud.loadComic();
        comicList.add(new ComicModel("https://upload.wikimedia.org/wikipedia/vi/b/bc/B%C3%ACa_truy%E1%BB%87n_Doraemon_t%E1%BA%ADp_1_sau_2010_VN.jpg", "DORAEMON - chú mèo máy đến từ tương lai  tập 1",
                "Bộ truyện kể về một chú mèo máy tên là Doraemon đến từ thế kỉ 22 để giúp một cậu bé lớp 5-3 hậu đậu tên là Nobi Nobita."));
        comicList.add(new ComicModel("https://salt.tikicdn.com/cache/550x550/ts/product/fb/a6/b9/0e4a0833e9639f5c4435e251de033b6f.jpg","ONE PIECE tập 57: Trận chiến thượng đỉnh"," One Piece nói về cuộc hành trình của Monkey D. Luffy - thuyền trưởng của băng hải tặc Mũ Rơm và các đồng đội của cậu. Luffy tìm kiếm vùng biển bí ẩn nơi cất giữ kho báu lớn nhất thế giới One Piece, với mục đích trở thành Tân Vua Hải Tặc."));
        comicList.add(new ComicModel("https://upload.wikimedia.org/wikipedia/vi/0/09/Demon_Slayer_-_Kimetsu_no_Yaiba%2C_volume_1.jpg","DEMON SLAYER tập 1", "Kamado Tanjirou[3] là một cậu bé tốt bụng, thông minh sống cùng gia đình trên núi và kiếm tiền bằng cách bán than củi. Tất cả mọi thứ thay đổi khi gia đình cậu bị tấn công và tàn sát bởi quỷ (oni). Tanjirou và em gái Nezuko là những người còn sống sót sau vụ việc đó, mặc dù Nezuko giờ đã trở thành quỷ."));
        comicList.add(new ComicModel("https://upload.wikimedia.org/wikipedia/vi/3/3e/Naruto_01_m.jpg","NARUTO tập 1", " Nhân vật chính là Uzumaki Naruto, một thiếu niên ồn ào, hiếu động, một ninja luôn muốn tìm cách khẳng định mình để được mọi người công nhận, rất muốn trở thành Hokage (Hỏa Ảnh) - người lãnh đạo ninja cả làng, được tất cả mọi người kính trọng."));
        comicList.add(new ComicModel("https://i.pinimg.com/originals/d3/58/62/d3586205ce95952e9b406435f018362c.jpg","CCONAN tập 80","Mở đầu câu truyện, cậu học sinh trung học 17 tuổi Shinichi Kudo bị tội phạm biến thành cậu bé Conan Edogawa."));
        ComicAdapter comicAdapter = new ComicAdapter(getContext(), comicList, this);
        recyclerView.setAdapter(comicAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        add_comic = view.findViewById(R.id.add_comic);
        add_comic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frame_layout, new Fragment_AddComic()).addToBackStack(null).commit();
            }
        });

        return view;
    }

    @Override
    public void onClick(ComicModel comicModel) {
        getFragmentManager().beginTransaction().replace(R.id.frame_layout, new ComicFragment(comicModel)).addToBackStack(null).commit();
    }


}