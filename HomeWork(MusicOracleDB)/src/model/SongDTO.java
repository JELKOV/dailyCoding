package model;

public class SongDTO {
    private int pk;
    private String title;
    private String artist;

//    public SongDTO(int pk, String title, String artist) {
//        this.pk = pk;
//        this.title = title;
//        this.artist = artist;
//    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
		this.pk = pk;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "RANKING"+ pk+ "{" +
                "pk=" + pk +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}