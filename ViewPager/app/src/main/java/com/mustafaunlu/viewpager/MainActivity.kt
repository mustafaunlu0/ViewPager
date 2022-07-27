package com.mustafaunlu.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMoviesViewPager()
    }

    private fun setupMoviesViewPager(){

        val moviesViewPager : ViewPager2=findViewById(R.id.moviesViewPager)
        moviesViewPager.clipToPadding=false
        moviesViewPager.clipChildren=false
        moviesViewPager.offscreenPageLimit=3
        moviesViewPager.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(10))
        compositePageTransformer.addTransformer { page, position ->
            val r =1 - abs(position)
            //page.scaleY=0.85f + r + 0.15f
            page.scaleY=0.8f +(r/5)

        }
        moviesViewPager.setPageTransformer(compositePageTransformer)
        moviesViewPager.adapter=MovieAdapter(getMovies())
    }



    fun getMovies() : List<Movie>{


        val movie = Movie("Black Widow","Action","June 11, 2020",R.drawable.black,3.9f)
        val movie1 = Movie("Us","Dramatic action","April 22,2018",R.drawable.us,
        4.1f)
        val movie2 = Movie("Popeye","Action","June 22, 2020",R.drawable.popeye,3.4f)
        val movie3 =Movie("Top Gun","Adventure - Action","February 02, 2022",R.drawable.topgun,4.2f)
        val movie4=Movie("Jurassic World","Adventure","May 15, 2022",R.drawable.jurassic,4.0f)

        val movieList = ArrayList<Movie>()
        movieList.add(movie)
        movieList.add(movie1)
        movieList.add(movie2)
        movieList.add(movie3)
        movieList.add(movie4)

        return movieList





    }


}