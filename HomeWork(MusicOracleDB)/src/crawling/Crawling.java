package crawling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import model.SongDTO;

public class Crawling {

	public static ArrayList<SongDTO> crawlData() {
		String filePath = "C:\\resource\\";
		String fileName = "music.txt";

		List<String> urls = new ArrayList<>();

		// 파일에서 URL 읽기
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath + fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				urls.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// URL 크롤링
		ArrayList<SongDTO> songs = new ArrayList<SongDTO>();
		int PK = 1;
		for (String url : urls) {
			try {
				Connection conn = Jsoup.connect(url);
				Document doc = conn.get();

				Elements songTitles = doc.select("p.song"); // ellipsis
				Elements artistNames = doc.select("span.checkEllipsisRealtimeChart");
				// 크롤링할 HTML 요소 선택 (예: <p> 태그)
//				int a = songTitles.size(); // 20 
//				System.out.println(songTitles);
//				System.out.println(a);
//				int b = artistNames.size(); //42 //21
//				System.out.println(artistNames);
//				System.out.println(b); 
				
				
				String artist="unKnown";
				String title ="unknown";
				for (int i = 0; i < artistNames.size(); i++) {
					SongDTO song = new SongDTO();
					title = songTitles.get(i).text();
					System.out.println("Song Title: " + title);
					artist =artistNames.get(i).text();
					System.out.println("Artist: " + artist);
					song.setPk(PK);
					song.setTitle(title);
					song.setArtist(artist);
					songs.add(song);
					System.out.println("song" + " " +song);
					System.out.println("songs" + songs);
					PK++;
				}
			}catch (IOException e) {
				System.out.println("Failed to connect to URL: " + url);
				e.printStackTrace();
			}
		}
		return songs;
	}
}
