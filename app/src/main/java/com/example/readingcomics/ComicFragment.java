package com.example.readingcomics;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;

@SuppressLint("ValidFragment")
public class ComicFragment extends Fragment {
    ComicModel comicModel;

    public ComicFragment(ComicModel comicModel) {
        this.comicModel = comicModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_comic, container, false);

        TextView content = view.findViewById(R.id.comic_content);
        ImageView image = view.findViewById(R.id.comic_image);
        TextView introduction = view.findViewById(R.id.comic_introduction);

        content.setText(comicModel.getComic_name());
        Glide.with(getContext()).load(comicModel.getComic_img()).fitCenter().into(image);
        introduction.setText(comicModel.getComic_introduction());
        return view;
    }
}