package assignment;

public class Main {
    public static void main(String[] args) {
        Song song = new Song("2", "Hotel California", "1976", "hotel_california.mp3");
        song.setGenre(Genre.ROCK);

        Album album = new Album("Hotel California", "eagles_cover.jpg");
        song.setAlbum(album);

        Artist artist = new Artist("Eagles", "Don Henley", "eagles.jpg");
        song.setArtist(artist);

        song.printInfo();
    }
}
