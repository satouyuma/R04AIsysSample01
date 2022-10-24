package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Senti message = getSentiment("Stepover Toehold With Facelock");
		if (message != null) {
			System.out.println(message.documents[0].confidenceScores.positive);
			System.out.println(message.documents[0].confidenceScores.neutral);
			System.out.println(message.documents[0].confidenceScores.negative);
		}
	}

	static Senti getSentiment(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3b07-text.cognitiveservices.azure.com/" + "text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "686e7194f8bf4bbc9baae84352f33cb1");

		Doc doc = new Doc();
		doc.id = "1";
		doc.text = s;

		Sour src = new Sour();
		src.documents = new Doc[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		JsonReader reader = WebApiConnector.postJsonReader(url, proxy, map, jsonData);
		Senti message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Senti.class);
			reader.close();
		}
		return message;
	}

}

class Senti {
	Document[] documents;
	String[] errors;
	String modelVersion;
}

class Document {
	ConfidenceScores confidenceScores;
}

class ConfidenceScores {
	double negative;
	double neutral;
	double positive;
}

class Sour {
	Doc[] documents;
}

class Doc {
	String id;
	String text;
}
