package com.example.pinterest;

public class Avatar {
    String mimageUrl, mId, mFileExtension;

    public Avatar() {
    }


    public Avatar(String id, String imageUrl, String fileExtension) {
        mimageUrl = imageUrl;
        mId = id;
        mFileExtension = fileExtension;
    }

    public String getimageUrl() {
        return mimageUrl;
    }

    public void setimageUrl(String mimageUrl) {
        this.mimageUrl = mimageUrl;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getFileExtension() {
        return mFileExtension;
    }

    public void setFileExtension(String mFileExtension) {
        this.mFileExtension = mFileExtension;
    }
}
