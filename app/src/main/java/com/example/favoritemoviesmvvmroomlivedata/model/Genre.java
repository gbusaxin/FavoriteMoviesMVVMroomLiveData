package com.example.favoritemoviesmvvmroomlivedata.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "genres_table")
public class Genre extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "genre_name")
    private String genreName;

    public Genre(int id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    @Ignore
    public Genre() {
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genre) {
        this.genreName = genre;
        notifyPropertyChanged(BR.genreName);
    }
}
