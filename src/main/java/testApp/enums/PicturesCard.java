package testApp.enums;

public enum PicturesCard {
    KING("Король"), QUEEN("Дама"), VALET("Валет"), TUZ ("Туз");

    private String pictureCardName;

    PicturesCard(String pictureCardName) {
        this.pictureCardName = pictureCardName;
    }

    public String getPictureCardName() {
        return pictureCardName;
    }
}
