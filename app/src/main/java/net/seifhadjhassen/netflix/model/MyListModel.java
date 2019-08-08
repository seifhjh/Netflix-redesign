package net.seifhadjhassen.netflix.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MyListModel implements Parcelable {

    int img;

    public MyListModel() {
    }

    public MyListModel(int img) {
        this.img = img;
    }

    protected MyListModel(Parcel in) {
        img = in.readInt();
    }

    public static final Creator<MyListModel> CREATOR = new Creator<MyListModel>() {
        @Override
        public MyListModel createFromParcel(Parcel in) {
            return new MyListModel(in);
        }

        @Override
        public MyListModel[] newArray(int size) {
            return new MyListModel[size];
        }
    };

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {


        dest.writeInt(img);
    }
}
