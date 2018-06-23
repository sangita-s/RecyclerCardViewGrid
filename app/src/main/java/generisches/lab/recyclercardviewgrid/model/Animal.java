package generisches.lab.recyclercardviewgrid.model;

import java.util.ArrayList;
import java.util.List;

import generisches.lab.recyclercardviewgrid.R;

public class Animal {
    private String title;
    private int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<Animal> getData(){
        List<Animal> data = new ArrayList<>();

        int[] images = {
                R.drawable.cat1,
                R.drawable.cat2,
                R.drawable.cat3,
                R.drawable.cat4,
                R.drawable.cat5,
                R.drawable.cat6,
                R.drawable.cat7,
                R.drawable.dog1,
                R.drawable.dog2,
                R.drawable.dog3,
                R.drawable.dog4,
                R.drawable.dog5,
                R.drawable.dog6,
                R.drawable.dog7,
                R.drawable.cat1,
                R.drawable.cat2,
                R.drawable.cat3,
                R.drawable.cat4,
                R.drawable.cat5,
                R.drawable.cat6,
                R.drawable.cat7
        };
        String[] categories = {
          "Cat","Cat","Cat","Cat","Cat","Cat","Cat","Dog","Dog","Dog","Dog","Dog","Dog","Dog",
                "Cat","Cat","Cat","Cat","Cat","Cat","Cat"
        };

        for(int i = 0; i < images.length; i++){
            Animal a = new Animal();
            a.setTitle(categories[i]);
            a.setImageId(images[i]);
            data.add(a);
        }

        return data;
    }
}
