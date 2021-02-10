package com.example.favoritemoviesmvvmroomlivedata.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Movie.class, Genre.class}, version = 1)
public abstract class MoviesDatabase extends RoomDatabase {

    private static MoviesDatabase instance;

    public static synchronized MoviesDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MoviesDatabase.class, "moviesDB")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InitialDataAsyncTask(instance).execute();
        }
    };

    private static class InitialDataAsyncTask extends AsyncTask<Void,Void,Void>{

        private GenreDao genreDao;
        private MovieDao movieDao;

        public InitialDataAsyncTask(MoviesDatabase database){
            genreDao = database.getGenreDao();
            movieDao = database.getMovieDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

    public abstract MovieDao getMovieDao();

    public abstract GenreDao getGenreDao();
}
