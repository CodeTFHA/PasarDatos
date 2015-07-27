package com.quizastepuedaayudar.pasardatos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tomas on 23/07/2015.
 */
public class Alumno implements Parcelable {

    private String nombre;
    private int n1;
    private int n2;

    public Alumno(int n1, int n2, String nombre) {
        this.n1 = n1;
        this.n2 = n2;
        this.nombre = nombre;
    }



    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.n1);
        dest.writeInt(this.n2);
    }

    public Alumno(Parcel in) {
        this.nombre = in.readString();
        this.n1 = in.readInt();
        this.n2 = in.readInt();
    }

    public static final Parcelable.Creator<Alumno> CREATOR = new Parcelable.Creator<Alumno>() {
        public Alumno createFromParcel(Parcel source) {
            return new Alumno(source);
        }

        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };
}
