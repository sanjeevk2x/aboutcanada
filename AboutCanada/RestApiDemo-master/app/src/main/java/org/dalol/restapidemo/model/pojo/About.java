package org.dalol.restapidemo.model.pojo;

/**
 * Created by Sanjeev on 23-05-2016.
 */
public class About {
    public String mTitle;
    public String mDescription;
    public String mImagePath;

    private About(Builder builder){
        mTitle = builder.mTitle;
        mDescription = builder.mDescription;
        mImagePath = builder.mImagePath;
    }

    public static class Builder {
        private String mTitle;
        private String mDescription;
        private String mImagePath;

        public Builder setTitle(String title) {
            mTitle = title;
            return Builder.this;
        }

        public Builder setDescription(String description) {
            mDescription = description;
            return Builder.this;
        }

        public Builder setImagePath(String imagePath) {
            mImagePath = imagePath;
            return Builder.this;
        }

        public About build(){
            return new About(Builder.this);
        }
    }
}
