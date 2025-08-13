import soundbloom.SoundBloom;
import soundbloom.enums.DeviceType;
import soundbloom.enums.StrategyType;

public class Client {
    public static void main(String[] args) {

        try {
            SoundBloom app = SoundBloom.getInstance();

            // populate
            app.createSongInLibrary("Aaj ki Raat", "Madhubanti Bagchi", "song/aaj_ki_raat.mp3");
            app.createSongInLibrary("Lat Lag Gayee", "Pritam Chakraborty", "song/lat_lag_gayee.mp3");
            app.createSongInLibrary("Garmi", "Badshah", "song/garmi.mp3");
            app.createSongInLibrary("Laila Main Laila", "Pawni A Pandey", "song/laila_main_laila.mp3");
            app.createSongInLibrary("Aashiqui Mein Teri", "Himesh Reshammiya", "song/aashiqui_mein_teri.mp3");
            app.createSongInLibrary("Choli Ke Peeche", "Alka Yagnik", "song/choli_ke_peeche.mp3");
            app.createSongInLibrary("Abhi Na Jao Chhod Kar", "Asha Bhosle and Mohammed Rafi", "song/abhi_na_jao_chhod_kar.mp3");
            app.createSongInLibrary("Ek Din Aap", "Alka Yagnik and Kumar Sanu", "song/ek_din_aap.mp3");
            app.createSongInLibrary("Kaun Tujhe", "Kishore Kumar", "song/kaun_tujhe.mp3");
            app.createSongInLibrary("Lag Ja Gale Se Phir", "Lata Mangeshkar", "song/lag_ja_gale_se_phir.mp3");
            app.createSongInLibrary("Itna Na Mujhse Tu Pyar Badha", "Lata Mangeshkar and Talat Mahmood", "song/itna_na_mujhse_tu_pyar_badha.mp3");

            // creating playlist and adding songs
            app.createPlayList("Dance Songs");
            app.addSongToPlayList("Dance Songs", "Aaj ki Raat");
            app.addSongToPlayList("Dance Songs", "Garmi");
            app.addSongToPlayList("Dance Songs", "Aashiqui Mein Teri");
            app.addSongToPlayList("Dance Songs", "Lat Lag Gayee");
            app.addSongToPlayList("Dance Songs", "Laila Main Laila");
            app.addSongToPlayList("Dance Songs", "Choli Ke Peeche");

            app.createPlayList("Old is Gold");
            app.addSongToPlayList("Old is Gold", "Abhi Na Jao Chhod Kar");
            app.addSongToPlayList("Old is Gold", "Itna Na Mujhse Tu Pyar Badha");
            app.addSongToPlayList("Old is Gold", "Kaun Tujhe");
            app.addSongToPlayList("Old is Gold", "Lag Ja Gale Se Phir");
            app.addSongToPlayList("Old is Gold", "Ek Din Aap");

            // connecting audio device
            app.connectDevice(DeviceType.BLUETOOTH);

            // playing song by searching
            app.playSong("Lag Ja Gale Se Phir");

            // pausing song by searching
            app.pauseCurrentSong();

            // connecting to another audio device
            app.connectDevice(DeviceType.HEADPHONE);

            // playing in sequential order
            System.out.println("\n><--------SEQUENCE--------><");
            app.selectPlayingStrategy(StrategyType.SEQUENCE);
            app.loadPlayList("Old is Gold");
            app.playAllTracksOfPlayList();

            // play in random order
            System.out.println("\n><---------RANDOM---------><");
            app.selectPlayingStrategy(StrategyType.RANDOM);
            app.loadPlayList("Dance Songs");
            app.playAllTracksOfPlayList();

            // play in custom order
            System.out.println("\n><---------CUSTOM---------><");
            app.selectPlayingStrategy(StrategyType.CUSTOM);
            app.loadPlayList("Old is Gold");
            app.addToQueue("Lag Ja Gale Se Phir");
            app.addToQueue("Ek Din Aap");
            app.addToQueue("Itna Na Mujhse Tu Pyar Badha");
            app.playAllTracksOfPlayList();

            // playing next song
            app.playNextSongOfPlayList();

            // playing previous song
            app.playPreviousTrackOfPlayList();
            app.pauseCurrentSong();
            app.playPreviousTrackOfPlayList();
            app.pauseCurrentSong();

        } catch (Exception error) {
            System.out.println("\n⚠️ " + error.getMessage() + " ️⚠️");
        }
    }
}
