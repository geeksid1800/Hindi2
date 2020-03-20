package com.example.hindi;

public class Words {
    private static final int NO_IMAGE_PROVIDED = -1;        // -1 if no image provided

    private String mHindiTranslation,mDefaultTranslation;
    private int mImageResourceID = NO_IMAGE_PROVIDED;  //By default it is in this state. If it changes, means there is an image
    private int mAudioResourceID;  //The ID of the audio file associated with each word, not the audio file itself
    //A constructor, remember in Java, we can create a new object simply by
    // Rectangle rect = new Rectangle(60,40);
    Words(String HindiTranslation, String DefaultTranslation, int AudioResourceID){
        mDefaultTranslation = DefaultTranslation;
        mHindiTranslation = HindiTranslation;
        mAudioResourceID = AudioResourceID;
    }

    Words(String HindiTranslation, String DefaultTranslation, int ImageResourceID, int AudioResourceID){
        mDefaultTranslation = DefaultTranslation;
        mHindiTranslation = HindiTranslation;
        mImageResourceID = ImageResourceID;
        mAudioResourceID = AudioResourceID;
    }

    //public methods, so outside classes can access the translations
    public String getHindiTranslation(){
      return mHindiTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceID() { return mImageResourceID; }

    public boolean hasImage(){
            return mImageResourceID != NO_IMAGE_PROVIDED;
                // returns true if they are not same, i.e. Word has image associated
    }
    public int getAudioResourceID(){ return mAudioResourceID; }

}
