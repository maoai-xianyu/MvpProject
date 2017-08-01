package com.mao.cn.mvpproject.model;

import java.io.Serializable;

/**
 * author:  zhangkun .
 * date:    on 2017/8/1.
 */

public class MovieDetail implements Serializable {

    private String movieName;
    private String movieCode;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCode() {
        return movieCode;
    }

    public void setMovieCode(String movieCode) {
        this.movieCode = movieCode;
    }

    @Override
    public String toString() {
        return "MovieDetail{" +
                "movieName='" + movieName + '\'' +
                ", movieCode='" + movieCode + '\'' +
                '}';
    }
}
